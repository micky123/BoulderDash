/*
 * 
 */
package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Wall.
 */
public class Wall extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(4, "Wall.png");

	/**
	 * Instantiates a new wall.
	 */
	Wall(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.WALL);
	}

	/**
	 * Gets the rock sprite.
	 *
	 * @return the rock sprite
	 */
	public static Sprite getWallSprite() {
		return SPRITE;
	}
}