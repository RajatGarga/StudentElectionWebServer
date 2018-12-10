package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Candidate;

public class CandidateDao {
	private static Connection conn = null;

	public void saveCandidatesDetails(Candidate n1) throws SQLException {
		conn = DbConnection.getConn();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO NomineeDetails(first_name,family_name,email,phone_number,hostel,room_number,batch,branch,cgpa,position) VALUES('"
				+ n1.getFirstName() + "','" + n1.getFamilyName() + "','" + (String) n1.getEmail() + "','"
				+ n1.getPhoneNum() + "','" + n1.getHostel() + "','" + n1.getRoom() + "','" + n1.getBatch() + "','"
				+ n1.getBranch() + "','" + n1.getCgpa() + "','" + n1.getPosition() + "')";
		stmt.executeUpdate(sql);

	}

	public static ArrayList<Candidate> getApprovedCandidates() {

	}

	public ArrayList<Candidate> getAllCandidatesDetails() {
		String sql = "select * from NomineeDetails";
		ArrayList<Candidate> nominee_details = new ArrayList<Candidate>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Candidate n1 = new Candidate();
				n1.setFirstName(rs.getString(1));
				n1.setFamilyName(rs.getString(2));
				n1.setEmail(rs.getString(3));
				n1.setPhoneNum(rs.getString(4));
				n1.setHostel(rs.getString(5));
				n1.setRoom(rs.getString(6));
				n1.setBatch(rs.getString(7));
				n1.setBranch(rs.getString(8));
				n1.setCgpa(rs.getString(9));
				n1.setPosition(rs.getString(10));
				nominee_details.add(n1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}

		return nominee_details;

	}
}
