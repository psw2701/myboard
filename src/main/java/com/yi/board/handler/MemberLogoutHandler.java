package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yi.board.mvc.CommandHandler;

public class MemberLogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// session을 지우면 로그아웃됨

		// getSession(true) : 세션이 이미 있는지 확인을 하여, 이미 있다면 그 세션을 변환기키고, 없으면 새로운 세션을
		// 생성한다.
		// get Session(false) : 세션이 있다면 그 세션을 리턴하지만 세션이 존재하지 않으면 null을 리턴한다.
		HttpSession session = req.getSession(false);

		if (session != null) {
			session.invalidate(); // 세션삭제

		}
		res.sendRedirect("index.jsp");
		return null;
	}

}
