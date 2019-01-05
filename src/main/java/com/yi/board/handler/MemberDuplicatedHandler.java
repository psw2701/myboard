package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.MemberService;

public class MemberDuplicatedHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String id = req.getParameter("id");
			
			MemberService service = MemberService.getInstance();
			boolean result = service.duplicatedMember(id);
			System.out.println(result);
			req.setAttribute("result", result);
			
			return "/WEB-INF/view/duplicatedID.jsp";
		}
		return null;
	}

}
