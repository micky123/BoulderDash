package controller;

/**
 * The Interface IController.
 */
public interface IController {

	/**
	 * Start.
	 */
	public void start() throws InterruptedException;

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	IOrderPerformer getOrderPerformer();

}
