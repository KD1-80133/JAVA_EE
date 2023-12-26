package beans;

import java.util.List;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import pojos.Candidate;

public class ResultBean {
	private List<Candidate> candList;
	
	public ResultBean()
	{
		
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchResult()
	{
		try(CandidateDao candDao=new CandidateDaoImpl())
		{
			candList=candDao.getCandidatewiseVotes();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
