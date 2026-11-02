package thread.w3s;

public class Main extends Thread {
  public static int amount = 0;

  public static void main(String[] args) throws InterruptedException {
    Main thread = new Main();
    thread.start();
    System.out.println(amount);
    amount++;
    thread.join();
    System.out.println(amount);
  }

  public void run() {
    amount++;
  }
}