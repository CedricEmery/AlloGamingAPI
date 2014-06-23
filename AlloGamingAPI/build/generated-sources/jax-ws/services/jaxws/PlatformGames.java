
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PlatformGames", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlatformGames", namespace = "http://services/")
public class PlatformGames {

    @XmlElement(name = "platformName", namespace = "")
    private String platformName;

    /**
     * 
     * @return
     *     returns String
     */
    public String getPlatformName() {
        return this.platformName;
    }

    /**
     * 
     * @param platformName
     *     the value for the platformName property
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

}
