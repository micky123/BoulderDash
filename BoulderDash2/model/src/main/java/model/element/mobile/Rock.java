/*
 *
 */

package model.element.mobile;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Rock.
 */
public class Rock extends Mobile implements Fallable {
	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(6, "Rock.png");
	/**
	 * Instantiates a new Rock.
	 * @param x the x
	 * @param y the y
	 * @param map the map
	 */
	Rock(final int x, final int y, final IMap map) {
		super(x, y, SPRITE, map, Permeability.ROCK);
	}
	public static Sprite getRockSprite() {
		return SPRITE;
	}
	@Override
	public void fall(){
		//if(this.getMap().getOnTheMapXY().getPermeability() == Permeability.DIAMOND)
		while(this.getMap().getOnTheMapXY(this.getX(), this.getY()+1).getPermeability() == Permeability.BLANK) {
			super.moveDown();
		}
	}}