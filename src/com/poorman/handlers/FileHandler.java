package com.poorman.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import com.poorman.excel.FileStatistics;
import com.poorman.resources.GlobalCollections;

public class FileHandler {

	public void countLinesInFile() throws InterruptedException {

		int processors = Runtime.getRuntime().availableProcessors();
		Thread[] threadsRunning = new Thread[processors];
		for (int i = 0; i < processors; i++) {
			threadsRunning[i] = new Thread(new CountLines());
		}

		for (int i = 0; i < processors; i++) {
			threadsRunning[i].start();
		}

		for (int i = 0; i < processors; i++) {
			threadsRunning[i].join();
		}

		System.out.println("Done counting lines");
	}

}

class CountLines implements Runnable {

	@Override
	public void run() {

		countLines(GlobalCollections.childrenFiles.poll());
	}

	private void countLines(File file) {
		while (!GlobalCollections.childrenFiles.isEmpty()) {

			if (file != null) {
				BufferedReader reader = null;
				try {
					String extension = FilenameUtils.getExtension(file.getName());
					String baseName = FilenameUtils.getBaseName(file.getName());
					String parentDirectory = FilenameUtils.getBaseName(file.getParent());

					reader = new BufferedReader(new FileReader(file));

					int lines = 0;
					while (reader.readLine() != null)
						lines++;

					GlobalCollections.files.addElement(new FileStatistics(baseName, extension, lines, parentDirectory));

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			countLines(GlobalCollections.childrenFiles.poll());
		}
	}

}
