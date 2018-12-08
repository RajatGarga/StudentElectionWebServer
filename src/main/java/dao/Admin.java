package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private Connection conn = null;
	public boolean authenticate(String userName, String pwd) {
		conn = DbConnection.getConn();
		String sql = "select * from Admin where username=? and pwdhash=?";
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
