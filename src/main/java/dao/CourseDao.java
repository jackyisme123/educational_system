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
import util.DBUtil;

public class CourseDao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4688102693757363867L;

	public List<Course> findCourse(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from course_set";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Course> list = new ArrayList<Course>();
			while(rs.next()) {
				Course c = createCourse(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ�γ�ʧ�ܣ�",e);
		} finally {
			DBUtil.close(conn);
		}
	}



	private Course createCourse(ResultSet rs) throws SQLException {
		Course c = new Course();
		c.setCourseId(rs.getInt("course_id"));
		c.setCourseName(rs.getString("course_name"));
		c.setTeacherName(rs.getString("teacher_name"));
		c.setClassroomName(rs.getString("classroom_name"));
		c.setClassDate(rs.getString("class_date"));
		c.setExamDate(rs.getString("exam_date"));
		return c;
	}
	
	/**
	 * ���ӿγ���Ϣ
	 * 
	 */
	public void save(Course c) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into course_set values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getCourseId());
			ps.setString(2, c.getCourseName());
			ps.setString(3, c.getTeacherName());
			ps.setString(4, c.getClassroomName());
			ps.setString(5, c.getClassDate());
			ps.setString(6, c.getExamDate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ӿγ�ʧ�ܣ�",e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	public void print(Course c) {
		System.out.println(c.getCourseId());
	}
	
	
	
	/**
	 * ���ҿγ���Ϣ
	 * @return 
	 */
	
	public Course findById(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from course_set where course_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return createCourse(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ӿγ�ʧ�ܣ�",e);
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * �޸Ŀγ���Ϣ
	 */
	
	public void update(Course c) {
		if(c==null) 
			return;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update course_set set course_name=?,teacher_name=?,classroom_name=?,class_date=?,exam_date=? where course_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getCourseName());
			ps.setString(2, c.getTeacherName());
			ps.setString(3, c.getClassroomName());
			ps.setString(4, c.getClassDate());
			ps.setString(5, c.getExamDate());
			ps.setInt(6,c.getCourseId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�޸Ŀγ�ʧ�ܣ�",e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * ɾ����Ϣ
	 * @param id
	 */
	public void delete(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "delete from course_set where course_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"ɾ���γ�ʧ��");
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * ��ѯĳһҳ������
	 * @param page ҳ��
	 * @param size ÿҳ��ʾ������
	 */
	public List<Course> findByPage(
		int page, int size) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"select * from ("
				+ "	select c.*,rownum r from ("
				+ "	  select * from course_set "
				+ "	  order by course_id"
				+ " ) c"
				+ ") where r between ? and ?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*size+1);
			ps.setInt(2, page*size);
			ResultSet rs = ps.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while(rs.next()) {
				Course c = createCourse(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ҳ��ѯ�γ�ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * ��ѯ������
	 */
	public int findRows() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select count(*) from course_set";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"��ѯ������ʧ��", e);
		} finally {
			DBUtil.close(con);
		}
		return 0;
	}
//	public static void main(String[] args) {
//		CourseDao dao = new CourseDao();
//		List<Course> list = dao.findCourse();
//		for(Course c : list) {
//			System.out.println(c.getCourseName());
//		}
//	}
}
