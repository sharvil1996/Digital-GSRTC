package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.SeatTypeBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class SeatTypeDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	
	public boolean insert(SeatTypeBean seatTypebean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into SeatType(SeatTypeName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,seatTypebean.getSeatTypeName());
				
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
	
		public List<SeatTypeBean> list(){
		
		List<SeatTypeBean> listOfSeatType = new ArrayList<SeatTypeBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from SeatType order by seatTypeId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				SeatTypeBean seatTypeBean = null;

				while(rs.next()){
					
					seatTypeBean = new SeatTypeBean();
					System.out.println("ID : "+rs.getString("SeatTypeId"));
					seatTypeBean.setSeatTypeId(rs.getString("SeatTypeId"));
					seatTypeBean.setSeatTypeName(rs.getString("SeatTypeName"));
					listOfSeatType.add(seatTypeBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfSeatType.size());
			return listOfSeatType;
		}

	
		public boolean delete(String seatTypeId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "delete from SeatType where SeatTypeId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,seatTypeId);
				
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

		public SeatTypeBean getByPK(String seatTypeId) {
			
			 conn=DBConnection.getConnection();	
			 SeatTypeBean seatType = new SeatTypeBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "Select * from seatType WHERE seatTypeId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, seatTypeId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						seatType.setSeatTypeId(rs.getString("SeatTypeId"));
						seatType.setSeatTypeName(rs.getString("seatTypeName"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return seatType;
		}
		
		public boolean update(SeatTypeBean seatType) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update SeatType set SeatTypeName=? where SeatTypeId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,seatType.getSeatTypeName());
					pstmt.setString(2,seatType.getSeatTypeId());
					
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
