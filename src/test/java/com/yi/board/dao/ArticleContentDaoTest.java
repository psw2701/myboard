package com.yi.board.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yi.board.model.Article;
import com.yi.board.model.ArticleContent;
import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class ArticleContentDaoTest {

	@Test
	public void testInsert(){
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			ArticleContentDao dao = session.getMapper(ArticleContentDao.class);
			
			ArticleContent content = new ArticleContent();
			content.setArticle_no(1);
			content.setContent("qwerqwer");
			dao.insert(content);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
