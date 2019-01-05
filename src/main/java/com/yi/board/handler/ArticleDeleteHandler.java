package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleDeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String articleNo = req.getParameter("no");
			int no = Integer.parseInt(articleNo);
			req.setAttribute("no", articleNo);
			ArticleService service = ArticleService.getInstance();
			service.delete(no, articleNo);
			return "list.do";
		}
		return null;
	}

}
