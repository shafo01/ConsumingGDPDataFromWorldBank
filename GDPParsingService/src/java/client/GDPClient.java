/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

/**
 *
 * @author starw
 */
public class GDPClient {

    static JsonArray emptyObject() {
        return Json.createArrayBuilder().build();
    }

    public JsonArray getJSONfromWorldBank(String urlString) {

        JsonArray res = emptyObject();
        //The key is appended to the root URL as a parameter, along with the address
        //we want to look for on maps, i.e. the place we want to find on maps       

        URL url;

        try {
            url = new URL(urlString);
            System.out.println(url);
        } catch (MalformedURLException ex) {
            System.out.println("Sorry, the URL " + urlString + " was bad.");

            return res;
        }

        //This is an auto-closing try-catch
        try (InputStream is = url.openStream();
                JsonReader rdr = Json.createReader(is)) {
            //Read the object from the reader
            JsonArray obj = rdr.readArray();

            return obj;
        } catch (IOException ex) {
            System.out.println("Sorry, that didn't work " + ex);

            return res;
        }
    }

}
