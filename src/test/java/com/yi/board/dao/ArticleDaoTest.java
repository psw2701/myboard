package com.yi.board.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yi.board.model.Article;
import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class ArticleDaoTest {

	@Test
	public void testInsert(){
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao dao = session.getMapper(ArticleDao.class);
			
			Article article = new Article();
			article.setWriter_id("user");
			article.setWriter_name("user");
			article.setRead_cnt(0);
			article.setModdate(new Date());
			article.setRegdate(new Date());
			article.setTitle("article test");
			dao.insert(article);
			
			int article_no = dao.selectLastNo();
			System.out.println(article_no);
			

			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
