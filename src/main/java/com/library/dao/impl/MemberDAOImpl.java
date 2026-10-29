package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.library.dao.MemberDAO;
import com.library.model.Member;
import com.library.util.DBConnection;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void addMember(com.library.model.Member member) throws SQLException {
		String sql = "insert into members(name, email, phone, address) values(?, ?, ?, ?)";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPhone());
			ps.setString(4, member.getAddress());
			ps.executeUpdate();
		}

	}

	@Override
	public com.library.model.Member getMemberById(int id) throws SQLException {
		String sql = "Select * from members where id = ?";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return mapRow(rs);
			}
		}

		return null;
	}

	@Override
	public List<Member> getAllMembers() throws SQLException {
		List<Member> members = new LinkedList<>();
		String sql = "select * from members order by id desc";
		try (Connection con = DBConnection.getInstance().getConnection();

				Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				members.add(mapRow(rs));
			}
		}
		return members;
	}

	@Override
	public void updateMembers(Member member) throws SQLException {
		String sql = "update members set name = ?, email = ?, phone = ?, address = ? where id = ? ";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPhone());
			ps.setString(4, member.getAddress());
			ps.setInt(5, member.getId());
			ps.executeUpdate();
		}

	}

	@Override
	public void deleteMembers(int id) throws SQLException {
		String sql = "delete from members where id = ?";
		try (Connection con = DBConnection.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		}

	}

	private Member mapRow(ResultSet rs) throws SQLException {
		return new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"),
				rs.getString("address"));
	}

//	@Override
//	public void addMember(Member member) throws SQLException {
//		
//		String sql = "insert into members(name, email, phone, address) values(?, ?, ?, ?)";
//		try (Connection con = DBConnection.getInstance().getConnection();
//				PreparedStatement ps = con.prepareStatement(sql)) {
//			ps.setString(1, member.getName());
//			ps.setString(2, member.getEmail());
//			ps.setString(3, member.getPhone());
//			ps.setString(4, member.getAddress());
//			ps.executeUpdate();
//			
//		}
//
//	}
//
//	@Override
//	public Member getMemberById(int id) throws SQLException {
//		String sql = "Select * from members where id = ?";
//		try (Connection con = DBConnection.getInstance().getConnection();
//				PreparedStatement ps = con.prepareStatement(sql)) {
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				return mapRow(rs);
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public List<Member> getAllMembers() throws SQLException {
//		
//		List<Member> members = new LinkedList<>();
//		String sql = "select * from members order by id desc";
//		try(Connection con = DBConnection.getInstance().getConnection();
//				Statement st = con.createStatement()){
//				ResultSet rs = st.executeQuery(sql);
//				if(rs.next()) {
//					members.add(mapRow(rs));
//				}
//		}
//		return members;
//	}
//
//	@Override
//	public void updateMembers(Member member) throws SQLException {
//		String sql = "update membres set name = ?, email = ?, phone = ?, address = ? where id = ? ";
//		try(Connection con = DBConnection.getInstance().getConnection();
//				PreparedStatement ps = con.prepareStatement(sql)){
//			ps.setString(1, member.getName());
//			ps.setString(2, member.getEmail());
//			ps.setString(3, member.getPhone());
//			ps.setString(4, member.getAddress());
//			ps.executeUpdate();
//		}
//	}
//
//	@Override
//	public void deleteMembers(int id) throws SQLException {
//		String sql = "delete from members where id = ?";
//		try(Connection con = DBConnection.getInstance().getConnection();
//				PreparedStatement ps = con.prepareStatement(sql)){
//			ps.setInt(1, id);
//			ps.executeUpdate();
//		}
//
//	}
//

}
