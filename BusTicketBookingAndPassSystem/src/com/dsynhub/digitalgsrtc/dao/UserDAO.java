package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.AdminBean;
import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class UserDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private boolean result = false;

	
	public boolean changePassword(UserBean userBean) {
		conn = DBConnection.getConnection();
		int rowAffected = 0;
		try {
			String updatePassword = "update user set password=? where userId=?";
			pstmt = conn.prepareStatement(updatePassword);
			pstmt.setString(1, userBean.getPassword());
			pstmt.setString(2, userBean.getUserId());
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

	
	public boolean resetPassword(UserBean userBean) {
		int i = 0;
		conn = DBConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("update user set password=? where email=?");
			pstmt.setString(1, userBean.getPassword());
			pstmt.setString(2, userBean.getEmail());
			i = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (i == 0)
			return false;
		else
			return true;

	}

	public boolean isEmailExists(String email) {
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement("select * from user where email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public Object checkUser(String userName, String password) {
		UserBean userBean = null;
		AdminBean adminBean = null;
		try {
			System.out.println(userName);
			System.out.println(password);
			conn = DBConnection.getConnection();
			String userSearchSQL = "select * from user where email=?";
			pstmt = conn.prepareStatement(userSearchSQL);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if (rs.next() && rs.getString("password").equals(password)) {
				userBean = new UserBean();
				userBean.setPassword(rs.getString("password"));
				userBean.setUserId(rs.getString("userId"));
				userBean.setFirstName(rs.getString("firstName"));
				userBean.setMiddleName(rs.getString("middleName"));
				userBean.setLastName(rs.getString("lastName"));
				userBean.setMobileNo(rs.getString("mobileNo"));
				userBean.setEmail(rs.getString("email"));
				userBean.setAddress(rs.getString("address"));
				userBean.setGender(rs.getString("gender"));
				userBean.setCityId(rs.getString("cityId"));

				userBean.setIsActive(rs.getString("isActive"));
				return userBean;
			} else {
				String adminSearchSQL = "select * from admin where email=?";
				pstmt = conn.prepareStatement(adminSearchSQL);
				pstmt.setString(1, userName);
				rs = pstmt.executeQuery();

				if (rs.next() && rs.getString("password").equals(password)) {
					System.out.println("Admin");
					adminBean = new AdminBean();
					adminBean.setAdminId(rs.getString("adminId"));
					adminBean.setFirstName(rs.getString("firstName"));
					adminBean.setMiddleName(rs.getString("middleName"));
					adminBean.setLastName(rs.getString("lastName"));
					adminBean.setEmail(rs.getString("email"));
					adminBean.setGender(rs.getString("gender"));
					adminBean.setCityId(rs.getString("cityId"));
					adminBean.setPassword(rs.getString("password"));
					adminBean.setMobileNo(rs.getString("mobileNo"));
					adminBean.setAddress(rs.getString("address"));
					adminBean.setIsActive(rs.getString("isActive"));
					return adminBean;
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public boolean insert(UserBean userBean) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String insertSQL = "INSERT INTO User(firstName,"
					+ " middleName,lastname,email,password,mobileNo,cityId,address,"
					+ "gender,regDate)"
					+ " values(?,?,?,?,?,?,?,?,?,curdate())";

			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, userBean.getFirstName());
				pstmt.setString(2, userBean.getMiddleName());
				pstmt.setString(3, userBean.getLastName());
				pstmt.setString(4, userBean.getEmail());
				pstmt.setString(5, userBean.getPassword());
				pstmt.setString(6, userBean.getMobileNo());
				pstmt.setString(7, userBean.getCityId());
				pstmt.setString(8, userBean.getAddress());
				pstmt.setString(9, userBean.getGender());

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

	public List<UserBean> list() {

		List<UserBean> listOFUsers = new ArrayList<UserBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {
			String selectSQL = "Select * from user,city "
					+ "where user.cityId=city.cityId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				UserBean userbean = null;
				while (rs.next()) {
					userbean = new UserBean();

					userbean.setUserId(rs.getString("userId"));
					userbean.setIsActive(rs.getString("isActive"));
					userbean.setAddress(rs.getString("address"));
					userbean.setEmail(rs.getString("email"));
					userbean.setFirstName(rs.getString("firstName"));
					userbean.setGender(rs.getString("gender"));
					userbean.setMiddleName(rs.getString("middlename"));
					userbean.setLastName(rs.getString("lastName"));
					userbean.setPassword(rs.getString("password"));
					userbean.setMobileNo(rs.getString("mobileNo"));
					userbean.setCityId(rs.getString("cityId"));
					userbean.setCityName(rs.getString("cityName"));
					userbean.setRegDate(rs.getString("regDate"));

					listOFUsers.add(userbean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOFUsers.size());
		return listOFUsers;
	}

	public boolean delete(String userId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "update user set isActive='n' where userid=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, userId);

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

	public UserBean getByPK(String userId) {

		conn = DBConnection.getConnection();

		UserBean userbean = new UserBean();

		if (conn != null) {

			String selectSQL = "Select * from user,CITY "
					+ "where user.cityId=city.cityId " + "AND userId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, userId);
				System.out.println(userId);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					userbean.setUserId(rs.getString("userId"));
					userbean.setIsActive(rs.getString("isActive"));
					userbean.setAddress(rs.getString("address"));
					userbean.setEmail(rs.getString("email"));
					userbean.setFirstName(rs.getString("firstName"));
					userbean.setGender(rs.getString("gender"));
					userbean.setLastName(rs.getString("lastName"));
					userbean.setPassword(rs.getString("password"));
					userbean.setMobileNo(rs.getString("mobileNo"));
					userbean.setCityId(rs.getString("cityId"));
					userbean.setCityName(rs.getString("cityName"));
					userbean.setLastName(rs.getString("lastName"));
					userbean.setMiddleName(rs.getString("middleName"));
					userbean.setRegDate(rs.getString("regDate"));

					System.out.println(userbean.getUserId());
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userbean;
	}

	public boolean update(UserBean userBean) {
		conn = DBConnection.getConnection();
		if (conn != null) {
			String updateSQL = "UPDATE user set cityId=?,firstName=?,lastName=?,middleName=?,"
					+ "gender=?,Address=?,mobileno=?,isActive=? where userId=?";

			System.out.println(userBean.getUserId() + "ID ");
			
			try {
				pstmt = conn.prepareStatement(updateSQL);


				pstmt.setString(1, userBean.getCityId());
				pstmt.setString(2, userBean.getFirstName());
				pstmt.setString(3, userBean.getLastName());
				pstmt.setString(4, userBean.getMiddleName());
				pstmt.setString(5, userBean.getGender());
				pstmt.setString(6, userBean.getAddress());
				pstmt.setString(7, userBean.getMobileNo());
				pstmt.setString(8, userBean.getIsActive());
				pstmt.setString(9, userBean.getUserId());

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

	public boolean updatePassword(String userId, String password) {

		boolean flag = false;
		conn = DBConnection.getConnection();
		if (conn != null) {
			String updateSQL = "update user set userPassword=? where userId=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, password);
				pstmt.setString(2, userId);
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
	
	public  ArrayList<UserBean> getRegularUserList()
	{
		ArrayList<UserBean> listOfUserBeans=new ArrayList<UserBean>();
	conn=DBConnection.getConnection();	
		UserBean userBeanObj=null;
		try {	
				pstmt=conn.prepareStatement("select * from user,city "+
					"where user.cityId=city.cityId and regDate=curdate()");
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				 userBeanObj=new UserBean();
					userBeanObj.setUserId(rs.getString("userId"));
					userBeanObj.setFirstName(rs.getString("firstName"));
					userBeanObj.setMiddleName(rs.getString("middleName"));
					userBeanObj.setLastName(rs.getString("lastName"));
				    userBeanObj.setMobileNo(rs.getString("mobileNo"));
				    userBeanObj.setEmail(rs.getString("email"));
				    userBeanObj.setAddress(rs.getString("address"));
				    userBeanObj.setGender(rs.getString("gender"));
				    userBeanObj.setCityName(rs.getString("cityName"));
				    userBeanObj.setCityId(rs.getString("cityId"));
				    userBeanObj.setIsActive(rs.getString("isActive"));
				    listOfUserBeans.add(userBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfUserBeans;
	}



}
