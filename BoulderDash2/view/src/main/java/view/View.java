/*
 *
 */
package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import fr.exia.showboard.BoardFrame;
import model.IMap;
import model.element.mobile.IRockford;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View implements Runnable, KeyListener, IView {

	/** The map view. */
	private static int mapView = 10;

	/** The square size. */
	private static int squareSize = 28;

	/** The close view. */
	private Rectangle closeView;

	/** The map. */
	private IMap map;

	/** The rockford. */
	private IRockford rockford;

	/** The view. */
	private int view;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

	private BoardFrame boardFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param map
	 *            the map
	 * @param rockford
	 *            the rockford
	 * @throws IOException
	 */
	public View(final IMap map, final IRockford rockford) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		this.setRockford(rockford);
		this.getRockford().getSprite().loadImage();
		// this.setCloseView(new Rectangle(0, this.getRockford().getY(),
		// this.getMap().getWidth(), mapView));
		this.setCloseView(new Rectangle(0, 0, this.getMap().getWidth(), this.getMap().getHeight()));
		SwingUtilities.invokeLater(this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see view.IView#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */
	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;

	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public int getView() {
		return this.view;
	}

	public void setView(final int view) {
		this.view = view;
	}

	/**
	 * Gets the close view.
	 *
	 * @return the close view
	 */
	public Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * Sets the close view.
	 *
	 * @param closeView
	 *            the new close view
	 */
	public void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
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
	 * @throws IOException
	 */
	public void setMap(final IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * Gets the rockford.
	 *
	 * @return the rockford
	 */
	public IRockford getRockford() {
		return this.rockford;
	}

	/**
	 * Sets the rockford.
	 *
	 * @param rockford
	 *            the new rockford
	 */
	public void setRockford(final IRockford rockford) {
		this.rockford = rockford;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	public IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order performer.
	 *
	 * @param orderPerformer
	 *            the new order performer
	 */
	@Override
	public void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.boardFrame = new BoardFrame("Boulderdash");
		this.boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		this.boardFrame.setDisplayFrame(this.closeView);
		this.boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		this.boardFrame.setHeightLooped(false);
		this.boardFrame.addKeyListener(this);
		this.boardFrame.setFocusable(true);
		this.boardFrame.setFocusTraversalKeysEnabled(false);
		this.boardFrame.setLocation(0, 0);

		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.boardFrame.addSquare(this.getMap().getBackground(), x, y);

			}
		}
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.boardFrame.addPawn(this.map.getOnTheMapXY(x, y));

			}
		}
		this.boardFrame.addPawn(this.getRockford());

		this.getMap().getObservable().addObserver(this.boardFrame.getObserver());

		this.boardFrame.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(final KeyEvent keyEvent) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(View.keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(final KeyEvent e) {

	}
}
