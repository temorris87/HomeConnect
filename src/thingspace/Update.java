package thingspace;

/**
 * Created by tysonmorris on 4/22/17.
 */

import java.io.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

public class Update {

  public static void main(String[] args) throws IOException {
    String[][] test = { {"on", "true"},
                        {"dim"  , "true"},
                        {"bright", "0.8"} };


    postData("livingroom_light", test);


    String[][] dat = parseData(getRoughData("livingroom_light"));

    for (int i = 0; i < dat.length; i++)
      System.out.println(dat[i][0] + " " + dat[i][1]);

    System.out.println();

    String[][] dat2 = parseData(getRoughData("oven"));

    for (int i = 0; i < dat2.length; i++)
      System.out.println(dat2[i][0] + " " + dat2[i][1]);
  }

  public static boolean postData(String object, String[][] args) throws IOException {
    String postSite = "https://thingspace.io/dweet/for/" + object + "?";
    for (int i = 0; i < args.length; i++) {
      if (i == 0)
        postSite += args[i][0] + "=" + args[i][1];
      else
        postSite += "&" + args[i][0] + "=" + args[i][1];
    }

    URL url = new URL(postSite);
    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
    httpCon.setDoOutput(true);
    httpCon.setRequestMethod("GET");

    return (httpCon.getResponseMessage().compareTo("OK") == 0);
  }

  public static String getRoughData(String object) throws IOException {
    URL url = new URL("https://thingspace.io/get/latest/dweet/for/" + object);
    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
    httpCon.setDoOutput(true);
    httpCon.setRequestMethod("GET");

    InputStream inputStream = httpCon.getErrorStream();
    if (inputStream == null)
      inputStream = httpCon.getInputStream();

    // Read everything from our stream
    BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream));

    String inputLine;
    StringBuilder response = new StringBuilder();

    while ((inputLine = responseReader.readLine()) != null) {
      response.append(inputLine);
    }
    responseReader.close();

    return response.toString();
  }

  public static String[][] parseData(String response) {

    int contentLoc = response.indexOf("content");
    String dataString = response.substring(contentLoc + 10, response.indexOf('}',contentLoc));

    StringTokenizer st = new StringTokenizer(dataString, ", : \"");

    String[][] data = new String[st.countTokens() / 2][2];
    for (int i = 0; i < data.length; i++) {
      data[i][0] = st.nextToken();
      data[i][1] = st.nextToken();
    }

    return data;
  }

}
