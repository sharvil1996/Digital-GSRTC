package com.dsynhub.digitalgsrtc.bean;

public class ScheduleDetailBean {

	private String scheduleDetailId;
	private String scheduleId;
	private String sourceId;
	private String destinationId;
	private String source;
	private String destination;
	private Integer weekOfDay;
	private String offDate;
	private Integer distance;
	private String BusNo;
	private String arrivalTime;
	private String departureTime;
	private String reachTime;
	private Integer timeTaken;
	private String busDetailId;

	public String getScheduleDetailId() {
		return scheduleDetailId;
	}

	public void setScheduleDetailId(String scheduleDetailId) {
		this.scheduleDetailId = scheduleDetailId;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getWeekOfDay() {
		return weekOfDay;
	}

	public void setWeekOfDay(Integer weekOfDay) {
		this.weekOfDay = weekOfDay;
	}

	public String getOffDate() {
		return offDate;
	}

	public void setOffDate(String offDate) {
		this.offDate = offDate;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getBusNo() {
		return BusNo;
	}

	public void setBusNo(String busNo) {
		BusNo = busNo;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getReachTime() {
		return reachTime;
	}

	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getBusDetailId() {
		return busDetailId;
	}

	public void setBusDetailId(String busDetailId) {
		this.busDetailId = busDetailId;
	}

}
