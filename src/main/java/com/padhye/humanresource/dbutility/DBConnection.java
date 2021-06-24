package com.padhye.humanresource.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DBConnection.class);	
	private static final String DATABASE_URL = "jdbc:sqlserver://127.0.0.1:49184;databaseName=agilesystem";	
	private static final String USERNAME = "sa";	
	private static final String PASSWORD = "ecwecw!@#1312";

	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	}
	
	public static void closeDBConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error occurred while closing database connection.",e);
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Error occurred while closing Resultset.",e);
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement ptmt) {
		if(ptmt != null) {
			try {
				ptmt.close();
			} catch (SQLException e) {
				LOGGER.error("Error occurred while closing PreparedStatement.",e);
			}
		}
	}
	
}
