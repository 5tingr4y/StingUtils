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

public interface ColorI<T extends ColorI<?>> {
	
	Color3i toColor3i();
	Color4i toColor4i();
	
	Color3f toColor3f();
	Color4f toColor4f();
	
	Color toAWTColor();
	
	int getRedInt();
	int getGreenInt();
	int getBlueInt();
	int getAlphaInt();
	
	float getRedFloat();
	float getGreenFloat();
	float getBlueFloat();
	float getAlphaFloat();
	
	T interpolate(ColorI<?> otherColor);
	
	/**
	 * 
	 * @param otherColor
	 * @param weight - weight of this color
	 * @return
	 */
	T interpolate(ColorI<?> otherColor, float weight);
}
