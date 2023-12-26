package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;
import com.app.pojo.Team;

public class DeteleById {
	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		{
			TeamDaoImpl dao=new TeamDaoImpl();
		    System.out.println( "Enter Team Id for deletion");
		    System.out.println(dao.deleteById(sc.nextInt()));
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
