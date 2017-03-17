package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.ReservationStatusBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class ReservationStatusDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	
	public boolean insert(ReservationStatusBean reservationStatusbean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into ReservationStatus(ResStatusName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,reservationStatusbean.getReservationStatusName());
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected > 0) {
					result=true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			 } catch (SQLException e) {
				e.printStackTrace();
			}finally{
			
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			 
		 }
		
		return result;
	}
	
		public List<ReservationStatusBean> list(){
		
		List<ReservationStatusBean> listOfReservationStatus = new ArrayList<ReservationStatusBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from ReservationStatus order by resStatusId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				ReservationStatusBean reservationStatusBean = null;

				while(rs.next()){
					
					reservationStatusBean = new ReservationStatusBean();
					System.out.println("ID : "+rs.getString("ResStatusId"));
					reservationStatusBean.setReservationStatusId(rs.getString("ResStatusId"));
					reservationStatusBean.setReservationStatusName(rs.getString("ResStatusName"));
					listOfReservationStatus.add(reservationStatusBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfReservationStatus.size());
			return listOfReservationStatus;
		}

	
		public boolean delete(String reservationStatusId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "delete from ReservationStatus where ResStatusId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,reservationStatusId);
				
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

		public ReservationStatusBean getByPK(String reservationStatusId) {
			
			 conn=DBConnection.getConnection();	
			 ReservationStatusBean reservationStatus = new ReservationStatusBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "Select * from reservationStatus WHERE resStatusId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, reservationStatusId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						reservationStatus.setReservationStatusId(rs.getString("ResStatusId"));
						reservationStatus.setReservationStatusName(rs.getString("resStatusName"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return reservationStatus;
		}
		
		public boolean update(ReservationStatusBean reservationStatus) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update ReservationStatus set ResStatusName=? where ResStatusId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,reservationStatus.getReservationStatusName());
					pstmt.setString(2,reservationStatus.getReservationStatusId());
					
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
