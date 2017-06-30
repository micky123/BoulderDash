/*
 *
 */

package model.element.mobile;

import java.util.ArrayList;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Monster.
 */
public abstract class Monster extends Mobile {

	/** The behaviors. */
	private ArrayList<IBehaviors> behaviors;

	/**
	 * Instantiates a new monster.
	 *
	 * @param x the x
	 * @param y the y
	 * @param sprite the sprite
	 * @param map the map
	 * @param permeability the permeability
	 */
	public Monster(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		super(x, y, sprite, map, permeability);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Explose.
	 */
	public void Explose(){
		if (this.isAlive()==false) {
			final Diamond diamond = new Diamond(this.getX(), this.getY(), this.getMap());
			final Diamond diamond2 = new Diamond(this.getX()-1, this.getY(), this.getMap());
			final Diamond diamond3 = new Diamond(this.getX()+1, this.getY(), this.getMap());
			final Diamond diamond4 = new Diamond(this.getX(), this.getY()+1, this.getMap());
			final Diamond diamond5 = new Diamond(this.getX()+1, this.getY()+1, this.getMap());
			final Diamond diamond6 = new Diamond(this.getX()-1, this.getY()+1, this.getMap());
			final Diamond diamond7 = new Diamond(this.getX(), this.getY()-1, this.getMap());
			final Diamond diamond8 = new Diamond(this.getX()+1, this.getY()-1, this.getMap());
			final Diamond diamond9 = new Diamond(this.getX()-1, this.getY()-1, this.getMap());
		}
		else {
			this.doNothing();
		}
	}
	/**
	 * Motionless element.
	 *
	 * @param sprite the sprite
	 */
	public void MotionlessElement(final Sprite sprite){

	}
}
