package com.yi.board.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yi.board.model.Article;
import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class MemberDaoTest {

	@Test
	public void testInsert(){
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			
			Member member = new Member();
			member.setMemberid("user");
			member.setName("user");
			member.setPassword("user");
			member.setRegdate(new Date());
			dao.insert(member);
		
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
