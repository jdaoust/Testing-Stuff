package com.example.testingcanvases;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class jsonExtractTest extends AppCompatActivity {

    Button extractButton;
    public static TextView exTxt;
    Button exBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_extract_test);

        exTxt = (TextView) findViewById(R.id.extractedText);

        extractButton = (Button) findViewById(R.id.extractButton);
        extractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Steps", "onClick: btn clicked, about to run the extractor");
                gettingTextExtracted process = new gettingTextExtracted();
                Log.d("Steps", "process instance initialized, about to execute");
                process.execute();
                Log.d("Steps", "ext process should be started");
            }
        });

        exBackToMain = (Button) findViewById(R.id.exBackToMain);
        exBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Steps", "onClick: btn clicked to go back to main, about to run that meth");
                goToMain();
            }
        });
    }

    private void goToMain(){
        Log.d("Steps", "in meth to go to main");
        Intent intent = new Intent(this, MainActivity.class);
        Log.d("Steps", "intent created for main from ext");
        startActivity(intent);

    }



}