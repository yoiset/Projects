
package es.dgoj.rgiaj;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-12-04T18:32:29.089+01:00
 * Generated source version: 2.7.0
 */

@WebFault(name = "FaultError", targetNamespace = "http://rgiaj.dgoj.es/")
public class Fault extends Exception {
    
    private es.dgoj.rgiaj.FaultError faultError;

    public Fault() {
        super();
    }
    
    public Fault(String message) {
        super(message);
    }
    
    public Fault(String message, Throwable cause) {
        super(message, cause);
    }

    public Fault(String message, es.dgoj.rgiaj.FaultError faultError) {
        super(message);
        this.faultError = faultError;
    }

    public Fault(String message, es.dgoj.rgiaj.FaultError faultError, Throwable cause) {
        super(message, cause);
        this.faultError = faultError;
    }

    public es.dgoj.rgiaj.FaultError getFaultInfo() {
        return this.faultError;
    }
}
