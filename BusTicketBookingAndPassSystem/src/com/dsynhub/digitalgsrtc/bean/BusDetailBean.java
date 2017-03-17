package com.dsynhub.digitalgsrtc.bean;

public class BusDetailBean {
	
	private String busNo;
	private String routeId;
	private String busDetailId;
	private String isAvailable;
	private String source;
	private String destination;

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getBusDetailId() {
		return busDetailId;
	}

	public void setBusDetailId(String busDetailId) {
		this.busDetailId = busDetailId;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
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
}