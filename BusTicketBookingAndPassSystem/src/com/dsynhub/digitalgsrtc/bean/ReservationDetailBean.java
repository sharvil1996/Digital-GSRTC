package com.dsynhub.digitalgsrtc.bean;

public class ReservationDetailBean {
	
	private String reservationId;
	private String seatNo[] = new String[5];
	private Integer seatNum;
	private String seatTypeId;
	private Integer amount;
	private Integer distance;
	private Integer noOfSeat;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String sourceName;
	private String destinationName;
	private String busNo;
	private String journeyDate;
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String[] getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String[] seatNo) {
		this.seatNo = seatNo;
	}
	public Integer getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}
	public String getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(String seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(Integer noOfSeat) {
		this.noOfSeat = noOfSeat;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	
}
