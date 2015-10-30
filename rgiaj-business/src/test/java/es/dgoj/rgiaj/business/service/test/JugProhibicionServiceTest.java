package es.dgoj.rgiaj.business.service.test;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import es.dgoj.rgiaj.business.beans.JugProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.type.FormatoDescargaProhibidos;
import es.dgoj.rgiaj.business.beans.type.TipoDescargaProhibidos;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.service.IJugProhibicionServ;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/spring/integration-core-config.xml",
		"classpath:/spring/app-custom-persistence-hibernate.xml", 
		"classpath:/spring/app-custom-performance.xml",
		"classpath:/spring/app-test-persistence-hibernate.xml"})
public class JugProhibicionServiceTest {
	
	@Resource
	private IJugProhibicionServ JugProhibicionService;
	
	@Test
	public void testGetFileJugProhibicionXML() throws JuegoExternoException{
		
		
		JugProhibicionQueryBean query= new JugProhibicionQueryBean("NAC",FormatoDescargaProhibidos.XML,TipoDescargaProhibidos.Completa, null, null);
	    byte []	flow= JugProhibicionService.getProhibidosList(query);
	    
	    assertNotNull(flow);	    
       try {
			FileOutputStream outFile=new FileOutputStream(new File("c:/documentospro/prohibidos-xml.zip"));
			ZipOutputStream zip= new ZipOutputStream(outFile);
			outFile.write(flow);
			outFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	}
	
	
	@Test
	public void testGetFileJugProhibicionTXT() throws JuegoExternoException{
		
		
		JugProhibicionQueryBean query= new JugProhibicionQueryBean("NAC",FormatoDescargaProhibidos.Texto,TipoDescargaProhibidos.Completa, null,null);
	    byte []	flow= JugProhibicionService.getProhibidosList(query);
	    
	    assertNotNull(flow);	    
       try {
			FileOutputStream outFile=new FileOutputStream(new File("c:/documentospro/prohibidos-txt.zip"));
			ZipOutputStream zip= new ZipOutputStream(outFile);
			outFile.write(flow);
			outFile.flush();
			outFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	}

}
