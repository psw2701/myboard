package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.MemberService;

public class MemberLoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {

			return "/WEB-INF/view/loginForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			MemberService service = MemberService.getInstance();
			int error = service.checkLoginMember(id, password);
			if (error == 0) {
				// login 처리
				req.getSession().setAttribute("AUTH", id);
				return "index.jsp";
			} else if (error == -1 || error == -2) {
				return "/WEB-INF/view/loginForm.jsp";
			}
		}
		return null;
	}

}
