/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.user;
import orm.DBUtils;

/**
 * @author dervish
 *
 */
public class UserDao {

	/* user model/user.java */
	public void addNew(user user) {

		try {
			/* DBUtils içindeki Sql deðeri alan method */
			PreparedStatement ps = DBUtils
					.getPreparedStatement("insert into users(username,password,email) values(?,?,?)");
			/* user model/user.java getFileds methods */
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(user user) {
		PreparedStatement ps;
		try {
			ps = DBUtils.getPreparedStatement("UPDATE users SET username=?,password=?,email=? WHERE id=?");
			// parametreler
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<user> getAll() {
		List<user> ls = new ArrayList<user>();

		try {
			ResultSet rs = DBUtils.getPreparedStatement("SELECT * FROM users").executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(2));
				user u = new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				ls.add(u);
				// System.out.println("Linked list : " + ls);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ls;

	}

	public static user getUser(int id) {
		int idUser = id;
		user u = new user();

		try {

			ResultSet rs = DBUtils.getPreparedStatement("SELECT * FROM users WHERE id=" + idUser).executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(2));
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				// System.out.println("Linked list : " + ls);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;

	}

	public void deleteUser(String id) {

		try {
			/* DBUtils içindeki Sql deðeri alan method */
			PreparedStatement ps = DBUtils.getPreparedStatement("delete from users where id=?");
			/* user model/user.java getFileds methods */
			ps.setString(1, id);

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * }
	 */

}
