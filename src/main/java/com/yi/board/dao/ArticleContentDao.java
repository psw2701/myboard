package com.yi.board.dao;

import java.sql.SQLException;
import java.util.Map;

import com.yi.board.model.ArticleContent;



public interface ArticleContentDao {
	public int insert(ArticleContent articleContent) throws SQLException;

	public ArticleContent selectByNo(int article_no) throws SQLException;

	public int delete(int no) throws SQLException;

	public void update(Map<String, Object> map) throws SQLException;

}
