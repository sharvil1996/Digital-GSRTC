package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.StationBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class StationDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	boolean result = false;


	public boolean insert(StationBean stationbean) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "insert into Station(StationName,cityId) values(?,?)";

			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, stationbean.getStationName());
				pstmt.setString(2, stationbean.getCityId());
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
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	public List<StationBean> list() {

		List<StationBean> listOfStation = new ArrayList<StationBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {

			String selectSQL = "select * from Station,city " +
							    "where station.cityId=city.cityId " +
								"order by stationId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();
				StationBean stationBean = null;

				while (rs.next()) {

					stationBean = new StationBean();
					stationBean.setCityId(rs.getString("cityId"));
					stationBean.setStationId(rs.getString("StationId"));
					stationBean.setStationName(rs.getString("StationName"));
					stationBean.setCityName(rs.getString("cityName"));
					listOfStation.add(stationBean);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOfStation.size());
		return listOfStation;
	}

	public boolean delete(String stationId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "delete from Station where StationId=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, stationId);

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

	public StationBean getByPK(String stationId) {

		conn = DBConnection.getConnection();
		StationBean station = new StationBean();
		if (conn != null) {

			String selectSQL = "Select * from station WHERE stationId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, stationId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getString("stationName"));
					station.setStationId(rs.getString("StationId"));
					station.setCityId(rs.getString("cityId"));
					station.setStationName(rs.getString("stationName"));

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return station;
	}

	public boolean update(StationBean station) {

		conn = DBConnection.getConnection();
		if (conn != null) {
			String updateSQL = "update Station set StationName=?,cityId=? where StationId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, station.getStationName());
				pstmt.setString(2, station.getCityId());
				pstmt.setString(3, station.getStationId());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
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
