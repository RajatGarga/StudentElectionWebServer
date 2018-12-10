package dao;

import java.sql.Connection;
import java.util.ArrayList;

import models.Transaction;

public class TransactionDao {
	private static Connection conn = null;

	public static ArrayList<Transaction> getTransactions(String owner) {
		conn = DbConnection.getConn();
		// TODO return a ArrayList of Transactions by fetching the relevant data from
		// database
	}

	public static boolean saveTransaction(Transaction transaction) {
		conn = DbConnection.getConn();
		// TODO check for duplicate using id and overwrite/create new entry
	}

	public static boolean saveTransaction(ArrayList<Transaction> transaction) {
		conn = DbConnection.getConn();
		// TODO check for duplicate using id and overwrite/create new entry
	}
}
