package com.library.service;

import java.sql.SQLException;
import java.util.List;

import com.library.dao.MemberDAO;
import com.library.dao.impl.MemberDAOImpl;
import com.library.model.Member;


public class MemberService {
	private final MemberDAO memberDao = new MemberDAOImpl();
	
	public void addMembers(Member member) throws SQLException{
		
		if(member.getName() == null || member.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("member name is requered");
		}
		memberDao.addMember(member);
	}
	
	public Member getMember(int id)throws SQLException{
		return memberDao.getMemberById(id);
	}
	
	public List<Member> getAllMembers()throws SQLException{
		return memberDao.getAllMembers();
	}
	
	public void updateMembers(Member member)throws SQLException{
		memberDao.updateMembers(member);
	}
	
	public void deleteMembers(int id)throws SQLException{
		memberDao.deleteMembers(id);
	}
}
