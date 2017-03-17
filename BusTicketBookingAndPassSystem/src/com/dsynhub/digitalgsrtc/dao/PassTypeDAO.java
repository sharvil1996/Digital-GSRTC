package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.PassTypeBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class PassTypeDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	
	public boolean insert(PassTypeBean passTypebean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into PassType(PassTypeName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,passTypebean.getPassTypeName());
				
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
	
		public List<PassTypeBean> list(){
		
		List<PassTypeBean> listOfPassType = new ArrayList<PassTypeBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from PassType order by passTypeId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				PassTypeBean passTypeBean = null;

				while(rs.next()){
					
					passTypeBean = new PassTypeBean();
					System.out.println("ID : "+rs.getString("PassTypeId"));
					passTypeBean.setPassTypeId(rs.getString("PassTypeId"));
					passTypeBean.setPassTypeName(rs.getString("PassTypeName"));
					listOfPassType.add(passTypeBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfPassType.size());
			return listOfPassType;
		}

	
		public boolean delete(String passTypeId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "delete from PassType where PassTypeId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,passTypeId);
				
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

		public PassTypeBean getByPK(String passTypeId) {
			
			 conn=DBConnection.getConnection();	
			 PassTypeBean passType = new PassTypeBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "Select * from passType WHERE passTypeId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, passTypeId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						passType.setPassTypeId(rs.getString("PassTypeId"));
						passType.setPassTypeName(rs.getString("passTypeName"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return passType;
		}
		
		public boolean update(PassTypeBean passType) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update PassType set PassTypeName=? where PassTypeId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,passType.getPassTypeName());
					pstmt.setString(2,passType.getPassTypeId());
					
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
