package com.yi.board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yi.board.dao.ArticleContentDao;
import com.yi.board.dao.ArticleDao;
import com.yi.board.dao.MemberDao;
import com.yi.board.model.Article;
import com.yi.board.model.ArticleContent;
import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class ArticleService {
	private static ArticleService service = new ArticleService();

	public static ArticleService getInstance() {
		return service;
	}

	// -1 : id에 해당하는 member가 없을수 있음
	// -2 : article 저장실패
	// -3 : articleContent 저장 실패
	// -4 : 특수경우
	// 0 : sucess
	public int insertArticle(String id, String title, String content) {
		/*
		 * 1.id에 해당하는 name값 가져오기 2. article 저장 3. article_content 저장
		 */

		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			// 1.id에 해당하는 name값 가져오기
			Member member = dao.selectById(id);
			if (member == null) {
				return -1;
			}

			// 2. article 저장
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			Date now = new Date();
			Article article = new Article(0, id, member.getName(), title, now, now, 0);
			articleDao.insert(article);
			int article_no = articleDao.selectLastNo();
			if (article_no < 0) {
				return -2;
			}

			// 3. article content 저장
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
			ArticleContent articleContent = new ArticleContent(article_no, content);
			int result = contentDao.insert(articleContent);
			if (result < 0) {
				return -3;
			}
			session.commit();
			return 0;
		} catch (Exception e) {
			session.rollback(); // isnert과정 sqlException발생 하면 rollback처리함
			e.printStackTrace();
		} finally {
			session.close();
		}
		return -4;
	}

	public List<Article> articleList() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			return articleDao.select();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Map<String, Object> readArticle(int no) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);

			Article article = articleDao.selectByNo(no);
			ArticleContent content = contentDao.selectByNo(no);

			// article, content 두개 다 return 해야함
			Map<String, Object> map = new HashMap<>();
			map.put("article", article);
			map.put("content", content);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public void delete(int no, String content) {
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();

			ArticleDao articleDao = session.getMapper(ArticleDao.class);
			articleDao.delete(no);
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
			contentDao.delete(no);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void update(String content, int no) {
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			ArticleContentDao contentDao = session.getMapper(ArticleContentDao.class);
			Map<String, Object> map = new HashMap<>();
			map.put("content", content);
			map.put("article_no", no);
			contentDao.update(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
