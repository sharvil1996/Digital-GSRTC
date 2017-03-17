package com.dsynhub.digitalgsrtc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class AdminDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private boolean result = false;

	public boolean changePassword(AdminBean adminBean) {
		conn = DBConnection.getConnection();
		int rowAffected = 0;
		try {
			String updatePassword = "update admin set password=? where adminId=?";
			pstmt = conn.prepareStatement(updatePassword);
			pstmt.setString(1, adminBean.getPassword());
			pstmt.setString(2, adminBean.getAdminId());
			rowAffected =  pstmt.executeUpdate();
			
			if (rowAffected == 0) {
				result = true;
				System.out.println(rowAffected + " not Updated......");
				return false;

			} else {
				System.out.println(rowAffected + " Row Updated......");
				return true;

			}

			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (rowAffected == 0) {
			result = true;
			System.out.println(rowAffected + " Row Updated......");
			return false;

		} else {
			System.out.println(rowAffected + " Row Updated......");
			return true;

		}
	}

	public boolean insert(AdminBean adminBean) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO admin(firstName,"
					+ " middleName,lastname,email,password,mobileNo,cityId,address,"
					+ "gender)" + " values(?,?,?,?,?,?,?,?,?)";

			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, adminBean.getFirstName());
				pstmt.setString(2, adminBean.getMiddleName());
				pstmt.setString(3, adminBean.getLastName());
				pstmt.setString(4, adminBean.getEmail());
				pstmt.setString(5, adminBean.getPassword());
				pstmt.setString(6, adminBean.getMobileNo());
				pstmt.setString(7, adminBean.getCityId());
				pstmt.setString(8, adminBean.getAddress());
				pstmt.setString(9, adminBean.getGender());

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

	public List<AdminBean> list() {

		List<AdminBean> listOFUsers = new ArrayList<AdminBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {
			String selectSQL = "Select * from admin,city "
					+ "where admin.cityId=city.cityId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				AdminBean adminbean = null;
				while (rs.next()) {
					adminbean = new AdminBean();

					adminbean.setAdminId(rs.getString("adminId"));
					adminbean.setIsActive(rs.getString("isActive"));
					adminbean.setAddress(rs.getString("address"));
					adminbean.setEmail(rs.getString("email"));
					adminbean.setFirstName(rs.getString("firstName"));
					adminbean.setGender(rs.getString("gender"));
					adminbean.setMiddleName(rs.getString("middlename"));
					adminbean.setLastName(rs.getString("lastName"));
					adminbean.setPassword(rs.getString("password"));
					adminbean.setMobileNo(rs.getString("mobileNo"));
					adminbean.setCityId(rs.getString("cityId"));
					adminbean.setCityName(rs.getString("cityName"));

					listOFUsers.add(adminbean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOFUsers.size());
		return listOFUsers;
	}

	public boolean delete(String adminId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "update admin set isActive='n' where adminid=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, adminId);

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

	public AdminBean getByPK(String adminId) {

		conn = DBConnection.getConnection();

		AdminBean adminbean = new AdminBean();

		if (conn != null) {

			String selectSQL = "Select * from admin,CITY "
					+ "where admin.cityId=city.cityId " + "AND adminId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, adminId);
				System.out.println(adminId);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					adminbean.setAdminId(rs.getString("adminId"));
					adminbean.setIsActive(rs.getString("isActive"));
					adminbean.setAddress(rs.getString("address"));
					adminbean.setEmail(rs.getString("email"));
					adminbean.setFirstName(rs.getString("firstName"));
					adminbean.setLastName(rs.getString("lastName"));
					adminbean.setMiddleName(rs.getString("middleName"));
					adminbean.setGender(rs.getString("gender"));
					adminbean.setLastName(rs.getString("lastName"));
					adminbean.setPassword(rs.getString("password"));
					adminbean.setMobileNo(rs.getString("mobileNo"));
					adminbean.setCityId(rs.getString("cityId"));
					adminbean.setCityName(rs.getString("cityName"));

					System.out.println(adminbean.getAdminId());
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return adminbean;
	}

	public boolean update(AdminBean adminBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE admin set cityId=?,firstName=?,lastName=?,middleName=?,"
					+ "email=?,gender=?,Address=?,mobileno=?,isActive=? where adminId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, adminBean.getCityId());
				pstmt.setString(2, adminBean.getFirstName());
				pstmt.setString(3, adminBean.getLastName());
				pstmt.setString(4, adminBean.getMiddleName());
				pstmt.setString(5, adminBean.getEmail());
				pstmt.setString(6, adminBean.getGender());
				pstmt.setString(7, adminBean.getAddress());
				pstmt.setString(8, adminBean.getMobileNo());
				pstmt.setString(9, adminBean.getIsActive());
				pstmt.setString(10, adminBean.getAdminId());

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

	public boolean updatePassword(String adminId, String password) {

		boolean flag = false;
		conn = DBConnection.getConnection();
		if (conn != null) {
			String updateSQL = "update admin set Password=? where adminId=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, password);
				pstmt.setString(2, adminId);
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected > 0) {
					flag = true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}
