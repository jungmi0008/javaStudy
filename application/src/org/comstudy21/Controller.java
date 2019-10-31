package org.comstudy21;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.comstudy21.util.JdbcUtil;

public class Controller extends HttpServlet{
	Dao dao = new Dao();
	HttpSession session;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String name = req.getParameter("name");
		String idNumber1 = req.getParameter("idNumber1");
		String idNumber2 = req.getParameter("idNumber2");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String mobile = req.getParameter("mobile");
		String payment = req.getParameter("payment");
		String startDay = req.getParameter("startDay");
		String endDay = req.getParameter("endDay");
		String agree = req.getParameter("agree");
		String course = req.getParameter("course");
		String searchCourse = req.getParameter("searchCourse");
		
		Dto dto = new Dto(name, idNumber1, idNumber2,address, phone, mobile, payment,
				startDay, endDay, agree,course);
		dao.setConn(JdbcUtil.getConnection());
		String path = makePath(req);
		String viewName = "/";
		if("/complete".equals(path)){
			//complete만 단독으로 쓰인 이유는 sendRedirect해서 doGet에서 forward하기 위함이다.
			dao.setConn(JdbcUtil.getConnection());
			dao.insert(dto);
			resp.sendRedirect("complete.do");	//doGet의 complete으로 간다. complete.jsp페이지로 포워드
			return;
		}else if("/views/newList".equals(path)){
			dao.setConn(JdbcUtil.getConnection());
			dto = new Dto(name, idNumber1, idNumber2,address, phone, mobile, payment,
					startDay, endDay, agree,searchCourse);
			Dto[] appArr =dao.search(dto);
			req.setAttribute("appArr", appArr);
			viewName="/WEB-INF/views/newList.jsp";
		}else if("/views/list".equals(path)){
			if("admin".equals(req.getParameter("userId"))&&"1234".equals(req.getParameter("password"))){
				session = req.getSession();
				session.setAttribute("login.id", "admin");
				
				dao.setConn(JdbcUtil.getConnection());
				Dto[] appArr = dao.selectAll();
				req.setAttribute("appArr", appArr);
				viewName="/WEB-INF/views/list.jsp";
			}else{
				viewName="/managerPage.jsp";
			}
		}
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = makePath(req);
		String viewName = "/";
		
		if("/complete".equals(path)){
			dao.setConn(JdbcUtil.getConnection());
			viewName="/WEB-INF/views/complete.jsp";
		}else if("/views/list".equals(path)){
			dao.setConn(JdbcUtil.getConnection());
			Dto[] appArr = dao.selectAll();
			req.setAttribute("appArr", appArr);
			viewName="/WEB-INF/views/list.jsp";				
		}else if("/views/managerPage".equals(path)){
			//views폴더에 managerPage가 없지만 requestURI는 이렇게 나온다. 하위 폴더에서 밖으로 나가서 그런듯?
			session.invalidate();
			viewName="/managerPage.jsp";
		}
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	private String makePath(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String ctxPath = req.getContextPath();
		String reqURI = req.getRequestURI();
		System.out.println(reqURI);
		int beginIndex = ctxPath.length();
		int lastIndex = reqURI.lastIndexOf(".");
		String path = reqURI.substring(beginIndex, lastIndex);
		return path;
	}
}
