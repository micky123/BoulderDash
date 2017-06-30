/*
 *
 */

package model.element.mobile;

import model.element.Permeability;

public class Turn1 extends BehaviorTurn {

	public Turn1(final Monster monster) {
		super(monster);
	}

	@Override
	public void doNothing() {

		if (this.getMonster().getMap().getOnTheMapXY(this.getMonster().getX() + 1, this.getMonster().getY())
				.getPermeability() == Permeability.BLANK) {
			this.getMonster().moveRight();
		} else if (this.getMonster().getMap().getOnTheMapXY(this.getMonster().getX(), this.getMonster().getY() - 1)
				.getPermeability() == Permeability.BLANK) {
			this.getMonster().moveDown();
		} else if (this.getMonster().getMap().getOnTheMapXY(this.getMonster().getX() - 1, this.getMonster().getY())
				.getPermeability() == Permeability.BLANK) {
			this.getMonster().moveLeft();
		} else {
			this.getMonster().moveUp();
		}

	}
}
