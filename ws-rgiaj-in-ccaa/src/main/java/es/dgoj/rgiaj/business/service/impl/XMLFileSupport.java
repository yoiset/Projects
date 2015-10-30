package es.dgoj.rgiaj.business.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import es.dgoj.rgiaj.business.model.JugMunicipio;
import es.dgoj.rgiaj.business.model.JugProhibicion;
import es.dgoj.rgiaj.business.model.JugProvincia;

/** Clase XML de Soporte para generar la lista de Prohibido en Formato XML
 * @author ylopezconnectis
 *
 */
public class XMLFileSupport {
	
	private Logger log= Logger.getLogger(XMLFileSupport.class);
	
	
	private static final String XML_DATE_FORMAT = "yyyy-MM-dd";
	private static final String TEXT_DATE_FORMAT = "dd/MM/yyyy";
	public static final String PROHIBIDOS_XML_FILE = "prohibidos.xml";
	public static final String PROHIBIDOS_TXT_ENCODING = "UTF-8";
	
		
	public final static String PROHIBIDOS_NODE = "Prohibidos";
	public final static String PROHIBICION_NODE = "Prohibicion";
	public final static String SITUACION_NODE = "Situacion";
	public final static String CODE = "codigo";
	public final static String DES = "descripcion";
	public final static String TIPO_PROHIBICION_NODE = "TipoProhibicion";
	public final static String TIPO_DOCUMENTO_NODE = "TipoDocumento";
	public final static String NUM_DOCUMENTO_NODE = "NumDocumento";
	public final static String NOMBRE_NODE = "Nombre";
	public final static String APELLIDO1_NODE = "Apellido1";
	public final static String APELLIDO2_NODE = "Apellido2";
	public final static String FECHA_NACIMIENTO_NODE = "FechaNacimiento";
	public final static String DIRECCION_NODE = "Direccion";
	public final static String DOMICILIO_NODE = "Domicilio";
	public final static String CODIGO_POSTAL_NODE = "CodigoPostal";
	public final static String MUNICIPIO_NODE = "Municipio";
	public final static String PROVINCIA_NODE = "Provincia";
	public final static String FECHA_PROHIBICION_NODE = "FechaProhibicion";
	public final static String FECHA_SITUACION_NODE = "FechaSituacion";
	public final static String CAUSA_PROHIBICION_NODE = "CausaProhibicion";
	public final static String DURACION_NODE = "Duracion";
	public final static String AMBITO_NODE = "Ambito";
	public final static String OBSERVACIONES_NODE = "Observaciones";
	
	
	/** Genera el XML a partir de una lista de Prohibidos recibida y un ZipOutPutStream
	 * @param zipOut
	 * @param prohibiciones
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 */
	public long writeProhibidosXml(ZipOutputStream zipOut, List<JugProhibicion> prohibiciones ) throws IOException, SAXException {
		ZipEntry zipEntry = new ZipEntry(PROHIBIDOS_XML_FILE);
		zipOut.putNextEntry(zipEntry);
		Document document = DocumentFactory.getInstance().createDocument();
		Element rootElement = document.addElement(PROHIBIDOS_NODE);
		XMLWriter writer = new XMLWriter(zipOut, OutputFormat.createPrettyPrint());
		writer.startDocument();
		writer.writeOpen(rootElement);
		writer.setIndentLevel(1);
//		List<Object[]> prohibiciones = createProhibidosQuery(comunidad, tipoDescarga).getResultList();
		long ultimo = 0;
		for (JugProhibicion row : prohibiciones) {
			
			Long idProhibicionEnvio = (Long) row.getIdProhibicionEnvio(); 
			if (ultimo < idProhibicionEnvio) {
				ultimo = idProhibicionEnvio;
			}
			writeProhibicionElement(rootElement, row, writer);
		}
		writer.writeClose(rootElement);
		writer.endDocument();
		writer.flush();
		return ultimo;
	}
	
	/**
	 * @param element
	 * @param row
	 * @param writer
	 * @throws IOException
	 */
	private void writeProhibicionElement(Element element, JugProhibicion row, XMLWriter writer) throws IOException {
		Element prohibicionElement = element.addElement(PROHIBICION_NODE);
		if(row.getJugComunidad()!=null)
		  addTextElement(prohibicionElement, AMBITO_NODE, row.getJugComunidad().getCodigo());
		
		Element situacionElement=prohibicionElement.addElement(SITUACION_NODE);
		if(row.getJugSituacion()!=null){
			addTextElement(situacionElement, CODE, row.getJugSituacion().getCodigo());
			addTextElement(situacionElement, DES, row.getJugSituacion().getDescripcion());		
		}
		
//		addTextElement(prohibicionElement, SITUACION_NODE, row.getJugSituacion().getCodigo());
		if(row.getJugTipoProhibicion()!=null)
		 addTextElement(prohibicionElement, TIPO_PROHIBICION_NODE, row.getJugTipoProhibicion().getCodigo());
		
		Element tipoDocElement=prohibicionElement.addElement(TIPO_DOCUMENTO_NODE);
		if(row.getJugPersona().getJugTipoDocIdent()!=null){
			addTextElement(tipoDocElement, CODE,row.getJugPersona().getJugTipoDocIdent().getId());
			addTextElement(tipoDocElement, DES, row.getJugPersona().getJugTipoDocIdent().getDescripcion());		
		}
		
//		addTextElement(prohibicionElement, TIPO_DOCUMENTO_NODE, row.getJugPersona().getJugTipoDocIdent().getCodigo());
		
		addTextElement(prohibicionElement, NUM_DOCUMENTO_NODE, row.getJugPersona().getNumDocIdent());
		addTextElement(prohibicionElement, NOMBRE_NODE, row.getJugPersona().getNombre());
		addTextElement(prohibicionElement, APELLIDO1_NODE, row.getJugPersona().getApellido1());
		addTextElement(prohibicionElement, APELLIDO2_NODE, row.getJugPersona().getApellido2());
		
		Element direccionElement = prohibicionElement.addElement(DIRECCION_NODE);		
		addTextElement(direccionElement, DOMICILIO_NODE, row.getJugPersona().getDomicilio());
		addTextElement(direccionElement, CODIGO_POSTAL_NODE,  row.getJugPersona().getCodPostal());
		
		JugMunicipio jugMunicipio = (JugMunicipio) row.getJugPersona().getJugMunicipio();
		Element municipioElement = direccionElement.addElement(MUNICIPIO_NODE);
		if (jugMunicipio != null) {
//			addTextElement(direccionElement, MUNICIPIO_NODE, jugMunicipio.getCodigo());
			addTextElement(municipioElement, CODE,jugMunicipio.getCodigo());
			addTextElement(municipioElement, DES, jugMunicipio.getDescripcion());
		} else {
			addTextElement(municipioElement, CODE, null);
			addTextElement(municipioElement, DES, null);
		}
		JugProvincia jugProvincia = (JugProvincia) row.getJugPersona().getJugProvincia();
		if (jugProvincia != null) {
			addTextElement(direccionElement, PROVINCIA_NODE, jugProvincia.getCodigo());
		} else {
			addTextElement(direccionElement, PROVINCIA_NODE, null);
		}
		try {
			addTextElement(prohibicionElement, FECHA_PROHIBICION_NODE, getXmlDateFormat().format((Date)row.getFechaProhibicion()));
		} catch (Exception e) {
			log.error("Error converting date: {0}", e);
			addTextElement(prohibicionElement, FECHA_PROHIBICION_NODE, "");
		}
		try {
			addTextElement(prohibicionElement, FECHA_SITUACION_NODE, row.getFechaSituacion() != null ? getXmlDateFormat().format((Date)row.getFechaSituacion()) : "");
		} catch (Exception e) {
			log.error("Error converting date: {0}", e);
			addTextElement(prohibicionElement, FECHA_SITUACION_NODE, "");
		}
		
		Element causaProhibicionElement = prohibicionElement.addElement(CAUSA_PROHIBICION_NODE);
		if(row.getJugCausaProhibicion()!=null){
			addTextElement(causaProhibicionElement, CODE, row.getJugCausaProhibicion().getCodigo());
			addTextElement(causaProhibicionElement, DES, row.getJugCausaProhibicion().getDescripcion());
		}
		
//		addTextElement(prohibicionElement, CAUSA_PROHIBICION_NODE, row.getJugCausaProhibicion().getCodigo());
		
		
		addTextElement(prohibicionElement, DURACION_NODE, row.getDuracion());
		writer.write(prohibicionElement);
		prohibicionElement.detach();
	}
	
	/**
	 * @param parent
	 * @param nodeName
	 * @param text
	 */
	private void addTextElement(Element parent, String nodeName, Object text) {
		Element element = parent.addElement(nodeName);
		if (text != null) {
			element.setText(text.toString());
		}
	}
	
	/**
	 * @return
	 */
	public SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat(TEXT_DATE_FORMAT);
	}

	/**
	 * @return
	 */
	public SimpleDateFormat getXmlDateFormat() {
		return new SimpleDateFormat(XML_DATE_FORMAT);
	}

}
