package dao;

import java.sql.Connection;
import java.util.ArrayList;

public class VotesDao {
	private static Connection conn = null;

	public static ArrayList<Block> getBlocks() {
		// TODO create one block for every unique timestamp that has all its
		// transactions and return ArrayList of such Blocks

		// Use the constructor with ArrayList of transactions

	}

	public static boolean saveBlock(Block block) {
		// TODO for all transactions in the block create a tuple in votes table and add
		// the transaction to transactions table

		// use getTransactionsArray() function on block
	}
}