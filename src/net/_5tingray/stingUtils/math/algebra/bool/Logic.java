package net._5tingray.stingUtils.math.algebra.bool;

/**
 * A logic utility class that provides some additional functions on booleans such as random booleans with a given chance for true and logic operations on boolean arrays.
 */
public class Logic {
	
	/**
	 * Randomly returns true or false with equal probability (50%).
	 * @return
	 */
	public static boolean randomBool() {
		return Math.random() < 0.5;
	}
	
	/**
	 * Randomly returns true or false with the given probability for true.
	 * @param chanceForTrue The probability that this method will return true from {@code 0 - 1}. The probability for false will be {@code 1 - chanceForTrue}
	 * @return
	 */
	public static boolean randomBool(double chanceForTrue) {
		if(chanceForTrue <= 0) return false;
		if(chanceForTrue >= 1) return true;
		return Math.random() < chanceForTrue;
	}
	
	/**
	 * Returns true only if all the given booleans are true. Returns false if the array is empty.
	 * @param bools
	 * @return
	 */
	public static boolean and(boolean... bools) {
		if(bools.length == 0) return false;
		for(boolean b: bools) {
			if(!b)
				return false;
		}
		return true;
	}
	
	/**
	 * Returns true if at least one of the given booleans is true. Returns false if the array is empty.
	 * @param bools
	 * @return
	 */
	public static boolean or(boolean... bools) {
		if(bools.length == 0) return false;
		for(boolean b: bools) {
			if(b)
				return true;
		}
		return false;
	}
	
	/**
	 * Returns true if all given booleans have the same value. Returns false if the array is empty.
	 * @param bools
	 * @return
	 */
	public static boolean equivalent(boolean... bools) {
		if(bools.length == 0) return false;
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
