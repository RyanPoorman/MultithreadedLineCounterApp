package com.poorman.driver;

import java.io.File;

import com.poorman.excel.ResultToExcel;
import com.poorman.handlers.DirectoryHandler;
import com.poorman.handlers.FileHandler;
import com.poorman.resources.GlobalCollections;

public class Driver {

	private static final String address = "/Users/ryanpoorman/Programming/LineCounterTest";

	public static void main(String[] args) {

		countLines(new File(address));

	}

	private static void countLines(File file) {

		try {
			System.out.println("Build Directory");

			new DirectoryHandler(file).breakApartDirectory();

			System.out.println("Starting to count lines");
			new FileHandler().countLinesInFile();

			System.out.println("Creating excel file");
			ResultToExcel.outputToExcel(GlobalCollections.files);

			System.out.println("Collections cleared");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
