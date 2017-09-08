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
		//��ȡ��ǰ·��
		String path = req.getServletPath();
		//���ݹ淶���ж�·��
		
		if("/findAll.a".equals(path)){
			//��Ա��ѯ�Լ���Ϣ
			findAll(req,res);
		}else if("/addStu.a".equals(path)){
			//�峤�鿴������Ա��Ϣ
			addStu(req,res);
		}else if("/toAddStu.a".equals(path)){
			//������Ա��Ϣ
			toAddStu(req,res);
		}
		else if("/toUpdateStu.a".equals(path)){
			//��ת�޸���Ա��Ϣ
			toUpdateStu(req,res);
		}else if("/updateStu.a".equals(path)){
			//�޸���Ա��Ϣ
			updateStu(req,res);
		}else if("/deleteStu.a".equals(path)){
			//�޸���Ա��Ϣ
			deleteStu(req,res);
		}else if("/findStu.a".equals(path)){
			//�޸���Ա��Ϣ
			findStu(req,res);
		}else{
			throw new RuntimeException("��Ч��·��");
		}
	}
	//��Ա���Լ�
	protected void findStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("WEB-INF/student/findstu.jsp").forward(req, res);
	}
	
	//ɾ����Ա
	protected void deleteStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		StuDao dao = new StuDao();
		dao.delete(new Integer(id));
		res.sendRedirect("findAll.a");
	}
	
	
	//�޸���Ա��Ϣ
		protected void updateStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String stuId = req.getParameter("stuId");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			String mobile = req.getParameter("mobile");
			String address = req.getParameter("address");
			//������Щ��Ϣ
			Student s = new Student();
			
				
				s.setStuId(new Integer(stuId));
			
			s.setPwd(pwd);
			s.setName(name);
			s.setGender(gender);
			s.setAge(new Integer(age));
			s.setMobile(mobile);
			s.setAddress(address);
			new StuDao().update(s);
			//�ض��򵽲�ѯ����
			res.sendRedirect("findAll.a");
			
		}
	//���޸���Ա��ҳ��
	protected void toUpdateStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		StuDao dao = new StuDao();
		Student student = dao.findStudentById(new Integer(id));
		req.setAttribute("student", student);
		req.getRequestDispatcher("WEB-INF/student/update.jsp").forward(req, res);
		
	}
	//������Ա��Ϣ
	protected void addStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String stuId = req.getParameter("stuId");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		//������Щ��Ϣ
		Student s = new Student();
		
			
			s.setStuId(new Integer(stuId));
		
		s.setPwd(pwd);
		s.setName(name);
		s.setGender(gender);
		s.setAge(new Integer(age));
		s.setMobile(mobile);
		s.setAddress(address);
		new StuDao().save(s);
		//�ض��򵽲�ѯ����
		res.sendRedirect("findAll.a");
		
	}
	//��������Ա��ҳ��
	protected void toAddStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("WEB-INF/student/addstu.jsp").forward(req, res);
		
	}
	
	//����Ա��ѯ����ѧ��
	protected void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StuDao dao = new StuDao();
		List<Student> list = dao.findStudentAll();
		req.setAttribute("students", list);
		req.getRequestDispatcher("WEB-INF/student/findall.jsp").forward(req, res);
		
	}
	
	
}
