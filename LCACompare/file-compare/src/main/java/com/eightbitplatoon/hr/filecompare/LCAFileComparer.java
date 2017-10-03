package com.eightbitplatoon.hr.filecompare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class LCAFileComparer {

	static ReportFile writer = null;

	/***
	 * 
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {

		LCAFileComparer comparer = new LCAFileComparer();
		List<FileCompareResult> resultList = new ArrayList<FileCompareResult>();
		
		ComparerParameters params = new ComparerParameters();
		JCommander cmd = new JCommander(params);

		try {

			cmd.parse(args);
			File[] Ffiles = new File(params.getFirstFolder()).listFiles();
			File[] Sfiles = new File(params.getSecFolder()).listFiles();

			Set fileset1 = new LinkedHashSet();
			for (int x = 0; x < Ffiles.length; x++) {
				fileset1.add(Ffiles[x].getName());
				System.out.println("\n********************** : " + Ffiles[x].getName());
			}

			Set fileset2 = new LinkedHashSet();
			for (int x = 0; x < Sfiles.length; x++) {
				fileset2.add(Sfiles[x].getName());

			}

			FileCompareResult result;
			for (Iterator i = fileset1.iterator(); i.hasNext();) {
				result = null;
				String filetoCompare = (String) i.next();
				if (!fileset2.contains(filetoCompare)) {

					System.out.println("This file is not in the second folder : " + filetoCompare);

					continue;

				} else {
					System.out.println("\n\nThis files is in the second folder : " + filetoCompare);

					final ZipFile fFile = new ZipFile(params.getFirstFolder() + "\\" + filetoCompare);
					final ZipFile sFile = new ZipFile(params.getSecFolder() + "\\" + filetoCompare);

					System.out.println("**** Starting File Compare Process *****");
					System.out.println("Files to Compare: \n" + params.getFirstFolder() + "\\" + filetoCompare);
					System.out.println("AND \n" + params.getSecFolder() + "\\" + filetoCompare);
					result = comparer.compareFiles(fFile, sFile);
					resultList.add(result);
					continue;

				}				
			}
			
			System.out.println("\n\n=================");
			System.out.println("Thank you for using the file comparison utility. A summary of your results follows");
			System.out.println("Number of files compared: " + resultList.size());
			for (int i = 0; i < resultList.size(); i++) {
				FileCompareResult resultLine = resultList.get(i);
				System.out.println(i + " :: File=" + resultLine.getFileName() +
						" :: File1Count=" + resultLine.getTotalFileCountFile1() +
						" :: File2Count=" + resultLine.getTotalFileCountFile2() +
						" :: Matched=" + resultLine.getMatchCount() +
						" :: Mismatch=" + resultLine.getMismatchCount() +
						" :: NotFound=" + resultLine.getNotFoundCount() +
						" :: RevNotFound=" + resultLine.getReverseNotFoundCount());
			} 

			
		} catch (Exception ex) {
			System.out.println("A error occured during file comparing : " + ex.getMessage());
			ex.printStackTrace();
			cmd.usage();
		}

	}

	/***
	 * 
	 * @param fsFile
	 * @param scFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private FileCompareResult compareFiles(ZipFile fsFile, ZipFile scFile) throws FileNotFoundException, IOException {

		FileCompareResult result = new FileCompareResult();
		result.setFileName(fsFile.getName());
		String filename = "";
		Path fPath = null;
		
		// Build set of files from zipFile1
		Set set1 = new LinkedHashSet();
		for (Enumeration e = fsFile.entries(); e.hasMoreElements();)
			set1.add(((ZipEntry) e.nextElement()).getName());

		result.setTotalFileCountFile1(set1.size());
		
		// Build set of files from zipFile2
		Set set2 = new LinkedHashSet();
		for (Enumeration e = scFile.entries(); e.hasMoreElements();)
			set2.add(((ZipEntry) e.nextElement()).getName());

		result.setTotalFileCountFile2(set2.size());
		
		// Iterate over files in set1, comparing each with set2
		
		int errcount = 0;
		int filecount = 0;
		int filenotfound = 0;
		int revNotFound = 0;
		for (Iterator i = set1.iterator(); i.hasNext();) {
			String name = (String) i.next();
			filename = "Compare_" + fsFile.getName().replace("\\", "") + ".txt";

			if (!set2.contains(name)) {
				filenotfound += 1;
				//fPath = new File(name).toPath();
				//if ((Files.isDirectory(fPath)) && !(Files.isRegularFile(fPath))) {
				//	System.out.println(name + " not found in " + scFile.getName());
				//	ReportFile.fileWriter(filename, name + " not found in " + scFile.getName());
				//	filenotfound += 1;
				//	continue;
				//}
			} else {
				try {
					//set2.remove(name);
					if (!streamsEqual(fsFile.getInputStream(fsFile.getEntry(name)),
							scFile.getInputStream(scFile.getEntry(name)))) {
						System.out.println(name + " does not match");
						ReportFile.fileWriter(filename, name + " does not match");
						errcount += 1;
						//continue;
					} else {
						System.out.println(name + " file matched");
						ReportFile.fileWriter(filename, name + " file matched");
						filecount += 1;
					}
				} catch (Exception e) {
					System.out.println(name + ": File could not be compared. This might be  due to file directory names being different or the file does not exist in both ZIP Files." + e);
					ReportFile.fileWriter(filename, name + ": File could not be compared. This is due to the directory names being different or the file does not exist in both ZIP Files." + e);
					e.printStackTrace();
					errcount += 1;
					continue;
				}				
			}
		}
		
		// Iterate over files in set 2, comparing with set 1
		System.out.println("zipFile2:");
		for (Iterator i = set2.iterator(); i.hasNext();) {
			String name = (String) i.next();
			System.out.println(name);
			fPath = new File(name).toPath();
			
			// Only worry about the files that were'nt previously matched
			if (!set1.contains(name)) {
				if ((Files.isDirectory(fPath)) && !(Files.isRegularFile(fPath))) {
					System.out.println(name + " not found in " + fsFile.getName());
					ReportFile.fileWriter(filename, name + " not found in " + fsFile.getName());
					//filenotfound += 1;
					revNotFound  += 1;
				}				
			}
		}
		
		System.out.println(filecount + " entries matched");
		result.setMatchCount(filecount);
		ReportFile.fileWriter(filename, filecount + " entries matched");
		if (errcount > 0) {
			System.out.println(errcount + " entries did not match");
			result.setMismatchCount(errcount);
			ReportFile.fileWriter(filename, errcount + " entries did not match");
		}
		if (filenotfound > 0) {
			System.out.println(filenotfound + " entries were not found");
			result.setNotFoundCount(filenotfound);
			ReportFile.fileWriter(filename, filenotfound + " entries were not found");
		}
		if (revNotFound > 0) {
			System.out.println(revNotFound + " entries found in second file, but not in first");
			result.setReverseNotFoundCount(revNotFound);
			ReportFile.fileWriter(filename, revNotFound + " entries found in second file, but not in first");
		}
		return result;

	}

	/***
	 * 
	 * @param stream1
	 * @param stream2
	 * @return
	 * @throws IOException
	 */

	static boolean streamsEqual(InputStream stream1, InputStream stream2) throws IOException {
		byte[] buf1 = new byte[4096];
		byte[] buf2 = new byte[4096];
		boolean done1 = false;
		boolean done2 = false;

		try {
			while (!done1) {
				int off1 = 0;
				int off2 = 0;

				while (off1 < buf1.length) {
					int count = stream1.read(buf1, off1, buf1.length - off1);
					if (count < 0) {
						done1 = true;
						break;
					}
					off1 += count;
				}
				while (off2 < buf2.length) {
					int count = stream2.read(buf2, off2, buf2.length - off2);
					if (count < 0) {
						done2 = true;
						break;
					}
					off2 += count;
				}
				if (off1 != off2 || done1 != done2)
					return false;
				for (int i = 0; i < off1; i++) {
					if (buf1[i] != buf2[i])
						return false;
				}
			}
			return true;
		} finally {
			stream1.close();
			stream2.close();
		}
	}

}
