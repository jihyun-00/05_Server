package edu.kh.todoList.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/update2")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 할 일 추가
				try {
					
					int todoNo = Integer.parseInt(req.getParameter("todoNo"));
					
					
					// 메인페이지 응답을 담당하는 jsp에 요청 위임
					String path = "/WEB-INF/views/update.jsp";
					req.getRequestDispatcher(path).forward(req, resp);
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}

}
