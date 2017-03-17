package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.LogsBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class LogsDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(LogsBean logsBean) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO logs(userName,userType,loginTime,logoutTime) "
					+ "values(?,?,?,?)";

			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, logsBean.getUserName());
				pstmt.setString(2, logsBean.getUserType());
				pstmt.setString(3, logsBean.getLoginTime());
				pstmt.setString(4, logsBean.getLogoutTime());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	public boolean update(LogsBean logsBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "update logs set logoutTime=? where userName=? And userType=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, logsBean.getLogoutTime());
				pstmt.setString(2, logsBean.getUserName());
				pstmt.setString(3, logsBean.getUserType());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
					System.out.println(rowsAffected + " Row(s) Updated......");

				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	public List<LogsBean> list() {

		List<LogsBean> listOfLogs = new ArrayList<LogsBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from logs";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				LogsBean logsBean = null;

				while(rs.next()){
					
					logsBean = new LogsBean();
					
					logsBean.setLogId(rs.getString("logId"));
					logsBean.setUserName(rs.getString("userName"));
					logsBean.setLoginTime(rs.getString("loginTime"));
					logsBean.setLogoutTime(rs.getString("logoutTime"));
					logsBean.setUserType(rs.getString("userType"));
					
					
					listOfLogs.add(logsBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
			return listOfLogs;
		}
}
