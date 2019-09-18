package org.comstudy21.phonebook.model;

public class PhonebookDto {
	private int idx;
	private String name;
	private String phone;
	
	public PhonebookDto() {}
	public PhonebookDto(int idx, String name, String phone) {
		this.idx = idx;
		this.name = name;
		this.phone = phone;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "(" + idx + ", " + name + ", " + phone + ")";
	}
	
}
