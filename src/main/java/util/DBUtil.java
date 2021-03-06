package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 该类引入了连接池来管理连接， 连接池代替了DriverManager 它是DBTool的升级版
 * 
 * @author lenovo
 *
 */

public class DBUtil {

	private static BasicDataSource ds;

	static {
		// 1.只读取一次连接参数
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败", e);
		}
		String driver = p.getProperty("driver");
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String pwd = p.getProperty("pwd");
		String initSize = p.getProperty("initSize");
		String maxSize = p.getProperty("maxSize");
		// 2.只创建一个连接池
		ds = new BasicDataSource();
		// 3.将连续参数设置给连接池
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
	 * 由连接池创建连接，其close()被连接池改为归还的作用，而不是真正的关闭。 并且归还时，该连接内的数据被清空，状态重置为空闲态。
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("归还连接失败", e);
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.close(conn);
	}

}
