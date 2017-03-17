package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.FeedbackBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class FeedbackDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	boolean result = false;
	public boolean insert(FeedbackBean feedbackBean){
		
		conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String insertSQL = "INSERT INTO feedback(userid,feedbackContent) values(?,?)";
			  	
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,feedbackBean.getUserId());
				pstmt.setString(2,feedbackBean.getFeedback());
				
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
	
	

	public List<FeedbackBean> list(){
		
		List<FeedbackBean> listOfFeedback = new ArrayList<FeedbackBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String selectSQL = "Select * from feedback,user where feedback.userId=user.userId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();

				FeedbackBean feedbackBean = null;
				while(rs.next()){
					feedbackBean = new FeedbackBean();
				
					feedbackBean.setFeedback(rs.getString("feedbackContent"));
					feedbackBean.setFeedbackId(rs.getString("feedbackId"));
					feedbackBean.setUserName(rs.getString("firstName"));
					
					listOfFeedback.add(feedbackBean);
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		System.out.println("Feedback Size : "+listOfFeedback.size());
		return listOfFeedback;
	}

	
	public boolean delete(String feedbackId) {
		 
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String deleteSQL = "DELETE FROM feedback WHERE feedbackId=?";
			 
			 try {
				pstmt = conn.prepareStatement(deleteSQL);
				
				pstmt.setString(1,feedbackId);
			
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
	
	public FeedbackBean getByPK(String feedbackId) {
		
		 conn=DBConnection.getConnection();	
		 FeedbackBean feedbackBean =new FeedbackBean();
		 
		 if(conn!=null){
			 String selectSQL = "Select * from feedback,user WHERE feedbackId=?";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				pstmt.setString(1, feedbackId);
				System.out.println("kjdk"+feedbackId);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()){
					feedbackBean.setFeedback(rs.getString("feedbackContent"));
					feedbackBean.setFeedbackId(rs.getString("feedbackId"));
					feedbackBean.setUserName(rs.getString("firstName"));
					feedbackBean.setUserId(rs.getString("userId"));
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	return feedbackBean;
	}
	
	public boolean update(FeedbackBean feedbackBean) {
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){
			 String updateSQL = "UPDATE feedback set feedbackContent=? WHERE feedbackID=?";
			 
			 try {
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setString(1,feedbackBean.getFeedback());
				pstmt.setString(2,feedbackBean.getFeedbackId());
				
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
