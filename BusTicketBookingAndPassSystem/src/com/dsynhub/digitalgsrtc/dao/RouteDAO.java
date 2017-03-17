package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.RouteBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;


public class RouteDAO 
{
	private Connection conn = null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	boolean result = false;
	private  ArrayList<RouteBean> listOfRouteBeans;
	public  RouteBean getRouteByPK2(String id)
	{
		listOfRouteBeans=new ArrayList<RouteBean>();
		conn=DBConnection.getConnection();
		RouteBean routeBean=null;
		try {
			pstmt=conn.prepareStatement("select sourceId,destinationId,routeId,isAvailable," +
										"ss.stationName as source," +
										"sd.stationName as destination " +
										"from route s,station ss,station sd " +
										"where s.sourceId=ss.stationId and " +
										"s.destinationId=sd.stationId and routeId=?");
			pstmt.setString(1, id);
			 rs=pstmt.executeQuery();
			rs.next();
			 routeBean=new RouteBean();
				routeBean.setRouteId(rs.getString("routeId"));
				routeBean.setIsAvailable(rs.getString("isAvailable"));
				routeBean.setDestinationName((rs.getString("destination")));
				routeBean.setSourceName((rs.getString("source")));
				routeBean.setSourceId(rs.getString("sourceId"));
				routeBean.setDestinationId(rs.getString("destinationId"));
				
				
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return routeBean;
	}

	public ArrayList<RouteBean> getDistinctBusNo(String id) {
		System.out.println(id+"  A");
		ArrayList<RouteBean> listOfBusDetailBeans = new ArrayList<RouteBean>();
		conn = DBConnection.getConnection();
		RouteBean routeBean = null;
		System.out.println("Bus" + id);
		try {
			pstmt = conn.prepareStatement("select distinct busNo from busDetail where routeId=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("hhhhh");
				routeBean = new RouteBean();
				routeBean.setBusNo(rs.getString("busNo"));
				listOfBusDetailBeans.add(routeBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfBusDetailBeans;
	}


	
	
	public boolean insert(RouteBean routebean){
		
		conn=DBConnection.getConnection();	
		
		 if(conn!=null){
			 String insertSQL = "insert into Route(sourceId,destinationId) values(?,?)";
			 
			 try {
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1,routebean.getSourceId());
				pstmt.setString(2, routebean.getDestinationId());
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
	
		public List<RouteBean> list(){
		
		List<RouteBean> listOfRoute = new ArrayList<RouteBean>();
		 conn=DBConnection.getConnection();	
			
		 if(conn!=null){

			 
			 String selectSQL = "select sourceId,destinationId,routeId,isAvailable,ss.stationName as source," +
					"sd.stationName as destination from route s,station ss," +
					"station sd where s.sourceId=ss.stationId and" +
					" s.destinationId=sd.stationId";
			 try {
				pstmt = conn.prepareStatement(selectSQL);
			
				rs = pstmt.executeQuery();
				RouteBean routeBean = null;

				while(rs.next()){
					
					routeBean = new RouteBean();
					routeBean.setSourceId(rs.getString("sourceId"));
					routeBean.setRouteId(rs.getString("RouteId"));
					routeBean.setDestinationId(rs.getString("destinationId"));
					routeBean.setDestinationName(rs.getString("destination"));
					routeBean.setSourceName(rs.getString("source"));
					routeBean.setIsAvailable(rs.getString("isAvailable"));
					listOfRoute.add(routeBean);
					
				}
				
				
			 } catch (SQLException e) {
				e.printStackTrace();
			}
			 
			 
		 }
		 	System.out.println("Size : "+listOfRoute.size());
			return listOfRoute;
		}

	
		public boolean delete(String routeId) {
			 
			 conn=DBConnection.getConnection();	
				
			 if(conn!=null){
				 String deleteSQL = "update Route set isAvailable='n' where RouteId=?";
				 
				 try {
					pstmt = conn.prepareStatement(deleteSQL);
					
					pstmt.setString(1,routeId);
				
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

		public RouteBean getByPK(String routeId) {
			
			 conn=DBConnection.getConnection();	
			 RouteBean routeBean = new RouteBean();			 
			 if(conn!=null){
				 
							 
				 String selectSQL = "select sourceId,destinationId,routeId,isAvailable,ss.stationName as source," +
					"sd.stationName as destination from route s,station ss," +
					"station sd where s.sourceId=ss.stationId and" +
					" s.destinationId=sd.stationId AND routeId=?";
				 try {
					pstmt = conn.prepareStatement(selectSQL);
				
					pstmt.setString(1, routeId);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()){
						System.out.println(rs.getString("destination")+"<");
						routeBean.setSourceId(rs.getString("sourceId"));
						routeBean.setRouteId(rs.getString("RouteId"));
						routeBean.setDestinationId(rs.getString("destinationId"));
						routeBean.setDestinationName(rs.getString("destination"));
						routeBean.setSourceName(rs.getString("source"));
						routeBean.setIsAvailable(rs.getString("isAvailable"));	
						
					
					}
					
					
				 } catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return routeBean;
		}
		
		public boolean update(RouteBean route) {
			
			 conn=DBConnection.getConnection();	
			 if(conn!=null){
				 String updateSQL = "update Route set sourceId=?,destinationId=? where RouteId=?";
				 
				 try {
					pstmt = conn.prepareStatement(updateSQL);
					
					
					pstmt.setString(1,route.getSourceId());
					pstmt.setString(2,route.getDestinationId());
					pstmt.setString(3,route.getRouteId());
					
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

		public boolean isExists(String sourceId, String destinationId) 
		{
			try {
				conn=DBConnection.getConnection();
				pstmt=conn.prepareStatement("select * from route where sourceId=? and destinationId=?");
				pstmt.setString(1, sourceId);
				pstmt.setString(2, destinationId);
				 rs=pstmt.executeQuery();
				 if(rs.next())
					 return true;
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return false;
		}

		public boolean checkReference(String routeId) 
		{
			try {
				conn=DBConnection.getConnection();
				pstmt=conn.prepareStatement("select * from busdetail where routeId=?");
				pstmt.setString(1, routeId);
				 rs=pstmt.executeQuery();
				 if(rs.next())
					 return true;
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
				return false;

		}
		
		


}
