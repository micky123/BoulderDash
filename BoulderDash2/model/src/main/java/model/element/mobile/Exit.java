/*
 * 
 */
package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Exit.
 */
public class Exit extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(7, "Exit.png");

	/**
	 * Instantiates a new exit.
	 */
	Exit(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.EXIT);
	}

	/**
	 * Gets the rock sprite.
	 *
	 * @return the rock sprite
	 */
	public static Sprite getExitSprite() {
		return SPRITE;
	}
}