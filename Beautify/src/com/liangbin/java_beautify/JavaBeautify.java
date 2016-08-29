package com.liangbin.java_beautify;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.Color;

public class JavaBeautify {

	public static Bitmap getBitmap(Bitmap bitmap) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		int pixels[] = new int[width * height];
		bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

		int x = 0, y = 0;
		for (x = 0; x < pixels.length; x++) {
			int pix = pixels[x];
			int a = pix >> 24;
			int r = (pix >> 16) & 0xff;
			int g = (pix >> 8) & 0xff;
			int b = (pix) & 0xff;
			int new_pix = (a << 24) | (r << 16) | (g << 8) | b;
			pixels[x] = new_pix;
		}

		bitmap = Bitmap.createBitmap(pixels, width, height,
				Bitmap.Config.RGB_565);

		return bitmap;
	}
}
