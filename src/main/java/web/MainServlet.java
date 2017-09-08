package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDao;
import dao.ScoreDao;
import dao.StuDao;
import dao.stuCourseDao;
import entity.Course;
import entity.Score;
import entity.Student;
import entity.stuCourse;
import util.ImageUtil;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/toLogin.do".equals(path)) {
			toLogin(req, res);
		} else if ("/toIndexStu.do".equals(path)) {
			toIndexStu(req, res);
		} else if ("/toIndexAdmin.do".equals(path)) {
			toIndexAdmin(req, res);
		} else if ("/logout.do".equals(path)) {
			logout(req, res);
		} else if ("/createImg.do".equals(path)) {
			createImg(req, res);
		} else if ("/login.do".equals(path)) {
			login(req, res);
		} else if ("/findCourse.do".equals(path)) {
			findCourse(req, res);
		} else if ("/toAddCourse.do".equals(path)) {
			toAddCourse(req, res);
		} else if ("/addCourse.do".equals(path)) {
			addCourse(req, res);
		} else if ("/toUpdateCourse.do".equals(path)) {
			toUpdateCourse(req, res);
		} else if ("/updateCourse.do".equals(path)) {
			updateCourse(req, res);
		} else if ("/deleteCourse.do".equals(path)) {
			deleteCourse(req, res);
		} else if ("/findStuCourse.do".equals(path)) {
			findStuCourse(req, res);
		} else if ("/toShowCourse.do".equals(path)) {
			toShowCourse(req, res);
		} else if ("/toShowCourse.do".equals(path)) {
			toShowCourse(req, res);
		} else if ("/toAddStuCourse.do".equals(path)) {
			toAddStuCourse(req, res);
		} else if ("/addStuCourse.do".equals(path)) {
			addStuCourse(req, res);
		} else if ("/deleteStuCourse.do".equals(path)) {
			deleteStuCourse(req, res);
		}else if("/stuFindScore.do".equals(path)){
			stuFindScore(req,res);
		}else if("/adminFindScore.do".equals(path)){
			adminFindScore(req,res);
		}else if("/toAddScore.do".equals(path)){
			toAddScore(req,res);
		}else if("/addScore.do".equals(path)){
			addScore(req,res);
		}else if("/deleteScore.do".equals(path)){
			deleteScore(req,res);
		}else if("/toUpdateScore.do".equals(path)){
			toUpdateScore(req,res);
		}else if("/updateScore.do".equals(path)){
			updateScore(req,res);
		}else if("/toContact.do".equals(path)){
			contact(req,res);
		}else if("/toContactAdmin.do".equals(path)){
			contactAdmin(req,res);
		}else if("/toContactStu.do".equals(path)){
			contactStu(req,res);
		} else {
			throw new RuntimeException("��Ч��·��");
		}
	}

	protected void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ���ձ�����
		String adminCode = req.getParameter("adminCode");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		Integer level = new Integer(req.getParameter("level"));
		// ��session�л�ȡ���ɵ���֤��
		HttpSession session = req.getSession();
		String imgcode = (String) session.getAttribute("imgcode");
		// �����֤��
		if (code == null || !code.equalsIgnoreCase(imgcode)) {
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			return;
		}

		// ����˺�����

		if (level == 1) {
			if (!adminCode.equals("admin")) {
				// �˺Ŵ���ת���ص�¼ҳ����ʾ
				req.setAttribute("error", "�˺Ŵ���");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);

			} else if (!password.equals("admin")) {
				// �������ת���ص�¼ҳ��ʾ
				req.setAttribute("error", "�������");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			}

			else {
				// ���˺Ŵ�����cookie�����͸��������������Զ����棬������ҳ��ʹ��
				Cookie cookie = new Cookie("adminCode", adminCode);
				res.addCookie(cookie);
				// Ҳ����session�������˺�
				session.setAttribute("adminCode", adminCode);
				// �����ض�����ҳ
				res.sendRedirect("toIndexAdmin.do");

			}
		} else {
			StuDao dao = new StuDao();
			Student a = dao.findByCode(adminCode);
			if (a == null) {
				// �˺Ŵ���ת���ص�¼ҳ����ʾ
				req.setAttribute("error", "�˺Ŵ���");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			} else if (!a.getPwd().equals(password)) {
				// �������ת���ص�¼ҳ��ʾ
				req.setAttribute("error", "�������");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			} else {
				// ���˺Ŵ�����cookie�����͸��������������Զ����棬������ҳ��ʹ��
				String name = URLEncoder.encode(a.getName(), "UTF-8");
				String c1 = URLEncoder.encode(a.getGender(), "UTF-8");
				String c2 = URLEncoder.encode(a.getAddress(), "UTF-8");
				String c3 = a.getAge() + "";
				String c4 = a.getMobile() + "";
				Cookie cookie = new Cookie("adminCode", adminCode);
				Cookie coname = new Cookie("coname", name);
				Cookie gender = new Cookie("gender", c1);
				Cookie age = new Cookie("age", c3);
				Cookie mobile = new Cookie("mobile", c4);
				Cookie address = new Cookie("address", c2);

				res.addCookie(cookie);
				res.addCookie(coname);
				res.addCookie(gender);
				res.addCookie(age);
				res.addCookie(mobile);
				res.addCookie(address);
				// Ҳ����session�������˺�
				session.setAttribute("adminCode", adminCode);
				// �����ض�����ҳ
				res.sendRedirect("toIndexStu.do");
			}
		}
	}

	protected void createImg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �����������֤�뼰ͼƬ
		Object[] objs = ImageUtil.createImage();
		// ����֤�����session
		String imgcode = (String) objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", imgcode);
		// ��ͼƬ����������
		BufferedImage img = (BufferedImage) objs[1];
		res.setContentType("image/png");
		// �������Զ������������Ŀ��ָ�������
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "png", os);
		os.close();
	}

	// �˳���¼
	protected void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ����session
		req.getSession().invalidate();
		// �ض��򵽵�¼ҳ��
		res.sendRedirect("toLogin.do");

	}

	// �򿪵�¼ҳ��
	protected void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
	}

	// ��ѧ����ҳ
	protected void toIndexStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/main/indexStu.jsp").forward(req, res);
	}

	// �򿪹���Ա��ҳ
	protected void toIndexAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/indexAdmin.jsp").forward(req, res);
	}

	protected void findCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ��ȡ�������
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// ��ȡ����
		String size = "5";

		// ��ѯ�ʷ�
		CourseDao dao = new CourseDao();
		List<Course> list = dao.findByPage(new Integer(page), new Integer(size));
		// ��ѯ��������������ҳ��
		int rows = dao.findRows();
		int total = rows / new Integer(size);
		if (rows % new Integer(size) != 0) {
			total++;
		}
		req.setAttribute("courses", list);
		req.setAttribute("total", total);
		req.setAttribute("page", page);
		req.getRequestDispatcher("WEB-INF/course/find.jsp").forward(req, res);
		// req.getRequestDispatcher("WEB-INF/stucourse/add.jsp").forward(req,
		// res);
	}

	/*
	 * ��ת������ҳ��
	 */
	protected void toAddCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/course/add.jsp").forward(req, res);

	}

	/*
	 * ���ӿγ�
	 */
	protected void addCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String courseId = req.getParameter("courseId");
		String courseName = req.getParameter("courseName");
		String teacherName = req.getParameter("teacherName");
		String classroomName = req.getParameter("classroomName");
		String classDate = req.getParameter("classDate");
		String examDate = req.getParameter("examDate");

		Course c = new Course();
		if (courseId != null && !courseId.equals("")) {
			c.setCourseId(new Integer(courseId));
		}
		c.setCourseName(courseName);
		c.setTeacherName(teacherName);
		c.setClassroomName(classroomName);
		c.setClassDate(classDate);
		c.setExamDate(examDate);

		new CourseDao().save(c);
		new CourseDao().print(c);
		res.sendRedirect("findCourse.do");
	}

	protected void toUpdateCourse(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		Course c = new CourseDao().findById(new Integer(id));
		req.setAttribute("course", c);
		req.getRequestDispatcher("WEB-INF/course/update.jsp").forward(req, res);
	}

	/**
	 * �޸Ŀγ�
	 * 
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String courseId = req.getParameter("courseId");
		String courseName = req.getParameter("courseName");
		String teacherName = req.getParameter("teacherName");
		String classroomName = req.getParameter("classroomName");
		String classDate = req.getParameter("classDate");
		String examDate = req.getParameter("examDate");

		Course c = new Course();
		c.setCourseId(new Integer(courseId));
		c.setCourseName(courseName);
		c.setTeacherName(teacherName);
		c.setClassroomName(classroomName);
		c.setClassDate(classDate);
		c.setExamDate(examDate);

		new CourseDao().update(c);

		res.sendRedirect("findCourse.do");

	}

	/**
	 * ɾ���γ�
	 */

	protected void deleteCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		new CourseDao().delete(new Integer(id));
		res.sendRedirect("findCourse.do");
	}

	/**
	 * ��ѯѧ����ѡ�γ�
	 * 
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findStuCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ��ȡ�������
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}

		HttpSession session = req.getSession();
		String stuId = (String) session.getAttribute("adminCode");

		// ��ȡ����
		String size = "5";

		// ��ѯ

		stuCourseDao dao = new stuCourseDao();
		List<stuCourse> list = dao.findByPageAndId(new Integer(page), new Integer(size), new Integer(stuId));
		// ��ѯ��������������ҳ��
		int rows = dao.findRows();
		int total = rows / new Integer(size);
		if (rows % new Integer(size) != 0) {
			total++;
		}

		// req.setAttribute("stuId", stuId);
		req.setAttribute("stucourses", list);
		req.setAttribute("total", total);
		req.setAttribute("page", page);
		req.getRequestDispatcher("WEB-INF/stucourse/findStu.jsp").forward(req, res);
	}

	/**
	 * ��תѡ��ҳ��
	 * 
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toShowCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ��ȡ�������
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// ��ȡ����
		String size = "5";

		// ��ѯ�ʷ�
		CourseDao dao = new CourseDao();
		List<Course> list = dao.findByPage(new Integer(page), new Integer(size));
		// ��ѯ��������������ҳ��
		int rows = dao.findRows();
		int total = rows / new Integer(size);
		if (rows % new Integer(size) != 0) {
			total++;
		}
		req.setAttribute("courses", list);
		req.setAttribute("total", total);
		req.setAttribute("page", page);

		req.getRequestDispatcher("WEB-INF/stucourse/showcourse.jsp").forward(req, res);
	}

	protected void toAddStuCourse(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		String stuId = (String) session.getAttribute("adminCode");

		Course c = new CourseDao().findById(new Integer(id));

		stuCourse s = new stuCourse();
		s.setStudentId(new Integer(stuId));
		s.setCourseId(c.getCourseId());
		s.setCourseName(c.getCourseName());
		s.setTeacherName(c.getTeacherName());
		s.setClassroomName(c.getClassroomName());
		s.setClassDate(c.getClassDate());
		s.setExamDate(c.getExamDate());
		req.setAttribute("stucourse", s);
		req.getRequestDispatcher("WEB-INF/stucourse/add.jsp").forward(req, res);

	}

	protected void addStuCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String studentId = req.getParameter("studentId");
		String courseId = req.getParameter("courseId");
		String courseName = req.getParameter("courseName");
		String teacherName = req.getParameter("teacherName");
		String classroomName = req.getParameter("classroomName");
		String classDate = req.getParameter("classDate");
		String examDate = req.getParameter("examDate");

		stuCourse s = new stuCourse();
		s.setStudentId(new Integer(studentId));
		s.setCourseId(new Integer(courseId));
		s.setCourseName(courseName);
		s.setTeacherName(teacherName);
		s.setClassroomName(classroomName);
		s.setClassDate(classDate);
		s.setExamDate(examDate);

		new stuCourseDao().save(s);
		res.sendRedirect("toShowCourse.do");
	}

	protected void deleteStuCourse(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		new stuCourseDao().delete(new Integer(id));
		res.sendRedirect("findStuCourse.do");
	}
	//�޸ĳɼ�
		protected void updateScore(HttpServletRequest req,HttpServletResponse res) throws IOException{
			//���մӱ��е�����
			req.setCharacterEncoding("utf-8");	
			String stuId=req.getParameter("stuId");
			String courseId=req.getParameter("courseId");
			String courseName=req.getParameter("courseName");
			String teacherName=req.getParameter("teacherName");
			String scoreNum=req.getParameter("scoreNum");
			//������Щ����
			Score s=new Score();
			s.setStuId(new Integer(stuId));
			s.setCourseId(new Integer(courseId));
			s.setCourseName(courseName);
			s.setTeacherName(teacherName);
			s.setScoreNum(new Double(scoreNum));
			new ScoreDao().updateScore(s);
			//�ض��򵽲�ѯ����(�ض���һ�㶼��.do)
			res.sendRedirect("adminFindScore.do");
			
		}
		
		//���޸ĳɼ���ҳ��
		protected void toUpdateScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			//����������������Ĳ���getParameter()����getParameterValues()
			String id=req.getParameter("id");
			System.out.println(id);
			//����id��ѯ������
			ScoreDao dao=new ScoreDao();
			Score score=dao.findById(new Integer(id));
			//��ת����ҳ��WEB-INF/score/modi.jsp
			req.setAttribute("score", score);
			//ת����jsp
			req.getRequestDispatcher("WEB-INF/cjcx/modi.jsp").forward(req, res);
		}

		//ɾ���ɼ�
		protected void deleteScore(HttpServletRequest req,HttpServletResponse res) throws IOException{
			String id=req.getParameter("id");
			ScoreDao dao=new ScoreDao();
			dao.deleteScoreById(new Integer(id));
		 	res.sendRedirect("adminFindScore.do");
		}
		
		//���ӳɼ�
		protected void addScore(HttpServletRequest req,HttpServletResponse res) throws IOException{
			//���ձ��е�����
			req.setCharacterEncoding("utf-8");
			String stuId=req.getParameter("stuId");
			String courseId=req.getParameter("courseId");
			String courseName=req.getParameter("courseName");
			String teacherName=req.getParameter("teacherName");
			String scoreNum=req.getParameter("scoreNum");
			//������Щ����
			Score s=new Score();
			s.setStuId(new Integer(stuId));
			s.setCourseId(new Integer(courseId));
			s.setCourseName(courseName);
			s.setTeacherName(teacherName);
			s.setScoreNum(Double.valueOf(scoreNum));
			new ScoreDao().save(s);
			res.sendRedirect("adminFindScore.do");
		}
		//�����ӳɼ�ҳ��
		protected void toAddScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			
			req.getRequestDispatcher("WEB-INF/cjcx/add.jsp").forward(req, res);
		}
		
		//ѧ����ѯ
		protected void stuFindScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{		
			//��ȡ�������
			String page=req.getParameter("page");
			if(page==null||page.equals("")){
				page="1";
			}
			//��ȡѧ��
			HttpSession session = req.getSession();
			String num = (String) session.getAttribute("adminCode");
			//System.out.println("num"+num);
			//��ȡ����
			String size="4";
			//��ѯ�ɼ�
			ScoreDao dao=new ScoreDao();
			List<Score> list=dao.stufindAll(new Integer(page),new Integer(size),new Integer(num));
			//��ѯ���������������ҳ��
			int rows=dao.findRows();
			int total=rows/new Integer(size);
			if(rows%new Integer(size)!=0){
				total++;
			}
			//�󶨵�request
			//ת������ѯҳ��
			req.setAttribute("score", list);
			req.setAttribute("total", total);
			req.setAttribute("page", page);
			//��ǰ��/Educaitonal_Management/findScore.do
			//Ŀ�꣺/Educaitonal_Management/WEB-INF/find.jsp
			req.getRequestDispatcher("WEB-INF/cjcx/stu_find.jsp").forward(req,res);
		}

		//����Ա
		protected void adminFindScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			//��ȡ�������
			String page=req.getParameter("page");
			if(page==null||page.equals("")){
				page="1";
			}
			//��ȡ����
			String size="4";
			//��ѯ�ɼ�
			ScoreDao dao=new ScoreDao();
			List<Score> list=dao.findAll(new Integer(page),new Integer(size));
			//��ѯ���������������ҳ��
			int rows=dao.findRows();
			int total=rows/new Integer(size);
			if(rows%new Integer(size)!=0){
				total++;
			}
			//�󶨵�request
			//ת������ѯҳ��
			req.setAttribute("score", list);
			req.setAttribute("total", total);
			req.setAttribute("page", page);
			//��ǰ��/Educaitonal_Management/findScore.do
			//Ŀ�꣺/Educaitonal_Management/WEB-INF/find.jsp
			req.getRequestDispatcher("WEB-INF/cjcx/admin_find.jsp").forward(req,res);
		}
		protected void contact(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/contact/contact.jsp").forward(req, res);
		}
		protected void contactAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/contact/contactAdmin.jsp").forward(req, res);
		}
		protected void contactStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/contact/contactStu.jsp").forward(req, res);
		}
}
