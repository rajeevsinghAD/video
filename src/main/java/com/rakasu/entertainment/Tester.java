package com.rakasu.entertainment;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rakasu.entertainment.entities.LibFolder;

public class Tester {

	public static void main(String[] args) {
		testHibernate();
	}

	public static void testSping() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SearchMediaFiles mediaFileSearch = context.getBean("searchMediaFiles", SearchMediaFiles.class);
		List<File> movieFolders = mediaFileSearch.getLibFoders().getMovieFolders();
		File movieFolder1 = new File("C:/Users/Public/Videos/Entertainment/Movies/English Movies");
		File movieFolder2 = new File(
				"C:/Users/Public/Videos/Entertainment/Tv Serials/Agatha Christie-Poirot-The Complete Seasons 01-12.DVDRip");
		movieFolders.add(movieFolder1);
		movieFolders.add(movieFolder2);
		List<File> fileList = mediaFileSearch.searchFiles();
		// List<File> fileList = mediaFileSearch.searchMovieFiles();

		fileList.stream().forEach(file -> System.out.println(file.getAbsolutePath()));

	}

	@SuppressWarnings({ "unchecked" })
	public static void testHibernate() {

		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(new LibFolder("localDriveSignature", "English Movies",
					"C:/Users/Public/Videos/Entertainment/Movies/English Movies"));
			session.save(new LibFolder("localDriveSignature",
					"Agatha Christie-Poirot-The Complete Seasons 01-12.DVDRip",
					"C:/Users/Public/Videos/Entertainment/Tv Serials/Agatha Christie-Poirot-The Complete Seasons 01-12.DVDRip"));
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Database unreachable.");
		}

	}
}
