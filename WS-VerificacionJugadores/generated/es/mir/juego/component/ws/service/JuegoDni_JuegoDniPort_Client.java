
package es.mir.juego.component.ws.service;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.2
 * 2013-04-30T18:25:59.303+02:00
 * Generated source version: 2.7.2
 * 
 */
public final class JuegoDni_JuegoDniPort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.ws.component.juego.mir.es/", "juegoDniService");

    private JuegoDni_JuegoDniPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = JuegoDniService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        JuegoDniService ss = new JuegoDniService(wsdlURL, SERVICE_NAME);
        JuegoDni port = ss.getJuegoDniPort();  
        
        {
        System.out.println("Invoking listaDni...");
        es.mir.juego.component.ws.service.ListaDniRequest _listaDni_listaDniRequest = null;
        try {
            es.mir.juego.component.ws.service.ListaDniResponse _listaDni__return = port.listaDni(_listaDni_listaDniRequest);
            System.out.println("listaDni.result=" + _listaDni__return);

        } catch (JuegoDniException_Exception e) { 
            System.out.println("Expected exception: JuegoDniException has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}