package es.dgoj.rgiaj.taglib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.tags.form.SelectTag;
import org.springframework.web.servlet.tags.form.TagWriter;

import com.dgoj.sprmvc.context.EnumMessageSource;
import com.jeveris.core.utils.ApplicationContextProvider;

/**
 * (es) Extensión del tag select de Spring MVC, con mas la generación
 * de opciones
 * 
 * (en) Extension of Spring MVC select tag, 
 * 
 * @author fmontoya
 *
 */
public class SelectOptionsTag extends SelectTag {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(SelectOptionsTag.class);
	
	/**
	 * Clase del enum que se quiere desplegar
	 */
	private String enumClass;
	
	/**
	 * 
	 */
	private String firstOptionValue = "";

	/**
	 * 
	 */
	private String firstOptionText;
	
	public String getEnumClass() {
		return enumClass;
	}

	public void setEnumClass(String enumClass) {
		this.enumClass = enumClass;
	}

	public String getFirstOptionValue() {
		return firstOptionValue;
	}

	public void setFirstOptionValue(String firstOptionValue) {
		this.firstOptionValue = firstOptionValue;
	}

	public String getFirstOptionText() {
		return firstOptionText;
	}

	public void setFirstOptionText(String firstOptionText) {
		this.firstOptionText = firstOptionText;
	}

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		
		if (enumClass != null) {
			generateEnumItems();
		}
		
		return super.writeTagContent(tagWriter);
	}
	
	private void generateEnumItems() throws JspException {
		
		Class<?> clazz;
		try {
			clazz = Class.forName(enumClass);
		} catch (ClassNotFoundException e) {
			throw new JspException("No se encontro la clase de enum " + enumClass);
		}

		if (!clazz.isEnum()) {
			throw new JspException("La clase " + enumClass + " no es un enum");
		}

		//Class is an enum
		@SuppressWarnings("unchecked")
		Class<Enum<?>> enumClazz = (Class<Enum<?>>) clazz;
		
		Enum<?>[] enumValues = enumClazz.getEnumConstants();

		EnumMessageSource enumMessageSource = null;
		if (ApplicationContextProvider.getBean("enumMessageSource")!=null) {
			enumMessageSource = (EnumMessageSource) ApplicationContextProvider.getBean("enumMessageSource");
		} else {
			logger.warn("missing 'enumMessageSource' Spring bean. Enum values can't be translated");
		}
		
		List<SelectBean> items = new ArrayList<SelectBean>();
		if (firstOptionText != null && firstOptionText.trim().length() > 0) {
			items.add(new SelectBean(firstOptionText, firstOptionValue));
		}
		
		for (int i = 0; i < enumValues.length; i++) {
			Enum<?> element = enumValues[i];

			//By default, the value name is used
			String message = element.name();
		          
			// Searches the i18n value
			if (enumMessageSource != null) {
				message = enumMessageSource.getMessage(element);
			}
			
			items.add(new SelectBean(message, element.name()));
		}
		
		//Attribute names of SelectBean
		super.setItemLabel("text");
		super.setItemValue("value");
		
		setItems(items);

	}
		
	public void setItemLabel(String itemLabel) {
		if (enumClass != null) {
			throw new UnsupportedOperationException("if enumClass is specified, itemLabel and itemText are implicit and must not be assigned");
		}
		super.setItemLabel(itemLabel);
	}
	
	@Override
	public void setItemValue(String itemValue) {
		if (enumClass != null) {
			throw new UnsupportedOperationException("if enumClass is specified, itemLabel and itemText are implicit and must not be assigned");
		}
		super.setItemValue(itemValue);
	}
	
}
