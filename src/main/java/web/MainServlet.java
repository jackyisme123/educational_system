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
			throw new RuntimeException("无效的路径");
		}
	}

	protected void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 接收表单数据
		String adminCode = req.getParameter("adminCode");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		Integer level = new Integer(req.getParameter("level"));
		// 从session中获取生成的验证码
		HttpSession session = req.getSession();
		String imgcode = (String) session.getAttribute("imgcode");
		// 检查验证码
		if (code == null || !code.equalsIgnoreCase(imgcode)) {
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			return;
		}

		// 检查账号密码

		if (level == 1) {
			if (!adminCode.equals("admin")) {
				// 账号错误，转发回登录页并提示
				req.setAttribute("error", "账号错误");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);

			} else if (!password.equals("admin")) {
				// 密码错误，转发回登录页提示
				req.setAttribute("error", "密码错误");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			}

			else {
				// 将账号储存如cookie，发送给浏览器，浏览器自动保存，给后续页面使用
				Cookie cookie = new Cookie("adminCode", adminCode);
				res.addCookie(cookie);
				// 也可用session来保存账号
				session.setAttribute("adminCode", adminCode);
				// 都对重定向到首页
				res.sendRedirect("toIndexAdmin.do");

			}
		} else {
			StuDao dao = new StuDao();
			Student a = dao.findByCode(adminCode);
			if (a == null) {
				// 账号错误，转发回登录页并提示
				req.setAttribute("error", "账号错误");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			} else if (!a.getPwd().equals(password)) {
				// 密码错误，转发回登录页提示
				req.setAttribute("error", "密码错误");
				req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			} else {
				// 将账号储存如cookie，发送给浏览器，浏览器自动保存，给后续页面使用
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
				// 也可用session来保存账号
				session.setAttribute("adminCode", adminCode);
				// 都对重定向到首页
				res.sendRedirect("toIndexStu.do");
			}
		}
	}

	protected void createImg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 生产随机的验证码及图片
		Object[] objs = ImageUtil.createImage();
		// 将验证码存入session
		String imgcode = (String) objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", imgcode);
		// 将图片输出给浏览器
		BufferedImage img = (BufferedImage) objs[1];
		res.setContentType("image/png");
		// 服务器自动创建输出流，目标指向浏览器
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "png", os);
		os.close();
	}

	// 退出登录
	protected void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 销毁session
		req.getSession().invalidate();
		// 重定向到登录页面
		res.sendRedirect("toLogin.do");

	}

	// 打开登录页面
	protected void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
	}

	// 打开学生主页
	protected void toIndexStu(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/main/indexStu.jsp").forward(req, res);
	}

	// 打开管理员主页
	protected void toIndexAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/indexAdmin.jsp").forward(req, res);
	}

	protected void findCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 获取请求参数
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// 获取常量
		String size = "5";

		// 查询资费
		CourseDao dao = new CourseDao();
		List<Course> list = dao.findByPage(new Integer(page), new Integer(size));
		// 查询总行数，计算总页数
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
	 * 跳转到增加页面
	 */
	protected void toAddCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/course/add.jsp").forward(req, res);

	}

	/*
	 * 增加课程
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
	 * 修改课程
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
	 * 删除课程
	 */

	protected void deleteCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		new CourseDao().delete(new Integer(id));
		res.sendRedirect("findCourse.do");
	}

	/**
	 * 查询学生已选课程
	 * 
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findStuCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 获取请求参数
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}

		HttpSession session = req.getSession();
		String stuId = (String) session.getAttribute("adminCode");

		// 获取常量
		String size = "5";

		// 查询

		stuCourseDao dao = new stuCourseDao();
		List<stuCourse> list = dao.findByPageAndId(new Integer(page), new Integer(size), new Integer(stuId));
		// 查询总行数，计算总页数
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
	 * 跳转选课页面
	 * 
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toShowCourse(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 获取请求参数
		String page = req.getParameter("page");
		if (page == null || page.equals("")) {
			page = "1";
		}
		// 获取常量
		String size = "5";

		// 查询资费
		CourseDao dao = new CourseDao();
		List<Course> list = dao.findByPage(new Integer(page), new Integer(size));
		// 查询总行数，计算总页数
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
	//修改成绩
		protected void updateScore(HttpServletRequest req,HttpServletResponse res) throws IOException{
			//接收从表单中的数据
			req.setCharacterEncoding("utf-8");	
			String stuId=req.getParameter("stuId");
			String courseId=req.getParameter("courseId");
			String courseName=req.getParameter("courseName");
			String teacherName=req.getParameter("teacherName");
			String scoreNum=req.getParameter("scoreNum");
			//保存这些数据
			Score s=new Score();
			s.setStuId(new Integer(stuId));
			s.setCourseId(new Integer(courseId));
			s.setCourseName(courseName);
			s.setTeacherName(teacherName);
			s.setScoreNum(new Double(scoreNum));
			new ScoreDao().updateScore(s);
			//重定向到查询功能(重定向一般都是.do)
			res.sendRedirect("adminFindScore.do");
			
		}
		
		//打开修改成绩的页面
		protected void toUpdateScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			//接收浏览器传过来的参数getParameter()或者getParameterValues()
			String id=req.getParameter("id");
			System.out.println(id);
			//根据id查询该数据
			ScoreDao dao=new ScoreDao();
			Score score=dao.findById(new Integer(id));
			//跳转到该页面WEB-INF/score/modi.jsp
			req.setAttribute("score", score);
			//转发到jsp
			req.getRequestDispatcher("WEB-INF/cjcx/modi.jsp").forward(req, res);
		}

		//删除成绩
		protected void deleteScore(HttpServletRequest req,HttpServletResponse res) throws IOException{
			String id=req.getParameter("id");
			ScoreDao dao=new ScoreDao();
			dao.deleteScoreById(new Integer(id));
		 	res.sendRedirect("adminFindScore.do");
		}
		
		//增加成绩
		protected void addScore(HttpServletRequest req,HttpServletResponse res) throws IOException{
			//接收表单中的数据
			req.setCharacterEncoding("utf-8");
			String stuId=req.getParameter("stuId");
			String courseId=req.getParameter("courseId");
			String courseName=req.getParameter("courseName");
			String teacherName=req.getParameter("teacherName");
			String scoreNum=req.getParameter("scoreNum");
			//保存这些数据
			Score s=new Score();
			s.setStuId(new Integer(stuId));
			s.setCourseId(new Integer(courseId));
			s.setCourseName(courseName);
			s.setTeacherName(teacherName);
			s.setScoreNum(Double.valueOf(scoreNum));
			new ScoreDao().save(s);
			res.sendRedirect("adminFindScore.do");
		}
		//打开增加成绩页面
		protected void toAddScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			
			req.getRequestDispatcher("WEB-INF/cjcx/add.jsp").forward(req, res);
		}
		
		//学生查询
		protected void stuFindScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{		
			//获取请求参数
			String page=req.getParameter("page");
			if(page==null||page.equals("")){
				page="1";
			}
			//获取学号
			HttpSession session = req.getSession();
			String num = (String) session.getAttribute("adminCode");
			//System.out.println("num"+num);
			//获取常量
			String size="4";
			//查询成绩
			ScoreDao dao=new ScoreDao();
			List<Score> list=dao.stufindAll(new Integer(page),new Integer(size),new Integer(num));
			//查询总行数，计算出总页数
			int rows=dao.findRows();
			int total=rows/new Integer(size);
			if(rows%new Integer(size)!=0){
				total++;
			}
			//绑定到request
			//转发到查询页面
			req.setAttribute("score", list);
			req.setAttribute("total", total);
			req.setAttribute("page", page);
			//当前：/Educaitonal_Management/findScore.do
			//目标：/Educaitonal_Management/WEB-INF/find.jsp
			req.getRequestDispatcher("WEB-INF/cjcx/stu_find.jsp").forward(req,res);
		}

		//管理员
		protected void adminFindScore(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			//获取请求参数
			String page=req.getParameter("page");
			if(page==null||page.equals("")){
				page="1";
			}
			//获取常量
			String size="4";
			//查询成绩
			ScoreDao dao=new ScoreDao();
			List<Score> list=dao.findAll(new Integer(page),new Integer(size));
			//查询总行数，计算出总页数
			int rows=dao.findRows();
			int total=rows/new Integer(size);
			if(rows%new Integer(size)!=0){
				total++;
			}
			//绑定到request
			//转发到查询页面
			req.setAttribute("score", list);
			req.setAttribute("total", total);
			req.setAttribute("page", page);
			//当前：/Educaitonal_Management/findScore.do
			//目标：/Educaitonal_Management/WEB-INF/find.jsp
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
