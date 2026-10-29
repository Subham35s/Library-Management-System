package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Member;


public interface MemberDAO {
	void addMember(Member member) throws SQLException;
	Member getMemberById(int id)throws SQLException;
	List<Member> getAllMembers()throws SQLException;
	void updateMembers(Member member)throws SQLException;
	void deleteMembers(int id)throws SQLException;
}
