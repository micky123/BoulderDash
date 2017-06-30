/*
 *
 */
package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Butterfly.
 */
public class Butterfly extends Monster {
	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(8, "Butterfly.png");

	/**
	 * Instantiates a new Butterfly.
	 *
	 * @param map the map
	 */
	Butterfly(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.MONSTER);
	}

	/**
	 * Gets the butterfly sprite.
	 *
	 * @return the butterfly sprite
	 */
	public static Sprite getButterflySprite() {
		return SPRITE;
	}
	@Override
	public void die(){
		this.Explose();
	}

}
