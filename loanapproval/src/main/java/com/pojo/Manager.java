package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Controller
@Entity
@Table(name="manager_details")
public class Manager {
	@Id
	@Column(name="manager_id")
	@GeneratedValue //autoincrement
	private int mid;
	
	//@Size(min = 5, max = 15, message = "Your username must between 8 and 15 characters")
	@Column(name="manager_name")
	private String mname;
	
	
	@Column(name="manager_email")
	private String memail;
	
	
	@Column(name="manager_pass")
	private String mpass;
	
	@Column(name="gender")
	private String gender;
	
	
	@Column(name="manager_address")
	private String maddress;
	
	@Column(name="manager_dob")
	private String mdob;
	
	
	private int hflag;


	public int getMid() {
		return mid;
	}


	public void setMid(int mid) {
		this.mid = mid;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getMpass() {
		return mpass;
	}


	public void setMpass(String mpass) {
		this.mpass = mpass;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMaddress() {
		return maddress;
	}


	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}


	public String getMdob() {
		return mdob;
	}


	public void setMdob(String mdob) {
		this.mdob = mdob;
	}


	public int getHflag() {
		return hflag;
	}


	public void setHflag(int hflag) {
		this.hflag = hflag;
	}

	

}
