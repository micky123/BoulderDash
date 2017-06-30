/*
 *
 */
package model.element.mobile;

/*
 *
 */
import java.awt.Point;

import fr.exia.showboard.IBoard;
import model.IMap;
import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Mobile.
 */
public abstract class Mobile extends Element implements IMobile {

	/** The position. */
	private Point position;

	/** The alive. */
	private boolean alive = true;

	/** The board. */
	private IBoard board;

	/** The map. */
	private IMap map;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	public Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.position = new Point();
		this.setMap(map);
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	public Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#doNothing()
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	protected void setHasMoved() {

		this.getMap().setMobileHasChanged();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#getX()
	 */
	@Override
	public int getX() {
		return this.getPosition().x;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#getY()
	 */
	@Override
	public int getY() {
		return this.getPosition().y;

	}

	public void setX(final int x) {
		this.getPosition().x = x;
	}

	public void setY(final int y) {
		this.getPosition().y = y;
	}

	protected void die() {
		this.alive = false;
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#getPosition()
	 */
	@Override
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position
	 *            the new position
	 */
	public void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	IBoard getBoard() {
		return this.board;
	}

	/**
	 * Sets the board.
	 *
	 * @param board
	 *            the new board
	 */
	public void setBoard(final IBoard board) {
		this.board = board;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the new map
	 */
	public void setMap(final IMap map) {
		this.map = map;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IMobile#isAlive()
	 */
	@Override
	public boolean isAlive() {
		return this.alive;
	}

	/**
	 * Checks if is crashed.
	 *
	 * @return true, if is crashed
	 */
	public boolean isCrashed() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.ROCK;
	}

	@Override
	public void setSprite(Sprite sprite) {
		super.setSprite(sprite);
	}

}
