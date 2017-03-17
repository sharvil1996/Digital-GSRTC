package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.PassBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class PassDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	boolean result = false;

	public boolean insert(PassBean passBean) {

		conn = DBConnection.getConnection();

		System.out.println(passBean.getValidity());
		if (conn != null) {
			String insertSQL = "INSERT INTO pass(userId,passTypeId,sourceID,DestinationId,orgId,"
					+ "termValidity,termStartDate,termEndDate,photo) values"
					+ "(?,?,?,?,?,?,curdate(),date_add(curdate(),interval "
					+ Integer.parseInt(passBean.getValidity())
					* 30
					+ " day),?)";

			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, passBean.getUserId());
				pstmt.setString(2, passBean.getPassTypeId());
				pstmt.setString(3, passBean.getSourceId());
				pstmt.setString(4, passBean.getDestinationId());
				pstmt.setString(5, passBean.getOrgId());
				pstmt.setString(6, passBean.getValidity());
				pstmt.setString(7, passBean.getPhoto());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					insertSQL = "insert into passDetail(passId,validity,amount,startDate,endDate) values(LAST_INSERT_ID(),?,?,curdate(),date_add(curdate(),interval "
							+ Integer.parseInt(passBean.getValidity())
							* 30
							+ " day))";
					pstmt = conn.prepareStatement(insertSQL);

					pstmt.setString(1, passBean.getValidity());
					pstmt.setString(2, Integer.parseInt(passBean.getValidity())
							* 300 + "");

					if (pstmt.executeUpdate() > 0) {

						System.out.println("Pass & PassDetail Inseted....");
						return true;
					} else {
						String temp = "delete from * pass where passId=LAST_INSERT_ID()";
						pstmt = conn.prepareStatement(temp);
						pstmt.execute();
					}

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

	public List<PassBean> list() {

		List<PassBean> listOfPass = new ArrayList<PassBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {
			String selectSQL = "select o.orgName,p.termValidity,p.termStartDate,p.termEndDate,"
					+ "u.userId,u.firstName,u.middleName,u.lastName,u.Email,passId,ss.stationName as source,sd.stationName "
					+ "as destination,pt.passTypeName,pt.passTypeId,p.isActive from pass p,user u,station "
					+ "ss,passType pt,station sd,organization o where p.userId=u.userId and "
					+ "p.sourceId=ss.stationId and p.destinationId=sd.stationId"
					+ " and p.passTypeId=pt.passTypeId and o.orgId=p.orgId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				PassBean passBean;
				while (rs.next()) {

					passBean = new PassBean();
					passBean.setOrgName(rs.getString("orgName"));
					passBean.setFirstName(rs.getString("firstName"));
					passBean.setMiddleName(rs.getString("middleName"));
					passBean.setLastName(rs.getString("lastName"));
					passBean.setEmail(rs.getString("email"));
					passBean.setPassId(rs.getString("passId"));
					passBean.setIsActive(rs.getString("isActive"));
					passBean.setSource(rs.getString("source"));
					passBean.setDestination(rs.getString("destination"));
					passBean.setPassType(rs.getString("passTypeName"));
					passBean.setUserId(rs.getString("userId"));
					passBean.setValidity(rs.getString("termValidity"));
					passBean.setStartTermDate(rs.getString("termStartDate"));
					passBean.setEndTermDate(rs.getString("termEndDate"));

					listOfPass.add(passBean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOfPass.size());
		return listOfPass;
	}

		
	public boolean delete(String passId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "DELETE FROM passDetail WHERE passId=?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, passId);

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {

					System.out.println(rowsAffected
							+ " Row(s) Deleted From PassDetail......");

					deleteSQL = "DELETE FROM pass WHERE passId=?";

					pstmt = conn.prepareStatement(deleteSQL);

					pstmt.setString(1, passId);
					rowsAffected = pstmt.executeUpdate();

					if (rowsAffected > 0) {
						result = true;
						System.out.println(rowsAffected
								+ " Row(s) Deleted From Pass......");
					}

				} else {
					System.out.println(rowsAffected + " Row(s) Deleted......");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	public PassBean getByPK(String passId) {
		conn = DBConnection.getConnection();
		PassBean passBean = new PassBean();

		if (conn != null) {
			String selectSQL = "select p.sourceId,p.destinationId,p.photo,p.orgId,o.orgName,o.orgAddress,p.termValidity,p.termStartDate,p.termEndDate,"
					+ "u.userId,u.firstName,u.middleName,u.lastName,u.Email,passId,ss.stationName as source,sd.stationName "
					+ "as destination,pt.passTypeName,pt.passTypeId,p.isActive from pass p,user u,station "
					+ "ss,passType pt,station sd,organization o where p.userId=u.userId and "
					+ "p.sourceId=ss.stationId and p.destinationId=sd.stationId"
					+ " and p.passTypeId=pt.passTypeId and o.orgId=p.orgId and passId=?";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, passId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					passBean.setOrgId(rs.getString("orgId"));
					passBean.setUserId(rs.getString("userId"));
					passBean.setFirstName(rs.getString("firstName"));
					passBean.setMiddleName(rs.getString("middleName"));
					passBean.setLastName(rs.getString("lastName"));
					passBean.setEmail(rs.getString("email"));
					passBean.setPassId(rs.getString("passId"));
					passBean.setIsActive(rs.getString("isActive"));
					passBean.setSourceId(rs.getString("sourceId"));
					passBean.setDestinationId(rs.getString("destinationId"));
					passBean.setSource(rs.getString("source"));
					passBean.setDestination(rs.getString("destination"));
					passBean.setPassTypeId(rs.getString("passTypeId"));
					passBean.setUserId(rs.getString("userId"));
					passBean.setValidity(rs.getString("termValidity"));
					passBean.setStartTermDate(rs.getString("termStartDate"));
					passBean.setEndTermDate(rs.getString("termEndDate"));
					passBean.setOrganizationName(rs.getString("orgName"));
					passBean.setOrganizationAddress(rs.getString("orgAddress"));
					passBean.setPhoto(rs.getString("photo"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return passBean;
	}

	public PassBean getByUserId(String userId) {
		conn = DBConnection.getConnection();
		PassBean passBean = new PassBean();

		if (conn != null) {
			String selectSQL = "select p.sourceId,p.destinationId,p.photo,p.orgId,o.orgName,o.orgAddress,p.termValidity,p.termStartDate,p.termEndDate,"
					+ "u.userId,u.firstName,u.middleName,u.lastName,u.Email,passId,ss.stationName as source,sd.stationName "
					+ "as destination,pt.passTypeName,pt.passTypeId,p.isActive from pass p,user u,station "
					+ "ss,passType pt,station sd,organization o where p.userId=u.userId and "
					+ "p.sourceId=ss.stationId and p.destinationId=sd.stationId"
					+ " and p.passTypeId=pt.passTypeId and o.orgId=p.orgId and p.userId=?";

			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, userId);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					passBean.setOrgId(rs.getString("orgId"));
					passBean.setUserId(rs.getString("userId"));
					passBean.setFirstName(rs.getString("firstName"));
					passBean.setMiddleName(rs.getString("middleName"));
					passBean.setLastName(rs.getString("lastName"));
					passBean.setEmail(rs.getString("email"));
					passBean.setPassId(rs.getString("passId"));
					passBean.setIsActive(rs.getString("isActive"));
					passBean.setSourceId(rs.getString("sourceId"));
					passBean.setDestinationId(rs.getString("destinationId"));
					passBean.setPassTypeId(rs.getString("passTypeId"));
					passBean.setUserId(rs.getString("userId"));
					passBean.setValidity(rs.getString("termValidity"));
					passBean.setStartTermDate(rs.getString("termStartDate"));
					passBean.setEndTermDate(rs.getString("termEndDate"));
					passBean.setPhoto(rs.getString("photo"));
					passBean.setOrganizationName(rs.getString("orgName"));
					passBean.setOrganizationId(rs.getString("orgId"));
					passBean.setOrganizationAddress(rs.getString("orgAddress"));
					passBean.setSource(rs.getString("source"));
					passBean.setDestination(rs.getString("destination"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return passBean;
	}
	
	public boolean update(PassBean passBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE pass set passTypeId=?,sourceID=?,destinationId=?,orgId=?,"
					+ "termValidity=?,termStartDate=curDate(),"
					+ "photo=?,termEndDate=date_add(curdate(),interval "
					+ Integer.parseInt(passBean.getValidity())
					* 30
					+ " day) where passId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, passBean.getPassTypeId());
				pstmt.setString(2, passBean.getSourceId());
				pstmt.setString(3, passBean.getDestinationId());
				pstmt.setString(4, passBean.getOrgId());
				pstmt.setString(5, passBean.getValidity());
				pstmt.setString(6, passBean.getPhoto());
				pstmt.setString(7, passBean.getPassId());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {

					updateSQL = "update passDetail set validity=?,amount=?,startDate=curDate(),"
							+ "endDate=date_add(curdate(),interval "
							+ Integer.parseInt(passBean.getValidity())
							* 30
							+ " day) where passId=?";
					pstmt = conn.prepareStatement(updateSQL);

					pstmt.setString(1, passBean.getValidity());
					pstmt.setString(2, Integer.parseInt(passBean.getValidity())
							* 300 + "");
					pstmt.setString(3, passBean.getPassId());
					rowsAffected = pstmt.executeUpdate();
					if (rowsAffected > 0) {
						System.out.println("Pass & PassDetail Row(s) Updated......");
						return true;
					}

				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	public boolean renewPass(PassBean passBean) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "UPDATE pass set "
					+ "termStartDate=curDate(),"
					+ "termEndDate=date_add(curdate(),interval "
					+ Integer.parseInt(passBean.getValidity())
					* 30
					+ " day) where passId=?";

			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, passBean.getPassId());

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {

					updateSQL = "update passDetail set startDate=curDate(),"
							+ "endDate=date_add(curdate(),interval "
							+ Integer.parseInt(passBean.getValidity())
							* 30
							+ " day) where passId=?";
					pstmt = conn.prepareStatement(updateSQL);

					pstmt.setString(1, passBean.getPassId());
					rowsAffected = pstmt.executeUpdate();
					if (rowsAffected > 0) {
						System.out.println("Pass & PassDetail Row(s) Renewed......");
						return true;
					}

				} else {
					System.out.println(rowsAffected + " Row(s) Updated......");

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
		}

	
	
	public boolean isExist(String userId) {
		conn = DBConnection.getConnection();
		try {
			pstmt=conn.prepareStatement("select * from pass where userid=?");
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			 if (rs.next()) {
				 return true;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}



	public List<PassBean> getRegularPassDetailList() {

		List<PassBean> listOfPass = new ArrayList<PassBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {
			String selectSQL = "select o.orgName,p.termValidity,p.termStartDate,p.termEndDate,"
					+ "u.userId,u.firstName,u.middleName,u.lastName,u.Email,passId,ss.stationName as source,sd.stationName "
					+ "as destination,pt.passTypeName,pt.passTypeId,p.isActive from pass p,user u,station "
					+ "ss,passType pt,station sd,organization o where p.userId=u.userId and "
					+ "p.sourceId=ss.stationId and p.destinationId=sd.stationId"
					+ " and p.passTypeId=pt.passTypeId and o.orgId=p.orgId and p.termStartDate=curdate()";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				PassBean passBean;
				while (rs.next()) {

					passBean = new PassBean();
					passBean.setOrgName(rs.getString("orgName"));
					passBean.setFirstName(rs.getString("firstName"));
					passBean.setMiddleName(rs.getString("middleName"));
					passBean.setLastName(rs.getString("lastName"));
					passBean.setEmail(rs.getString("email"));
					passBean.setPassId(rs.getString("passId"));
					passBean.setIsActive(rs.getString("isActive"));
					passBean.setSource(rs.getString("source"));
					passBean.setDestination(rs.getString("destination"));
					passBean.setPassType(rs.getString("passTypeName"));
					passBean.setUserId(rs.getString("userId"));
					passBean.setValidity(rs.getString("termValidity"));
					passBean.setStartTermDate(rs.getString("termStartDate"));
					passBean.setEndTermDate(rs.getString("termEndDate"));

					listOfPass.add(passBean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOfPass.size());
		return listOfPass;
	}




}

