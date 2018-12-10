package models;

import java.util.ArrayList;

import com.google.gson.JsonArray;

public class Block {
	private int height;
	private String timestamp;
	private JsonArray transactions;
	private String previousHash;
	private int nonce;
	private Block parent;

	public Block(int height, String timestamp, ArrayList<Transaction> transactions, String previousHash, int nonce,
			Block parent) {
		super();
		this.height = height;
		this.timestamp = timestamp;
		this.transactions = new JsonArray();
		for (int i = 0; i < transactions.size(); i++) {
			this.transactions.add(transactions.get(i).toJSON());
		}
		this.previousHash = previousHash;
		this.nonce = nonce;
		this.parent = parent;
	}

	public Block(int height, String timestamp, JsonArray transactions, String previousHash, int nonce, Block parent) {
		super();
		this.height = height;
		this.timestamp = timestamp;
		this.transactions = transactions;
		this.previousHash = previousHash;
		this.nonce = nonce;
		this.parent = parent;
	}

	public Block(String timestamp, JsonArray transactions, String previousHash) {
		super();
		this.height = -1;
		this.timestamp = timestamp;
		this.transactions = transactions;
		this.previousHash = previousHash;
		this.nonce = 0;
		parent = null;
	}

	public Block(String timestamp, String previousHash) {
		super();
		this.height = -1;
		this.timestamp = timestamp;
		this.transactions = new JsonArray();
		this.previousHash = previousHash;
		this.nonce = 0;
		parent = null;
	}

	public Block(String timestamp, JsonArray transactions, String previousHash, int nonce) {
		super();
		this.height = -1;
		this.timestamp = timestamp;
		this.transactions = transactions;
		this.previousHash = previousHash;
		this.nonce = nonce;
		parent = null;
	}

	public ArrayList<Transaction> getTransactionsArray() {
		ArrayList<Transaction> t = new ArrayList<Transaction>();
		for (int i = 0; i < this.transactions.size(); i++) {
			Transaction tempTrans = Transaction.fromJSON(this.transactions.get(i).getAsString());
			t.add(tempTrans);
		}
		return t;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public JsonArray getTransactions() {
		return transactions;
	}

	public void setTransactions(JsonArray transactions) {
		this.transactions = transactions;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public Block getParent() {
		return parent;
	}

	public void setParent(Block parent) {
		this.parent = parent;
	}

}
