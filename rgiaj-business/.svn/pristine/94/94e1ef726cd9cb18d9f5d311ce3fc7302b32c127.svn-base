package es.dgoj.rgiaj.business.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.jeveris.core.exception.impl.CoreException;
import com.jeveris.core.reporting.ReportFactoryBean;
import com.jeveris.core.reporting.controllers.BusinessReportingControllerHolder;
import com.jeveris.core.reporting.controllers.BusinessReportingControllerImpl;

/**
 * @author dgonzalezconnectis
 *
 */
public final class UtilBusiness {

	private UtilBusiness() {
		super();
	}
	
	/* Prepara el informe PDF a devolver a la capa web.
	 * @author dgonzalezconnectis 
	 */
	static public byte[] preparaInformePDF(ReportFactoryBean reportListDatasourceRunner, String reportType, String reportName, String reportTitle){
		byte[] reportBytes =  null;
		
		Map<String, String> reportInputParameters = new HashMap<String, String>();
		reportInputParameters.put("system_REPORT_RESOURCE", reportName);
		reportInputParameters.put("system_REPORT_FORMAT", reportType);
		reportInputParameters.put("report_Titulo", reportTitle);
		
		try {
			String path = new ClassPathResource(".").getFile().getCanonicalPath() + File.separator + "report" + File.separator;
			reportInputParameters.put(BusinessReportingControllerImpl.REPORT_PATH_PARAMETER_NAME, path);
		} catch (IOException e) {
			throw new CoreException(e, "");
		}

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		BusinessReportingControllerHolder.setCurrentReportInputParameters(reportInputParameters);
		BusinessReportingControllerHolder.setCurrentReportOutputStream(buffer);
		try {
			// Generate export
			reportListDatasourceRunner.getObject().run();
		} catch (Exception e) {
			throw new CoreException(e, e.getCause().getMessage());
		}
		
		reportBytes = buffer.toByteArray();
					
		// remove parameters
		BusinessReportingControllerHolder.removeCurrentReportInputParameters();
		BusinessReportingControllerHolder.removeCurrentReportOutputStream();
		
		return reportBytes;
		
	}

}
