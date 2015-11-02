package gateway;

import java.net.MalformedURLException;
import java.net.URL;
 
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
 
import backend.Server;
 
public class LoadBalancer {
     
    private URL url;
    Service service;
    ServerLevel hello;
    QName qname;
    private boolean toggleServer;
    int port1;
    int port2;
     
    public LoadBalancer(String passedServiceName) throws MalformedURLException {
        url = null;
        qname = new QName("http://backend/", "ServerImplService");
        toggleServer = true;
        if (passedServiceName.equals("Facebook")) {
            port1 = 9993;
            port2 = 9994;
        }
        else if (passedServiceName.equals("Twitter")) {
            port1 = 9995;
            port2 = 9996;
        }        
    }
     
    public ServerLevel getNextServer () throws MalformedURLException {
        if (toggleServer)
            url = new URL("http://localhost:" + port1 + "/ws/hello?wsdl");
        else
            url = new URL("http://localhost:" + port2 + "/ws/hello?wsdl");
        toggleServer = !toggleServer;
         
         
        Service service = Service.create(url, qname);
        ServerLevel hello = service.getPort(ServerLevel.class);
         
        return hello;                         
    }
}