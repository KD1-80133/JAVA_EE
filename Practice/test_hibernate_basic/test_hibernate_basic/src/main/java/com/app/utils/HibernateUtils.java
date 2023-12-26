package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
public class HibernateUtils {
	private static SessionFactory factory;
//	static init block to create singleton SF
//	Configuration-->configure-->buildSessionFactory
	static
	{

		System.out.println("in static init block");
//		build SF
		factory=new Configuration()//empty config created
				.configure()//reads hibernate config xml file n populates the config
				.buildSessionFactory();//builds instance of Sf from the populated(filled up) config
		System.out.println("Session factory created....");
	}
	//add getter
	public static SessionFactory getFactory()
	{
		return factory;
	}
}
