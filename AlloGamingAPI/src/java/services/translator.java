/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.apache.commons.io.IOUtils;
import org.json.XML;


/**
 *
 * @author Cedric
 */
@WebService()
@SOAPBinding(style = Style.RPC)
//@javax.ws.rs.ApplicationPath("translator")
//@Path("translator")
public class translator {

    /**
     * This is a sample web service operation
     */
    //@GET
    //@WebMethod(operationName = "GetGamesList")
    public String GetGamesList(@WebParam(name = "gameName") String sGameName) throws MalformedURLException, UnsupportedEncodingException 
    {
        URL url = new URL("http://thegamesdb.net/api/GetGamesList.php?name=halo"+ URLEncoder.encode(sGameName,"UTF-8"));
        return getXMLfromJson(url);
    }

    //@GET
    //@WebMethod(operationName = "GetGame")
    public String GetGame(@WebParam(name = "gameId") long lGameId) throws MalformedURLException 
    {
        URL url = new URL("http://thegamesdb.net/api/GetGame.php?id="+ lGameId);
        return getXMLfromJson(url);
    }

    //@GET
    //@WebMethod(operationName = "GetArt")
    public String GetArt(@WebParam(name = "artId") long lArtId) throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetArt.php?id="+ lArtId));
    }

    //@GET
    //@Path("GetPlatformsList")
    @WebMethod(operationName = "GetPlatformsList")
    public String GetPlatformsList() throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetPlatformsList.php"));
    }
    
    //@GET
    //@WebMethod(operationName = "GetPlatform")
    public String GetPlatform(@WebParam(name = "platformId") long lPlatformId) throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetPlatform.php?id="+ lPlatformId));
    }
    
    //@GET
    //@WebMethod(operationName = "getPlatformGames")
    public String GetPlatformGames(@WebParam(name = "platformId") long lPlatformId) throws MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/GetPlatformGames.php?platform="+ lPlatformId));
    }
    
    //@GET
    //@WebMethod(operationName = "PlatformGames")
    public String PlatformGames(@WebParam(name = "platformName") String sPlatformName) throws UnsupportedEncodingException, MalformedURLException 
    {
        return getXMLfromJson(new URL("http://thegamesdb.net/api/PlatformGames.php?platform="+ URLEncoder.encode(sPlatformName,"UTF-8")));
    }
    
    public String getXMLfromJson(URL url) throws MalformedURLException 
    {
        System.out.println(url.toString());
        
        try
        {
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");
  
            String xml = IOUtils.toString(httpcon.getInputStream());
            
            System.out.println("flux XML");
            System.out.println(xml);
            
            org.json.JSONObject jsonObj = XML.toJSONObject(xml);
            
            System.out.println("read ok");
            System.out.println(jsonObj);
            String JSONData = jsonObj.toString(4);
            System.out.println("flux Json");
            System.out.println(JSONData);
            
            return JSONData;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
