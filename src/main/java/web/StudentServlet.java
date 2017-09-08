package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;
import entity.Student;

public class StudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获取当前路径
		String path = req.getServletPath();
		//根据规范来判断路径
		
		if("/findAll.a".equals(path)){
			//族员查询自己信息
			findAll(req,res);
		}else if("/addStu.a".equals(path)){
			//族长查看所有族员信息
			addStu(req,res);
		}else if("/toAddStu.a".equals(path)){
			//增加族员信息
			toAddStu(req,res);
		}
		else if("/toUpdateStu.a".equals(path)){
			//跳转修改族员信息
			toUpdateStu(req,res);
		}else if("/updateStu.a".equals(path)){
			//修改族员信息
			updateStu(req,res);
		}else if("/deleteStu.a".equals(path)){
			//修改族员信息
			deleteStu(req,res);
		}else if("/findStu.a".equals(path)){
			//修改族员信息
			findStu(req,res);
		}else{
			throw new RuntimeException("无效的路径");
		}
	}
	//族员查自己
	protected void findStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("WEB-INF/student/findstu.jsp").forward(req, res);
	}
	
	//删除族员
	protected void deleteStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		StuDao dao = new StuDao();
		dao.delete(new Integer(id));
		res.sendRedirect("findAll.a");
	}
	
	
	//修改族员信息
		protected void updateStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String stuId = req.getParameter("stuId");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			String mobile = req.getParameter("mobile");
			String address = req.getParameter("address");
			//保存这些信息
			Student s = new Student();
			
				
				s.setStuId(new Integer(stuId));
			
			s.setPwd(pwd);
			s.setName(name);
			s.setGender(gender);
			s.setAge(new Integer(age));
			s.setMobile(mobile);
			s.setAddress(address);
			new StuDao().update(s);
			//重定向到查询功能
			res.sendRedirect("findAll.a");
			
		}
	//打开修改族员的页面
	protected void toUpdateStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		StuDao dao = new StuDao();
		Student student = dao.findStudentById(new Integer(id));
		req.setAttribute("student", student);
		req.getRequestDispatcher("WEB-INF/student/update.jsp").forward(req, res);
		
	}
	//增加族员信息
	protected void addStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String stuId = req.getParameter("stuId");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		//保存这些信息
		Student s = new Student();
		
			
			s.setStuId(new Integer(stuId));
		
		s.setPwd(pwd);
		s.setName(name);
		s.setGender(gender);
		s.setAge(new Integer(age));
		s.setMobile(mobile);
		s.setAddress(address);
		new StuDao().save(s);
		//重定向到查询功能
		res.sendRedirect("findAll.a");
		
	}
	//打开增加族员的页面
	protected void toAddStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("WEB-INF/student/addstu.jsp").forward(req, res);
		
	}
	
	//管理员查询所有学生
	protected void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StuDao dao = new StuDao();
		List<Student> list = dao.findStudentAll();
		req.setAttribute("students", list);
		req.getRequestDispatcher("WEB-INF/student/findall.jsp").forward(req, res);
		
	}
	
	
}
