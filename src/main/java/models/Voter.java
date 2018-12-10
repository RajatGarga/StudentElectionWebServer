package models;

public class Voter {
	private String publicKey;
	private String privateKey;
	private String username;
	private String pwdHash;

	public Voter(String publicKey, String privateKey, String username, String pwdHash) {
		super();
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		this.username = username;
		this.pwdHash = pwdHash;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

}
