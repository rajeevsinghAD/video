package com.rakasu.entertainment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "LIBFOLDER")
public class LibFolder {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int folderId;

	@Column(name = "drive_signature")
	private String driveSignature;

	@Column(name = "folder_name")
	private String FolderName;

	@Column(name = "folder_path")
	private String FolderPath;

	public LibFolder() {
		super();
	}

	public LibFolder(String driveSignature, String folderName, String folderPath) {
		super();
		this.driveSignature = driveSignature;
		FolderName = folderName;
		FolderPath = folderPath;
	}

	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public String getDriveSignature() {
		return driveSignature;
	}

	public void setDriveSignature(String driveSignature) {
		this.driveSignature = driveSignature;
	}

	public String getFolderName() {
		return FolderName;
	}

	public void setFolderName(String folderName) {
		FolderName = folderName;
	}

	public String getFolderPath() {
		return FolderPath;
	}

	public void setFolderPath(String folderPath) {
		FolderPath = folderPath;
	}

}
