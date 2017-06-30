package model;
/*
 *
 */

import model.element.mobile.IRockford;

/*
 *
 */

public interface IModel {

	public IRockford getRockford();

	public IMap getMap();

	public boolean nextMap();
}
