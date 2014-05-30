package serverTest;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerTest {

    String hostUrl = "http://54.200.252.24:8080/DrinkDbServer";
    //String hostUrl = "http://localhost:8089/DrinkDbServer";
    String charset = "UTF-8";
    String userid = "9774d56d682e549c";
    String drinkid = "123";
    String rating = "4";

    @Before
    public void setUp() throws Exception {
        Thread.sleep(250); // server gets angry when we request too fast?
    }

    @After
    public void tearDown() throws Exception {
        
    }
    
    @Test
    public void testConnection() throws Exception {
        InputStream response = new URL(hostUrl).openStream();
        assertTrue(response != null);
    }
    
    
    @Test
    public void testAddUserRating() throws Exception {
        String url = hostUrl + "/adduserrating";

        String query = String.format("%s&%s&%s", 
                URLEncoder.encode(userid, charset), 
                URLEncoder.encode(drinkid, charset),
                URLEncoder.encode(rating, charset));
        
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        assertTrue(response != null);
        HttpURLConnection hc = (HttpURLConnection) connection;
        assertTrue(hc.getResponseCode() == 200);
    }
    
    @Test
    public void testAddFavorite() throws Exception {
        String url = hostUrl + "/addfavorite";

        String query = String.format("%s&%s", 
             URLEncoder.encode(userid, charset), 
             URLEncoder.encode(drinkid, charset));
        
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        assertTrue(response != null);
        HttpURLConnection hc = (HttpURLConnection) connection;
        assertTrue(hc.getResponseCode() == 200);
    }
    
    @Test
    public void testRemoveFavorite() throws Exception {
        String url = hostUrl + "/removefavorite";

        String query = String.format("%s&%s", 
                URLEncoder.encode(userid, charset), 
                URLEncoder.encode(drinkid, charset));
        
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        assertTrue(response != null);
        HttpURLConnection hc = (HttpURLConnection) connection;
        assertTrue(hc.getResponseCode() == 200);
    }
    
    @Test
    public void testGetUserFavorites() throws Exception {
        String url = hostUrl + "/getuserfavorites";

        String query = String.format("%s", URLEncoder.encode(userid, charset));
        
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        assertTrue(response != null);
        HttpURLConnection hc = (HttpURLConnection) connection;
        assertTrue(hc.getResponseCode() == 200);
    }
    
    @Test
    public void testGetUserRatings() throws Exception {
        String url = hostUrl + "/getuserratings";

        String query = String.format("%s", URLEncoder.encode(userid, charset));
        
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        assertTrue(response != null);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response, charset));
        assertTrue(reader !=  null);
        String data = reader.readLine();
        assertTrue(data.length() > 0);
        HttpURLConnection hc = (HttpURLConnection) connection;
        assertTrue(hc.getResponseCode() == 200);
    }
    
    @Test
    public void testGetAvgRatings() throws Exception {
        String url = hostUrl + "/getavgratings";
        
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        assertTrue(response != null);
        HttpURLConnection hc = (HttpURLConnection) connection;
        assertTrue(hc.getResponseCode() == 200);
    }
    
    @Test
    public void testGetAllDrinks() throws Exception {
        String url = hostUrl + "/getalldrinks";

        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
        assertTrue(response != null);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response, charset));
        assertTrue(reader !=  null);
        String data = reader.readLine();
        assertTrue(data.length() > 0);
        HttpURLConnection hc = (HttpURLConnection) connection;
        assertTrue(hc.getResponseCode() == 200);
    }
}
