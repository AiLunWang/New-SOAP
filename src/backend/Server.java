package backend;

public class Server {
   
  protected static int id;
  int resultsServed;

  static
  {
	  id = 0; //WHY IS THIS COUNT STATIC!!! THIS IS THE CAUSE OF THE ERROR. BOTH SERVERS THINK THEY ARE NUMBER TWO.
  }
  
  public Server() {
      resultsServed = 0;
      id++;
  } 
}