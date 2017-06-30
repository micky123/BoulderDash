/*
 *
 */

package model.element.mobile;

import java.awt.Point;

import fr.exia.showboard.IPawn;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMobile.
 */
public interface IMobile extends IPawn {

	/**
	 * Move up.
	 */
	public void moveUp();

	/**
	 * Move left.
	 */
	public void moveLeft();

	/**
	 * Move down.
	 */
	public void moveDown();

	/**
	 * Move right.
	 */
	public void moveRight();

	/**
	 * Do nothing.
	 */
	public void doNothing();

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.exia.showboard.IPawn#getX()
	 */
	@Override
	public int getX();

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.exia.showboard.IPawn#getY()
	 */
	@Override
	public int getY();

	/**
	 * Checks if is alive.
	 *
	 * @return true, if is alive
	 */
	public boolean isAlive();

	@Override
	public Point getPosition();

	public Permeability getPermeability();

	public void setPermeability(Permeability permeability);

	public Sprite getSprite();

	public void setSprite(Sprite sprite);
}
