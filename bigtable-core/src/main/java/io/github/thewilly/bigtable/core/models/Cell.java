package io.github.thewilly.bigtable.core.models;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A cell is a unit of storage for bigtable, it consists of the following fields: 1) column
 * qualifier 2) timestamp 3) number of versions 4) versions
 */
public interface Cell extends Serializable, Comparable<Cell> {

  /** The Default comparator. */
  Comparator<Cell> DEFAULT_COMPARATOR = Comparator.comparing(Cell::getColumnQualifier);

  /**
   * Gets the column qualifier. The column qualifier is the unique string that identifies a column.
   *
   * @return the column qualifier as a String.
   */
  String getColumnQualifier();

  /**
   * Gets the time stamp. The timestamp represent the last univresal time when the cell was updated.
   *
   * @return the time stamp as a long.
   */
  long getTimeStamp();

  /**
   * Gets the number of versions that the cell stores.
   *
   * @return the number of versions as an Integer.
   */
  int getNumberOfVersions();

  /**
   * Gets the data versions including the current valid one.
   *
   * @return the data contained by the cell.
   */
  VersionableDataArray getDataVersions();

  /**
   * Adds a new data version to the cell by invalidating the previous one and seting this one as the
   * valid current one.
   *
   * @param data is the data version to add to the cell.
   * @return the previous version of the data stored or null if none.
   */
  VersionableData addDataVersion(VersionableData data);
}
