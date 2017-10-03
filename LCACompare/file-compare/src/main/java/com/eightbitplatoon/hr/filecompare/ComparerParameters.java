package com.eightbitplatoon.hr.filecompare;

import com.beust.jcommander.Parameter;

public class ComparerParameters {

	@Parameter(names = "-f", required = true, description = "File Path that contains first file to compare")
	private String firstFolder;

	@Parameter(names = "-s", required = true, description = "File Path that contains second file to compare")
	private String secondFolder;

	public String getFirstFolder() {
		return firstFolder;
	}

	public String getSecFolder() {
		return secondFolder;
	}
}
