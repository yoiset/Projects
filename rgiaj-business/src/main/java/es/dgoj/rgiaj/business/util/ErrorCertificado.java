package es.dgoj.rgiaj.business.util;

/**
 * Esta excepción es lanzada cuando se encuentra un problema en un certificado.
 */
public class ErrorCertificado extends RuntimeException {
	
	static final long serialVersionUID = 1L;

    public ErrorCertificado(Exception cause) {
        super(cause);
    }	

}
