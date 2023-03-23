package com.green.nown;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class DBListener
 *
 */
@WebListener
public class DBListener implements ServletContextListener {


    public DBListener() {
        // TODO Auto-generated constructor stub
    }

    //서버 종료시 실행
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("서버가 종료되면 같이 종료되요");
    }

    //서버 실행시 실해
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("서버 실행시 실행된다.");
    }
	
}
