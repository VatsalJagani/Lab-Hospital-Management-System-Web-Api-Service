/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author sahdev
 */
public class ServiceConnection {

    public static String output(String urlString) throws MalformedURLException, IOException {
        String finalOutput = "";
        //URL url = new URL("http://localhost:59190/api/"+ urlString);
        URL url = new URL("http://vatsaljagani-001-site1.itempurl.com/api/"+ urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            finalOutput += output;
            // convert this json string to object by jackson 2
            // set to session
        }
        conn.disconnect();
        return finalOutput;
    }
}
