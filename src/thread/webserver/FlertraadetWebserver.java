package thread.webserver;

import java.net.*;
public class FlertraadetWebserver
{
  public static void main(String[] arg)
  {
    try {
      ServerSocket serversocket = new ServerSocket(8001);

      while (true)
      {
        Socket forbindelse = serversocket.accept();
        Anmodning a = new Anmodning(forbindelse);
        a.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}