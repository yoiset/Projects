package es.dgoj.rgiaj.business.service.impl;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

import es.dgoj.rgiaj.business.model.JugMunicipio;
import es.dgoj.rgiaj.business.model.JugProhibicion;
import es.dgoj.rgiaj.business.model.JugProvincia;

/**Clase TXT de Soporte para generar la lista de Prohibido en Formato TXT
 * @author ylopezconnectis
 *
 */
public class TextFileSupport {
	
	private static final String TEXT_DATE_FORMAT = "dd/MM/yyyy";
	public static final String PROHIBIDOS_TXT_FILE = "prohibidos.txt";
	public static final String PROHIBIDOS_TXT_ENCODING = "UTF-8";
	
	public final static String EMPTY_MARKER="-";
	public final static String SEPARATOR_MARKER="|";
	
	
	private Logger log= Logger.getLogger(TextFileSupport.class);
	
	/**Genera el TXT a partir de una lista de Prohibidos recibida y un ZipOutPutStream
	 * @param zipOut
	 * @param prohibiciones
	 * @return
	 * @throws IOException
	 */
	public long writeProhibidosTexto(ZipOutputStream zipOut,List<JugProhibicion> prohibiciones ) throws IOException {
		ZipEntry zipEntry = new ZipEntry(PROHIBIDOS_TXT_FILE);
		long ultimo = 0;
		try {
			zipOut.putNextEntry(zipEntry);
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(zipOut, PROHIBIDOS_TXT_ENCODING));
			for (JugProhibicion row : prohibiciones) {
				Long idProhibicionEnvio = (Long) row.getIdProhibicionEnvio(); 
				if (ultimo < idProhibicionEnvio) {
					ultimo = idProhibicionEnvio;
				}
				if(row.getJugPersona()==null) continue;
				
				if(row.getJugPersona().getJugTipoDocIdent()!=null)
				 printValue(printWriter, row.getJugPersona().getJugTipoDocIdent().getId());
				else  printValue(printWriter, null);
				printWriter.print(SEPARATOR_MARKER);
				printValue(printWriter, row.getJugPersona().getNumDocIdent());
				printWriter.print(SEPARATOR_MARKER);
				printValue(printWriter, row.getJugPersona().getApellido1());
				printWriter.print(SEPARATOR_MARKER);
				printValue(printWriter, row.getJugPersona().getApellido2());
				printWriter.print(SEPARATOR_MARKER);
				printValue(printWriter, row.getJugPersona().getNombre());
				printWriter.print(SEPARATOR_MARKER);
				printValue(printWriter, row.getJugPersona().getDomicilio());
				printWriter.print(SEPARATOR_MARKER);
				printValue(printWriter, row.getJugPersona().getCodPostal());
				printWriter.print(SEPARATOR_MARKER);
				if (row.getJugPersona().getJugMunicipio() != null) {
					printValue(printWriter, ((JugMunicipio)row.getJugPersona().getJugMunicipio()).getCodigo());
				} else {
					printWriter.print(EMPTY_MARKER);
				}
				printWriter.print(SEPARATOR_MARKER);
				if (row.getJugPersona().getJugProvincia() != null) {
					printValue(printWriter, ((JugProvincia)row.getJugPersona().getJugProvincia()).getCodigo());
				} else {
					printWriter.print(EMPTY_MARKER);
				}
				printWriter.print(SEPARATOR_MARKER);
				//printValue(printWriter, row[3]);
				printValue(printWriter, 'R');
				printWriter.print(SEPARATOR_MARKER);
				printDate(printWriter, (Date)row.getFechaProhibicion());
				printWriter.print(SEPARATOR_MARKER);
				printDate(printWriter, (Date)row.getFechaSituacion());
				printWriter.print(SEPARATOR_MARKER);
				if(row.getJugCausaProhibicion()!=null)
				 printValue(printWriter, Integer.valueOf((String)row.getJugCausaProhibicion().getCodigo()));
				else  printValue(printWriter, null);
				printWriter.print(SEPARATOR_MARKER);
				printValue(printWriter, row.getDuracion());
				printWriter.print(SEPARATOR_MARKER);
				if(row.getJugComunidad()!=null)
				 printValue(printWriter, row.getJugComunidad().getCodigo());
				else  printValue(printWriter, null);
				printWriter.print(SEPARATOR_MARKER);
				if(row.getJugSituacion()!=null)
				 printValue(printWriter, row.getJugSituacion().getCodigo());
				else printValue(printWriter, null);
				printWriter.println();
			}
			printWriter.flush();
		} catch (Exception e) {
			log.error("Error intenando crear el Fuchero Text");
			
		}
		
		return ultimo;
	}
	
	/**
	 * @param printWriter
	 * @param value
	 */
	private void printValue(PrintWriter printWriter, Object value) {
		if (value == null) {
			printWriter.print(EMPTY_MARKER);
		} else {
			printWriter.print(value);
		}
	}
	
	/**
	 * @param printWriter
	 * @param date
	 */
	private void printDate (PrintWriter printWriter, Date date) {
		try {
			if (date != null) {
				printWriter.print(getDateFormat().format(date));
				return;
			} 
		} catch(Exception e) {
			log.error("Error converting date: {0}", e);
		}
		printValue(printWriter, null);
	}
	
	/**
	 * @return
	 */
	public SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat(TEXT_DATE_FORMAT);
	}

	

}
