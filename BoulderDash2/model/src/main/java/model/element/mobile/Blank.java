/*
 * 
 */
package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Blank.
 */
public class Blank extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(3, "Blank.png");

	/**
	 * Instantiates a new blank.
	 */
	Blank(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.BLANK);
	}

	/**
	 * Gets the rock sprite.
	 *
	 * @return the rock sprite
	 */
	public static Sprite getBlankSprite() {
		return SPRITE;
	}
}