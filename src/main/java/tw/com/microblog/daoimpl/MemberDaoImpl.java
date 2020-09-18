package tw.com.microblog.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import tw.com.microblog.basedao.Dao;
import tw.com.microblog.bean.Memberz;
import tw.com.microblog.dao.MemberDao;
import tw.com.microblog.utils.DBConnectionUtils;


public class MemberDaoImpl extends Dao<Memberz> implements MemberDao {

	
	
	
	@Override
	public void addUser(Memberz mb) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// role預設0未啟用(未驗證)
			String addSQL = "insert into memberz(username, password1,password2, email, role,salt) value(?,?,?,?,?,?);";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(addSQL);
			ps.setString(1, mb.getUsername());
			ps.setString(2, mb.getPassword1());
			ps.setString(3, mb.getPassword2());
			ps.setString(4, mb.getEmail());
			ps.setInt(5, 0);
			ps.setInt(6, mb.getSalt());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Memberz> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Memberz> mlist = new ArrayList<>();
		try {
			String sql = "select * from memberz ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Boolean blrole = false;
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password1 = rs.getString(3);
				String password2 = rs.getString(4);
				String email = rs.getString(5);
				int role = rs.getInt(6);
				if (role == 1) {
					blrole = true;
				}
				int salt = rs.getInt(7);
				Memberz memberz = new Memberz(id, username, password1, password2, email, blrole, salt);
				mlist.add(memberz);
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
		return mlist;
	}

	@Override
	public List<Memberz> getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Memberz> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserPass(String username, String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pass = null;
		try {
			String sql = "select password1 from  memberz where username=? and email=? ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				pass = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

		return pass;
	}

	@Override
	public boolean getLogin(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean bllogin = false;
		try {
			String sql = "select id from  memberz where username=? and password1=? ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				bllogin = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

		return bllogin;
	}

	@Override
	public int getPassLogin(String username, String email, int a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkName(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean bluser = false;
		try {
			String sql = "select id from  memberz where username=?;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				bluser = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

		return bluser;
	}

	@Override
	public String getUserName(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("login");
	}

	@Override
	public boolean checkEmail(String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean blemail = false;
		try {
			String sql = "select id from  memberz where email=?;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				blemail = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

		return blemail;
	}

	@Override
	public void activateEmail(int id, String email, int salt) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "update memberz set role= ? where id=? and email=? and salt=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);// 啟動為會員
			ps.setInt(2, id);
			ps.setString(3, email);
			ps.setInt(4, salt);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
	}

	@Override
	public int getIdByEmail(String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String sql = "select id from memberz where email=?;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

		return id;
	}

	@Override
	public int getSaltBy(int id, String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int salt = 0;
		try {
			String sql = "select salt from memberz where id=? and email=?;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, email);
			rs = ps.executeQuery();

			while (rs.next()) {
				salt = rs.getInt(1);
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

		return salt;
	}

	@Override
	public void updatePass(int id, String newpass, String newpass2) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "update memberz set password1= ? , password2=? where id=? ;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpass);
			ps.setString(2, newpass2);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
	}

	@Override
	public int getIdBy(String name, String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String sql = "select id from memberz where username=? and email=?;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(rs);
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

		return id;
	}

}
