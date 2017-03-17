package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.BusCategoryBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class BusCategoryDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	
	public boolean insert(BusCategoryBean busCategorybean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into BusCategory(BusCategoryName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,busCategorybean.getBusCategoryName());
				
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
	
		public List<BusCategoryBean> list(){
		
		List<BusCategoryBean> listOfBusCategory = new ArrayList<BusCategoryBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from BusCategory order by busCategoryId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				BusCategoryBean busCategoryBean = null;

				while(rs.next()){
					
					busCategoryBean = new BusCategoryBean();
					System.out.println("ID : "+rs.getString("BusCategoryId"));
					busCategoryBean.setBusCategoryId(rs.getString("BusCategoryId"));
					busCategoryBean.setBusCategoryName(rs.getString("BusCategoryName"));
					listOfBusCategory.add(busCategoryBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfBusCategory.size());
			return listOfBusCategory;
		}

	
		public boolean delete(String busCategoryId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "delete from BusCategory where BusCategoryId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,busCategoryId);
				
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

		public BusCategoryBean getByPK(String busCategoryId) {
			
			 conn=DBConnection.getConnection();	
			 BusCategoryBean busCategory = new BusCategoryBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "Select * from busCategory WHERE busCategoryId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, busCategoryId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						busCategory.setBusCategoryId(rs.getString("BusCategoryId"));
						busCategory.setBusCategoryName(rs.getString("busCategoryName"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return busCategory;
		}
		
		public boolean update(BusCategoryBean busCategory) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update BusCategory set BusCategoryName=? where BusCategoryId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,busCategory.getBusCategoryName());
					pstmt.setString(2,busCategory.getBusCategoryId());
					
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
