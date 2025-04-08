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

@WebServlet("/todo/delete")
public class DeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			// 전달받은 파라미터 얻어오기
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));

			TodoListService service = new TodoListServiceImpl();

			// 할 일을 수정하는 서비스 호출 후 결과 반환받기
			int result = service.todoDelete(todoNo);

			// session scope 객체 얻어오기
			HttpSession session = req.getSession();

			// result 값이 0보다 크다 == 변경 성공
			// -> 원래 보고 있던 상세 페이지로 redirect
			// -> message "완료 여부가 변경되었습니다!" alert
			if (result > 0) {
				session.setAttribute("message", "할 일이 삭제되었습니다!");
				resp.sendRedirect("/");
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
