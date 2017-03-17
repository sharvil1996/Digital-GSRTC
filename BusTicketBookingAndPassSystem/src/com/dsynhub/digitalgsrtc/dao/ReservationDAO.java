package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ReservationDetailBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class ReservationDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ReservationBean> listOfReservationBeans;

	
	
	public ArrayList<ReservationBean> getRegularReservationList() // ajni date
																	// mate all
	{
		listOfReservationBeans = new ArrayList<ReservationBean>();
		conn = DBConnection.getConnection();
		ReservationBean reservationBean = null;
		try {
			pstmt = conn
					.prepareStatement("select s.journeyDate,s.userId,u.firstName,u.middleName,"
							+ "u.lastName,u.email,sourceId,destinationId,reservationId,isCancel,ss.stationName "
							+ "as source,s.noOfSeat,s.totalAmount,s.busNo,s.distance,"
							+ "sd.stationName as destination "
							+ "from reservation s,station ss,user u,station sd ,bus bs "
							+ "where s.sourceId=ss.stationId and"
							+ " s.destinationId=sd.stationId and s.busNo=bs.busNo and s.userId=u.userId"
							+ " and isCancel='n' and s.resDate=curdate()");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationBean = new ReservationBean();
				reservationBean.setReservationId(rs
						.getString("reservationId"));
				reservationBean.setDestinationName((rs
						.getString("destination")));
				reservationBean.setSourceName((rs.getString("source")));
				reservationBean.setSourceId(rs.getString("sourceId"));
				reservationBean.setDestinationId(rs
						.getString("destinationId"));
				reservationBean.setDistance(rs.getInt("distance"));
				reservationBean.setTotalAmount(rs.getInt("totalAmount"));
				reservationBean.setIsCancel(rs.getString("isCancel"));
				reservationBean.setBusNo(rs.getString("busNo"));
				reservationBean.setNoOfSeat(rs.getInt("noOfSeat"));
				reservationBean.setUserId(rs.getString("userId"));
				reservationBean.setJourneyDate(rs.getDate("journeyDate")
						.toString());
				reservationBean.setFirstName(rs.getString("firstName"));
				reservationBean.setMiddleName(rs.getString("middleName"));
				reservationBean.setLastName(rs.getString("lastName"));
				reservationBean.setEmail(rs.getString("email"));
				listOfReservationBeans.add(reservationBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationBeans;
	}

	public ArrayList<ReservationBean> getUserReservationList(String userID) // perticular
																			// date
	{
		listOfReservationBeans = new ArrayList<ReservationBean>();
		conn = DBConnection.getConnection();
		ReservationBean reservationBean = null;
		try {

			pstmt = conn
					.prepareStatement("select s.journeyDate,s.userId,u.firstName,u.middleName,"
							+ "u.lastName,u.email,sourceId,destinationId,reservationId,isCancel,ss.stationName "
							+ "as source,s.noOfSeat,s.totalAmount,s.busNo,s.distance"
							+ ",sd.stationName as destination "
							+ "from reservation s,station ss,user u,station sd ,bus bs " 
							+ "where s.sourceId=ss.stationId and"
							+ " s.destinationId=sd.stationId and s.busNo=bs.busNo and s.userId=u.userId"
							+ " and isCancel='n' and s.userId=?");
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationBean = new ReservationBean();
				reservationBean
						.setReservationId(rs.getString("reservationId"));
				reservationBean
						.setDestinationName((rs.getString("destination")));
				reservationBean.setSourceName((rs.getString("source")));
				reservationBean.setSourceId(rs.getString("sourceId"));
				reservationBean
						.setDestinationId(rs.getString("destinationId"));
				reservationBean.setDistance(rs.getInt("distance"));
				reservationBean.setTotalAmount(rs.getInt("totalAmount"));
				reservationBean.setIsCancel(rs.getString("isCancel"));
				reservationBean.setBusNo(rs.getString("busNo"));
				reservationBean.setNoOfSeat(rs.getInt("noOfSeat"));
				reservationBean.setUserId(rs.getString("userId"));
				reservationBean.setJourneyDate(rs.getDate("journeyDate")
						.toString());
				reservationBean.setFirstName(rs.getString("firstName"));
				reservationBean.setMiddleName(rs.getString("middleName"));
				reservationBean.setLastName(rs.getString("lastName"));
				reservationBean.setEmail(rs.getString("email"));
				listOfReservationBeans.add(reservationBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationBeans;
	}

	public boolean cancelReservation(String resId) {
		int i = 0;
		Savepoint p1 = null;
		conn = DBConnection.getConnection();
		try {
			conn.setAutoCommit(false);
			p1 = conn.setSavepoint();
			pstmt = conn
					.prepareStatement("update reservation set isCancel='y'"
							+ " where reservationId=?");
			pstmt.setString(1, resId);
			i = pstmt.executeUpdate();
			p1 = conn.setSavepoint();
			pstmt = conn
					.prepareStatement("delete from reservationDetail where reservationId=?");
			pstmt.setString(1, resId);
			i = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			try {
				conn.rollback(p1);
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	public boolean insert(ReservationBean reservationBean) {
		conn = DBConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("insert into reservation(sourceId,destinationId,busNo,"
							+ "noOfSeat,totalAmount,userId,"
							+ "distance,journeyDate,resDate) values(?,?,?,?,?,?,?,?,curdate())");
			pstmt.setString(1, reservationBean.getSourceId());
			pstmt.setString(2, reservationBean.getDestinationId());
			pstmt.setString(3, reservationBean.getBusNo());
			pstmt.setInt(4, reservationBean.getNoOfSeat());
			pstmt.setInt(5, reservationBean.getTotalAmount());
			pstmt.setString(6, reservationBean.getUserId());
			pstmt.setInt(7, reservationBean.getDistance());
			pstmt.setString(8, reservationBean.getJourneyDate());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;

	}

	public ReservationBean getByPK(String reservationId) {
		conn = DBConnection.getConnection();
		ReservationBean reservationBean = null;
		try {
			pstmt = conn
					.prepareStatement("select s.journeyDate,s.userId,u.firstName,u.middleName,"
							+ "u.lastName,u.email,sourceId,destinationId,reservationId,isCancel,ss.stationName "
							+ "as source,sd.stationName as destination,s.noOfSeat,s.totalAmount,s.busNo,s.distance"
							+ ",sd.stationName as destination from reservation s,station ss,user u,"
							+ "station sd ,bus bs where s.sourceId=ss.stationId and"
							+ " s.destinationId=sd.stationId and s.busNo=bs.busNo and s.userId=u.userId"
							+ " and s.reservationId=? and isCancel='n'");
			pstmt.setString(1, reservationId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				reservationBean = new ReservationBean();
				reservationBean.setReservationId(reservationId);
				reservationBean
						.setDestinationId(rs.getString("destinationId"));
				reservationBean.setSourceId(rs.getString("sourceId"));
				reservationBean.setDestinationName(rs.getString("destination"));
				reservationBean.setSourceName(rs.getString("source"));
				reservationBean.setIsCancel(rs.getString("isCancel"));
				reservationBean.setBusNo(rs.getString("busNo"));
				reservationBean.setDistance(rs.getInt("distance"));
				reservationBean.setNoOfSeat(rs.getInt("noOfSeat"));
				reservationBean.setJourneyDate(rs.getString("journeyDate"));
				reservationBean.setTotalAmount(rs.getInt("totalAmount"));
				reservationBean.setFirstName(rs.getString("firstName"));
				reservationBean.setMiddleName(rs.getString("middleName"));
				reservationBean.setLastName(rs.getString("lastName"));
				reservationBean.setEmail(rs.getString("email"));
				reservationBean.setUserId(rs.getString("userId"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return reservationBean;
	}

	public boolean updateReservation(
			ReservationDetailBean reservationDetailBeanobj,
			ReservationBean reservationBean) {
		int i = 0;
		Savepoint p1 = null;
		conn = DBConnection.getConnection();
		try {
			conn.setAutoCommit(false);
			p1 = conn.setSavepoint();
			pstmt = conn
					.prepareStatement("update reservation set noOfSeat=?,isCancel=?,journeyDate=?,userId=? where reservationId=?");
			pstmt.setInt(1, reservationBean.getNoOfSeat());
			pstmt.setString(2, reservationBean.getIsCancel());
			pstmt.setString(3, reservationBean.getJourneyDate());
			pstmt.setString(4, reservationBean.getUserId());
			pstmt.setString(5, reservationBean.getReservationId());
			i = pstmt.executeUpdate();
			p1 = conn.setSavepoint();
			String seat[] = reservationDetailBeanobj.getSeatNo();
			new ReservationDetailDAO()
					.removeReservationDetailById(reservationBean
							.getReservationId());
			for (int j = 0; j < seat.length; j++) {
				pstmt = conn
						.prepareStatement("insert into reservationDetail(reservationId,seatNo,seatTypeId) values("
								+ "?,?,?)");
				pstmt.setString(1, reservationBean.getReservationId());
				pstmt.setInt(2, Integer.parseInt(seat[j]));
				pstmt.setString(3, reservationDetailBeanobj.getSeatTypeId());
				p1 = conn.setSavepoint();
				i = pstmt.executeUpdate();
				conn.setAutoCommit(true);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			try {
				conn.rollback(p1);
				return false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean removeReservation(String reservationId) {
		conn = DBConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("delete  from reservation where reservationId=?");
			pstmt.setString(1, reservationId);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

	public ArrayList<ReservationBean> list() // no date define
	{
		listOfReservationBeans = new ArrayList<ReservationBean>();
		conn = DBConnection.getConnection();
		ReservationBean reservationBean = null;
		try {
			pstmt = conn
					.prepareStatement("select s.journeyDate,s.userId,u.firstName,u.middleName,"
							+ "u.lastName,u.email,sourceId,destinationId,reservationId,isCancel,ss.stationName "
							+ "as source,s.noOfSeat,s.totalAmount,s.busNo,s.distance"
							+ ",sd.stationName as destination from reservation s,station ss,user u,"
							+ "station sd ,bus bs where s.sourceId=ss.stationId and"
							+ " s.destinationId=sd.stationId and s.busNo=bs.busNo and s.userId=u.userId"
							+ " and isCancel='n'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationBean = new ReservationBean();
				reservationBean
						.setReservationId(rs.getString("reservationId"));
				reservationBean
						.setDestinationName((rs.getString("destination")));
				reservationBean.setSourceName((rs.getString("source")));
				reservationBean.setSourceId(rs.getString("sourceId"));
				reservationBean
						.setDestinationId(rs.getString("destinationId"));
				reservationBean.setDistance(rs.getInt("distance"));
				reservationBean.setTotalAmount(rs.getInt("totalAmount"));
				reservationBean.setIsCancel(rs.getString("isCancel"));
				reservationBean.setBusNo(rs.getString("busNo"));
				reservationBean.setNoOfSeat(rs.getInt("noOfSeat"));
				reservationBean.setUserId(rs.getString("userId"));
				reservationBean.setJourneyDate(rs.getDate("journeyDate")
						.toString());
				reservationBean.setFirstName(rs.getString("firstName"));
				reservationBean.setMiddleName(rs.getString("middleName"));
				reservationBean.setLastName(rs.getString("lastName"));
				reservationBean.setEmail(rs.getString("email"));
				listOfReservationBeans.add(reservationBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationBeans;
	}

}
