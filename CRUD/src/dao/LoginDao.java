/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dervish
 *
 */
public class LoginDao {
  static String sql="select * from users where username=? and password=?";
 
  static String url="jdbc:mysql://localhost/servletdb?&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false";
  static String username="root";
  static String passwordd="1234";
  
  public static boolean check(String user,String password) {
	  
	  try {
		 Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, username,passwordd);
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,user);
		st.setString(2,password);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
			return true;
		}
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return false;
	  
	  
  }
  
 /** public static void main(String[] args) {
	System.out.println(check("dervis","1234"));
}*/
}
