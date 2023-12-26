package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;
import com.app.pojo.Team;

public class UpdateByName {
	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		{
			TeamDaoImpl dao=new TeamDaoImpl();
		    System.out.println( "Enter Team name And Age , Avrage to incrrement");
		    System.out.println(dao.updateAgeAndBattingAvg(sc.next(),sc.nextInt(),sc.nextDouble()));
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
