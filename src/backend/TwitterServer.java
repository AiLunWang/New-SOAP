package backend;
import javax.jws.WebService;

@WebService(endpointInterface = "backend.TwitterService")
public final class TwitterServer implements TwitterService {
	public String getTwitterInfo() {
		return "Facebook Server #" + id + " (" + ++resultsServed + " results served)"; 
	}
}
