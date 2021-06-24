package com.padhye.humanresource.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.padhye.humanresource.dbutility.DBConnection;

public class UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
	
	public boolean isUserValid(String userName, String passWord) {
		boolean isValid = false;
		String query = "Select isActive from tblUsers (nolock) where userName = ? and password = ?";
		Connection oCon = null;
		PreparedStatement ptmt = null;
		ResultSet oRs = null;
		try {
			oCon = new DBConnection().getConnection();
			ptmt = oCon.prepareStatement(query);
			ptmt.setString(1, userName);
			ptmt.setString(2, passWord);
			oRs = ptmt.executeQuery();
			if(oRs.next()) {
				isValid = oRs.getInt("isActive") == 1 ? true : false;
			}
		} catch (SQLException e) {
			LOGGER.error("Error occurred while creating database connection.",e);
		}finally {
			DBConnection.closeResultSet(oRs);
			DBConnection.closePreparedStatement(ptmt);
			DBConnection.closeDBConnection(oCon);
		}
		return isValid;
	}
}
