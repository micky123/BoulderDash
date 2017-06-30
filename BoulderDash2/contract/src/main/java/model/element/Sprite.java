/*
 *
 */

package model.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class Sprite.
 */
public class Sprite {

	/** The image. */
	private Image image;

	/** The image name. */
	private String imageName;

	/** The image loaded. */
	private boolean imageLoaded;

	/** The console image. */
	private int consoleImage;

	/**
	 * Instantiates a new sprite.
	 *
	 * @param character
	 *            the character
	 * @param imageName
	 *            the image name
	 */
	public Sprite(final int character, final String imageName) {
		this.setConsoleImage(character);
		this.setImageName(imageName);
	}

	/**
	 * Instantiates a new sprite.
	 *
	 * @param character
	 *            the character
	 */
	public Sprite(final int character) {
		this(character, "noimage.jpg");
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return this.image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image
	 *            the new image
	 */
	public void setImage(final Image image) {
		this.image = image;
	}

	/**
	 * Gets the image name.
	 *
	 * @return the image name
	 */
	public String getImageName() {
		return this.imageName;
	}

	/**
	 * Sets the image name.
	 *
	 * @param imageName
	 *            the new image name
	 */
	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	/**
	 * Checks if is image loaded.
	 *
	 * @return true, if is image loaded
	 */
	public boolean isImageLoaded() {
		return this.imageLoaded;
	}

	/**
	 * Sets the image loaded.
	 *
	 * @param imageLoaded
	 *            the new image loaded
	 */
	public void setImageLoaded(final boolean imageLoaded) {
		this.imageLoaded = imageLoaded;
	}

	/**
	 * Gets the console image.
	 *
	 * @return the console image
	 */
	public int getConsoleImage() {
		return this.consoleImage;
	}

	/**
	 * Sets the console image.
	 *
	 * @param consoleImage
	 *            the new console image
	 */
	public void setConsoleImage(final int consoleImage) {
		this.consoleImage = consoleImage;
	}

	/**
	 * Load image.
	 *
	 * @throws IOException
	 */
	public void loadImage() throws IOException {
		this.setImage(ImageIO.read(new File("images/" + this.getImageName())));
	}
}
