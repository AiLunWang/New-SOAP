package backend;

public class Server {
   
  protected static int id;
  int resultsServed;

  static
  {
	  id = 0;
  }
  
  public Server() {
      resultsServed = 0;
      id++;
  } 
}