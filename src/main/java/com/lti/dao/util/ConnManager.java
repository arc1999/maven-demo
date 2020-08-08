package com.lti.dao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {

	public static Connection connect() {
		try {
			Properties dbdrops = new Properties();
			dbdrops.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
//			System.out.println(dbdrops.getProperty("drivername"));
//			System.out.println(dbdrops.getProperty("url"));
//			System.out.println(dbdrops.getProperty("user"));
//			System.out.println(dbdrops.getProperty("pass"));
			Class.forName(dbdrops.getProperty("drivername"));
//			String url = "jdbc:oracle:thin:@localhost:32118:XE";
//			String user = "dummy";
//			String pass = "dummy";
			return DriverManager.getConnection(dbdrops.getProperty("url"), dbdrops.getProperty("user"),
					dbdrops.getProperty("pass"));

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace(); // we should rather throw an user defined exception
			return null; // very bad should throw an exception indicating some problem which trying to
							// fetch data
		}
	}
}
