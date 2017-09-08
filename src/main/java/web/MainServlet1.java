package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String path=req.getServletPath();
		if("/toNotice.b".equals(path)){
			notice(req,res);
		}else if("/toNoticeAdmin.b".equals(path)){
			notice_admin(req,res);
		}else if("/toNoticeStu.b".equals(path)){
			notice_stu(req,res);
		}else if("/notice1.b".equals(path)){
			notice1(req,res);
		}else if("/notice2.b".equals(path)){
			notice2(req,res);
		}else if("/notice3.b".equals(path)){
			notice3(req,res);
		}else if("/notice4.b".equals(path)){
			notice4(req,res);
		}else if("/notice1_stu.b".equals(path)){
			notice1_stu(req,res);
		}else if("/notice2_stu.b".equals(path)){
			notice2_stu(req,res);
		}else if("/notice3_stu.b".equals(path)){
			notice3_stu(req,res);
		}else if("/notice4_stu.b".equals(path)){
			notice4_stu(req,res);
		}else if("/notice1_admin.b".equals(path)){
			notice1_admin(req,res);
		}else if("/notice2_admin.b".equals(path)){
			notice2_admin(req,res);
		}else if("/notice3_admin.b".equals(path)){
			notice3_admin(req,res);
		}else if("/notice4_admin.b".equals(path)){
			notice4_admin(req,res);
		} else if ("/tojxfc.b".equals(path)) {
			tojxfc(req, res);
		} else if ("/tojxfc_stu.b".equals(path)) {
			tojxfc_stu(req, res);
		} else if ("/tojxfc_admin.b".equals(path)) {
			tojxfc_admin(req, res);
		}else {
			throw new RuntimeException("无效路径");
		}
		
		
		}
					//打开主页面
			protected void notice(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			}
			
					//打开公告页面1
			protected void notice1(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/notice/main/notice1.jsp").forward(req, res);
			}
					//打开公告页面2
			protected void notice2(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
				req.getRequestDispatcher("WEB-INF/notice/main/notice2.jsp").forward(req, res);
		}
					//打开公告页面3
		protected void notice3(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
				req.getRequestDispatcher("WEB-INF/notice/main/notice3.jsp").forward(req, res);
		}
		//打开公告页面4
		protected void notice4(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
				req.getRequestDispatcher("WEB-INF/notice/main/notice4.jsp").forward(req, res);
		}
		//打开学生主页面
		protected void notice_stu(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/indexStu.jsp").forward(req, res);
		}
		
				//打开公告页面1
		protected void notice1_stu(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/notice/main/notice1_stu.jsp").forward(req, res);
		}
				//打开公告页面2
		protected void notice2_stu(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/notice/main/notice2_stu.jsp").forward(req, res);
	}
				//打开公告页面3
	protected void notice3_stu(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/notice/main/notice3_stu.jsp").forward(req, res);
	}
	//打开公告页面4
	protected void notice4_stu(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/notice/main/notice4_stu.jsp").forward(req, res);
	}
	//打开管理员主页面
			protected void notice_admin(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/main/indexAdmin.jsp").forward(req, res);
			}
			
					//打开公告页面1
			protected void notice1_admin(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/notice/main/notice1_admin.jsp").forward(req, res);
			}
					//打开公告页面2
			protected void notice2_admin(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
				req.getRequestDispatcher("WEB-INF/notice/main/notice2_admin.jsp").forward(req, res);
		}
					//打开公告页面3
		protected void notice3_admin(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
				req.getRequestDispatcher("WEB-INF/notice/main/notice3_admin.jsp").forward(req, res);
		}
		//打开公告页面4
		protected void notice4_admin(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
				req.getRequestDispatcher("WEB-INF/notice/main/notice4_admin.jsp").forward(req, res);
		}
		
		protected void tojxfc(
				HttpServletRequest req, 
				HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/jxfc/jxfc.jsp").forward(req, res);
		}
		protected void tojxfc_stu(
				HttpServletRequest req, 
				HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/jxfc/jxfc_stu.jsp").forward(req, res);
		}
		protected void tojxfc_admin(
				HttpServletRequest req, 
				HttpServletResponse res) throws ServletException, IOException {
			req.getRequestDispatcher("WEB-INF/jxfc/jxfc_admin.jsp").forward(req, res);
		}
		
		
}
