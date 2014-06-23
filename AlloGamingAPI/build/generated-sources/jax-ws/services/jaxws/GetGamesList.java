
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetGamesList", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetGamesList", namespace = "http://services/")
public class GetGamesList {

    @XmlElement(name = "gameName", namespace = "")
    private String gameName;

    /**
     * 
     * @return
     *     returns String
     */
    public String getGameName() {
        return this.gameName;
    }

    /**
     * 
     * @param gameName
     *     the value for the gameName property
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

}
