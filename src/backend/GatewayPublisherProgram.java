package backend;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public final class GatewayPublisherProgram{
  
    public static void main(String[] args) throws MalformedURLException {
		if (args.length != 5)
		{
			System.err.println("Must pass port numbers");
			System.exit(0x80004005); // E_FAIL
		}
		
		try
		{
			int twPort = Integer.parseInt(args[0]);
			int twPort2 = Integer.parseInt(args[1]);
			int fbPort = Integer.parseInt(args[2]);
			int fbPort2 = Integer.parseInt(args[3]);
			int gPort = Integer.parseInt(args[4]);
			Endpoint.publish("http://localhost:" + gPort + "/ws/gateway", new GatewayServer(new int[]{twPort, twPort2}, new int[]{fbPort, fbPort2}));
		} catch (NumberFormatException e) {
			System.err.println("Invalid port number");
			System.exit(0xC00D132C); // NS_E_CURL_INVALIDPORT
		}
	}
}