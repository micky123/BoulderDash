/*
 * 
 */
package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Border.
 */
public class Border extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(5, "Border.png");

	/**
	 * Instantiates a new border.
	 */
	Border(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.BORDER);
	}

	/**
	 * Gets the rock sprite.
	 *
	 * @return the rock sprite
	 */
	public static Sprite getBorderSprite() {
		return SPRITE;
	}
}