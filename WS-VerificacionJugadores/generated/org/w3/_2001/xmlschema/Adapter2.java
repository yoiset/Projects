
package org.w3._2001.xmlschema;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter2
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (es.gob.cnjuego.ws.util.DataTypeAdapter.parseDate(value));
    }

    public String marshal(Date value) {
        return (es.gob.cnjuego.ws.util.DataTypeAdapter.printDate(value));
    }

}
