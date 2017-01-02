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
package net._5tingr4y.stingUtils.color;

import java.awt.Color;

public class Color3f implements ColorI<Color3f> {

    public final float r, g, b;

    public Color3f(float r_, float g_, float b_) {
        if(r_ < 0) { r_ = 0;}
        if(g_ < 0) { g_ = 0;}
        if(b_ < 0) { b_ = 0;}

        if(r_ > 1) { r_ = 1;}
        if(g_ > 1) { g_ = 1;}
        if(b_ > 1) { b_ = 1;}

        r = r_; g = g_; b = b_;
    }

    //converters

    @Override
    public Color3i toColor3i() {
        return new Color3i(Math.round(r * 255), Math.round(g * 255), Math.round(b * 255));
    }

    @Override
    public Color4i toColor4i() {
        return new Color4i(Math.round(r * 255), Math.round(g * 255), Math.round(b * 255), 255);
    }

    @Override
    public Color3f toColor3f() {
        return this;
    }

    @Override
    public Color4f toColor4f() {
        return new Color4f(r, g, b, 1);
    }

    @Override
    public Color toAWTColor() {
        return new Color(r, g, b);
    }

    //value getters

    @Override
    public int getRedInt() {
        return Math.round(r * 255);
    }

    @Override
    public int getGreenInt() {
        return Math.round(g * 255);
    }

    @Override
    public int getBlueInt() {
        return Math.round(b * 255);
    }

    @Override
    public int getAlphaInt() {
        return 255;
    }

    @Override
    public float getRedFloat() {
        return r;
    }

    @Override
    public float getGreenFloat() {
        return g;
    }

    @Override
    public float getBlueFloat() {
        return b;
    }

    @Override
    public float getAlphaFloat() {
        return 1;
    }

    //operations

    @Override
    public Color3f interpolate(ColorI<?> otherColor) {
        Color3f color3f = otherColor.toColor3f();
        return new Color3f((r + color3f.r)/2, (g + color3f.g)/2, (b + color3f.b)/2);
    }

    @Override
    public Color3f interpolate(ColorI<?> otherColor, float weight) {
        if(weight <= 0) return this;
        if(weight >= 1) return otherColor.toColor3f();
        Color3f color3f = otherColor.toColor3f();
        return new Color3f(r*weight + color3f.r*(1-weight),
                g*weight + color3f.g*(1-weight),
                b*weight + color3f.b*(1-weight));
    }

}
