package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import entity.Student;
import util.DBUtil;

public class StuDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3956428956772028110L;
	public Student findByCode(String code){
		
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="select * from student_info where stu_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Student a=new Student();
				a.setStuId(rs.getInt("stu_id"));
				a.setPwd(rs.getString("pwd"));
				a.setName(rs.getString("name"));
				a.setGender(rs.getString("gender"));
				a.setAge(rs.getInt("age"));
				a.setMobile(rs.getObject("mobile"));
				a.setAddress(rs.getString("address"));
				return a;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����Աʧ��",e);
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	
	public Student findStudentById(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from student_info where stu_id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Student s = new Student();
				s.setStuId(rs.getInt("stu_id"));
				s.setPwd(rs.getString("pwd"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setMobile(rs.getObject("mobile"));
				s.setAddress(rs.getString("address"));
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯѧ����Ϣʧ��",e);
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
	}
	
	//����Ա��¼ʱ�鿴����ѧ����Ϣ
	public List<Student> findStudentAll(){
		Connection conn=null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from student_info order by stu_id";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Student> list = new ArrayList<Student>();
			while(rs.next()){
				Student s = new Student();
				s.setStuId(rs.getInt("stu_id"));
				s.setPwd(rs.getString("pwd"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setMobile(rs.getObject("mobile"));
				s.setAddress(rs.getString("address"));
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ѧ����Ϣʧ��",e);
		}finally{
			DBUtil.close(conn);
		}
		
	}
	//����Ա��¼���ѧ����Ϣ
	public void save(Student student){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into student_info values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, student.getStuId());
			ps.setString(2,student.getPwd() );
			ps.setString(3, student.getName());
			ps.setString(4, student.getGender());
			ps.setObject(5, student.getAge());
			ps.setObject(6, student.getMobile());
			ps.setString(7, student.getAddress());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ѧ��ʧ��",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	//����Ա��¼�޸�ѧ����Ϣ
	public void update(Student s){
		if(s==null){
			return;
		}
		Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				String sql="update student_info set pwd=?,name=?,gender=?,age=?,mobile=?,address=? where stu_id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, s.getPwd());
				ps.setString(2, s.getName());
				ps.setString(3, s.getGender());
				ps.setObject(4, s.getAge());
				ps.setObject(5, s.getMobile());
				ps.setString(6, s.getAddress());
				ps.setObject(7, s.getStuId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�޸�ѧ��ʧ��",e);
			}finally{
				DBUtil.close(conn);
			}
			
	}
	//����Ա��¼ɾ��ѧ����Ϣ
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from student_info where stu_id=?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"ɾ��ѧ��ʧ��");
		} finally {
			DBUtil.close(conn);
		}
	}
	
	
	
}
