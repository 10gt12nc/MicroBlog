package tw.com.microblog.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tw.com.microblog.bean.Messagez;
import tw.com.microblog.dao.MessagesDao;
import tw.com.microblog.utils.DBConnectionUtils;


public class MessagesDaoImpl implements MessagesDao {

	@Override
	public void addMessage(Messagez mbmessage) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String addSQL = "insert into message(username, message, openmessage ) value(?,?, 0) ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(addSQL);
			ps.setString(1, mbmessage.getUsername());
			ps.setString(2, mbmessage.getMessage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

	}

	@Override
	public List<Messagez> getAllMessage(String userName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Messagez> mlist = new ArrayList<>();
		try {
			String sql = "select id, username, message from message where username=? order by id desc ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, userName);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String message = rs.getString(3);
				Messagez messagez = new Messagez(id, username, message);
				mlist.add(messagez);
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
	public void deleteUser(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "delete from message where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}

	}

	@Override
	public void updateMessagez(int id, String message) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "update message set message= ? where id = ?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, message);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
	}

	@Override
	public void openMessage(int id, Boolean bl) {
		Connection conn = null;
		PreparedStatement ps = null;
		int b = 0;
		if (bl == true) {
			b = 1;
		}
		try {
			conn = DBConnectionUtils.getDB().getConnection();
			String sql = "update message set openmessage= ? where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DBConnectionUtils.getDB().close(ps);
			DBConnectionUtils.getDB().close(conn);
		}
	}

	@Override
	public List<Messagez> getAllMessage() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Messagez> mlist = new ArrayList<>();
		try {
			String sql = "select id, username, message from message where openmessage=1 order by id desc Limit 10 ;";
			conn = DBConnectionUtils.getDB().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String message = rs.getString(3);
				Messagez messagez = new Messagez(id, username, message);
				mlist.add(messagez);
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

}
