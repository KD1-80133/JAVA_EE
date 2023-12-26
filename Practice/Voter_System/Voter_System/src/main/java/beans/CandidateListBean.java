package beans;

import java.util.List;

import daos.CandidateDao;
import daos.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> candList;
	
	public  CandidateListBean()
	{
		
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchCandidateList()
	{
		try(CandidateDao candDao=new CandidateDaoImpl())
		{
			candList=candDao.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
