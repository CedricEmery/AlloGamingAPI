/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Cedric
 */
@WebService(serviceName = "translator")
public class translator {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "GetGamesList")
    public String GetGamesList(@WebParam(name = "game's name") String sGameName) throws MalformedURLException, UnsupportedEncodingException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetGamesList.php?name="+ URLEncoder.encode(sGameName,"UTF-8")));
    }

    @WebMethod(operationName = "GetGame")
    public String GetGame(@WebParam(name = "game's Id") long lGameId) throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetGame.php?id="+ lGameId));
    }

    @WebMethod(operationName = "GetArt")
    public String GetArt(@WebParam(name = "art's Id") long lArtId) throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetArt.php?id="+ lArtId));
    }

    @WebMethod(operationName = "GetPlatformsList")
    public String GetPlatformsList() throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetPlatformsList.php"));
    }

    @WebMethod(operationName = "GetPlatform")
    public String GetPlatform(@WebParam(name = "platform's Id") long lPlatformId) throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetPlatform.php?id="+ lPlatformId));
    }

    @WebMethod(operationName = "GetPlatformGames")
    public String GetPlatformGames(@WebParam(name = "platform's Id") long lPlatformId) throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetPlatformGames.php?platform="+ lPlatformId));
    }

    @WebMethod(operationName = "PlatformGames")
    public String PlatformGames(@WebParam(name = "platform's name") String sPlatformName) throws UnsupportedEncodingException, MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/PlatformGames.php?platform="+ URLEncoder.encode(sPlatformName,"UTF-8")));
    }
    
    public String getXMLfromJson(URL url) 
    {
        InputStream inputStream = null;
        
        try
        {
            inputStream = url.openStream();
            String xml = IOUtils.toString(inputStream);
            JSON objJson = new XMLSerializer().read(xml);
            String JSONData = objJson.toString(2);
            return JSONData;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                if (inputStream != null) 
                {
                    inputStream.close();
                }
                url = null;
                
                return null;
            } 
            catch (IOException ex) 
            {
            }
        }
        return null;
    }
}
