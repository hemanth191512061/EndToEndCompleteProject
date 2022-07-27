package com.mystore.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.maven.plugin.logging.Log;


public class Loggers {

	
		// TODO Auto-generated method stub
		
		// Initialize Log4j logs
	private static final Logger logs = (Logger) LogManager.getLogger(Loggers.class);

		 public static void startTestCase(String sTestCaseName){    
		   logs.info("====================================="+sTestCaseName+" TEST START=========================================");
		   }
		 
		 public static void endTestCase(String sTestCaseName){
		   
		 logs.info("====================================="+sTestCaseName+" TEST END=========================================");
		   }
		 
		 // Need to create below methods, so that they can be called  

		  public static void info(String message) {

		   logs.info(message);

		   }

		  public static void warn(String message) {

		     logs.warn(message);

		  }

		  public static void error(String message) {

		     logs.error(message);

		  }

		  public static void fatal(String message) {

		     logs.fatal(message);

		  }

		  public static void debug(String message) {

		     logs.debug(message);

		  }
		  
		  public static void trance(String message) {
			     logs.trace(message);

			  }


	}


