
package es.redsara.intermediacion.scsp.esquemas.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.2
 * 2013-06-18T10:07:45.186+02:00
 * Generated source version: 2.7.2
 */

@WebFault(name = "fault", targetNamespace = "http://intermediacion.redsara.es/scsp/esquemas/ws/fault")
public class FaultMessage extends Exception {
    
    private es.redsara.intermediacion.scsp.esquemas.ws.fault.Fault fault;

    public FaultMessage() {
        super();
    }
    
    public FaultMessage(String message) {
        super(message);
    }
    
    public FaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public FaultMessage(String message, es.redsara.intermediacion.scsp.esquemas.ws.fault.Fault fault) {
        super(message);
        this.fault = fault;
    }

    public FaultMessage(String message, es.redsara.intermediacion.scsp.esquemas.ws.fault.Fault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public es.redsara.intermediacion.scsp.esquemas.ws.fault.Fault getFaultInfo() {
        return this.fault;
    }
}
