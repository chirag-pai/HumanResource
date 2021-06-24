package com.padhye.humanresource.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.padhye.humanresource.dbutility.DBConnection;
import com.padhye.humanresource.model.Employee;

public class EmployeeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	
	public HashMap<Integer,String> getNonAdminUserList(){
		HashMap<Integer,String> employeeMap = new HashMap<Integer,String>();
		String query = " Select userId,userName from tblUsers (nolock) where isAdmin = 0 ";
		Connection oCon = null;
		PreparedStatement ptmt = null;
		ResultSet oRs = null;
		try {
			oCon = new DBConnection().getConnection();
			ptmt = oCon.prepareStatement(query);
			oRs = ptmt.executeQuery();
			while(oRs.next()) {
				employeeMap.put(oRs.getInt("userId"),oRs.getString("userName"));
			}
		} catch (SQLException e) {
			LOGGER.error("Error occurred while creating database connection.",e);
		}finally {
			DBConnection.closeResultSet(oRs);
			DBConnection.closePreparedStatement(ptmt);
			DBConnection.closeDBConnection(oCon);
		}
		return employeeMap;
	}
	
	public int insertLeaveDetail(Employee employee) {
		String query = "insert into tblEmployeeLeaveLog values (?,?,?,?,?)";
		Connection oCon =  null;
		PreparedStatement ptmt = null;
		ResultSet oRs = null;
		int rowInserted = 0;
		try {
			oCon = new DBConnection().getConnection();
			ptmt = oCon.prepareStatement(query);
			ptmt.setInt(1, employee.getEmployeeId());
			ptmt.setDate(2, employee.getFromDate());
			ptmt.setDate(3, employee.getToDate());
			ptmt.setInt(4, employee.getNumberOfDays());
			ptmt.setString(5, employee.getReason());
			rowInserted = ptmt.executeUpdate();
		}catch(SQLException e) {
			LOGGER.error("Error occured while inserting leave details.",e);
		}finally {
			DBConnection.closeResultSet(oRs);
			DBConnection.closePreparedStatement(ptmt);
			DBConnection.closeDBConnection(oCon);
		}
		return rowInserted;
	}
}
