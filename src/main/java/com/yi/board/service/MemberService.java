package com.yi.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yi.board.dao.MemberDao;
import com.yi.board.model.Member;
import com.yi.board.mvc.MySqlSessionFactory;

public class MemberService {
	private static MemberService service = new MemberService();

	public static MemberService getInstance() {
		return service;
	}

	// 0 :정상적인 insert처리가 되었을때
	// -1: insert안되었을떄

	public int insertMember(Member mem) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();

			MemberDao dao = session.getMapper(MemberDao.class);
			dao.insert(mem);
			session.commit();
			return 0;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return -1;

	}

	// true 중복된 멤버가 있음
	// false 중복된 멤버가 없음
	public boolean duplicatedMember(String id) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member mem = dao.selectById(id);
			if (mem != null) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public List<Member> getList() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();

			MemberDao dao = session.getMapper(MemberDao.class);

			return dao.selectListByAll();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	// 0 : id, pw 일치함
	// -1 : pw일치하지 않음
	// -2 : id가 없음 (회원 가입 안됨)
	// -3: error
	public int checkLoginMember(String id, String password) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member member = dao.selectById(id);
			if (member == null) {
				return -2;
			}
			if (member.getPassword().equals(password) == false) {
				return -1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return -3;
	}

	public int changePwd(String id, String password, String newPassword) {
		SqlSession session = null;
		// 현재 비밀번호가 일치하는지 확인
		// 일치 시 :새 비밀번호 변경

		try {
			session = MySqlSessionFactory.openSession();
			MemberDao dao = session.getMapper(MemberDao.class);
			Member member = dao.selectById(id);
			session.commit();
			if (member.getPassword().equals(password) == false) {
				return -1;
			}
			if (member.getPassword().equals(password) == true) {
				// DB에 있는 비번 변경
				dao.updatePw(newPassword, id);
				return -2;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return -3;
	}

}
