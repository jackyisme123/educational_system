package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.stuCourse;
import util.DBUtil;

public class stuCourseDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4258211778423903298L;

	public List<stuCourse> findCourse(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from stucourse_set";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<stuCourse> list = new ArrayList<stuCourse>();
			while(rs.next()) {
				stuCourse s = createStuCourse(rs);
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询课程失败！",e);
		} finally {
			DBUtil.close(conn);
		}
	}

	
	
	
	/**
	 * 查询某一页的数据
	 * @param page 页码
	 * @param size 每页显示的行数
	 */
	public List<stuCourse> findByPageAndId(
		int page, int size,int id) {
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from ("
				+ "	select c.*,rownum r from ("
				+ "	  select * from stucourse_set "
				+ "	  where stu_id=? order by course_id "
				+ " ) c"
				+ ") where r between ? and ?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2, (page-1)*size+1);
			ps.setInt(3, page*size);
			ResultSet rs = ps.executeQuery();
			List<stuCourse> list = new ArrayList<stuCourse>();
			while(rs.next()) {
				stuCourse s = createStuCourse(rs);		
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"分页查询课程失败", e);
		} finally {
			DBUtil.close(conn);
		}
	}

	private stuCourse createStuCourse(ResultSet rs) throws SQLException {
		stuCourse s = new stuCourse();
		s.setStudentId(rs.getInt("stu_id"));
		s.setCourseId(rs.getInt("course_id"));
		s.setCourseName(rs.getString("course_name"));
		s.setTeacherName(rs.getString("teacher_name"));
		s.setClassroomName(rs.getString("classroom_name"));
		s.setClassDate(rs.getString("class_date"));
		s.setExamDate(rs.getString("exam_date"));
		return s;
	}
	
	/**
	 * 查询总行数
	 */
	public int findRows() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select count(*) from stucourse_set";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询总行数失败", e);
		} finally {
			DBUtil.close(con);
		}
		return 0;
	}
	
	/**
	 * 选课
	 * 
	 */
	public void save(stuCourse s) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into stucourse_set values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getStudentId());
			ps.setInt(2, s.getCourseId());
			ps.setString(3, s.getCourseName());
			ps.setString(4, s.getTeacherName());
			ps.setString(5, s.getClassroomName());
			ps.setString(6, s.getClassDate());
			ps.setString(7, s.getExamDate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("选课失败！",e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 删除信息
	 * @param id
	 */
	public void delete(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "delete from stucourse_set where course_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"删除课程失败");
		} finally {
			DBUtil.close(con);
		}
	}
//	public static void main(String[] args) {
//		stuCourseDao s = new stuCourseDao();
//		List<stuCourse> list = s.findByPage(2, 5);
//		for(stuCourse sc: list ) {
//			System.out.println(sc.getStudentId() + "," + sc.getCourseName());
//		}
//	}
}
