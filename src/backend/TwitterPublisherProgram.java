package backend;

import javax.xml.ws.Endpoint;

//For utility purposes, this publisher publishes two twitter services on two different ports 
//rather than having to have two instances running
public final class TwitterPublisherProgram {
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
			Endpoint.publish("http://localhost:" + port + "/ws/twitter", new TwitterServer());
			Endpoint.publish("http://localhost:" + port2 + "/ws/twitter", new TwitterServer());
		} catch (NumberFormatException e) {
			System.err.println("Invalid port number");
			System.exit(0xC00D132C); // NS_E_CURL_INVALIDPORT
		}
	}
}
