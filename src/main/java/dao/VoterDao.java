package dao;

import java.sql.Connection;

import models.Voter;

public class VoterDao {
	private static Connection conn = null;

	public static Voter getVoter(String username) {
		conn = DbConnection.getConn();
		// TODO return a Voter object by fetching the relevant data from database
	}

	public static boolean saveVoter(Voter voter) {
		conn = DbConnection.getConn();
		// TODO check for duplicate using username and overwrite/create new entry
	}
}
