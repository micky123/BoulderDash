package controller;

import java.io.IOException;

/**
 * The Interface IOrderPerformer.
 */
public interface IOrderPerformer {

	/**
	 * Order perform.
	 *
	 * @param userOrder the user order
	 */
	void orderPerform(UserOrder userOrder) throws IOException;
}
