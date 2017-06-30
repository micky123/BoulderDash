/*
 * 
 */
package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Dirt.
 */
public class Dirt extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(1, "Dirt.png");

	/**
	 * Instantiates a new dirt.
	 *
	 * @param x the x
	 * @param y the y
	 * @param map the map
	 */
	Dirt(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.DIRT);
	}

	/**
	 * Gets the rock sprite.
	 *
	 * @return the rock sprite
	 */
	public static Sprite getDirtSprite() {
		return SPRITE;
	}
}