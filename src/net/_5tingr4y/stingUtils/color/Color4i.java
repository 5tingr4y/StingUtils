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

public class Color4i implements ColorI<Color4i> {

    public final int r, g, b, a;

    public Color4i(int r_, int g_, int b_, int a_) {
        if(r_ < 0) { r_ = 0;}
        if(g_ < 0) { g_ = 0;}
        if(b_ < 0) { b_ = 0;}
        if(a_ < 0) { a_ = 0;}

        if(r_ > 255) { r_ = 255;}
        if(g_ > 255) { g_ = 255;}
        if(b_ > 255) { b_ = 255;}
        if(a_ > 255) { a_ = 255;}

        r = r_; g = g_; b = b_; a = a_;
    }

    //converters

    @Override
    public Color3i toColor3i() {
        return new Color3i(r, g, b);
    }

    @Override
    public Color4i toColor4i() {
        return this;
    }

    @Override
    public Color3f toColor3f() {
        return new Color3f(r / 255f, g / 255f, b / 255f);
    }

    @Override
    public Color4f toColor4f() {
        return new Color4f(r / 255f, g / 255f, b / 255f, a / 255f);
    }

    @Override
    public Color toAWTColor() {
        return new Color(r, g, b, a);
    }

    //value getters

    @Override
    public int getRedInt() {
        return r;
    }

    @Override
    public int getGreenInt() {
        return g;
    }

    @Override
    public int getBlueInt() {
        return b;
    }

    @Override
    public int getAlphaInt() {
        return a;
    }

    @Override
    public float getRedFloat() {
        return r / 255f;
    }

    @Override
    public float getGreenFloat() {
        return g / 255f;
    }

    @Override
    public float getBlueFloat() {
        return b / 255f;
    }

    @Override
    public float getAlphaFloat() {
        return a / 255f;
    }

    //operations

    @Override
    public Color4i interpolate(ColorI<?> otherColor) {
        Color4i color4i = otherColor.toColor4i();
        return new Color4i((r + color4i.r)/2, (g + color4i.g)/2, (b + color4i.b)/2, (a + color4i.a)/2);
    }

    @Override
    public Color4i interpolate(ColorI<?> otherColor, float weight) {
        if(weight <= 0) return this;
        if(weight >= 255) return otherColor.toColor4i();
        Color4i color4i = otherColor.toColor4i();
        return new Color4i(Math.round(r*weight + color4i.r*(1-weight)),
                Math.round(g*weight + color4i.g*(1-weight)),
                Math.round(b*weight + color4i.b*(1-weight)),
                Math.round(a*weight + color4i.a*(1-weight)));
    }

}
