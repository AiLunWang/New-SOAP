package backend;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "backend.FacebookService")
public final class GatewayServer extends Server implements GatewayService {

	@Override
	public String getFacebookInfo() {
		// pick a Facebook Server
		// make a SOAP request to it
		// return the result
		return "";
	}

	@Override
	public String getTwitterInfo() {
		// pick a Twitter Server
		// make a SOAP request to it
		// return the result
		return "";
	}
}
