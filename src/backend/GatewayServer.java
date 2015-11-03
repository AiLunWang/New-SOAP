package backend;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

@WebService(endpointInterface = "backend.GatewayService")
public final class GatewayServer extends Server implements GatewayService {

	int[] twitterPorts;
	int[] facebookPorts;
	Random rand;
	
	public GatewayServer (int[] twitter, int[] facebook) {
		twitterPorts = twitter;
		facebookPorts = facebook;
		rand = new Random();
	}
	
	@Override
	public String getFacebookInfo() {
		System.out.println(facebookPorts[0] + ", " + facebookPorts[1]);
		int chosenPort = facebookPorts[rand.nextInt(facebookPorts.length)];
		System.out.println(chosenPort);
		URL url;
		try
		{
			url = new URL("http://localhost:" + chosenPort + "/ws/facebook?wsdl");
		}
		catch (MalformedURLException e)
		{
			return "Info could not be found.";
		}
		QName qname = new QName("http://backend/", "FacebookServerService");
		Service svc = Service.create(url, qname);
		FacebookService fbSvc = svc.getPort(FacebookService.class);
		return fbSvc.getFacebookInfo();
	}

	@Override
	public String getTwitterInfo() {
		int chosenPort = twitterPorts[new Random().nextInt(twitterPorts.length)];
		URL url;
		try
		{
			url = new URL("http://localhost:" + chosenPort + "/ws/twitter?wsdl");
		}
		catch (MalformedURLException e)
		{
			return "Info could not be found.";
		}
		QName qname = new QName("http://backend/", "TwitterServerService");
		Service svc = Service.create(url, qname);
		TwitterService twSvc = svc.getPort(TwitterService.class);
		return twSvc.getTwitterInfo();
	}
}
