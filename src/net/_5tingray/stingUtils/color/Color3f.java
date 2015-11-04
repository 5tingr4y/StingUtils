package net._5tingray.stingUtils.color;

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

	@Override
	public Color3i toColor3i() {
		return new Color3i((int) Math.round(r * 255), (int) Math.round(g * 255), (int) Math.round(b * 255));
	}

	@Override
	public Color4i toColor4i() {
		return new Color4i((int) Math.round(r * 255), (int) Math.round(g * 255), (int) Math.round(b * 255), 255);
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
		return new Color3f(r*(1-weight) + color3f.r*weight,
				g*weight + color3f.g*(1-weight),
				b*weight + color3f.b*(1-weight));
	}

}
