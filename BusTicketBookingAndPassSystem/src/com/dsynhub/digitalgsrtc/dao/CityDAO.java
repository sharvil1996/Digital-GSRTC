package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.CityBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class CityDAO {

	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(CityBean cityBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO CITY(cityName) values(?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,cityBean.getCityName());
				
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
		 }
		
		return result;
	}
	
	

	public List<CityBean> list(){
		
		List<CityBean> listOfCity = new ArrayList<CityBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from city order by cityId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				CityBean city = null;
				while(rs.next()){
					city = new CityBean();
				
					city.setCityId(rs.getString("CITYID"));
					city.setCityName(rs.getString("CITYNAME"));
									
					listOfCity.add(city);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Size : "+listOfCity.size());
		return listOfCity;
	}

	
	public boolean delete(String cityId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM city WHERE cityId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,cityId);
			
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
	
	public CityBean getByPK(String cityId) {
		
		 conn=DBConnection.getConnection();	
		 CityBean city =new CityBean();
		 
		 if(conn!=null){
			 String selectSQL = "Select * from city WHERE CITYID=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, cityId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					 
					city.setCityId(rs.getString("CITYID"));
					city.setCityName(rs.getString("CITYNAME"));
					
					
				
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return city;
	}
	
	public boolean update(CityBean cityBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE city set cityName=? WHERE CITYID=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,cityBean.getCityName());
				pstmt.setString(2, cityBean.getCityId());
				
				
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
