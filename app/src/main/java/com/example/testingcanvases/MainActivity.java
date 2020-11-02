package com.example.testingcanvases;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button goToExtractor;
    ImageView cbyFloorPlanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        goToExtractor = (Button) findViewById(R.id.goToExtractor);
        Log.d("Steps", "onCreate: gotoext btn linked");
        goToExtractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Steps", "onClick: btn clicked, about to open extractor activity");
                openGetTxtExt();
                Log.d("Steps", "onClick: launched open extractor activity method");
            }
        });

        ImageView cbyFloorPlanView = (ImageView) findViewById(R.id.cbyFloorPlan); //setting the imageView

  /* THIS COMMENT TAKES OUT THE ENTIRE PART OF CANVAS/DRAWING TESTING

        /* COMMENT BLOCK 1

        //getting the display width of whatever phone is being used
        Display display = getWindowManager().getDefaultDisplay();
        int displayWidth = display.getWidth();

        //if the bitmap treats the drawable immediately, it will maybe crash to the shear size of the file
        //hence, we configure Options for it to make a preliminary scan of the size of the image to know that its too big
        // we can get the size without "scanning" the whole image, then use that to scale it down to an appropriate size
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cby0_1, options);
        int imWidth = options.outWidth;
        int imHeigth = options.outHeight;
        if (imWidth>displayWidth) {
            int widthRatio = Math.round((float) imWidth/(float) displayWidth);
            options.inSampleSize = widthRatio;
        }
        // COMMENT BLOCK 1 SUPPOSED TO FINISH HERE

        Bitmap bitmap = ((BitmapDrawable)cbyFloorPlanView.getDrawable()).getBitmap();
        Log.d("Steps", "bitmap created from imageview");


        Bitmap tempBitmap = Bitmap.createBitmap(365,651, Bitmap.Config.ARGB_8888);
        Log.d("Steps", "temp bitmap created");

        // now that we got the scaling ratio, we "turn off" the option to "scan" only part of the image.
        // we can then call in the full image, but in its resized format
        //options.inJustDecodeBounds=false;
        //Bitmap scaledBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cby0_1,options);

        //Log.d("Steps","bitmap, created");

        //cbyFloorPlanView.setImageBitmap(scaledBitmap); //set the imageView to display the newly resized bitmap image
        //Log.d("Steps","imgView set");

        float x1 = 10;
        float y1 = 10;
        float x2 = 20;
        float y2 = 20;

        Paint testPaint = new Paint();
        testPaint.setColor(Color.RED);
        testPaint.setAntiAlias(true);
        testPaint.setStrokeWidth(5);
        testPaint.setStyle(Paint.Style.STROKE);
        testPaint.setStrokeJoin(Paint.Join.ROUND);
        testPaint.setStrokeCap(Paint.Cap.ROUND);

        Log.d("Steps","new paint created & configured");

        Canvas testCanvas = new Canvas(tempBitmap);
        Log.d("Steps","new canvas created");

        /* COMMENT BLOCK 2
        Bitmap.Config bitmapConfig = scaledBitmap.getConfig();
        Log.d("Steps","bitmap configuration vble created");

        if(bitmapConfig == null) {
            bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        }
        Log.d("Steps","bitmap configuration vble set");
        //COMMENT BLOCK 2 SUPPOSED TO FINISH HERE

        testCanvas.drawBitmap(bitmap,null,new Rect(0,0,365,651),testPaint);

        testCanvas.drawLine(x1, y1, x2, y2, testPaint);
        Log.d("Steps","line drawn");

        cbyFloorPlanView.setImageDrawable(new BitmapDrawable(getResources(), tempBitmap));
        Log.d("Steps","imgView set to new drawable");


        //Testing shit out for the display width
        //Rect bounds = WindowManager.getCurrentWindowMetrics().getBounds();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        Log.d("Steps", "heigth is "+height+", width is "+width);

*/

    }

    public void openGetTxtExt(){
        Log.d("Steps", "in open ext act meth.");
        Intent intent = new Intent(this, jsonExtractTest.class);
        Log.d("Steps", "intent set for opening the ext act");
        startActivity(intent);
        Log.d("Steps", "ext act launched?");

    }

    }

//}