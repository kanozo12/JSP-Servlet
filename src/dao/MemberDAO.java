package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.LoginDTO;
import domain.UserVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	
	private MemberDAO() {
		//do nothing; //기본 생성자를 private으로 만들어서 더 이상 생성하지 못하게 막음
	}
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public UserVO login(LoginDTO login) {
		String sql = "SELECT * FROM after_jsp WHERE id = ? AND pass = ?";
		Connection con = JDBCUtil.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPass());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(con);
		}
	}

	public boolean register(UserVO user) {
		String sql = "INSERT INTO after_jsp(`id`, `pass`, `name`) VALUES(?, ?, ?)";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getName());
			int res = pstmt.executeUpdate();
			
			return res == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(con);
		}
	}
}
