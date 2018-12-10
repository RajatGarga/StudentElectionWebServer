package dao;

import java.sql.Connection;
import java.util.ArrayList;

import models.Voter;

public class VoterDao {
	private static Connection conn = null;

	public static Voter getVoter(String username) {
		conn = DbConnection.getConn();
		Voter v = new Voter();
		String sql = "select * from Voter where username=?";
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				v.setPwdHash(rs.getString(2));
				v.setUsername(rs.getString(1));
				v.setPublicKey(rs.getString(3));
				v.setPrivateKey(rs.getString(4));
				
				}
			
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public static boolean saveVoter(Voter v) {
		conn = DbConnection.getConn();
		
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO Voter(username,pwdhash,public_key,private_key) VALUES('"
				+ v.getUsername() + "','" + v.getPwdHash() + "','" + v.getPublicKey() + "','"
				+ v.getPrivateKey() + "');";
		stmt.executeUpdate(sql);
	}

	public static ArrayList<String> getAllPublicKeys() {

	}
}
