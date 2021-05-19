//https://stackoverflow.com/questions/877096/how-can-i-pass-a-parameter-to-a-java-thread

import java.util.*;
import java.io.*;


public class MyRunnable implements Runnable {
  public String directory;
  public volatile static String biggest = "1\t\t0.00";
  public volatile static int numDone = 0;
  public volatile static String biggestPlace = "somewhere";

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

    if (getValue(topAccount) > getValue(biggest)){ //checking if the biggest account in this thread's file is greater than the biggest found so far
      biggest = topAccount;
      biggestPlace = directory;
    }
    numDone++;
    if (numDone == 10){ //if this is the last thread alive, print the biggest account
      System.out.println ("Account with the greatest balance: " + biggest);
      System.out.println ("This account can be found in in: " + biggestPlace);
    }
 	}

 	public double getValue(String lineOfText){
 		String strVal = lineOfText.substring(lineOfText.indexOf("\t")+2); //chops lineOfText so now just the number remains
 		double value = Double.parseDouble(strVal);
 		return value;
 	}
}
