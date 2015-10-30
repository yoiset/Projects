package es.dgoj.rgiaj.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Configurable;


import es.dgoj.rgiaj.business.beans.JugProhibicionBean;
import es.dgoj.rgiaj.business.beans.type.FormatoDescargaProhibidos;
import es.dgoj.rgiaj.business.beans.type.TipoDescargaProhibidos;

@Configurable
public class JugProhibidosForm {
	
	private String fileFormat="TXT";
	private String downloadType="Incremental";
	
	private boolean enableConfirm;
	private boolean pendingConfirm;
	
	private boolean selectDesde;
	private String puntual;
	
	private int countReg=10;
	
	private List<String> listUltimasDescargas;
	
		
	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getDownloadType() {
		return downloadType;
	}

	public void setDownloadType(String downloadType) {
		this.downloadType = downloadType;
	}
	
	/** retorna el tipo de descarga
	 * @return
	 */
	public TipoDescargaProhibidos getTipoDescarga(){
		
	    TipoDescargaProhibidos tipoDescarga=TipoDescargaProhibidos.Incremental;
	    
	    if(TipoDescargaProhibidos.Completa.toString().equalsIgnoreCase(downloadType))
	      return TipoDescargaProhibidos.Completa;
	   	    
	    return tipoDescarga;
		
	}
	
	
	/** retorna el formato de descarga
	 * @return
	 */
	public FormatoDescargaProhibidos getFormatoDescarga(){
		FormatoDescargaProhibidos formatoDescarga= FormatoDescargaProhibidos.Texto;
	    if(FormatoDescargaProhibidos.XML.toString().equalsIgnoreCase(fileFormat))
	    	return FormatoDescargaProhibidos.XML;
	  
	    if(FormatoDescargaProhibidos.Ambos.toString().equalsIgnoreCase(fileFormat))
	    	return FormatoDescargaProhibidos.Ambos;
	    
	    return formatoDescarga;
	}

	public boolean isEnableConfirm() {
		return enableConfirm;
	}

	public void setEnableConfirm(boolean enableConfirm) {
		this.enableConfirm = enableConfirm;
	}

	public boolean isPendingConfirm() {
		return pendingConfirm;
	}

	public void setPendingConfirm(boolean pendingConfirm) {
		this.pendingConfirm = pendingConfirm;
	}

	public List<String> getListUltimasDescargas() {
		return listUltimasDescargas;
	}

	public void setListUltimasDescargas(List<String> listUltimasDescargas) {
		this.listUltimasDescargas = listUltimasDescargas;
	}
	
	/** Rellena la lista de ultimas descargas. Numero; fecha
	 * @param list
	 */
	public void fillUltimasDescargas(List<JugProhibicionBean> list){
		this.listUltimasDescargas=new ArrayList<String>();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		if(list!=null)
			for (JugProhibicionBean bean : list) {				
				String date= formatDate.format(bean.getFechaDescarga());
				this.listUltimasDescargas.add(bean.getUltimo().toString() + " | " +  date);
			}
	}

	public boolean isSelectDesde() {
		return selectDesde;
	}

	public void setSelectDesde(boolean selectDesde) {
		this.selectDesde = selectDesde;
	}

	public String getPuntual() {
		return puntual;
	}

	public void setPuntual(String puntual) {
		this.puntual = puntual;
	}
	
	public long getLast(){
		if(TipoDescargaProhibidos.Incremental.equals(getTipoDescarga()))
			if(selectDesde){
				StringTokenizer toke= new StringTokenizer(puntual,"|");
				String value= toke.nextToken();
				return Long.parseLong(value.trim());
			}
		return 0;
	}
	
	public Date getDesde() throws ParseException{
		if(TipoDescargaProhibidos.Incremental.equals(getTipoDescarga()))
			if(selectDesde){
				SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy hh:mm");
				StringTokenizer toke= new StringTokenizer(puntual,"|");
				toke.nextToken();
				String date=toke.nextToken();
				return format.parse(date.trim());
			}
		
		return null;
	}

	public int getCountReg() {
		return countReg;
	}

	public void setCountReg(int countReg) {
		this.countReg = countReg;
	}

	
	
	
}
