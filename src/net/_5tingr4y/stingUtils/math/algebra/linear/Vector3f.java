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
package net._5tingr4y.stingUtils.math.algebra.linear;

import net._5tingr4y.stingUtils.math.arithmetic.Maths;

public class Vector3f {
	
	
	private float x, y, z;
	private boolean immutable = false;
	
	public Vector3f() {
		x = (float) Math.random();
		y = (float) Math.random();
		z = (float) Math.random();
	}
	
	public Vector3f(float r) {
		x = Maths.random1f(r);
		y = Maths.random1f(r);
		z = Maths.random1f(r);
	}
	
	public Vector3f(float x_, float y_, float z_) {
		x = x_;
		y = y_;
		z = z_;
	}

	//getters
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getZ() {
		return z;
	}
	
	@Override
	public Vector3f clone() {
		return new Vector3f(x, y, z);
	}
	
	public float length() {
		return (float) Math.sqrt((x*x) + (y*y) + (z * z));
	}
	
	@Override
	public String toString() {
		return "Vector3f: ("+x+"|"+y+"|"+z+")";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(!(o instanceof Vector3f)) return false;
		
		return ((Vector3f)o).x == x && ((Vector3f)o).y == y && ((Vector3f)o).z == z;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result = 31 + result + Float.floatToIntBits(x);
		result = 31 + result + Float.floatToIntBits(y);
		result = 31 + result + Float.floatToIntBits(z);
		return result;
	}
	
	//setters
	public Vector3f setImmutable() {
		immutable = true;
		return this;
	}
	
	public Vector3f addI(Vector3f v) {
		return new Vector3f(x + v.x, y + v.y, z + v.z);
	}
	
	public Vector3f addM(Vector3f v) {
		if(immutable) return addI(v);
			
		x += v.x;
		y += v.y;
		z += v.z;
		return this;
	}
	
	public Vector3f subI(Vector3f v) {
		return new Vector3f(x - v.x, y - v.y, z - v.z);
	}
	
	public Vector3f subM(Vector3f v) {
		if(immutable) return subI(v);
		
		x -= v.x;
		y -= v.y;
		z -= v.z;
		return this;
	}
	
	public Vector3f multI(float f) {
		return new Vector3f(x * f, y * f, z * f);
	}
	
	public Vector3f multM(float f) {
		if(immutable) return multI(f);
		
		x *= f;
		y *= f;
		z *= f;
		return this;
	}
	
	public Vector3f scaleI(Vector3f v) {
		return new Vector3f(x * v.x, y * v.y, z * v.z);
	}
	
	public Vector3f scaleM(Vector3f v) {
		if(immutable) return scaleI(v);
		
		x *= v.x;
		y *= v.y;
		z *= v.z;
		return this;
	}
	
	public Vector3f divI(float f) {
		return new Vector3f(x / f, y / f, z / f);
	}
	
	public Vector3f divM(float f) {
		if(immutable) return divI(f);
		
		x /= f;
		y /= f;
		z /= f;
		return this;
	}
	
	public float scalarMult(Vector3f v) {
		return (x * v.x) + (y * v.y) + (z * v.z); 
	}
	
	public Vector3f normalizeI() {
		float l = length();
		if (l != 0) {
			return divI(l);
		}
		return new Vector3f(x, y, z);
	}
	
	public Vector3f normalizeM() {
		if(immutable) return normalizeI();
		
		float l = length();
		if(l != 0) {
			divM(l);
		}
		return this;
	}
	
	//TODO: rotation
	
	public Vector3f interpolateI(Vector3f v) {
		return new Vector3f((x + v.x)/2f, (y + v.y)/2f, (z + v.z)/2f);
	}
	
	public Vector3f interpolateM(Vector3f v) {
		if(immutable) return interpolateI(v);
		
		x = (x + v.x) / 2f;
		y = (y + v.y) / 2f;
		z = (z + v.z) / 2f;
		return this;
	}
	
	/**
	 * 
	 * @param v - the other Vector
	 * @param percentage - the percentage weight of THIS Vector
	 * @return
	 */
	public Vector3f interpolateI(Vector3f v, float percentage) {
		if(percentage <= 0) return new Vector3f(x, y, z);
		if(percentage >= 1) return new Vector3f(v.x, v.y, v.z);
		return new Vector3f((x*percentage) + (v.x * (1-percentage)), (y*percentage) + (v.y * (1-percentage)), (z*percentage) + (v.z * (1-percentage)));
	}
	
	public Vector3f interpolateM(Vector3f v, float percentage) {
		if(immutable) return interpolateI(v, percentage);
		
		if(percentage <= 0) return this;
		if(percentage >= 1) {
			x = v.x; y = v.y;
			return this;
		}
		
		x = (x*percentage) + (v.x * (1-percentage));
		y = (y*percentage) + (v.y * (1-percentage));
		z = (z*percentage) + (v.z * (1-percentage));
		return this;
	}
}
