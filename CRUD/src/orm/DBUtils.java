/**
 * 
 */
package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author dervish
 *
 */
public class DBUtils {
	static String url = "jdbc:mysql://localhost/servletdb?&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false";
	static String username = "root";
	static String passwordd = "1234";

	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement st = null;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, passwordd);
		st = con.prepareStatement(sql);

		return st;

	}

	private void close() {

	}
}
