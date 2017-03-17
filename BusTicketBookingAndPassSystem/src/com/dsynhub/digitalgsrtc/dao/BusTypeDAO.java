package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.BusTypeBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class BusTypeDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	
	public boolean insert(BusTypeBean busTypebean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into BusType(BusTypeName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,busTypebean.getBusTypeName());
				
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
	
		public List<BusTypeBean> list(){
		
		List<BusTypeBean> listOfBusType = new ArrayList<BusTypeBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from BusType order by busTypeId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				BusTypeBean busTypeBean = null;

				while(rs.next()){
					
					busTypeBean = new BusTypeBean();
					System.out.println("ID : "+rs.getString("BusTypeId"));
					busTypeBean.setBusTypeId(rs.getString("BusTypeId"));
					busTypeBean.setBusTypeName(rs.getString("BusTypeName"));
					listOfBusType.add(busTypeBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfBusType.size());
			return listOfBusType;
		}

	
		public boolean delete(String busTypeId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "delete from BusType where BusTypeId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,busTypeId);
				
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

		public BusTypeBean getByPK(String busTypeId) {
			
			 conn=DBConnection.getConnection();	
			 BusTypeBean busType = new BusTypeBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "Select * from busType WHERE busTypeId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, busTypeId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						busType.setBusTypeId(rs.getString("BusTypeId"));
						busType.setBusTypeName(rs.getString("busTypeName"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return busType;
		}
		
		public boolean update(BusTypeBean busType) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update BusType set BusTypeName=? where BusTypeId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,busType.getBusTypeName());
					pstmt.setString(2,busType.getBusTypeId());
					
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
