package org.comstudy21;

public class Dto {
	private String name;
	private String idNumber1;
	private String idNumber2;
	private String address;
	private String phone;
	private String mobile;
	private String payment;
	private String startDay;
	private String endDay;
	private String agree;
	private String course;
	
	public Dto() {
		// TODO Auto-generated constructor stub
	}
	

	

	public Dto(String name, String idNumber1, String idNumber2, String address, String phone, String mobile,
			String payment, String startDay, String endDay, String agree, String course) {
		super();
		this.name = name;
		this.idNumber1 = idNumber1;
		this.idNumber2 = idNumber2;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.payment = payment;
		this.startDay = startDay;
		this.endDay = endDay;
		this.agree = agree;
		this.course = course;
	}




	public String getCourse() {
		return course;
	}




	public void setCourse(String course) {
		this.course = course;
	}




	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber1() {
		return idNumber1;
	}
	public void setIdNumber1(String idNumber1) {
		this.idNumber1 = idNumber1;
	}
	public String getIdNumber2() {
		return idNumber2;
	}
	public void setIdNumber2(String idNumber2) {
		this.idNumber2 = idNumber2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}




	@Override
	public String toString() {
		return "Dto [name=" + name + ", idNumber1=" + idNumber1 + ", idNumber2=" + idNumber2 + ", address=" + address
				+ ", phone=" + phone + ", mobile=" + mobile + ", payment=" + payment + ", startDay=" + startDay
				+ ", endDay=" + endDay + ", agree=" + agree + ", course=" + course + "]";
	}
	
}
