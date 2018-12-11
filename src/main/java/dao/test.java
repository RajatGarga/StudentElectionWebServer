package dao;

import java.util.ArrayList;
import java.util.Iterator;

import models.Candidate;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandidateDao dao = new CandidateDao();
		ArrayList<Candidate> can = dao.getApprovedCandidates();
		Iterator<Candidate> it = can.iterator();
		while (it.hasNext()) {
			Candidate can1 = it.next();
			System.out.println(can1.toString());
		}
	}

}
