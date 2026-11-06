package thread;

public class ThreadSyncExample {
  public static void main(String[] args) {
//    Table table=new Table();
//    MyThread t1=new MyThread(table, 10);
//    MyThread t2=new MyThread(table, 9);
    MyThread t1=new MyThread(new Table(), 10);
    MyThread t2=new MyThread(new Table(), 9);
    t1.start();
    t2.start();
  }
}

class Table {
  static synchronized void printTable(int n){
    for (int i=1; i<=n; i++){
      System.out.println(i+"*"+n+" = "+i*n);
    }
  }
}

class MyThread extends Thread {
  Table table;
  int n;
  MyThread(Table table, int n){
    this.table=table;
    this.n=n;
  }

  public void run(){
    table.printTable(n);
  }
}
