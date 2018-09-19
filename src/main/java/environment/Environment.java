package environment;

import lifeform.LifeForm;

/**
 * An Environment to hold all the cells.
 * 
 * SWE200 Programmers: Ryan Bruno, Richard Clapper
 */

public class Environment {

  public Cell[][] theCells;

  /**
   * Creates the Environment with the given width and height.
   * 
   * @param width
   * @param height
   */
  public Environment(int width, int height) {
    theCells = new Cell[width][height];

    for (int i = 0; i < theCells.length; i++) {
      for (int j = 0; j < theCells[i].length; j++) {
        theCells[i][j] = new Cell();
      }
    }
  }

  /**
   * Adds LifeForm to the Cell at the given location. Will not add LifeForm if
   * cell in invalid or already taken.
   * 
   * @param row
   * @param col
   * @param entity
   * @return
   */
  public boolean addLifeForm(LifeForm entity, int row, int col) {
    if (row >= theCells.length || col >= theCells[0].length || row < 0 || col < 0) {
      return false;
    }
    return theCells[row][col].addLifeForm(entity);
  }

  /**
   * Remove the Lifeform in the given row and col.
   * 
   * @param row
   * @param col
   */
  public void removeLifeForm(int row, int col) {
    if (row >= theCells.length || col >= theCells[0].length || row < 0 || col < 0) {
      return;
    }
    theCells[row][col].removeLifeForm();
  }

  /**
   * 
   * @param row
   * @param col
   * @return the Lifeform in the given row and col.
   */
  public LifeForm getLifeForm(int row, int col) {
    return theCells[row][col].getLifeForm();
  }

}