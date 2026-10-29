package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.model.Member;
import com.library.service.MemberService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

@WebServlet("/members")
public class MemberServlet extends HttpServlet{
	private final MemberService memberService = new MemberService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		if(action == null) {
			action = "list";
		}
		try {
			switch(action) {
			case "new":
				req.getRequestDispatcher("/member/add.jsp").forward(req, resp);
				break;
				
			case "edit":
				int editId = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("member", memberService.getMember(editId));
				req.getRequestDispatcher("/member/edit.jsp").forward(req, resp);
				break;
			case "delete":
				memberService.deleteMembers(Integer.parseInt(req.getParameter("id")));
				resp.sendRedirect(req.getContextPath() + "/members?action=list");
				break;
				
			default:
				req.setAttribute("members", memberService.getAllMembers());
				req.getRequestDispatcher("/member/list.jsp").forward(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		try {
			Member member = new Member(		
					req.getParameter("name"),
					req.getParameter("email"),
					req.getParameter("phone"),
					req.getParameter("address")
					);
			
			if("update".equals(action)) {
				member.setId(Integer.parseInt(req.getParameter("id")));
				memberService.updateMembers(member);
			}else {
				memberService.addMembers(member);
			}
			resp.sendRedirect(req.getContextPath()+"/members?action=list");
		}catch(SQLException e) {
			throw new ServletException();
		}
	}
}
