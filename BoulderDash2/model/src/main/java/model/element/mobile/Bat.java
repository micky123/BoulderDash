/*
 *
 */

package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Bat.
 */
public class Bat extends Monster {
	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(9, "Bat.png");

	/**
	 * Instantiates a new Bat.
	 *
	 * @param map the map
	 */

	Bat(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.MONSTER);
	}

	/**
	 * Gets the bat sprite.
	 *
	 * @return the bat sprite
	 */
	public static Sprite getBatSprite() {
		return SPRITE;
	}

	/* (non-Javadoc)
	 * @see model.element.mobile.Mobile#die()
	 */
	@Override
	public void die(){
		this.Explose();
	}

}
