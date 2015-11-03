package client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import backend.GatewayService;

public final class GatewayClientProgram {
	 public static void main (String[] args) {
	    	if (args.length != 1)
	    	{
	    		System.err.println("Must pass port number");
				System.exit(0x80004005); // E_FAIL
	    	}
	    	
	    	try
	    	{
	    		int port = Integer.parseInt(args[0]);
	    		URL url = new URL("http://localhost:" + port + "/ws/gateway?wsdl");
	    		QName qname = new QName("http://backend/", "GatewayServerService");
	    		Service svc = Service.create(url, qname);
	    		GatewayService gSvc = svc.getPort(GatewayService.class);
	    		System.out.println(gSvc.getFacebookInfo());
	    		System.out.println(gSvc.getTwitterInfo());
	    	}
	    	catch (NumberFormatException e)
	    	{
	    		System.err.println("Invalid port number");
	    		System.exit(0xC00D132C); // NS_E_CURL_INVALIDPORT
	    	}
	    	catch (MalformedURLException e)
	    	{
				System.err.println("Malformed URL");
				System.exit(0xC00D1329); // NS_E_CURL_INVALIDARG
			}
	    }  

}
