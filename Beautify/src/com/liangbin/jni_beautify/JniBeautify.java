package com.liangbin.jni_beautify;

public class JniBeautify {
	static {
		System.loadLibrary("lb_beautify");
	}
	public static native int[] getBitmap(int[] pixls, int width, int height);
}
