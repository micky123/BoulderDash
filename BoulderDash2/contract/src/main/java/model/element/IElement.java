/*
 *
 */
package model.element;

import java.awt.Image;

import fr.exia.showboard.ISquare;

// TODO: Auto-generated Javadoc
/**
 * The Interface IElement.
 */
public interface IElement extends ISquare {

	/**
	 * Gets the sprite.
	 *
	 * @return the sprite
	 */
	public Sprite getSprite();

	void setSprite(Sprite sprite);

	/**
	 * Gets the permeability.
	 *
	 * @return the permeability
	 */
	public Permeability getPermeability();

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.exia.showboard.ISquare#getImage()
	 */

	@Override
	public Image getImage();
}
