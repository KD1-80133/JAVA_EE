package com.app.dao;

import com.app.pojo.Team;
import org.hibernate.*;
import static com.app.utils.HibernateUtils.getFactory;
import java.io.Serializable;
import java.util.List;

public class TeamDaoImpl implements TeamDao{

	@Override
	public String addTeamDetails(Team newTeam) {
		String msg="Adding team failed!!";
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin a tx
		Transaction tx=session.beginTransaction();
		//3.try-save team details,commit
		try
		{
			Serializable teamId=session.save(newTeam);
			tx.commit();
			msg="Added team deatils with Id="+teamId;
		}
		//catch : runtime exc:rollback tx,throw e
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<Team> getAllTeamByIdAndAbbreviation() {
		List<Team> team=null;
		String jpql="select new com.app.pojo.Team(teamId,abbreviation) from Team t";
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin a tx
		Transaction tx=session.beginTransaction();
		//3.try-save team details,commit
		try
		{
			team=session.createQuery(jpql,Team.class).getResultList();
			tx.commit();
			
		}
		//catch : runtime exc:rollback tx,throw e
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public Team getAllTeamDeatils(Integer teamId) {
		Team team=null;
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin a tx
		Transaction tx=session.beginTransaction();
		//3.try-save team details,commit
		try
		{
			team=session.get(Team.class, teamId);
			tx.commit();
		}
		//catch : runtime exc:rollback tx,throw e
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public List<Team> getAllTeamByAgeAndWicket(int maxAge, int wicketsTaken) {
		List<Team> team=null;
		String jpql="select t from Team t where t.maxAge < :age and t.wicketsTaken > :wkts";
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin a tx
		Transaction tx=session.beginTransaction();
		//3.try-save team details,commit
		try
		{
			
			team=session.createQuery(jpql,Team.class).setParameter("age",maxAge).setParameter("wkts", wicketsTaken).getResultList();
			tx.commit();
			
		}
		//catch : runtime exc:rollback tx,throw e
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return team;
		
	}

	@Override
	public String updateAgeAndBattingAvg(String name,int maxAge,double battingAvg) {
		Team team=null;
		String msg="update failed!!";
		String jpql="select t from Team t where t.name=:teamName";
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin a tx
		Transaction tx=session.beginTransaction();
		//3.try-save team details,commit
		try
		{
			team=session.createQuery(jpql,Team.class).setParameter("teamName", name).getSingleResult();
			team.setMaxAge(team.getMaxAge()+maxAge);
			team.setBattingAvg(team.getBattingAvg()+battingAvg);
			msg="Updated "+team.getMaxAge()+"MaxAge to"+team.getMaxAge()+"And Batting avg to"+team.getBattingAvg();
			
			tx.commit();
			
		}
		//catch : runtime exc:rollback tx,throw e
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteById(Integer teamId) {
		Team team=null;
		String msg="deletion failed!!";
		String jpql="select t from Team t where t.name=:teamName";
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin a tx
		Transaction tx=session.beginTransaction();
		//3.try-save team details,commit
		try
		{
			team=session.get(Team.class, teamId);
			if(team!=null)
			{
				session.delete(team);
			msg="deleted team deatils of"+team.getName();
			}
			tx.commit();
			
		}
		//catch : runtime exc:rollback tx,throw e
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
		
	}

}
