package com.yi.board.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.model.Member;
import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.MemberService;

public class MemberJoinHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")){
			
			return "WEB-INF/view/joinForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			String memberid = req.getParameter("memberid");
			String name= req.getParameter("name");
			String password= req.getParameter("password");
			
			
			Member member = new Member(memberid, name, password, new Date());
			
			MemberService service = MemberService.getInstance();
			service.insertMember(member);
			
			req.setAttribute("name", name);
			res.sendRedirect("login.do"); //method-get
			
			return null;
		}
		return null;

}
}
