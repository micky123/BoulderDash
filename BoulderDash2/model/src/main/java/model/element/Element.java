package model.element;

import java.awt.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class Element.
 */
public abstract class Element implements IElement {

	/** The sprite. */
	private Sprite sprite;

	/** The permeability. */
	private Permeability permeability;

	/**
	 * Instantiates a new element.
	 *
	 * @param sprite
	 *            the sprite
	 * @param permeability
	 *            the permeability
	 */
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.IElement#getSprite()
	 */
	@Override
	public Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite
	 *            the new sprite
	 */
	@Override
	public void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.IElement#getPermeability()
	 */
	@Override
	public Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * Sets the permeability.
	 *
	 * @param permeability
	 *            the new permeability
	 */
	public void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.IElement#getImage()
	 */
	@Override
	public Image getImage() {
		return this.getSprite().getImage();
	}

}
