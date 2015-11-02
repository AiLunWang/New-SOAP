/*What was ServiceLevel supposed to be?*/
package gateway;

import java.net.MalformedURLException;
import java.net.URL;
 
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
 
import backend.Server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.xml.internal.ws.developer.JAXWSProperties;
 
  
//Service Implementation
@WebService(endpointInterface = "frontend.GatewayLevel")
public class GatewayImplement<HttpServletRequest> implements GatewayLevel{
     
    int resultsServed;
     
    public GatewayImplement() throws MalformedURLException {
        resultsServed = 0;
    }
     @Resource
      WebServiceContext wsContext; 
 
      /**
       * Web service operation
       */
    @WebMethod
    @Override
    public String getFrontendInformation(String passedService) throws MalformedURLException {
         
 
        MessageContext msgx = wsContext.getMessageContext();
        HttpExchange exchange = (HttpExchange)msgx.get(JAXWSProperties.HTTP_EXCHANGE);
        System.out.println("Client IP: " + exchange.getRemoteAddress().getAddress()
                + ". Client Port: " + exchange.getRemoteAddress().getPort()
                + ". Total results served: " + ++resultsServed);
         
        if (passedService.equals("Facebook")) {
            QName qname = new QName("http://intermediate/", "ServiceImplService");
            URL url = new URL("http://localhost:9991/ws/hello?wsdl");
            Service service = Service.create(url, qname);
            ServiceLevel hello = service.getPort(ServiceLevel.class);
 
 
 
            return hello.getIntermediateInformation();
        }
        else if (passedService.equals("Twitter")) {
            QName qname = new QName("http://intermediate/", "ServiceImplService");
            URL url = new URL("http://localhost:9992/ws/hello?wsdl");
            Service service = Service.create(url, qname);
            ServiceLevel hello = service.getPort(ServiceLevel.class);
            return hello.getIntermediateInformation();
        }
        else
            return "Error, invalid request";
    } 
}