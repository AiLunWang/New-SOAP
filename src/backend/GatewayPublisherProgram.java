package backend;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public final class GatewayPublisherProgram{
  
    public static void main(String[] args) throws MalformedURLException {
		if (args.length != 1)
		{
			System.err.println("Must pass port number");
			System.exit(0x80004005); // E_FAIL
		}
		
		try
		{
			int port = Integer.parseInt(args[0]);
			Endpoint.publish("http://localhost:" + port + "/ws/gateway", new GatewayServer());
		} catch (NumberFormatException e) {
			System.err.println("Invalid port number");
			System.exit(0x80070057); // E_INVALIDARG
		}
	}
}