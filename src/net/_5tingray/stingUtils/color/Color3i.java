package net._5tingray.stingUtils.color;

import java.awt.Color;

public class Color3i implements ColorI<Color3i> {
	
	public final int r, g, b;
	
	public Color3i(int r_, int g_, int b_) {
		if(r_ < 0) { r_ = 0;}
		if(g_ < 0) { g_ = 0;}
		if(b_ < 0) { b_ = 0;}
		
		if(r_ > 255) { r_ = 255;}
		if(g_ > 255) { g_ = 255;}
		if(b_ > 255) { b_ = 255;}
		
		r = r_; g = g_; b = b_;
	}

	@Override
	public Color3i toColor3i() {
		return this;
	}

	@Override
	public Color4i toColor4i() {
		return new Color4i(r, g, b, 255);
	}

	@Override
	public Color3f toColor3f() {
		return new Color3f(r / 255f, g / 255f, b / 255f);
	}

	@Override
	public Color4f toColor4f() {
		return new Color4f(r / 255f, g / 255f, b / 255f, 1);
	}

	@Override
	public Color toAWTColor() {
		return new Color(r, g, b);
	}

	@Override
	public Color3i interpolate(ColorI<?> otherColor) {
		Color3i color3i = otherColor.toColor3i();
		return new Color3i((r + color3i.r)/2, (g + color3i.g)/2, (b + color3i.b)/2);
	}

	@Override
	public Color3i interpolate(ColorI<?> otherColor, float weight) {
		if(weight <= 0) return this;
		if(weight >= 255) return otherColor.toColor3i();
		Color3i color3i = otherColor.toColor3i();
		return new Color3i((int) Math.round(r*(1-weight) + color3i.r*weight),
				(int) Math.round(g*weight + color3i.g*(1-weight)),
				(int) Math.round(b*weight + color3i.b*(1-weight)));
	}

}
