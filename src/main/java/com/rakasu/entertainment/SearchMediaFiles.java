package com.rakasu.entertainment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class SearchMediaFiles {

	@Value("C:/Users/Public/Videos/Entertainment/Movies/English Movies")
	private String libSourceFolder;

	@Autowired
	private LibraryFolders libFoders;

	public List<File> searchFiles() {
		List<File> mediaFiles = new ArrayList<File>();
		String path = getLibSourceFolder();
		if (path != null) {
			File searchFolder = new File(path);
			File[] files = searchFolder.listFiles();
			List<File> fileList = Arrays.asList(files);
			fileList.stream().forEach(file -> mediaFiles.add(file));
		}
		return mediaFiles;
	}

	public List<File> searchMovieFiles() {
		List<File> mediaFiles = new ArrayList<File>();
		List<File> movieFolders = libFoders.getMovieFolders();
		if (movieFolders != null && !movieFolders.isEmpty()) {
			movieFolders.stream().forEach(folder -> mediaFiles.addAll(Arrays.asList(folder.listFiles())));
		}
		return mediaFiles;
	}

	public String getLibSourceFolder() {
		return libSourceFolder;
	}

	public void setLibSourceFolder(String libSourceFolder) {
		this.libSourceFolder = libSourceFolder;
	}

	public LibraryFolders getLibFoders() {
		return libFoders;
	}

	public void setLibFoders(LibraryFolders libFoders) {
		this.libFoders = libFoders;
	}
}
