package backend;

import javax.jws.WebService;

@WebService(endpointInterface = "backend.FacebookService")
public final class FacebookServer extends Server implements FacebookService {

	@Override
	public String getFacebookInfo() {
		return "Facebook Server #" + id + " (" + ++resultsServed + " results served)"; 
	}
}
