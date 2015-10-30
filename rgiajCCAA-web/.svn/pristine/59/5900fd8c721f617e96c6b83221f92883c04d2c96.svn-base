package es.dgoj.rgiaj.taglib;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.InputTag;
import org.springframework.web.servlet.tags.form.TagWriter;

import com.dgoj.sprmvc.web.util.TagUtils;

/**
 * Extensi&oacute;n del input tag de Spring MVC que muestra un calendario
 * @author fmontoya
 *
 */
public class CalendarTextTag extends InputTag {

	private static final long serialVersionUID = 1L;
	
	private static final String align = "Tl";
	private static final boolean singleClick = true;
	
	private static final String DEFAULT_BUTTON_STYLE = "calendar_button";
	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	
	
	public String buttonStyleClass = DEFAULT_BUTTON_STYLE;

	private String TRIGGER_NAME = "f_trigger_";

//	private String format = "%d/%m/%Y";
	private String format = DEFAULT_DATE_FORMAT;
	
	
	public CalendarTextTag() {
		super();
	}
	
	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		super.writeTagContent(tagWriter);

		TagUtils.write(pageContext, calendarButtonHtml());
		
		return SKIP_BODY;
	}
	
	
	public String calendarButtonHtml() throws JspException {
		
		StringBuilder sb = new StringBuilder(600);
		
		String triggerName = TRIGGER_NAME + resolveId();
		
        sb.append("<input type=\"button\" class=\"" + buttonStyleClass + "\" id=\"" + triggerName + "\">\n");
		if (!isReadonly() && !isDisabled()) {
	        sb.append("<script type=\"text/javascript\">\n");
			sb.append("    Calendar.setup({\n");
			sb.append("        inputField     :    \"").append(resolveId()).append("\",  // id of the input field\n");
			sb.append("        ifFormat       :    \"").append(translateFormat()).append("\",        // format of the input field\n");
			sb.append("        button         :    \"").append(triggerName).append("\",     // trigger for the calendar (button ID)\n");
			sb.append("        align          :    \"").append(align).append("\",              // alignment (defaults to \"Bl\")\n");
			sb.append("        singleClick    :    ").append(singleClick).append(",");
			sb.append("        electric       :    false\n");
			sb.append("    });\n");
			sb.append("</script>\n");
		}

		return sb.toString();
		
	}

	private String translateFormat() {
		String result = format;
		
		result = result.replace("dd", "%d");
		result = result.replace("MM", "%m");
		result = result.replace("yyyy", "%Y");
		
		return result;
	}
	
	@Override
	public int doEndTag() throws JspException {
		int result = super.doEndTag();
		this.buttonStyleClass = DEFAULT_BUTTON_STYLE;
		this.format = DEFAULT_DATE_FORMAT;
		return result;
	}
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getButtonStyleClass() {
		return buttonStyleClass;
	}

	public void setButtonStyleClass(String buttonStyleClass) {
		this.buttonStyleClass = buttonStyleClass;
	}

	
}
