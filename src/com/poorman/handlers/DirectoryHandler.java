package com.poorman.handlers;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import com.poorman.resources.GlobalCollections;

public class DirectoryHandler {

	private Queue<File> parentDirectories = new LinkedList<File>();

	public DirectoryHandler(File baseFile) {
		addToParentDirectories(baseFile);
	}

	public void breakApartDirectory() {

		File file = null;

		do {
			file = parentDirectories.poll();
			if (file != null) {
				if (file.isDirectory()) {
					addToParentDirectories(file.listFiles());
				} else if (file.canRead()) {
					addToChildrenFiles(file);
				}
			}

		} while (!parentDirectories.isEmpty());
		System.out.println("Done building directory");
	}

	private void addToChildrenFiles(File file) {
		GlobalCollections.childrenFiles.add(file);
	}

	private void addToParentDirectories(File[] files) {
		for (File file : files) {
			this.parentDirectories.add(file);
		}
	}

	private void addToParentDirectories(File file) {
		this.parentDirectories.add(file);
	}
}
