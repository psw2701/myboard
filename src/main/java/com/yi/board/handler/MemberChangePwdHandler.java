package com.yi.board.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.model.Member;
import com.yi.board.mvc.CommandHandler;

public class MemberChangePwdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if (req.getMethod().equalsIgnoreCase("get")) {

			return "WEB-INF/view/changePwdForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			String memberid = (String) req.getSession().getAttribute("AUTH");
			String password= req.getParameter("password");
			String newPassword =req.getParameter("newPassword");
			//Member member = new Member(memberid,  password,  newPassword);
		}
		return null;
	}

}
