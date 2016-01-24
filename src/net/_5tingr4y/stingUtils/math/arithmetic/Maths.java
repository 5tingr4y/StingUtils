/*
 * This file is part of StingUtils, licensed under the MIT License (MIT)
 *
 * Copyright (c) 2015 Raymond Kampmann <http://5tingr4y.net/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net._5tingr4y.stingUtils.math.arithmetic;

/**
 * 
 * @deprecated This will be replacesd by a new class later.
 */
@Deprecated
public class Maths {
	
	/*======*\
	|* Byte *|
	\*======*/
	/**
	 * Returns a random byte between 0 and a-1;
	 * @param a
	 * @return
	 */
	public static byte random1b(byte a) {
		return (byte) (Math.random() * a);
	}
	
	/**
	 * Returns a random byte between a and b-1;
	 * @param a
	 * @param b
	 * @return
	 */
	public static byte random2b(byte a, byte b) {
		return (byte) (random1b((byte) Math.abs(a-b)) + Math.min(a, b));
	}
	
	/**
	 * Returns the smallest value in the given byte array;
	 * @param input
	 * @return
	 */
	public static byte minByte(byte[] input) {
		int ret = Byte.MAX_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.min(ret, input[i]);
		}
		return (byte) ret;
	}
	
	/**
	 * Returns the biggest value in the given byte array;
	 * @param input
	 * @return
	 */
	public static byte maxByte(byte[] input) {
		int ret = Byte.MIN_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.max(ret, input[i]);
		}
		return (byte) ret;
	}
	
	/**
	 * Returns the position of the smallest value in the given byte array;
	 * @param input
	 * @return
	 */
	public static int minPosByte(byte[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] < input[ret]) ret = i;
		}
		return ret;
	}
	
	/**
	 * Returns the position of the biggest value in the given byte array;
	 * @param input
	 * @return
	 */
	public static int maxPosByte(byte[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > input[ret]) ret = i;
		}
		return ret;
	}
	
	
	/*=======*\
	|* Short *|
	\*=======*/
	/**
	 * Returns a random short between 0 and a-1;
	 * @param a
	 * @return
	 */
	public static short random1s(short a) {
		return (short) (Math.random() * a);
	}
	
	/**
	 * Returns a random short between a and b-1;
	 * @param a
	 * @param b
	 * @return
	 */
	public static short random2s(short a, short b) {
		return (short) (random1s((short) Math.abs(a-b)) + Math.min(a, b));
	}
	
	/**
	 * Returns the smallest value in the given short array;
	 * @param input
	 * @return
	 */
	public static short minShort(short[] input) {
		int ret = Short.MAX_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.min(ret, input[i]);
		}
		return (short) ret;
	}
	
	/**
	 * Returns the biggest value in the given short array;
	 * @param input
	 * @return
	 */
	public static short maxShort(short[] input) {
		int ret = Short.MIN_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.max(ret, input[i]);
		}
		return (short) ret;
	}
	
	/**
	 * Returns the position of the smallest value in the given short array;
	 * @param input
	 * @return
	 */
	public static int minPosShort(short[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] < input[ret]) ret = i;
		}
		return ret;
	}
	
	/**
	 * Returns the position of the biggest value in the given short array;
	 * @param input
	 * @return
	 */
	public static int maxPosShort(short[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > input[ret]) ret = i;
		}
		return ret;
	}
	
	
	/*=========*\
	|* Integer *|
	\*=========*/
	/**
	 * Returns a random integer between 0 and a-1;
	 * @param a
	 * @return
	 */
	public static int random1i(int a) {
		return (int) (Math.random() * a);
	}
	
	/**
	 * Returns a random integer between a and b-1;
	 * @param a
	 * @param b
	 * @return
	 */
	public static int random2i(int a, int b) {
		return random1i(Math.abs(a-b)) + Math.min(a, b);
	}
	
	/**
	 * TODO: javadoc
	 * @param a
	 * @param b
	 * @return
	 */
	public static int posMod(int a, int b) {
		return a % b < 0 ? a % b + Math.abs(b) : a % b;
	}
	
	/**
	 * Returns the smallest value in the given integer array;
	 * @param input
	 * @return
	 */
	public static int minInt(int[] input) {
		int ret = Integer.MAX_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.min(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the biggest value in the given integer array;
	 * @param input
	 * @return
	 */
	public static int maxInt(int[] input) {
		int ret = Integer.MIN_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.max(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the position of the smallest value in the given integer array;
	 * @param input
	 * @return
	 */
	public static int minPosInt(int[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] < input[ret]) ret = i;
		}
		return ret;
	}
	
	/**
	 * Returns the position of the biggest value in the given integer array;
	 * @param input
	 * @return
	 */
	public static int maxPosInt(int[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > input[ret]) ret = i;
		}
		return ret;
	}
	
	public static int limitInt(int value, int min, int max) {
		return Math.min(max, Math.max(min, value));
	}
	
	/*======*\
	|* Long *|
	\*======*/
	/**
	 * Returns a random long between 0 and a-1;
	 * @param a
	 * @return
	 */
	public static long random1L(long a) {
		return (long) (Math.random() * a);
	}

	/**
	 * Returns a random long between a and b-1;
	 * @param a
	 * @param b
	 * @return
	 */
	public static long random2L(long a, long b) {
		return random1L(Math.abs(a-b)) + Math.min(a, b);
	}
	
	/**
	 * Returns the smallest value in the given long array;
	 * @param input
	 * @return
	 */
	public static long minLong(long[] input) {
		long ret = Long.MAX_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.min(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the biggest value in the given long array;
	 * @param input
	 * @return
	 */
	public static long maxLong(long[] input) {
		long ret = Long.MIN_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.max(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the position of the smallest value in the given long array;
	 * @param input
	 * @return
	 */
	public static int minPosLong(long[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] < input[ret]) ret = i;
		}
		return ret;
	}
	
	/**
	 * Returns the position of the biggest value in the given long array;
	 * @param input
	 * @return
	 */
	public static int maxPosLong(long[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > input[ret]) ret = i;
		}
		return ret;
	}
	
	/*=======*\
	|* Float *|
	\*=======*/
	/**
	 * Returns a random float between 0 (inclusive) and a (exclusive);
	 * @param a
	 * @return
	 */
	public static float random1f(float a) {
		return (float) Math.random() * a;
	}
	
	/**
	 * Returns a random float between a (inclusive) and b (exclusive);
	 * @param a
	 * @return
	 */
	public static float random2f(float a, float b) {
		return random1f(Math.abs(a-b)) + Math.min(a, b);
	}
	
	/**
	 * Returns the smallest value in the given float array;
	 * @param input
	 * @return
	 */
	public static float minFloat(float[] input) {
		float ret = Float.MAX_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.min(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the biggest value in the given float array;
	 * @param input
	 * @return
	 */
	public static float maxFloat(float[] input) {
		float ret = Float.MIN_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.max(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the position of the smallest value in the given float array;
	 * @param input
	 * @return
	 */
	public static int minPosFloat(float[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] < input[ret]) ret = i;
		}
		return ret;
	}
	
	/**
	 * Returns the position of the biggest value in the given float array;
	 * @param input
	 * @return
	 */
	public static int maxPosFloat(float[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > input[ret]) ret = i;
		}
		return ret;
	}
	
	/*========*\
	|* Double *|
	\*========*/
	/**
	 * Returns a random float between 0 (inclusive) and a (exclusive);
	 * @param a
	 * @return
	 */
	public static double random1d(double a) {
		return Math.random() * a;
	}
	
	/**
	 * Returns a random float between a (inclusive) and b (exclusive);
	 * @param a
	 * @return
	 */
	public static double random2d(double a, double b) {
		return random1d(Math.abs(a-b)) + Math.min(a, b);
	}
	
	/**
	 * Returns the smallest value in the given double array;
	 * @param input
	 * @return
	 */
	public static double minDouble(double[] input) {
		double ret = Double.MAX_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.min(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the biggest value in the given double array;
	 * @param input
	 * @return
	 */
	public static double maxDouble(double[] input) {
		double ret = Double.MIN_VALUE;
		for(int i = 0; i < input.length; i++) {
			ret = Math.max(ret, input[i]);
		}
		return ret;
	}
	
	/**
	 * Returns the position of the smallest value in the given double array;
	 * @param input
	 * @return
	 */
	public static int minPosDouble(double[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] < input[ret]) ret = i;
		}
		return ret;
	}
	
	/**
	 * Returns the position of the biggest value in the given double array;
	 * @param input
	 * @return
	 */
	public static int maxPosDouble(double[] input) {
		int ret = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > input[ret]) ret = i;
		}
		return ret;
	}
}
