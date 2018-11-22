package cn.hank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 只做验证码验证 */
		request.setCharacterEncoding("utf-8");
		
		String checkcode = request.getParameter("checkcode");
		System.out.println(checkcode);
		// 从session中取出checkcode_session
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		if (checkcode_session.equals(checkcode)) {
			// 验证成功
			response.sendRedirect("success.html");
		} else {
			response.sendRedirect("fail.html");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}