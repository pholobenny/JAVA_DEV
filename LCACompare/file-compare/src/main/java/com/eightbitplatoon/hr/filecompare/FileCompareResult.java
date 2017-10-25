/**
 * 
 */
package com.eightbitplatoon.hr.filecompare;

/**
 * @author mbn
 *
 */
public class FileCompareResult {

	private String fileName;
	private int totalFileCountFile1;
	private int totalFileCountFile2;
	private int matchCount;
	private int mismatchCount;
	private int notFoundCount;
	private int reverseNotFoundCount;
	
	public FileCompareResult() {
		super();
		this.fileName = "";
		this.totalFileCountFile1 = 0;
		this.totalFileCountFile2 = 0;
		this.matchCount = 0;
		this.mismatchCount = 0;
		this.notFoundCount = 0;
		this.reverseNotFoundCount = 0;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getMatchCount() {
		return matchCount;
	}
	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
	}
	public int getMismatchCount() {
		return mismatchCount;
	}
	public void setMismatchCount(int mismatchCount) {
		this.mismatchCount = mismatchCount;
	}
	public int getNotFoundCount() {
		return notFoundCount;
	}
	public void setNotFoundCount(int notFoundCount) {
		this.notFoundCount = notFoundCount;
	}

	public int getReverseNotFoundCount() {
		return reverseNotFoundCount;
	}

	public void setReverseNotFoundCount(int reverseNotFoundCount) {
		this.reverseNotFoundCount = reverseNotFoundCount;
	}

	public int getTotalFileCountFile1() {
		return totalFileCountFile1;
	}

	public void setTotalFileCountFile1(int totalFileCountFile1) {
		this.totalFileCountFile1 = totalFileCountFile1;
	}

	public int getTotalFileCountFile2() {
		return totalFileCountFile2;
	}

	public void setTotalFileCountFile2(int totalFileCountFile2) {
		this.totalFileCountFile2 = totalFileCountFile2;
	}

	
	
	
	
	
	
}
