package com.eightbitplatoon.hr.filecompare;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportFile {

	public static void fileWriter(String filename, String data) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		//create one file for results
		try {			
			//File file = new File(filename);
			File file = new File("Results");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);				
			bw.append(data +"\n");			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

}
