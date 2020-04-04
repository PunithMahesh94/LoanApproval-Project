package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Controller
@Entity
@Table(name="customer_info")
public class Customer {

	@Id
	@Column(name="cust_id")
	@GeneratedValue //autoincrement
	private int cust_id;
	
	@Column(name="cust_name")
	private String cname;
	
	
	@Column(name="cust_email")
	private String cemail;
	
	@Column(name="cust_address")
	private String caddress;
	
	
	@Column(name="cust_pass")
	private String cpass;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="loantype")
	private String cloantype;

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCloantype() {
		return cloantype;
	}

	public void setCloantype(String cloantype) {
		this.cloantype = cloantype;
	}
	
	private int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
