/* *
 */
package model.element.mobile;

import model.IMap;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Monster objects.
 */
public abstract class MobileFactory {
	/** The sprite butterfly. */
	private static final Sprite SPRITE_BUTTERFLY = Butterfly.getButterflySprite();
	/** The sprite bat. */
	private static final Sprite SPRITE_BAT = Bat.getBatSprite();
	/** The sprite Diamond. */
	private static final Sprite SPRITE_DIAMOND = Diamond.getDiamondSprite();
	/** The sprite Rock . */
	private static final Sprite SPRITE_ROCK = Rock.getRockSprite();
	/** The Constant BLANK. */
	private static final Sprite SPRITE_BLANK = Blank.getBlankSprite();
	/** The Constant WALL. */
	private static final Sprite SPRITE_WALL = Wall.getWallSprite();
	/** The Constant EXIT. */
	private static final Sprite SPRITE_EXIT = Exit.getExitSprite();
	/** The Constant BORDER. */
	private static final Sprite SPRITE_BORDER = Border.getBorderSprite();
	/** The Constant DIRT. */
	private static final Sprite SPRITE_DIRT = Dirt.getDirtSprite();

	/**
	 * Creates a new Monster object.
	 *
	 * @return the monster
	 */
	public static Monster createButterfly(final int x, final int y, IMap map) {
		return new Butterfly(x, y, map);
	}

	/**
	 * Creates a new Monster object.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the diamond
	 */
	//
	public static Diamond createDiamond(final int x, final int y, IMap map) {
		return new Diamond(x, y, map);
	}

	/**
	 * Creates a new Monster object.
	 *
	 * @return the rock
	 */
	public static Rock createRock(final int x, final int y, IMap map) {
		return new Rock(x, y, map);
	}

	/**
	 * Create a new Bat.
	 *
	 * @return the monster
	 */
	public static Monster createBat(final int x, final int y, IMap map) {
		return new Bat(x, y, map);
	}

	/**
	 * Creates a new Monster object.
	 *
	 * @return the dirt
	 */
	public static Dirt createDirt(final int x, final int y, IMap map) {
		return new Dirt(x, y, map);
	}

	/**
	 * Creates a new Monster object.
	 *
	 * @return the exit
	 */
	public static Exit createExit(final int x, final int y, IMap map) {
		return new Exit(x, y, map);
	}

	/**
	 * Creates a new Monster object.
	 *
	 * @return the blank
	 */
	public static Blank createBlank(final int x, final int y, IMap map) {
		return new Blank(x, y, map);
	}

	/**
	 * Creates a new Monster object.
	 *
	 * @return the wall
	 */
	public static Wall createWall(final int x, final int y, IMap map) {
		return new Wall(x, y, map);
	}

	/**
	 * Creates a new Border object.
	 *
	 * @return the border
	 */
	public static Border createBorder(final int x, final int y, IMap map) {
		return new Border(x, y, map);
	}

	/**
	 * Gets the from file symbol.
	 *
	 * @param fileSymbol
	 *            the file symbol
	 * @return the from file symbol
	 */
	public static IMobile getFromFileSymbol(final char fileSymbol, int x, int y, IMap map) {
		switch (Integer.parseInt(String.valueOf(fileSymbol))) {
		case 0:
			return createDirt(x, y, map);
		case 1:
			return createDirt(x, y, map);
		case 2:
			return createDiamond(x, y, map);
		case 3:
			return createBlank(x, y, map);
		case 4:
			return createWall(x, y, map);
		case 5:
			return createBorder(x, y, map);
		case 6:
			return createRock(x, y, map);
		case 7:
			return createExit(x, y, map);
		case 8:
			return createButterfly(x, y, map);
		case 9:
		default:
			return createBat(x, y, map);
		}
	}
}