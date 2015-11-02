package gateway;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

import backend.FacebookServer;
import backend.TwitterServer;
   
//Endpoint publisher
public class GatewayProgram {
  
    public static void main(String[] args) throws MalformedURLException {
        Endpoint.publish("http://localhost:9991/ws/hello", new FacebookServer()); //Facebook Service
        Endpoint.publish("http://localhost:9992/ws/hello", new TwitterServer()); //Twitter Service        
    }
}