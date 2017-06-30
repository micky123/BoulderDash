/*
 *
 */
package model;

import java.io.IOException;
import java.sql.SQLException;

import model.dao.MapDAO;
import model.element.mobile.IRockford;
import model.element.mobile.Rockford;

/**
 * The Class ModelFacade.
 */
public class ModelFacade implements IModel {

	private int mapLevel = 0;

	/** The map. */
	private IMap map;

	/** The rockford. */
	private IRockford rockford;

	/**
	 * Instantiates a new model facade.
	 *
	 * @param rockfordStartX
	 *            the rockford start X
	 * @param rockfordStartY
	 *            the rockford start Y
	 * @throws IOException
	 */
	public ModelFacade(final String fileName, final int rockfordStartX, final int rockfordStartY) {
		try {
			this.setMap(new Map(fileName));
			this.setRockford(new Rockford(rockfordStartX, rockfordStartY, this.getMap()));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ModelFacade(final int rockfordStartX, final int rockfordStartY) throws SQLException {
		try {
			this.setRockford(new Rockford(rockfordStartX, rockfordStartY, this.getMap()));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setMap(MapDAO.getMapbyId(0));
	}

	@Override
	public boolean nextMap() {
		this.mapLevel++;
		try {
			this.setMap(MapDAO.getMapbyId(this.mapLevel));
		} catch (final SQLException e) {
			return false;
		}
		this.getMap().setMobileHasChanged();
		return true;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the new map
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	@Override
	public IMap getMap() {
		return this.map;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.IModel#getRockford()
	 */
	@Override
	public IRockford getRockford() {
		return this.rockford;
	}

	/**
	 * Sets the rockford.
	 *
	 * @param rockford
	 *            the new rockford
	 */
	public void setRockford(final IRockford rockford) {
		this.rockford = rockford;
	}
}
