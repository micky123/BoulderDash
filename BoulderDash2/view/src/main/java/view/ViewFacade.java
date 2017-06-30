/*
 *
 */
package view;

import java.io.IOException;

import controller.IOrderPerformer;
import model.IMap;
import model.element.mobile.IRockford;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

	private View view;

	/**
	 * Instantiates a new view facade.
	 */
	public ViewFacade(IMap map, IRockford rockford) {
		try {
			this.view = new View(map, rockford);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see view.IView#displayMessage(java.lang.String)
	 */
	@Override
	public final void displayMessage(final String message) {
		this.view.displayMessage(message);
	}

	@Override
	public void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.view.setOrderPerformer(orderPerformer);
	}
}
