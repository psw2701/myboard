package com.yi.board.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String articleNo = req.getParameter("no");
			int no = Integer.parseInt(articleNo);
			ArticleService service = ArticleService.getInstance();
			Map<String, Object> map = service.readArticle(no);
			req.setAttribute("map", map);
			return "/WEB-INF/view/articleRead.jsp";
			
		}
		return null;
	}

}
