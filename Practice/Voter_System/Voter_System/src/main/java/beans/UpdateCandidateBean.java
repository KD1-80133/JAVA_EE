package beans;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import pojos.Candidate;

public class UpdateCandidateBean {
	private int id;
	private String name;
	private String party;
	private int votes;
	private String message;
	public UpdateCandidateBean()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void updateCandidate() {
				try(CandidateDao candDao = new CandidateDaoImpl()) {
					Candidate c = new Candidate(id, name, party, votes);
					int count = candDao.update(c);
					this.message = "Candidates Updated: " + count;
				} catch (Exception e) {
					e.printStackTrace();
					this.message = e.getMessage();
				}
			}
}
