/*
 *
 */
package main;

import controller.ControllerFacade;
import controller.IController;
import model.IModel;
import model.ModelFacade;
import view.IView;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

	private static final int startX = 4;
	private static final int startY = 5;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		final IModel model = new ModelFacade("map.txt", startX, startY);
		final IView view = new ViewFacade(model.getMap(), model.getRockford());
		final IController controller = new ControllerFacade(view, model);
		view.setOrderPerformer(controller.getOrderPerformer());

		try {
			controller.start();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
