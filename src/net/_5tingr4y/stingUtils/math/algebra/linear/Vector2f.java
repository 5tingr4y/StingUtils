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

public class Vector2f {

    public static final Vector2f ZERO = new Vector2f(0, 0).setImmutable();
    public static final Vector2f ONE = new Vector2f(1, 1).setImmutable();
    public static final Vector2f BASE_01 = new Vector2f(0, 1).setImmutable();
    public static final Vector2f BASE_10 = new Vector2f(1, 0).setImmutable();

    private float x, y;
    private boolean immutable = false;

    public Vector2f() {
        x = (float) Math.random();
        y = (float) Math.random();
    }

    public Vector2f(float r) {
        x = Maths.random1f(r);
        y = Maths.random1f(r);
    }

    public Vector2f(float x_, float y_) {
        x = x_;
        y = y_;
    }

    //getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Vector2f copy() {
        return new Vector2f(x, y);
    }

    public float length() {
        return (float) Math.sqrt((x*x) + (y*y));
    }

    public float getAngleRad() {
        if(length() == 0) {return -1;}
        double a = Math.acos(x/length());
        if(y >= 0) {
            return (float)a;
        }
        return (float) ((2*Math.PI)-a);
    }

    public float getAngle() {
        return (float) (getAngleRad()*180/Math.PI);
    }

    @Override
    public String toString() {
        return "Vector2f: ("+x+"|"+y+")";
    }

    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof Vector2f && ((Vector2f)o).x == x && ((Vector2f)o).y == y);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 + result + Float.floatToIntBits(x);
        result = 31 + result + Float.floatToIntBits(y);
        return result;
    }

    //setters
    public Vector2f setImmutable() {
        immutable = true;
        return this;
    }

    public Vector2f addI(Vector2f v) {
        return new Vector2f(x + v.x, y + v.y);
    }

    public Vector2f addM(Vector2f v) {
        if(immutable) return addI(v);

        x += v.x;
        y += v.y;
        return this;
    }

    public Vector2f subI(Vector2f v) {
        return new Vector2f(x - v.x, y - v.y);
    }

    public Vector2f subM(Vector2f v) {
        if(immutable) return subI(v);

        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vector2f multI(float f) {
        return new Vector2f(x * f, y * f);
    }

    public Vector2f multM(float f) {
        if(immutable) return multI(f);

        x *= f;
        y *= f;
        return this;
    }

    public Vector2f scaleI(Vector2f v) {
        return new Vector2f(x * v.x, y * v.y);
    }

    public Vector2f scaleM(Vector2f v) {
        if(immutable) return scaleI(v);

        x *= v.x;
        y *= v.y;
        return this;
    }

    public Vector2f divI(float f) {
        return new Vector2f(x / f, y / f);
    }

    public Vector2f divM(float f) {
        if(immutable) return divI(f);

        x /= f;
        y /= f;
        return this;
    }

    public float scalarMult(Vector2f v) {
        return (x * v.x) + (y * v.y);
    }

    public Vector2f normalizeI() {
        float l = length();
        if (l != 0) {
            return divI(l);
        }
        return new Vector2f(x, y);
    }

    public Vector2f normalizeM() {
        if(immutable) return normalizeI();

        float l = length();
        if(l != 0) {
            divM(l);
        }
        return this;
    }

    public Vector2f rotateI(float degrees) {
        if(degrees == 0) return new Vector2f(x, y);

        float buff = (float) (degrees * Math.PI/180.0);
        return rotateRadI(buff);
    }

    public Vector2f rotateM(float degrees) {
        if(degrees == 0) return immutable ? new Vector2f(x, y) : this;

        float buff = (float) (degrees * Math.PI/180.0);
        return rotateRadM(buff);
    }

    public Vector2f rotateRadI(float rad) {
        if(rad == 0) return new Vector2f(x, y);

        return new Vector2f((float) (x * Math.cos(rad) - y * Math.sin(rad)), (float) (x * Math.sin(rad) + y * Math.cos(rad)));
    }

    public Vector2f rotateRadM(float rad) {
        if(rad == 0) return immutable ? new Vector2f(x, y) : this;

        float bx = (float) (x * Math.cos(rad) - y * Math.sin(rad));
        float by = (float) (x * Math.sin(rad) + y * Math.cos(rad));

        x = bx; y = by;
        return this;
    }

    public Vector2f interpolateI(Vector2f v) {
        return new Vector2f((x + v.x)/2f, (y + v.y)/2f);
    }

    public Vector2f interpolateM(Vector2f v) {
        if(immutable) return interpolateI(v);

        x = (x + v.x) / 2f;
        y = (y + v.y) / 2f;
        return this;
    }

    /**
     *
     * @param v the other Vector
     * @param percentage the percentage weight of THIS Vector
     * @return
     */
    public Vector2f interpolateI(Vector2f v, float percentage) {
        if(percentage <= 0) return new Vector2f(x,y);
        if(percentage >= 1) return new Vector2f(v.x, v.y);
        return new Vector2f((x*percentage) + (v.x * (1-percentage)), (y*percentage) + (v.y * (1-percentage)));
    }

    public Vector2f interpolateM(Vector2f v, float percentage) {
        if(immutable) return interpolateI(v, percentage);

        if(percentage <= 0) return this;
        if(percentage >= 1) {
            x = v.x; y = v.y;
            return this;
        }

        x = (x*percentage) + (v.x * (1-percentage));
        y = (y*percentage) + (v.y * (1-percentage));
        return this;
    }
}
