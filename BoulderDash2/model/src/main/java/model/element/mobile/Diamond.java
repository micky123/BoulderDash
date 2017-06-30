/*
 *
 */
package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Diamond.
 */


public class Diamond extends Mobile implements Fallable {
	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(2, "Diamond.png");

	/**
	 * Instantiates a new Diamond.
	 *
	 * @param x the x
	 * @param y the y
	 * @param map the map
	 */


	Diamond(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.DIAMOND);
	}
	public static Sprite getDiamondSprite() {
		return SPRITE;
	}

	@Override
	public void fall(){
		//if(this.getMap().getOnTheMapXY().getPermeability() == Permeability.DIAMOND)
		while(this.getMap().getOnTheMapXY(this.getX(), this.getY()+1).getPermeability() == Permeability.BLANK) {
			super.moveDown();
			System.out.println("coucou");
		}
	}
}
