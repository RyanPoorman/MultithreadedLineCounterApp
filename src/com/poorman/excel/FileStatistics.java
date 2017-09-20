package com.poorman.excel;

public class FileStatistics {

	private String fileName;
	private String fileExtension;
	private int lineCount;
	private String parentDirectory;

	public FileStatistics(String name, String extension, int count, String parent) {
		setFileName(name);
		setFileExtension(extension);
		setLineCount(count);
		setParentDirectory(parent);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public String getParentDirectory() {
		return parentDirectory;
	}

	public void setParentDirectory(String parentDirectory) {
		this.parentDirectory = parentDirectory;
	}
}
