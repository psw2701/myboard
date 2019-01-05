package com.yi.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.board.model.ArticleContent;
import com.yi.board.mvc.CommandHandler;
import com.yi.board.service.ArticleService;

public class ArticleUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")){
			String articleNo = req.getParameter("no");
			int no = Integer.parseInt(articleNo);
			String content = req.getParameter("content");
			
			req.setAttribute("no", articleNo);
			req.setAttribute("content", content);
			
			return "/WEB-INF/view/articleUpdateForm.jsp";
			
		}else if (req.getMethod().equalsIgnoreCase("post")){
			String articleNo = req.getParameter("no");
			int no = Integer.parseInt(articleNo);
			String content = req.getParameter("content");
			
			ArticleContent articleContent = new ArticleContent();
			articleContent.setArticle_no(Integer.parseInt(articleNo));
			articleContent.setContent(content);
			ArticleService service = ArticleService.getInstance();
			service.update(content, no);
		}
		return "list.do";
	}

}
