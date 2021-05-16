//https://www.youtube.com/watch?v=J09TLPgwd0Y
public class Main{
    public static void main(String[] args) throws InterruptedException{


      System.out.println(checkAccountBalances("Accounts"));


    	//thread1.setDaemon(true); //this will make the threads stop when main runs into an exception (like dividing 1 by 0) but will not println
    //	thread2.setDaemon(true);
    	//thread1.join(2000); //calling thread (ex.main) waits until the specified thread dies or for 2000 milliseconds
    //	thread2.start();

    	//System.out.println(1/0);


    }

    public static String checkAccountBalances(String directory) throws InterruptedException{
      Thread thread0 = new Thread(new MyRunnable(directory + "/Accounts 0.txt"));
      thread0.start();
      Thread thread1 = new Thread(new MyRunnable(directory + "/Accounts 1.txt"));
      thread1.start();
      Thread thread2 = new Thread(new MyRunnable(directory + "/Accounts 2.txt"));
      thread2.start();
      Thread thread3 = new Thread(new MyRunnable(directory + "/Accounts 3.txt"));
      thread3.start();
      Thread thread4 = new Thread(new MyRunnable(directory + "/Accounts 4.txt"));
      thread4.start();
      Thread thread5 = new Thread(new MyRunnable(directory + "/Accounts 5.txt"));
      thread5.start();
      Thread thread6 = new Thread(new MyRunnable(directory + "/Accounts 6.txt"));
      thread6.start();
      Thread thread7 = new Thread(new MyRunnable(directory + "/Accounts 7.txt"));
      thread7.start();
      Thread thread8 = new Thread(new MyRunnable(directory + "/Accounts 8.txt"));
      thread8.start();
      Thread thread9 = new Thread(new MyRunnable(directory + "/Accounts 9.txt"));
      thread9.start();

      //Below forces thread10 to wait for all the others to end before picking out the final account
      Thread[] threads = {thread0, thread1, thread2, thread3, thread4, thread5, thread6, thread7, thread8, thread9};
      for (Thread thread : threads){
        try{
          thread.join();
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      /*for (int i = 0; i < 10; i++){
        System.out.println ("Should be false: " + threads[i].isAlive());
      }*/

      return "Done";
    }

}
