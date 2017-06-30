package view;

import controller.IOrderPerformer;

/**
 * The Interface IView.
 */
public interface IView {

	/**
	 * Display message.
	 *
	 * @param message
	 *            the message
	 */
	void displayMessage(String message);

	void setOrderPerformer(IOrderPerformer orderPeformer);
}
