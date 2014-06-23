
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetPlatform", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPlatform", namespace = "http://services/")
public class GetPlatform {

    @XmlElement(name = "platformId", namespace = "")
    private long platformId;

    /**
     * 
     * @return
     *     returns long
     */
    public long getPlatformId() {
        return this.platformId;
    }

    /**
     * 
     * @param platformId
     *     the value for the platformId property
     */
    public void setPlatformId(long platformId) {
        this.platformId = platformId;
    }

}
