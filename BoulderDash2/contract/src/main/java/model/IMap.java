/*
 *
 */
package model;

import java.util.Observable;

import model.element.IElement;
import model.element.mobile.IMobile;

public interface IMap {
	public int getWidth();

	public int getHeight();

	public IMobile getOnTheMapXY(int x, int y);

	public void setMobileHasChanged();

	public Observable getObservable();

	public void setOnTheMapXY(final IMobile element, final int x, final int y);

	public void setDiamondsLeft(int diams);

	public int getDiamondsLeft();

	public IElement getBackground();

}
