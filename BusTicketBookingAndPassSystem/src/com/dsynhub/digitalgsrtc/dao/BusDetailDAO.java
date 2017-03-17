package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.BusDetailBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class BusDetailDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public String getBusDetailId(String busNo,String routeId) {
		ArrayList<BusDetailBean> listOfBusDetailBeans = new ArrayList<BusDetailBean>();
		conn = DBConnection.getConnection();
		System.out.println(busNo + " " + routeId) ;
		BusDetailBean busDetailBean = null;
		try {
			pstmt = conn.prepareStatement("select busDetailId from busDetail where routeId=? and busNo=?");
			pstmt.setString(1,routeId);
			pstmt.setString(2, busNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				busDetailBean= new BusDetailBean();
				return rs.getString("busDetailId");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}


	
	public ArrayList<BusDetailBean> getDistinctBusDetailList() {
		
		ArrayList<BusDetailBean> listOfBusDetailBeans = new ArrayList<BusDetailBean>();
		
		conn = DBConnection.getConnection();
		
		BusDetailBean busDetailBean = null;
		if(conn!=null)
		{
		try {
			pstmt = conn.prepareStatement("select distinct routeId from busDetail");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				busDetailBean = new BusDetailBean();
				busDetailBean.setRouteId(rs.getString("routeId"));
				listOfBusDetailBeans.add(busDetailBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		}
		return listOfBusDetailBeans;
	}

	public boolean insert(BusDetailBean busDetailBean) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO busdetail(routeid,busNo) values(?,?)";

			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, busDetailBean.getRouteId());
				pstmt.setString(2, busDetailBean.getBusNo());

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	public List<BusDetailBean> list() {

		List<BusDetailBean> listOfBusDetail = new ArrayList<BusDetailBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {
			try {
				pstmt = conn
						.prepareStatement("select b.busDetailId,b.isAvailable,r.routeId,"
								+ "bs.busNo,ss.stationName as source,sd.stationName as destination "
								+ "from busDetail b,route r,bus bs,station ss,station sd "
								+ "where b.routeid=r.routeId and r.sourceId=ss.stationId "
								+ " and r.destinationId=sd.stationId and  b.busNo=bs.busNo");

				rs = pstmt.executeQuery();

				BusDetailBean busDetailBean = null;
				while (rs.next()) {
					busDetailBean = new BusDetailBean();

					busDetailBean.setBusDetailId(rs.getString("busDetailId"));
					busDetailBean.setBusNo(rs.getString("busNo"));
					busDetailBean.setDestination(rs.getString("destination"));
					busDetailBean.setIsAvailable(rs.getString("isAvailable"));
					busDetailBean.setRouteId(rs.getString("routeId"));
					busDetailBean.setSource(rs.getString("source"));

					listOfBusDetail.add(busDetailBean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("BusDetail Size : " + listOfBusDetail.size());
		return listOfBusDetail;
	}

	public boolean delete(String busDetailId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "update busDetail set isAvailable=? where busdetailId=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, "n");
				pstmt.setString(2, busDetailId);

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
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

	public BusDetailBean getByPK(String busDetailId) {

		conn = DBConnection.getConnection();
		BusDetailBean busDetailBean = new BusDetailBean();

		if (conn != null) {
			String selectSQL = "select b.busDetailId,b.isAvailable,r.routeId,"
					+ "bs.busNo,ss.stationName as source,sd.stationName as destination from busDetail b,route r"
					+ " ,bus bs,station ss,station sd where b.routeid=r.routeId and r.sourceId=ss.stationId "
					+ " and r.destinationId=sd.stationId and  b.busNo=bs.busNo And b.busdetailId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, busDetailId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					busDetailBean.setBusDetailId(rs.getString("busDetailId"));
					busDetailBean.setBusNo(rs.getString("busNo"));
					busDetailBean.setDestination(rs.getString("destination"));
					busDetailBean.setIsAvailable(rs.getString("isAvailable"));
					busDetailBean.setRouteId(rs.getString("routeId"));
					busDetailBean.setSource(rs.getString("source"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return busDetailBean;
	}

	public boolean update(BusDetailBean busDetailBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE busDetail set routeId=?,isAvailable=? WHERE busDetailId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, busDetailBean.getRouteId());
				pstmt.setString(2, busDetailBean.getIsAvailable());
				pstmt.setInt(3,Integer.parseInt(busDetailBean.getBusDetailId()));

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

}
