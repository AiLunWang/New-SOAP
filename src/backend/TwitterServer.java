package backend;
import javax.jws.WebService;

@WebService(endpointInterface = "backend.TwitterService")
public final class TwitterServer extends Server implements TwitterService {
	public String getTwitterInfo() {
		return "Twitter Server #" + id + " (" + ++resultsServed + " results served)"; 
	}
}
