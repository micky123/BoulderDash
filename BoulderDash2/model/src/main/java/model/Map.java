/*
 *
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import model.element.IElement;
import model.element.mobile.IMobile;
import model.element.mobile.MobileFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map extends Observable implements IMap {

	/** The width. */
	private int width;

	/** The height. */
	private int height;

	/** The diamond left. */
	public int diamondLeft;

	/** The on the map. */
	private IMobile[][] onTheMap;

	/**
	 * Instantiates a new map.
	 *
	 * @param mapNumber
	 *            the map number
	 */

	public Map(final int width, final int height, final int diamondsLeft, final IMobile[][] onTheMap) {
		this.setHeight(height);
		this.setWidth(width);
		this.setDiamondsLeft(diamondsLeft);
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getHeight(); j++) {
				this.setOnTheMapXY(onTheMap[i][j], i, j);
			}
		}
	}

	/**
	 * Instantiates a new map.
	 *
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 */
	public Map(final String fileName) throws IOException {
		super();
		try {
			this.loadFile(fileName);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		// TODO : insert the map in the DB
	}

	/**
	 * Load file.
	 *
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 */
	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;
		int y = 0;
		line = buffer.readLine();
		this.setWidth(Integer.parseInt(line));
		line = buffer.readLine();
		this.setHeight(Integer.parseInt(line));
		line = buffer.readLine();
		this.setDiamondsLeft(Integer.parseInt(line));
		this.onTheMap = new IMobile[this.getWidth()][this.getHeight()];
		line = buffer.readLine();
		while (line != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				this.setOnTheMapXY(MobileFactory.getFromFileSymbol(line.toCharArray()[x], x, y, this), x, y);
			}
			line = buffer.readLine();
			y++;
		}
		buffer.close();

	}

	private void loadFromDB(final int mapNumber) {
		// TODO : get the map
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IMap#getOnTheMapXY(int, int)
	 */
	@Override
	public IMobile getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	@Override
	public void setOnTheMapXY(final IMobile element, final int x, final int y) {
		this.onTheMap[x][y] = element;
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IMap#setMobileHasChanged()
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IMap#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IMap#getWidth()
	 */
	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param widht
	 *            the new width
	 */
	public void setWidth(final int width) {
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IMap#getHeight()
	 */
	@Override
	public int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	public void setHeight(final int height) {
		this.height = height;
	}

	/**
	 * Gets the diamonds left.
	 *
	 * @return the diamonds left
	 */
	public int getDiamondsLeft() {
		return this.diamondLeft;
	}

	/**
	 * Sets the diamonds left.
	 *
	 * @param diamondLeft
	 *            the new diamonds left
	 */
	public void setDiamondsLeft(final int diamondLeft) {
		this.diamondLeft = diamondLeft;
	}

	public IElement getBackground() {
		return MobileFactory.createBlank(0, 0, this);
	}

}
