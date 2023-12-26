package com.app.tester;
import static com.app.utils.HibernateUtils.getFactory;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;
import com.app.pojo.Team;
public class AddTeamDetails {
	public static void main(String[] args) {
	try(SessionFactory sf = getFactory();
			Scanner sc = new Scanner(System.in))
	{
		TeamDaoImpl dao=new TeamDaoImpl();
	    System.out.println( "Enter team deatils:String name, String abbreviation, String owner, int maxAge, double battingAvg,int wicketsTaken");
	    Team team=new Team(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
	    System.out.println(dao.addTeamDetails(team));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
