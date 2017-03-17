package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.BusBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class BusDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	
	
		public boolean insert(BusBean busBean) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO BUS(busNo,capacity,busTypeId,busDepoId,busCategoryId) "
					+ "values(?,?,?,?,?)";

			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, busBean.getBusNo());
				pstmt.setString(2, busBean.getCapacity());
				pstmt.setString(3, busBean.getBusTypeId());
				pstmt.setString(4, busBean.getBusDepoId());
				pstmt.setString(5, busBean.getBusCategoryId());

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

	public List<BusBean> list() {

		List<BusBean> listOfBus = new ArrayList<BusBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {
			String selectSQL = "SELECT * FROM BUS,BUSTYPE,BUSCATEGORY,CITY "
					+ "where bus.busTypeId=busType.busTypeId and "
					+ "bus.busCategoryId=busCategory.busCategoryId and "
					+ "bus.busDepoId=city.cityId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				BusBean busbean = null;
				while (rs.next()) {
					busbean = new BusBean();

					busbean.setBusNo(rs.getString("busNo"));

					busbean.setBusDepoId(rs.getString("cityId"));
					busbean.setBusDepoName(rs.getString("cityName"));

					busbean.setBusTypeId(rs.getString("BusTypeId"));
					busbean.setBusTypeName(rs.getString("BusTypeName"));

					busbean.setBusCategoryId(rs.getString("BusCategoryId"));
					busbean.setBusCategoryName(rs.getString("BusCategoryName"));

					busbean.setCapacity(rs.getString("capacity"));
					busbean.setIsAvailable(rs.getString("isAvailable"));

					listOfBus.add(busbean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOfBus.size());
		return listOfBus;
	}

	public boolean delete(String busNo) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "UPDATE bus set isAvailable='n' WHERE busNo=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, busNo);

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

	public BusBean getByPK(String busNo) {
		System.out.println("HI" + busNo);
		conn = DBConnection.getConnection();
		BusBean busbean = new BusBean();

		if (conn != null) {
			String selectSQL = "SELECT * FROM BUS,BUSTYPE,BUSCATEGORY,CITY "
					+ "where bus.busTypeId=busType.busTypeId and "
					+ "bus.busCategoryId=busCategory.busCategoryId and "
					+ "bus.busDepoId=city.cityId " + "AND busNo=?";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, busNo);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					busbean.setBusNo(rs.getString("busNo"));

					busbean.setBusDepoId(rs.getString("cityId"));
					busbean.setBusDepoName(rs.getString("cityName"));

					busbean.setBusTypeId(rs.getString("BusTypeId"));
					busbean.setBusTypeName(rs.getString("BusTypeName"));

					busbean.setBusCategoryId(rs.getString("BusCategoryId"));
					busbean.setBusCategoryName(rs.getString("BusCategoryName"));

					busbean.setCapacity(rs.getString("capacity"));
					busbean.setIsAvailable(rs.getString("isAvailable"));

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return busbean;
	}

	public boolean update(BusBean busBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE bus set "
					+ "busTypeId=?,busCategoryId=?,busDepoId=?,capacity=?,isAvailable=? "
					+ "WHERE busNo=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(4, busBean.getCapacity());
				pstmt.setString(1, busBean.getBusTypeId());
				pstmt.setString(3, busBean.getBusDepoId());
				pstmt.setString(2, busBean.getBusCategoryId());
				pstmt.setString(5, busBean.getIsAvailable());
				pstmt.setString(6, busBean.getBusNo());
				System.out.println("cap : " + busBean.getCapacity()
						+ "\nbustypeId : " + busBean.getBusTypeId());
				System.out.println("Busdepo : " + busBean.getBusDepoId() + "  "
						+ busBean.getBusNo());
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
