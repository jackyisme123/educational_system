package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * �������������ӳ����������ӣ� ���ӳش�����DriverManager ����DBTool��������
 * 
 * @author lenovo
 *
 */

public class DBUtil {

	private static BasicDataSource ds;

	static {
		// 1.ֻ��ȡһ�����Ӳ���
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡ�����ļ�ʧ��", e);
		}
		String driver = p.getProperty("driver");
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String pwd = p.getProperty("pwd");
		String initSize = p.getProperty("initSize");
		String maxSize = p.getProperty("maxSize");
		// 2.ֻ����һ�����ӳ�
		ds = new BasicDataSource();
		// 3.�������������ø����ӳ�
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pwd);
		ds.setInitialSize(new Integer(initSize));
		ds.setMaxActive(new Integer(maxSize));
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();

	}

	/**
	 * �����ӳش������ӣ���close()�����ӳظ�Ϊ�黹�����ã������������Ĺرա� ���ҹ黹ʱ���������ڵ����ݱ���գ�״̬����Ϊ����̬��
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�黹����ʧ��", e);
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.close(conn);
	}

}
