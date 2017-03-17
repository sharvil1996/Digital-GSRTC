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

public class ReservationDetailDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<ReservationDetailBean> listOfReservationDetailBeans;

	public boolean insert(ReservationDetailBean reservationDetailBean,
			ReservationBean reservationBean) {
		conn = DBConnection.getConnection();
		Savepoint p1 = null;
		int i = 0;
		try {
			conn.setAutoCommit(false);
			p1 = conn.setSavepoint();
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
			p1 = conn.setSavepoint();
			String[] seat = reservationDetailBean.getSeatNo();
			for (int j = 0; j < reservationDetailBean.getSeatNo().length; j++) {
				pstmt = conn
						.prepareStatement("insert into reservationDetail(reservationId,seatNo,seatTypeId) values(last_"
								+ "insert_id(),?,?)");
				pstmt.setString(1, seat[j]);
				pstmt.setString(2, reservationDetailBean.getSeatTypeId());
				i = pstmt.executeUpdate();
			}

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

	public ArrayList<ReservationDetailBean> getReservationSeats2(
			ReservationBean reservationBean) {
		listOfReservationDetailBeans = new ArrayList<ReservationDetailBean>();
		conn = DBConnection.getConnection();
		ReservationDetailBean reservationDetailBean = null;
		try {

			pstmt = conn
					.prepareStatement("select rd.seatNo,rd.seatTypeId from reservationDetail rd,"
							+ "reservation r where r.journeyDate=?"
							+ " and busNo=? and r.reservationId=rd.reservationId"
							+ " and isCancel='n'");
			pstmt.setString(1, reservationBean.getJourneyDate());
			pstmt.setString(2, reservationBean.getBusNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationDetailBean = new ReservationDetailBean();
				reservationDetailBean.setSeatNum(rs.getInt("seatNo"));
				reservationDetailBean.setSeatTypeId(rs.getString("seatTypeId"));
				listOfReservationDetailBeans.add(reservationDetailBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationDetailBeans;
	}

	public ArrayList<ReservationDetailBean> getReservationSeats(
			ReservationBean reservationBean) {
		listOfReservationDetailBeans = new ArrayList<ReservationDetailBean>();
		conn = DBConnection.getConnection();
		ReservationDetailBean reservationDetailBean = null;
		try {
			pstmt = conn
					.prepareStatement("select rd.seatNo,rd.seatTypeId" +
							" from reservationDetail rd,reservation r " +
							"where r.journeyDate=?"
							+ " and busNo=? and r.reservationId=rd.reservationId"
							+ " and isCancel='n'");
			pstmt.setString(1, reservationBean.getJourneyDate());
			pstmt.setString(2, reservationBean.getBusNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationDetailBean = new ReservationDetailBean();
				reservationDetailBean.setSeatNum(rs.getInt("seatNo"));
				reservationDetailBean.setSeatTypeId(rs.getString("seatTypeId"));
				listOfReservationDetailBeans.add(reservationDetailBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationDetailBeans;
	}

	public ArrayList<ReservationDetailBean> getReservationDetailListByPK(
			String reservationId) {
		conn = DBConnection.getConnection();
		ReservationDetailBean reservationDetailBean = null;
		try {
			listOfReservationDetailBeans = new ArrayList<ReservationDetailBean>();
			pstmt = conn
					.prepareStatement("select * from reservationDetail where reservationId=?");
			pstmt.setString(1, reservationId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationDetailBean = new ReservationDetailBean();
				reservationDetailBean.setReservationId(reservationId);
				reservationDetailBean.setSeatNum(rs.getInt("seatNo"));
				reservationDetailBean.setSeatTypeId(rs.getString("seatTypeId"));
				listOfReservationDetailBeans.add(reservationDetailBean);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfReservationDetailBeans;
	}

	public boolean update(
			ReservationDetailBean reservationDetailBean,ReservationBean reservationBean) {
		int i = 0;
		Savepoint p1 = null;
/*		System.out.println("source" + reservationBean.getSourceId());
		System.out.println("Amt" + reservationBean.getTotalAmount());
		
		System.out.println("user" + reservationBean.getUserId());
		System.out.println("distnce" + reservationBean.getDistance());

		System.out.println("Res" + reservationBean.getReservationId());

*/		
		conn = DBConnection.getConnection();
		try {
			
			conn.setAutoCommit(false);
			p1 = conn.setSavepoint();
			pstmt = conn
					.prepareStatement("update reservation set sourceId=?,destinationId=?,busNo=?,"
							+ "noOfSeat=?,totalAmount=?,userId=?,"
							+ "distance=?,journeyDate=?,resDate=curdate() where reservationId=?");
			
			pstmt.setString(1, reservationBean.getSourceId());
			pstmt.setString(2, reservationBean.getDestinationId());
			pstmt.setString(3, reservationBean.getBusNo());
			pstmt.setInt(4, reservationBean.getNoOfSeat());
			pstmt.setInt(5, reservationBean.getTotalAmount());
			pstmt.setString(6, reservationBean.getUserId());	
			pstmt.setInt(7, reservationBean.getDistance());
			pstmt.setString(8, reservationBean.getJourneyDate());
			pstmt.setString(9, reservationBean.getReservationId());
			
			
			
			i = pstmt.executeUpdate();
			p1 = conn.setSavepoint();
			/*String[] seat = reservationDetailBean.getSeatNo();
			System.out.println(reservationDetailBean.getSeatNo().length + "length");
			for (int j = 0; j < reservationDetailBean.getSeatNo().length; j++) {
				pstmt = conn
						.prepareStatement("update reservationDetail set" +
								" seatTypeId=?,seatNo=? where reservationId=?");

				System.out.println(seat[j]+ " SeatNo");
				System.out.println("Seat " + reservationDetailBean.getSeatTypeId());
				System.out.println("ID " + reservationBean.getReservationId());
				
				pstmt.setString(1, reservationDetailBean.getSeatTypeId());
				pstmt.setString(2, seat[j]);
				pstmt.setString(3, reservationBean.getReservationId());

				i = pstmt.executeUpdate();
			}
*/
			pstmt = conn
					.prepareStatement("delete from reservationDetail where reservationId=?");
			pstmt.setString(1, reservationBean.getReservationId());
			i = pstmt.executeUpdate();
			
			if(i==0)
				System.out.println("Not Delete");
			else
				System.out.println("delete");
				
			String[] seat = reservationDetailBean.getSeatNo();
			for (int j = 0; j < reservationDetailBean.getSeatNo().length; j++) {
				pstmt = conn
						.prepareStatement("insert into reservationDetail(reservationId,seatNo,seatTypeId) values(?,?,?)");
				pstmt.setString(1, reservationBean.getReservationId());
				pstmt.setString(2, seat[j]);
				pstmt.setString(3, reservationDetailBean.getSeatTypeId());
				i = pstmt.executeUpdate();
			}
			
		}
		catch (SQLException e) {
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

	public boolean delete(String id) {
		conn = DBConnection.getConnection();
		Savepoint p1 = null;
		int i = 0;
		try {
			conn.setAutoCommit(false);
			p1 = conn.setSavepoint();
			pstmt = conn
					.prepareStatement("delete  from reservationDetail where reservationId=?");
			pstmt.setString(1, id);
			i = pstmt.executeUpdate();
			p1 = conn.setSavepoint();
			pstmt = conn
					.prepareStatement("delete  from reservation where reservationId=?");
			pstmt.setString(1, id);
			i = pstmt.executeUpdate();
			p1 = conn.setSavepoint();
			conn.setAutoCommit(true);

		} catch (SQLException e) {

			e.printStackTrace();
			try {
				conn.rollback(p1);
				return false;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return true;
	}

	public boolean removeReservationDetailById(String id) {
		conn = DBConnection.getConnection();
		int i = 0;
		try {
			pstmt = conn
					.prepareStatement("delete  from reservationDetail where reservationId=?");
			pstmt.setString(1, id);
			i = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (i == 0)
			return false;
		else
			return true;
	}

}
