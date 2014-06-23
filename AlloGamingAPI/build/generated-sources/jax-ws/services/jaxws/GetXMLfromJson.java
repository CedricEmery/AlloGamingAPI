
package services.jaxws;

import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getXMLfromJson", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getXMLfromJson", namespace = "http://services/")
public class GetXMLfromJson {

    @XmlElement(name = "arg0", namespace = "")
    private URL arg0;

    /**
     * 
     * @return
     *     returns URL
     */
    public URL getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(URL arg0) {
        this.arg0 = arg0;
    }

}
