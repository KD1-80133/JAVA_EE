package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;
public class TestHibernate {
	public static void main(String[] args)
	{
		//getSessionFactory from utils
		try(SessionFactory sf=getFactory())
		{
			System.out.println("hibertnate booted successfully!!");
		}//JVM:sf.close()-->(DBCP is cleaned up automatically)
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
