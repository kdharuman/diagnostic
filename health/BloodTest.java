package com.teembinsys;

import java.util.Date;

public class BloodTest {

	
	private int serial_number;
	private  String test_id;
	private String test_name;
	private float mrp;
	private String test_upload_date;
	private String test_modified_date;
	
	public int getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}
	public String getTest_id() {
		return test_id;
	}
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	public String getTest_upload_date() {
		return test_upload_date;
	}
	public void setTest_upload_date(String test_upload_date) {
		this.test_upload_date = test_upload_date;
	}
	public String getTest_modified_date() {
		return test_modified_date;
	}
	public void setTest_modified_date(String test_modified_date) {
		this.test_modified_date = test_modified_date;
	}
	@Override
	public String toString() {
		return "BloodTest [serial_number=" + serial_number + ", test_id=" + test_id + ", test_name=" + test_name
				+ ", mrp=" + mrp + ", test_upload_date=" + test_upload_date + ", test_modified_date="
				+ test_modified_date + "]";
	}
	
	
}


