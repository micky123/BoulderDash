/*
 *
 */
package controller;

import java.util.ArrayList;

import model.IModel;
import model.element.mobile.Fallable;
import model.element.mobile.IRockford;
import view.IView;

/**
 * The Class Controller.
 */
public class Controller implements IController, IOrderPerformer {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/** The stack order. */
	private UserOrder stackOrder;

	/** The speed. */
	private static int speed = 220;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setModel(model);
		this.setView(view);
		this.clearStackOrder();
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private IView getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	private IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Gets the stack order.
	 *
	 * @return the stack order
	 */
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Sets the stack order.
	 *
	 * @param stackOrder
	 *            the new stack order
	 */
	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Start.
	 */
	@Override
	public void start() throws InterruptedException {
		final IRockford rockford = this.getModel().getRockford();
		while (rockford.isAlive()) {
			while (rockford.isAlive() & !rockford.isWin()) {
				Thread.sleep(speed);
				this.manageOrder();
				this.manageFallables();
			}
			if (rockford.isAlive()) {
				this.getView().displayMessage("You win !\nNext map is loading...");
				rockford.setWin(false);
				if (!this.getModel().nextMap()) {
					this.getView().displayMessage("Congrats, you have completed all the levels !");
					System.exit(0);
				}
			} else {
				this.getView().displayMessage("You loose bro !");
				System.exit(0);
			}
		}
	}


	public void manageFallables() {
		final ArrayList<Fallable> fallables = new ArrayList<Fallable>();
		for(int i=0; i < this.getModel().getMap().getWidth(); i++){
			for(int j=0; j < this.getModel().getMap().getHeight(); j++){
				if(this.getModel().getMap().getOnTheMapXY(i, j) instanceof Fallable) {
					fallables.add((Fallable) this.getModel().getMap().getOnTheMapXY(i, j));
				}
			}
		}

		for(final Fallable fallable : fallables){
			fallable.fall();
		}
	}

	private void manageOrder() {
		switch (this.getStackOrder()) {
		case UP:
			this.getModel().getRockford().moveUp();
			break;
		case DOWN:
			this.getModel().getRockford().moveDown();
			break;
		case LEFT:
			this.getModel().getRockford().moveLeft();
			break;
		case RIGHT:
			this.getModel().getRockford().moveRight();
			break;
		case NOP:
		default:
			this.getModel().getRockford().doNothing();
			break;
		}
		this.clearStackOrder();
	}

	/**
	 * Clear stack order.
	 */
	public void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/**
	 * Order perform.
	 *
	 * @param userOrder
	 *            the user order
	 */
	@Override
	public void orderPerform(final UserOrder userOrder) {
		this.setStackOrder(userOrder);
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}

}
