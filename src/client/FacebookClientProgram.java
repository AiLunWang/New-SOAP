package client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import backend.FacebookService;
  
public final class FacebookClientProgram{
  
    public static void main (String[] args) {
    	if (args.length != 1)
    	{
    		System.err.println("Must pass port number");
			System.exit(0x80004005); // E_FAIL
    	}
    	
    	try
    	{
    		int port = Integer.parseInt(args[0]);
    		URL url = new URL("http://localhost:" + port + "/ws/facebook?wsdl");
    		QName qname = new QName("http://backend/", "FacebookServerService");
    		Service svc = Service.create(url, qname);
    		FacebookService fbSvc = svc.getPort(FacebookService.class);
    		System.out.println(fbSvc.getFacebookInfo());
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