package edu.nyu.sdg.data;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class DataFetchApplication {

  public static void main(String... args) throws Exception {

    var url = "https://data.cityofnewyork.us/resource/bnx9-e6tj.csv?$limit=2000";
    var targetTablename = "acris" + System.currentTimeMillis();
    var appToken = "1uPvCkPCFgGbXHlo7xvqUcI7i";
    var outputFilename = "C:/NYU/data-api/src/main/java/edu/nyu/sdg/data/output.csv";
    long counter = 0;

    var httpClient = new DefaultHttpClient();

    var getRequest = new HttpGet(url);

    getRequest.addHeader("X-App-Token", appToken);

    var response = httpClient.execute(getRequest);

    if (response.getStatusLine().getStatusCode() != 200) {
      throw new RuntimeException("Failed : HTTP error code : "
        + response.getStatusLine().getStatusCode());
    }

    var br = new BufferedReader(
      new InputStreamReader((response.getEntity().getContent())));

    String output;

    var writer = new BufferedWriter(new FileWriter(outputFilename));

    while ((output = br.readLine()) != null) {
      writer.write(output + "\n");
      counter++;

      if(counter % 9999==0){
        System.out.println("counter => " + counter);
      }

    }

    writer.close();

    System.out.println("Downloaded " + counter + " records from the API");

    httpClient.getConnectionManager().shutdown();


  }
}
