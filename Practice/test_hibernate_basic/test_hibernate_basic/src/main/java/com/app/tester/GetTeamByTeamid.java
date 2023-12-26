package com.app.tester;

import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import com.app.dao.TeamDaoImpl;


import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class GetTeamByTeamid {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			// create dao instance
			TeamDaoImpl dao = new TeamDaoImpl();
			System.out.println("Team List");
			dao.getAllTeamByIdAndAbbreviation().forEach(t->System.out.println(t.getTeamId()+""+t.getAbbreviation()));{
				
			}// auto boxing
		} // JVM : sc.close , sf.close=> DBCP is clened up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
