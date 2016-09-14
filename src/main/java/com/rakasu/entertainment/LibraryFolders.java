package com.rakasu.entertainment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LibraryFolders {

/*	@Bean
	@Autowired()
	public List<File> movieFolders(){
		return new ArrayList<File>();
	}
	@Bean
	@Autowired()
	public List<File> songsFolders(){
		return new ArrayList<File>();
	}*/
	
	List<File> movieFolders = new ArrayList<File>();
	List<File> songsFolders = new ArrayList<File>();

	public List<File> getMovieFolders() {
		return movieFolders;
	}

	public void setMovieFolders(List<File> movieFolders) {
		this.movieFolders = movieFolders;
	}

	public List<File> getSongsFolders() {
		return songsFolders;
	}

	public void setSongsFolders(List<File> songsFolders) {
		this.songsFolders = songsFolders;
	}

}
