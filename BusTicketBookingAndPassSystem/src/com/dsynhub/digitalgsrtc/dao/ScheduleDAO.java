package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.ScheduleBean;
import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class ScheduleDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private boolean result = false;

	
	public boolean insert(ScheduleBean scheduleBean) {
		conn = DBConnection.getConnection();
		if (conn != null) {
			String insertSQL = "INSERT INTO SCHEDULE(busNo) values(?)";

			try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, scheduleBean.getBusNo());
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
					e.printStackTrace();
				}
			}

		}

		return result;
	}

		
	public List<ScheduleBean> list(){
		
		List<ScheduleBean> listOfSchedule = new ArrayList<ScheduleBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from SCHEDULE";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				ScheduleBean scheduleBean = null;

				while(rs.next()){
					
					scheduleBean = new ScheduleBean();
					scheduleBean.setScheduleId(rs.getString("scheduleId"));
					scheduleBean.setBusNo(rs.getString("busNo"));
					
					listOfSchedule.add(scheduleBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfSchedule.size());
			return listOfSchedule;
		}

	public boolean delete(String schdeuleId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "delete from Schedule where ScheduleId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,schdeuleId);
			
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Deleted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Deleted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 }
		 return result;
	}


	public ScheduleBean getByPK(String scheduleId) {
		
		 conn=DBConnection.getConnection();	
		 ScheduleBean schedule = new ScheduleBean();			 
		 if(conn!=null){
			 
						 
			 String selectSQL = "Select * from schedule WHERE scheduleId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, scheduleId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					schedule.setScheduleId(rs.getString("ScheduleId"));
					schedule.setBusNo(rs.getString("busNo"));
					
				
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return schedule;
	}
	
	public boolean update(ScheduleBean schedule) {
		
		 conn=DBConnection.getConnection();	
		 if(conn!=null){
			 String updateSQL = "update schedule set busNo=? where scheduleId=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				
				pstmt.setString(1,schedule.getBusNo());
				pstmt.setString(2,schedule.getScheduleId());
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
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
	
}
