
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetArt", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetArt", namespace = "http://services/")
public class GetArt {

    @XmlElement(name = "artId", namespace = "")
    private long artId;

    /**
     * 
     * @return
     *     returns long
     */
    public long getArtId() {
        return this.artId;
    }

    /**
     * 
     * @param artId
     *     the value for the artId property
     */
    public void setArtId(long artId) {
        this.artId = artId;
    }

}
