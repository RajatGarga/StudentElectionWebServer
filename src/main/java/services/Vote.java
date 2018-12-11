package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import BlockChain.BlockChain;
import BlockChain.Constants;
import dao.CandidateDao;
import dao.VoterDao;
import models.Block;
import models.Candidate;
import models.Position;
import models.Transaction;
import utils.Crypto;
import utils.ElectionConfig;
import utils.General;

/**
 * Servlet implementation class Vote
 */
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Position> positions;
	BlockChain chain;
	KeyPair keys;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		keys = Crypto.generateKeys();
		positions = ElectionConfig.getPositions();
		ArrayList<Candidate> candidates = CandidateDao.getApprovedCandidates();
		Iterator<Candidate> it = candidates.iterator();
		while (it.hasNext()) {
			Candidate can1 = it.next();
			System.out.println(can1.toString());
		}
		for (int i = 0; i < candidates.size(); i++) {
			Candidate can = candidates.get(i);
			String regPos = can.getPosition();
			for (int j = 0; j < positions.size(); j++) {
				if (positions.get(j).getName().matches(regPos)) {
					Position postemp = positions.get(j);
					postemp.addCandidate(can);
					positions.set(j, postemp);
				}
			}
		}
		int size = positions.size() - 1;
		for (int i = size; i >= 0; i--) {
			if (positions.get(i).getCandidates().size() == 0) {
				positions.remove(i);
			}
		}
		int max_amount = 0;
		for (int i = 0; i < positions.size(); i++) {
			int num = positions.get(i).getMaxWinners();
			max_amount += ((num) * (num + 1)) / 2;
		}
		ArrayList<String> voterPublicKeys = VoterDao.getAllPublicKeys();
		chain = new BlockChain(null);
		Block block = new Block(General.getTimeStamp(), chain.head.hashBlock());
		for (int i = 0; i < voterPublicKeys.size(); i++) {
			Transaction tran = new Transaction(Crypto.getPublicKeyasString(keys), voterPublicKeys.get(i), 4,
					String.valueOf(i));
			tran.sign(Crypto.getPrivateKeyasString(keys));
			block.addTransaction(tran.toJSON());
		}
		block.setHeight(chain.head.getHeight() + 1);
		if (block.mine()) {
			Constants.addCode code = chain.addBlock(block, true);
			if (code == Constants.addCode.SUCCESS) {
				System.out.println("Successfully mined");
				// System.out.println(chain.toJSON());
			} else {
				System.out.println("An error occured while adding genesis: " + code);
			}
		}
		chain.addBlock(block, true);
		System.out.println("SYSTEM INIT COMPLETE! READY TO SERVE");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		JsonObject json = new JsonObject();
		json.addProperty("chain", chain.toJSON());
		JsonArray arr = new JsonArray();
		for (int i1 = 0; i1 < positions.size(); i1++) {
			arr.add(positions.get(i1).toJSON());
		}
		json.addProperty("positions", arr.toString());
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		String object = request.getParameter("block");
		Block block = Block.fromJSON(object);
		JsonObject json = new JsonObject();
		Constants.addCode code = chain.addBlock(block, false);
		System.out.println("Got Post!");
		if (code == Constants.addCode.SUCCESS) {
			json.addProperty("success", "true");
			json.addProperty("message", "Successfully Cast Vote");
			System.out.println("Successfuly added bloc!");
		} else {
			json.addProperty("success", "false");
			json.addProperty("message", code.toString());
			json.addProperty("chain", chain.toJSON());
			System.out.println(code.toString());
		}
		PrintWriter out = response.getWriter();
		out.println(json.toString());
	}

}
