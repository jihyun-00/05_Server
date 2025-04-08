package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/update")
public class UpdateServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			// 1. TodoListServiceImpl 객체 생성
			TodoListService service = new TodoListServiceImpl();
			
			// 2. 요청 시 전달받은 파라미터 데이터 얻어오기
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			
			// 3. 서비스 호출 후 결과 반환받기
			int result = service.todoupdate(todoNo, title, detail);
			
			HttpSession session = req.getSession();
			
			// 4. 성공/실패 메시지 세팅하기
			String message = null;
			if (result > 0) {
				session.setAttribute("message", "할 일이 수정되었습니다!");
				resp.sendRedirect("/todo/update?todoNo=" + todoNo);
//				resp.sendRedirect("/todo/delete?todoNo=\" + todoNo");

				return;
			}

			// 변경 실패 시
			// -> 메인 페이지로 redirect
			// -> message "todo가 존재하지 않습니다" alert
			session.setAttribute("message", "todo가 존재하지 않습니다.");
			resp.sendRedirect("/");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
