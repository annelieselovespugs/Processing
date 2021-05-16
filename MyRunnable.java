//https://stackoverflow.com/questions/877096/how-can-i-pass-a-parameter-to-a-java-thread

import java.util.*;
import java.io.*;


public class MyRunnable implements Runnable {
  public String directory;
  //public volatile String biggest = "1\t\t0.00";

  public MyRunnable(String dir) {
    directory = dir;
  }

   @Override
   public void run() {
  	//System.out.println("Starting");
    findLargest(directory);
    }

   public void findLargest(String directory){
 		String topAccount = "1\t\t0.00"; //account #, two tabs, value with two decimal places
 	  String currentAccount = "";
 	  try {
 	    File accountFile = new File (directory);
 	    Scanner accountScanner = new Scanner (accountFile);
 	    while (accountScanner.hasNextLine())
 	    {
 	      currentAccount = accountScanner.nextLine();
 	      if (getValue(topAccount) < getValue(currentAccount)){
 	        topAccount = currentAccount;
 	      }
 	    }
 	  }
 	  catch (Exception exe) {
 	    System.out.println ("Uh oh: " + exe);
 	  }

    System.out.println (topAccount);
 	}

 	public double getValue(String lineOfText){
 		String strVal = lineOfText.substring(lineOfText.indexOf("\t")+2); //chops lineOfText so now just the number remains
 		double value = Double.parseDouble(strVal);
 		return value;
 	}
}
