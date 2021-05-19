import java.util.*;
import java.util.Timer; //might not need this
import java.io.*;

//https://www.youtube.com/watch?v=J09TLPgwd0Y
public class Main{
    public static int millisecondsPassed = 0;

    public static void main(String[] args) throws InterruptedException{
      System.out.println(checkAccountBalances("Accounts"));
      startTimer();
    }

    public static String checkAccountBalances(String directory) throws InterruptedException{
      Thread thread0 = new Thread(new MyRunnable("Accounts/Accounts 0.txt"));
      Thread thread1 = new Thread(new MyRunnable("Accounts/Accounts 1.txt"));
      Thread thread2 = new Thread(new MyRunnable("Accounts/Accounts 2.txt"));
      Thread thread3 = new Thread(new MyRunnable("Accounts/Accounts 3.txt"));
      Thread thread4 = new Thread(new MyRunnable("Accounts/Accounts 4.txt"));
      Thread thread5 = new Thread(new MyRunnable("Accounts/Accounts 5.txt"));
      Thread thread6 = new Thread(new MyRunnable("Accounts/Accounts 6.txt"));
      Thread thread7 = new Thread(new MyRunnable("Accounts/Accounts 7.txt"));
      Thread thread8 = new Thread(new MyRunnable("Accounts/Accounts 8.txt"));
      Thread thread9 = new Thread(new MyRunnable("Accounts/Accounts 9.txt"));

      Thread.UncaughtExceptionHandler h = (thread, exception) -> {
          System.out.println(exception.getMessage());
          thread0.interrupt();
          thread1.interrupt();
          thread2.interrupt();
          thread3.interrupt();
          thread4.interrupt();
          thread5.interrupt();
          thread6.interrupt();
          thread7.interrupt();
          thread8.interrupt();
          thread9.interrupt();
      };
      thread0.setUncaughtExceptionHandler(h);
      thread1.setUncaughtExceptionHandler(h);
      thread2.setUncaughtExceptionHandler(h);
      thread3.setUncaughtExceptionHandler(h);
      thread4.setUncaughtExceptionHandler(h);
      thread5.setUncaughtExceptionHandler(h);
      thread6.setUncaughtExceptionHandler(h);
      thread7.setUncaughtExceptionHandler(h);
      thread8.setUncaughtExceptionHandler(h);
      thread9.setUncaughtExceptionHandler(h);

      thread0.start();
      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();
      thread5.start();
      thread6.start();
      thread7.start();
      thread8.start();
      thread9.start();

      return "The largest account has been/will be printed to the console above/below this line. ∠( ᐛ 」∠)＿";
    }

    public static void startTimer(){
      Timer timer = new Timer("timerThread");
      timer.schedule(new TimerTask() {

          @Override
          public void run() {
            millisecondsPassed = millisecondsPassed + 10;
            //System.out.println("milliseconds passed: " + millisecondsPassed);
            if (millisecondsPassed > 650){
                System.out.println ("Time is almost up. Throwing an error to make sure all threads that are still alive (if any) are interrupted.");
                throw new RuntimeException();
            }
          }
      }, 0, 10);
    }

}
