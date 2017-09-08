package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Score;
import util.DBUtil;

public class ScoreDao implements Serializable {

	public static void main(String[] args) {
		ScoreDao dao = new ScoreDao();
		List<Score> list = dao.findAll(1, 4);
		for (Score s : list) {
			System.out.println(s);
		}
	}

	// ��ѯ������
	public int findRows() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) from score";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ������ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}
		return 0;
	}

	// Dao�������������ݿ���ֶεģ�����ҵ���߼��ģ�
	public List<Score> findAll(int page, int size) {
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "select * from (select c.*,rownum r from(select * from score order by course_id) c)where r between ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, (page - 1) * size + 1);
			ps.setInt(2, page * size);
			ResultSet rs = ps.executeQuery();
			List<Score> list = new ArrayList<Score>();
			while (rs.next()) {
				Score s = new Score();
				s.setStuId(rs.getInt("stu_id"));
				s.setCourseId(rs.getInt("course_id"));
				s.setCourseName(rs.getString("course_name"));
				s.setTeacherName(rs.getString("teacher_name"));
				s.setScoreNum(rs.getDouble("score"));
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("1");
			throw new RuntimeException("��ҳ��ѯ����ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public List<Score> stufindAll(int page, int size,int num) {
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "select * from (select c.*,rownum r from(select * from score where stu_id= "+num+"order by course_id ) c)where r between ? and ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, (page - 1) * size + 1);
			ps.setInt(2, page * size);
			ResultSet rs = ps.executeQuery();
			List<Score> list = new ArrayList<Score>();
			while (rs.next()) {
				Score s = new Score();
				s.setStuId(rs.getInt("stu_id"));
				s.setCourseId(rs.getInt("course_id"));
				s.setCourseName(rs.getString("course_name"));
				s.setTeacherName(rs.getString("teacher_name"));
				s.setScoreNum(rs.getDouble("score"));
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ѧ����ҳ��ѯ����ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public void save(Score s) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "Insert into score values(?,?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getStuId());
			ps.setInt(2, s.getCourseId());
			ps.setString(3, s.getCourseName());
			ps.setString(4, s.getTeacherName());
			ps.setDouble(5, s.getScoreNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�����ɼ�ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public void deleteScoreById(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from score where course_id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ���ɼ��쳣", e);
		} finally {
			DBUtil.close(conn);
		}

	}

	public Score findById(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from score where course_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Score s = new Score();
				s.setStuId(rs.getInt("stu_id"));
				s.setCourseId(rs.getInt("course_id"));
				s.setCourseName(rs.getString("course_name"));
				s.setTeacherName(rs.getString("teacher_name"));
				s.setScoreNum(rs.getDouble("score"));
				return s;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ�ɼ�ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}

		return null;

	}

	public void updateScore(Score s) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update score set stu_id=?,course_name=?,teacher_name=?,score=? where course_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getStuId());
			ps.setString(2, s.getCourseName());
			ps.setString(3, s.getTeacherName());
			// setInt()/setDouble()��֧��null
			// ��ҵ������Щ�ֶ�ȷʵ����ΪNull
			// ��ʱ����Object���䴦����
			ps.setObject(4, s.getScoreNum());
			ps.setObject(5, s.getCourseId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�ɼ��޸�ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}

	}
}
