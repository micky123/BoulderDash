/*
 *
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.IMap;
import model.element.mobile.IRockford;

// TODO: Auto-generated Javadoc
/**
 * The Class MapDAO.
 */
public abstract class MapDAO extends AbstractDAO {

	/** The sql Map by id. */
	private static String sqlMapById = "{call findMapById(?)}";

	/** The sql Rockford. */
	private static String sqlGetRockford = "{call findRockford(?)}";

	/** The sql insertCells. */
	private static String sqlInsertCells = "{call insertCells(?,?,?,?)}";

	/** The sql insertMap */
	private static String dslinsertMap = "{call insertMap(?,?,?,?)}";

	/** The id column index. */
	private static int idColumnIndex = 1;

	/** The name column index. */
	private static int nameColumnIndex = 2;

	/**
	 * Gets the map by id.
	 *
	 * @param id
	 *            the id
	 * @return the map by id
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static IMap getMapbyId(final int id) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlMapById);
		final IMap map = null;
		callStatement.setInt(1, id);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				// map = new Map(result.getInt(idColumnIndex),
				// result.getString(nameColumnIndex));
			}
			result.close();
		}
		return map;
	}

	private static void insertCells(final int x,final int y, final int map_id, final int sprite_id) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlInsertCells);
		callStatement.setInt(1, x);
		callStatement.setInt(2, y);
		callStatement.setInt(3, map_id);
		callStatement.setInt(4, sprite_id);
		callStatement.execute();
	}


	public static void insertMap(final String name,final int width, final int height, final int diamondsLeft) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlInsertCells);
		callStatement.setString(1, name);
		callStatement.setInt(2, width);
		callStatement.setInt(3, height);
		callStatement.setInt(4, diamondsLeft);
		callStatement.execute();
	}
	/**
	 * Gets Rockford.
	 *
	 * @param name
	 *            the name
	 * @return the example by name
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static IRockford getRockford(final String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlGetRockford);
		final IRockford rockford = null;

		callStatement.setString(1, name);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				// rockford = new Example(result.getInt(idColumnIndex),
				// result.getString(nameColumnIndex));
			}
			result.close();
		}
		return rockford;
	}

}
