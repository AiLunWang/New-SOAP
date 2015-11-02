package backend;

import javax.xml.ws.Endpoint;

public final class FacebookPublisherProgram {
	public static void main(String[] args) {
		if (args.length != 1)
		{
			System.err.println("Must pass port number");
			System.exit(0x80004005); // E_FAIL
		}
		
		try
		{
			int port = Integer.parseInt(args[0]);
			Endpoint.publish("http://localhost:" + port + "/ws/facebook", new FacebookServer());
		} catch (NumberFormatException e) {
			System.err.println("Invalid port number");
			System.exit(0x80070057); // E_INVALIDARG
		}
	}
}
