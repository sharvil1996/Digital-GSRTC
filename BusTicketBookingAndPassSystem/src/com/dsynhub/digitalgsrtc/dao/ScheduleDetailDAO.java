package com.dsynhub.digitalgsrtc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.util.DBConnection;

public class ScheduleDetailDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private boolean result = false;

	public ArrayList<ScheduleDetailBean> getUserScheduleDetailList(
			String sourceId, String destinationId) {
		ArrayList<ScheduleDetailBean> listOfScheduleDetailBeans = new ArrayList<ScheduleDetailBean>();
		conn = DBConnection.getConnection();
		ScheduleDetailBean ScheduleDetailBean = null;
		try {
			String sql = "select bd.busNo,"
					+ "sc.scheduleId,arrivalTime,departureTime,timeTaken,"
					+ "sourceId,destinationId,offDate,"
					+ "distance,ss.stationName as source,weekOffDay,"
					+ "sd.stationName as destination from busDetail bd,"
					+ "scheduleDetail s,station ss,"
					+ "station sd,schedule sc where s.sourceId=ss.stationId and"
					+ " s.destinationId=sd.stationId and s.scheduleId=sc.scheduleId"
					+ " and sc.busDetailId=bd.busDetailId and s.sourceId=? and "
					+ "s.destinationId=? and isAvailable='y'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sourceId);
			pstmt.setString(2, destinationId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ScheduleDetailBean = new ScheduleDetailBean();
				ScheduleDetailBean.setScheduleId(rs.getString("scheduleId"));
				ScheduleDetailBean.setWeekOfDay(rs.getInt("weekOffDay"));
				ScheduleDetailBean.setDestination((rs
						.getString("destination")));
				ScheduleDetailBean.setSource((rs.getString("source")));
				ScheduleDetailBean.setSourceId(rs.getString("sourceId"));
				ScheduleDetailBean.setDestinationId(rs
						.getString("destinationId"));
				ScheduleDetailBean.setScheduleId(rs.getString("scheduleId"));
				ScheduleDetailBean.setArrivalTime(rs
						.getString("arrivalTime"));
				ScheduleDetailBean.setDepartureTime(rs
						.getString("departureTime"));
				ScheduleDetailBean.setTimeTaken(rs.getInt("timeTaken"));
				ScheduleDetailBean.setOffDate(rs.getString("offDate"));
				ScheduleDetailBean.setDistance(rs.getInt("distance"));
				ScheduleDetailBean.setBusNo(rs.getString("busNo"));
				listOfScheduleDetailBeans.add(ScheduleDetailBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("size" + listOfScheduleDetailBeans.size());
		return listOfScheduleDetailBeans;
	}

	public String getStationId(String station) {
		conn = DBConnection.getConnection();
		try {
			pstmt = conn
					.prepareStatement("select stationId from station where stationName=?");
			pstmt.setString(1, station);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("stationId");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(ScheduleDetailBean scheduleDetailBean) {

		conn = DBConnection.getConnection();
		Savepoint savePoint = null;
		if (conn != null) {

			String insertScheduleSQL = "insert into schedule(busDetailId) values(?)";
			try {
				conn.setAutoCommit(false);

				savePoint = conn.setSavepoint();

				pstmt = conn.prepareStatement(insertScheduleSQL);

				pstmt.setString(1, scheduleDetailBean.getBusDetailId());

				int rowsAffected = pstmt.executeUpdate();

				String insertScheduleDetailSQL = "insert into scheduleDetail"
						+ "(scheduleId,sourceId,destinationId,distance,weekOffDay,"
						+ "offDate,departureTime,arrivalTime,timeTaken) "
						+ "values(last_insert_id(),?,?,?,?,?,?,?,"
						+ "floor(-time_to_sec(timediff(\""
						+ scheduleDetailBean.getDepartureTime() + "\",\""
						+ scheduleDetailBean.getReachTime() + "\"))/60))";

				savePoint = conn.setSavepoint();

				pstmt = conn.prepareStatement(insertScheduleDetailSQL);

				pstmt.setString(1, scheduleDetailBean.getSourceId());
				pstmt.setString(2, scheduleDetailBean.getDestinationId());
				pstmt.setInt(3, scheduleDetailBean.getDistance());
				pstmt.setInt(4, scheduleDetailBean.getWeekOfDay());
				pstmt.setString(5, scheduleDetailBean.getOffDate());
				pstmt.setString(6, scheduleDetailBean.getDepartureTime());
				pstmt.setString(7, scheduleDetailBean.getArrivalTime());

				rowsAffected = pstmt.executeUpdate();

				if (rowsAffected > 0) {
					result = true;
					System.out.println(rowsAffected + " Row(s) Inserted......");

				} else {
					System.out.println(rowsAffected + " Row(s) Inserted......");

				}

			} catch (SQLException e) {
				try {
					conn.rollback(savePoint);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				return false;
			}
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			return result;
		}

		return true;

	}

	public List<ScheduleDetailBean> list() {

		List<ScheduleDetailBean> listOFScheduleDetail = new ArrayList<ScheduleDetailBean>();
		conn = DBConnection.getConnection();

		if (conn != null) {
			String selectSQL = "select bd.busNo,"
					+ "sc.scheduleId,arrivalTime,departureTime,timeTaken,"
					+ "sourceId,destinationId,offDate,"
					+ "distance,ss.stationName as source,weekOffDay,"
					+ "sd.stationName as destination "
					+ "from busDetail bd,scheduleDetail s,station ss,station sd,schedule sc "
					+ "where s.sourceId=ss.stationId and "
					+ "s.destinationId=sd.stationId and s.scheduleId=sc.scheduleId "
					+ "and sc.busDetailId=bd.busDetailId";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();

				ScheduleDetailBean scheduleDetailBean = null;
				while (rs.next()) {
					scheduleDetailBean = new ScheduleDetailBean();

					scheduleDetailBean
							.setScheduleId(rs.getString("scheduleId"));
					scheduleDetailBean.setWeekOfDay(rs.getInt("weekOffDay"));
					scheduleDetailBean.setDestination((rs
							.getString("destination")));
					scheduleDetailBean.setSource((rs.getString("source")));
					scheduleDetailBean.setSourceId(rs.getString("sourceId"));
					scheduleDetailBean.setDestinationId(rs
							.getString("destinationId"));
					scheduleDetailBean
							.setScheduleId(rs.getString("scheduleId"));
					scheduleDetailBean.setArrivalTime(rs
							.getString("arrivalTime"));
					scheduleDetailBean.setDepartureTime(rs
							.getString("departureTime"));
					scheduleDetailBean.setTimeTaken(rs.getInt("timeTaken"));
					scheduleDetailBean.setOffDate(rs.getString("offDate"));
					scheduleDetailBean.setDistance(rs.getInt("distance"));
					scheduleDetailBean.setBusNo(rs.getString("busNo"));

					listOFScheduleDetail.add(scheduleDetailBean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Size : " + listOFScheduleDetail.size());
		return listOFScheduleDetail;
	}

	public boolean delete(String scheduleId) {

		conn = DBConnection.getConnection();

		if (conn != null) {
			String deleteSQL = "delete from scheduleDetail where scheduleId=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1, scheduleId);

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

	public ScheduleDetailBean getByPK(String scheduleId) {

		conn = DBConnection.getConnection();
		ScheduleDetailBean scheduleDetailBean = new ScheduleDetailBean();
		if (conn != null) {

			String selectSQL = "select bd.busNo,ss.stationName as source,sd.stationName as "
					+ "destination,sc.sourceId,sc.destinationId,sc.distance,sc.timeTaken,"
					+ "sc.weekOffDay,sc.offDate,sc.arrivalTime,sc.departureTime "
					+ "from busDetail bd,schedule s,scheduleDetail sc,station ss,station sd "
					+ "where sc.sourceId=ss.stationId and sc.destinationId=sd.stationId "
					+ "and sc.scheduleId=s.scheduleId and s.busDetailId=bd.busDetailId "
					+ "and sc.scheduleId=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setString(1, scheduleId);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					scheduleDetailBean.setScheduleId(scheduleId);
					scheduleDetailBean.setWeekOfDay(rs.getInt("weekOffDay"));
					scheduleDetailBean.setDestination((rs
							.getString("destination")));
					scheduleDetailBean.setSource((rs.getString("source")));
					scheduleDetailBean.setSourceId(rs.getString("sourceId"));
					scheduleDetailBean.setDestinationId(rs
							.getString("destinationId"));
					scheduleDetailBean.setArrivalTime(rs
							.getString("arrivalTime"));
					scheduleDetailBean.setDepartureTime(rs
							.getString("departureTime"));
					scheduleDetailBean.setTimeTaken(rs.getInt("timeTaken"));
					scheduleDetailBean.setOffDate(rs.getString("offDate"));
					scheduleDetailBean.setDistance(rs.getInt("distance"));
					scheduleDetailBean.setBusNo(rs.getString("busNo"));

					String sql = "SELECT ADDTIME(\""
							+ scheduleDetailBean.getDepartureTime()
							+ "\", SEC_TO_TIME("
							+ scheduleDetailBean.getTimeTaken()
							+ "*60)) as reachTime";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					rs.next();
					scheduleDetailBean.setReachTime(rs.getString("reachTime"));

					System.out.println(rs.getString("reachTime") + "Hello");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return scheduleDetailBean;
	}

	public boolean update(ScheduleDetailBean scheduleDetailBean) {
		conn = DBConnection.getConnection();

		if (conn != null) {
			String updateSQL = "update scheduleDetail set sourceId=?,destinationId=?,distance=?"
					+ ",weekOffDay=?,offDate=?,arrivalTime=?,departureTime=?,timeTaken="
					+ "floor(-time_to_sec(timediff(\""
					+ scheduleDetailBean.getDepartureTime()
					+ "\",\""
					+ scheduleDetailBean.getReachTime()
					+ "\"))/60) "
					+ "where scheduleId=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);

				pstmt.setString(1, scheduleDetailBean.getSourceId());
				pstmt.setString(2, scheduleDetailBean.getDestinationId());
				pstmt.setInt(3, scheduleDetailBean.getDistance());
				pstmt.setInt(4, scheduleDetailBean.getWeekOfDay());
				pstmt.setString(5, scheduleDetailBean.getOffDate());
				pstmt.setString(6, scheduleDetailBean.getDepartureTime());
				pstmt.setString(7, scheduleDetailBean.getArrivalTime());
				pstmt.setString(8, scheduleDetailBean.getScheduleId());

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
