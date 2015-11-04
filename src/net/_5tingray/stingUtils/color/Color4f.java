package net._5tingray.stingUtils.color;

import java.awt.Color;

public class Color4f implements ColorI<Color4f> {
	
	public final float r, g, b, a;
	
	public Color4f(float r_, float g_, float b_, float a_) {
		if(r_ < 0) { r_ = 0;}
		if(g_ < 0) { g_ = 0;}
		if(b_ < 0) { b_ = 0;}
		if(a_ < 0) { a_ = 0;}
		
		if(r_ > 1) { r_ = 1;}
		if(g_ > 1) { g_ = 1;}
		if(b_ > 1) { b_ = 1;}
		if(a_ > 1) { a_ = 1;}
		
		r = r_; g = g_; b = b_; a = a_;
	}
	
	@Override
	public Color3i toColor3i() {
		return new Color3i((int) Math.round(r * 255), (int) Math.round(g * 255), (int) Math.round(b * 255));
	}

	@Override
	public Color4i toColor4i() {
		return new Color4i((int) Math.round(r * 255), (int) Math.round(g * 255), (int) Math.round(b * 255), (int) Math.round(a * 255));
	}

	@Override
	public Color3f toColor3f() {
		return new Color3f(r, g, b);
	}

	@Override
	public Color4f toColor4f() {
		return this;
	}

	@Override
	public Color toAWTColor() {
		return new Color(r, g, b, a);
	}

	@Override
	public Color4f interpolate(ColorI<?> otherColor) {
		Color4f color4f = otherColor.toColor4f();
		return new Color4f((r + color4f.r)/2, (g + color4f.g)/2, (b + color4f.b)/2, (a + color4f.a)/2);
	}

	@Override
	public Color4f interpolate(ColorI<?> otherColor, float weight) {
		if(weight <= 0) return this;
		if(weight >= 1) return otherColor.toColor4f();
		Color4f color4f = otherColor.toColor4f();
		return new Color4f(r*(1-weight) + color4f.r*weight,
				g*weight + color4f.g*(1-weight),
				b*weight + color4f.b*(1-weight),
				a*weight + color4f.a*(1-weight));
	}
}
