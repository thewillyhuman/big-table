package io.github.thewilly.bigtable.core.mutation;

import io.github.thewilly.bigtable.core.models.TableImpl;
import io.github.thewilly.bigtable.core.models.TableRow;

/** The type Table mutation. */
public class TableMutation {

  private final TableImpl _tableToMutate;

  private TableMutation(TableImpl tableToMutate) {
    _tableToMutate = tableToMutate;
  }

  /**
   * Create table mutation.
   *
   * @param <T> the type parameter
   * @param table the table
   * @return the table mutation
   */
  public static <T extends Comparable<T>> TableMutation create(TableImpl<T> table) {
    return new TableMutation(table);
  }

  /**
   * Add row boolean.
   *
   * @param <T> the type parameter
   * @param row the row
   * @return the boolean
   */
  public <T extends Comparable<T>> boolean addRow(TableRow row) {
    if (row.getCells().length == _tableToMutate.getNumberOfColumns()) {
      _tableToMutate.readAllRows().add(row);
      return true;
    }
    return false;
  }

  /**
   * Remove row boolean.
   *
   * @param <T> the type parameter
   * @param row the row
   * @return the boolean
   */
  public <T extends Comparable<T>> boolean removeRow(TableRow row) {
    return _tableToMutate.readAllRows().remove(row);
  }
}
