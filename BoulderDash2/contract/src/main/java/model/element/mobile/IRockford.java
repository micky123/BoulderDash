/*
 *
 */
package model.element.mobile;

import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Interface IRockford.
 */
public interface IRockford extends IMobile {

	/**
	 * Gets the sprite.
	 *
	 * @return the sprite
	 */
	@Override
	Sprite getSprite();

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveLeft()
	 */
	@Override
	void moveLeft();

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveRight()
	 */
	@Override
	void moveRight();

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveUp()
	 */
	@Override
	void moveUp();

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveDown()
	 */
	@Override
	void moveDown();

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#doNothing()
	 */
	@Override
	void doNothing();

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#getY()
	 */
	@Override
	int getY();

	boolean isWin();

	public void setWin(final boolean win);

	void pickUpDiamond();
}
