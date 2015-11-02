package client;

import gateway.GatewayLevel;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
  
public class TwitterClientProgram{
  
    public static void main(String[] args) throws Exception {
  
     
  
        //1st argument service URI, refer to wsdl document above
    //2nd argument is service name, refer to wsdl document above
         
        URL url = new URL("http://localhost:9990/ws/hello?wsdl");
         
        QName qname = new QName("http://frontend/", "GatewayImplService");
  
        Service service = Service.create(url, qname);
  
        GatewayLevel hello = service.getPort(GatewayLevel.class);
  
        System.out.println(hello.getFrontendInformation("Twitter"));
  
    }
  
}