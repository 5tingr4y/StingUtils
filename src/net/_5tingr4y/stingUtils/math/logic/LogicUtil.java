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
package net._5tingr4y.stingUtils.math.logic;

/**
 * A logic utility class that provides some additional functions on booleans such as random booleans with a given chance for true and logic operations on boolean arrays.
 */
public class LogicUtil {
	
	/**
	 * Randomly returns true or false with equal probability.
	 * @return
	 */
	public static boolean randomBool() {
		return Math.random() < 0.5;
	}
	
	/**
	 * Randomly returns true or false with the given probability for true.
	 * @param chanceForTrue The probability that this method will return true ranging from {@code 0 - 1}. The probability for false will be {@code 1 - chanceForTrue}
	 * @return
	 */
	public static boolean randomBool(double chanceForTrue) {
		if(chanceForTrue <= 0) return false;
		if(chanceForTrue >= 1) return true;
		return Math.random() < chanceForTrue;
	}
	
	/**
	 * Returns true only if all the given booleans are true. Returns false if the array is empty.
	 * <p>If the number of given booleans is 0, this method will return true.
	 * @param bools
	 * @return
	 */
	public static boolean and(boolean... bools) {
		for(boolean b: bools) {
			if(!b)
				return false;
		}
		return true;
	}
	
	/**
	 * Returns true if at least one of the given booleans is true. Returns false if the array is empty.
	 * <p>If the number of given booleans is 0, this method will return false.
	 * @param bools
	 * @return
	 */
	public static boolean or(boolean... bools) {
		for(boolean b: bools) {
			if(b)
				return true;
		}
		return false;
	}
	
	/**
	 * Returns true if all given booleans have the same value. Returns false if the array is empty.
	 * <p>If the number of given booleans is 0, this method will return true.
	 * @param bools
	 * @return
	 */
	public static boolean equivalent(boolean... bools) {
		if(bools.length == 0) return true;
		boolean start = bools[0];
		for(int i = 1; i < bools.length; i++) {
			if(bools[i] != start)
				return false;
		}
		return true;
	}
	
	/**
	 * Returns the result of {@code a -> b}.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean implies(boolean a, boolean b) {
		return !a || b;
	}
}
