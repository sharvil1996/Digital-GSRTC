package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.OrganizationBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class OrganizationDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	
	public boolean insert(OrganizationBean organizationBean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into organization(orgName,orgAddress) values(?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,organizationBean.getOrgName());
				pstmt.setString(2,organizationBean.getOrgAddress());
				
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
	
		public List<OrganizationBean> list(){
		
		List<OrganizationBean> listOfOrganization = new ArrayList<OrganizationBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select * from organization order by orgId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				OrganizationBean organizationBean = null;

				while(rs.next()){
					
					organizationBean = new OrganizationBean();
					organizationBean.setOrgId(rs.getString("OrgId"));
					organizationBean.setOrgName(rs.getString("OrgName"));
					organizationBean.setOrgAddress(rs.getString("OrgAddress"));
					listOfOrganization.add(organizationBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfOrganization.size());
			return listOfOrganization;
		}

	
		public boolean delete(String orgId) {
			 
			 conn=DBConnection.getConnection();	
			 System.out.println(orgId);
			 if(conn!=null){
				 String deleteSQL = "delete from Organization where OrgId=?";
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,orgId);
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

		public OrganizationBean getByPK(String orgId) {
			
			 conn=DBConnection.getConnection();	
			 OrganizationBean organization = new OrganizationBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "Select * from organization WHERE orgId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, orgId);
					
					rs = pstmt.executeQuery();

					
					while(rs.next()){
						organization.setOrgId(rs.getString("orgId"));
						organization.setOrgName(rs.getString("orgName"));
						organization.setOrgAddress(rs.getString("orgAddress"));
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return organization;
		}
		
		public boolean update(OrganizationBean organizationBean) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update Organization set orgName=?,orgAddress=? where orgId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,organizationBean.getOrgName());
					pstmt.setString(2,organizationBean.getOrgAddress());
					pstmt.setString(3,organizationBean.getOrgId());
					
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
