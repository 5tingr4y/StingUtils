package net._5tingray.stingUtils.color;

import java.awt.Color;

public interface ColorI<T extends ColorI<?>> {
	
	public Color3i toColor3i();
	public Color4i toColor4i();
	
	public Color3f toColor3f();
	public Color4f toColor4f();
	
	public Color toAWTColor();
	
	public T interpolate(ColorI<?> otherColor);
	
	/**
	 * 
	 * @param otherColor
	 * @param weight - weight of this color
	 * @return
	 */
	public T interpolate(ColorI<?> otherColor, float weight);
}
