package com.app.dao;
import java.util.List;

import com.app.pojo.Team;
public interface TeamDao {
// add a method to insrt teams details
	String addTeamDetails(Team newTeam);
	
	List<Team> getAllTeamByIdAndAbbreviation();
	
	Team getAllTeamDeatils(Integer teamId);
	
	List<Team> getAllTeamByAgeAndWicket(int maxAge,int wicketsTaken);
	
	String updateAgeAndBattingAvg(String name,int maxAge,double battingAvg);
	
	String deleteById(Integer teamId);
	
}
