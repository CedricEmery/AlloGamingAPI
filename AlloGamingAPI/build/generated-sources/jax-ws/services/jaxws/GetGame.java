
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetGame", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetGame", namespace = "http://services/")
public class GetGame {

    @XmlElement(name = "gameId", namespace = "")
    private long gameId;

    /**
     * 
     * @return
     *     returns long
     */
    public long getGameId() {
        return this.gameId;
    }

    /**
     * 
     * @param gameId
     *     the value for the gameId property
     */
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

}
