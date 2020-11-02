package com.example.testingcanvases;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class gettingTextExtracted extends AsyncTask<Void,Void,Void> {

    String fullData="";

    @Override
    protected Void doInBackground(Void... voids) {


        URL url = null;
        HttpURLConnection httpURLConnection = null;

        try {

            Log.d("Steps", "try: in the try loop, about to instanciate the URL");
            url = new URL("https://pastebin.com/raw/0edDmPCu");

            httpURLConnection = (HttpURLConnection) url.openConnection(); //establishes the bridge to the data source
            httpURLConnection.setRequestMethod("GET");
            Log.d("Steps", "try: established the http connection on the url");

            InputStream inputStream = (BufferedInputStream) httpURLConnection.getInputStream(); //lets us have the data flow in so that we can read it
            Log.d("Steps", "try: established input stream");


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); //gonna setup a way to read the file
            Log.d("Steps", "try: established buffered reader");

            String line="";
            while(line != null){

                Log.d("Steps", "try: while: in the loop");

                line = bufferedReader.readLine();
                Log.d("Steps", "try: while: line read");

                fullData = fullData+line;
                Log.d("Steps", "try: while: line added");

            }

            httpURLConnection.disconnect(); //seems like I should close this after im done with it...

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Log.d("Steps", "onPostExc: in the meth");
        jsonExtractTest.exTxt.setText(this.fullData);
        Log.d("Steps", "onPostExc: textview settext done");
    }
}
