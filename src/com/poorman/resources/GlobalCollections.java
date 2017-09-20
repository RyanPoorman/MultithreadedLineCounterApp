package com.poorman.resources;

import java.io.File;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.poorman.excel.FileStatistics;

public class GlobalCollections {

	public static Vector<FileStatistics> files = new Vector<FileStatistics>();

	public static ConcurrentLinkedQueue<File> childrenFiles = new ConcurrentLinkedQueue<File>();

	public static void clearCollections() {
		files.clear();
		childrenFiles.clear();
	}
}
