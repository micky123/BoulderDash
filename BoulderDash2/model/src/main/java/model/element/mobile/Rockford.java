/*
 *
 */
package model.element.mobile;

import java.io.IOException;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Rockford.
 */
public class Rockford extends Mobile implements IRockford {

	/** The Constant spriteFront. */
	private final static Sprite spriteFront = new Sprite(0, "RockfordFront.png");

	/** The Constant spriteBack. */
	private final static Sprite spriteBack = new Sprite(0, "RockfordBack.png");

	/** The Constant spriteLeft. */
	private final static Sprite spriteLeft = new Sprite(0, "RockfordLeft.png");

	/** The Constant spriteRight. */
	private final static Sprite spriteRight = new Sprite(0, "RockfordRight.png");

	/** The Constant spriteDead. */
	private final static Sprite spriteDead = new Sprite(0, "RockfordDead.png");

	private boolean win = false;



	@Override
	public void setWin(final boolean win) {
		this.win = win;
	}

	/**
	 * Instantiates a new rockford.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param map
	 *            the map
	 * @throws IOException
	 */
	public Rockford(final int x, final int y, final IMap map) throws IOException {
		super(x, y, spriteFront, map, Permeability.ROCK);
		spriteBack.loadImage();
		spriteLeft.loadImage();
		spriteRight.loadImage();
		spriteDead.loadImage();
	}

	private Boolean isMovePossible(final int x, final int y) {
		switch (this.getMap().getOnTheMapXY(x, y).getPermeability()) {
		case BLANK:
		case DIRT:
		case DIAMOND:
		case EXIT:
			return true;
		default:
			return false;
		}
	}

	private Boolean isExit(final int x, final int y) {
		return this.getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.EXIT;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IRockford#moveLeft()
	 */
	@Override
	public void moveLeft() {
		if (this.isExit(this.getX() - 1, this.getY())) {
			if (this.getMap().getDiamondsLeft() == 0) {
				this.setWin(true);
			}
			this.setSprite(spriteLeft);
			super.moveLeft();
			this.setSprite(spriteFront);
		} else if (this.isMovePossible(this.getX() - 1, this.getY())) {

			this.transformToBlank(this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()));
			super.moveLeft();
			this.pickUpDiamond();
			this.setSprite(spriteLeft);

		} else {
			this.doNothing();
			this.setSprite(spriteFront);
		}
	}

	private void transformToBlank(final IMobile mobile) {
		mobile.setSprite(Blank.getBlankSprite());
		mobile.setPermeability(Permeability.BLANK);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IRockford#moveRight()
	 */
	@Override
	public void moveRight() {
		if (this.isExit(this.getX() + 1, this.getY())) {
			if (this.getMap().getDiamondsLeft() == 0) {
				this.setWin(true);
			}
			this.setSprite(spriteRight);
			super.moveRight();
			this.setSprite(spriteFront);
		} else if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.transformToBlank(this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()));			// System.out.println(this.getMap().getOnTheMapXY(this.getX() + 1,
			// this.getY()).toString());
			super.moveRight();
			this.setSprite(spriteRight);
			this.pickUpDiamond();
		} else {
			this.doNothing();
			this.setSprite(spriteFront);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IRockford#moveUp()
	 */
	@Override
	public void moveUp() {
		if (this.isExit(this.getX(), this.getY()-1)) {
			if (this.getMap().getDiamondsLeft() == 0) {
				this.setWin(true);
			}
			this.setSprite(spriteBack);
			super.moveUp();
			this.setSprite(spriteFront);
		} else if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.transformToBlank(this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1));			super.moveUp();
			this.setSprite(spriteBack);
			this.pickUpDiamond();
		} else {
			this.doNothing();
			this.setSprite(spriteFront);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IRockford#moveDown()
	 */
	@Override
	public void moveDown() {
		if (this.isExit(this.getX(), this.getY()+1)) {
			if (this.getMap().getDiamondsLeft() == 0) {
				this.setWin(true);
			}
			this.setSprite(spriteFront);
			super.moveDown();
		} else if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.transformToBlank(this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1));
			super.moveDown();
			this.setSprite(spriteFront);
			this.pickUpDiamond();
		} else {
			this.doNothing();
			this.setSprite(spriteFront);
		}
	}

	@Override
	protected void die() {
		super.die();
		this.setSprite(spriteDead);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.element.mobile.IRockford#doNothing()
	 */
	@Override
	public void doNothing() {
		super.doNothing();
		this.setSprite(spriteFront);
	}

	@Override
	public boolean isWin() {
		return this.win;
	}

	@Override
	public void pickUpDiamond() {
		if(this.getMap().getOnTheMapXY(this.getX(),this.getY()).getPermeability() == Permeability.DIAMOND) {
			this.getMap().getOnTheMapXY(this.getX(),this.getY()).setSprite(Blank.getBlankSprite());
			this.getMap().setDiamondsLeft(this.getMap().getDiamondsLeft()-1);
		}

	}


}
