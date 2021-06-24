package com.padhye.humanresource.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.padhye.humanresource.dbutility.DBConnection;
import com.padhye.humanresource.model.Reports;

public class ReportsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReportsDao.class);
	
	public ArrayList<Reports> fetchReportBetweenDates(Date fromDate, Date toDate){
		ArrayList<Reports> reportList = new ArrayList<Reports>();
		String query = "  select userName,fromDate,ToDate,Reason from tblusers u (nolock) " + 
						" inner join tblEmployeeLeaveLog e (nolock) on u.userId=e.employeeId " + 
						" where fromDate >= ? and toDate <= ?";
		Connection oCon = null;
		PreparedStatement ptmt = null;
		ResultSet oRs = null;
		try {
			oCon = new DBConnection().getConnection();
			ptmt = oCon.prepareStatement(query);
			ptmt.setDate(1, fromDate);
			ptmt.setDate(2, toDate);
			oRs = ptmt.executeQuery();
			while(oRs.next()) {
				Reports rep = new Reports();
				rep.setEmployeeName(oRs.getString("userName"));
				rep.setFromDate(oRs.getDate("fromDate"));
				rep.setToDate(oRs.getDate("toDate"));
				rep.setReason(oRs.getString("reason"));
				reportList.add(rep);
			}
		}catch(SQLException e) {
			LOGGER.error("Error occured while fetching report.",e);
		}finally {
			DBConnection.closeResultSet(oRs);
			DBConnection.closePreparedStatement(ptmt);
			DBConnection.closeDBConnection(oCon);
		}
		return reportList;
	}
}
