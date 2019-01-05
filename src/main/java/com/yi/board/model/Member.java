package com.yi.board.model;

import java.util.Date;

public class Member {
	private String memberid;
	private String name;
	private String password;
	private Date regdate;
	
	

	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Member(String mamberid, String name, String password, Date regdate) {
		this.memberid = mamberid;
		this.name = name;
		this.password = password;
		this.regdate = regdate;
	}



	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String mamberid) {
		this.memberid = mamberid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [mamberid=" + memberid + ", name=" + name + ", password=" + password + ", regdate=" + regdate
				+ "]";
	}

}
