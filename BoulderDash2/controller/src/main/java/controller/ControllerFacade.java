/*
 *
 */
package controller;

import java.io.IOException;

import model.IModel;
import view.IView;

public class ControllerFacade implements IOrderPerformer, IController {

	private Controller controller;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public ControllerFacade(final IView view, final IModel model) {
		this.setController(new Controller(view, model));
	}

	public IController getController() {
		return this.controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void orderPerform(UserOrder userOrder) throws IOException {
		this.getController().getOrderPerformer().orderPerform(userOrder);
	}

	@Override
	public void start() throws InterruptedException {
		this.getController().start();
	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		return this.getController().getOrderPerformer();
	}

}
