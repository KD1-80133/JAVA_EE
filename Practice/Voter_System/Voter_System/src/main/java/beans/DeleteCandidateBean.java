package beans;

import daos.CandidateDao;
import daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	private int candId;
	private String message;
	public DeleteCandidateBean()
	{
		
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void deleteCand()
	{
		try(CandidateDao candDao=new CandidateDaoImpl())
		{
			int count = candDao.deleteById(candId);
			this.message="Candidate Deleted :"+count;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.message=e.getMessage();
		}
	}

}
