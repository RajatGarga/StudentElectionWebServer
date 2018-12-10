package models;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Position {
	private String name;
	private int maxWinners;
	private ArrayList<Candidate> candidates;
	private ArrayList<Integer> votes;

	public Position(String name, int maxWinners) {
		super();
		this.name = name;
		this.maxWinners = maxWinners;
	}

	public void addCandidate(Candidate can) {
		this.candidates.add(can);
	}

	public String toJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public static Position fromJSON(String jsonString) {
		return new Gson().fromJson(jsonString, Position.class);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxWinners() {
		return maxWinners;
	}

	public void setMaxWinners(int maxWinners) {
		this.maxWinners = maxWinners;
	}

	public ArrayList<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(ArrayList<Candidate> candidates) {
		this.candidates = candidates;
	}

	public ArrayList<Integer> getVotes() {
		return votes;
	}

	public void setVotes(ArrayList<Integer> votes) {
		this.votes = votes;
	}

}
