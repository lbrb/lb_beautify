package com.liangbin.beautify;

import com.liangbin.java_beautify.JavaBeautify;
import com.liangbin.jni_beautify.JniBeautify;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
	private ImageView imageView;
	private TextView textView;
	private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic);
        textView = (TextView) findViewById(R.id.textView);
    }
    
    public void original_pic(View v) {
    	long startTime = System.currentTimeMillis();
    	imageView.setImageBitmap(bitmap);
    	long endTime = System.currentTimeMillis();
    	textView.setText((endTime-startTime)+"ms");
    	
    }
    
    public void java_pic(View v) {
    	long startTime = System.currentTimeMillis();
    	imageView.setImageBitmap(JavaBeautify.getBitmap(bitmap));
    	long endTime = System.currentTimeMillis();
    	textView.setText((endTime-startTime)+"ms");
    	
    }
    
    public void jni_pic(View v) {
    	long startTime = System.currentTimeMillis();
    	int width = bitmap.getWidth();
    	int height = bitmap.getHeight();
    	int[] pixels = new int[width*height];
    	bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
    	
    	Bitmap bitmap = Bitmap.createBitmap(pixels, width, height, Bitmap.Config.RGB_565);
    	imageView.setImageBitmap(bitmap);
    	long endTime = System.currentTimeMillis();
    	textView.setText((endTime-startTime)+"ms");
    
    }

}
