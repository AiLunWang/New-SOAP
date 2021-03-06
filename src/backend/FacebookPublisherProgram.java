package backend;

import javax.xml.ws.Endpoint;

//For utility purposes, this publisher publishes two facebook services on two different ports 
//rather than having to have two instances running
public final class FacebookPublisherProgram {
	public static void main(String[] args) {
		if (args.length != 2)
		{
			System.err.println("Must pass port numbers");
			System.exit(0x80004005); // E_FAIL
		}
		
		try
		{
			int port = Integer.parseInt(args[0]);
			int port2 = Integer.parseInt(args[1]);
			Endpoint.publish("http://localhost:" + port + "/ws/facebook", new FacebookServer());
			Endpoint.publish("http://localhost:" + port2 + "/ws/facebook", new FacebookServer());
		} catch (NumberFormatException e) {
			System.err.println("Invalid port number");
			System.exit(0xC00D132C); // NS_E_CURL_INVALIDPORT
		}
	}
}
