/*
 *
 */

package model.element.mobile;

// TODO: Auto-generated Javadoc
/**
 * The Class BehaviorTurn.
 */
public abstract class BehaviorTurn implements IBehaviors {

	private final Monster monster;

	public BehaviorTurn(final Monster monster) {
		this.monster = monster;

	}

	public Monster getMonster() {
		return this.monster;
	}
}
