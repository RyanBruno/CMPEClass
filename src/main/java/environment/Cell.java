package environment;

import lifeform.LifeForm;

/**
 * SWE200 
 * Programmers: Ryan Bruno, Richard Clapper
 */
public class Cell {

  private LifeForm entity;

  /**
   * Added the LifeForm to the Cell. Does not add if already set.
   * 
   * @param entity the LifeForm held in the cell.
   * @return true if Lifeform has been set, false if not.
   */
  public boolean addLifeForm(LifeForm entity) {
    if (this.entity == null) {
      this.entity = entity;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Removes the entity.
   */
  public void removeLifeForm() {
    this.entity = null;
  }

  /**
   * @return the Lifeform of the cell.
   */
  public LifeForm getLifeForm() {
    return entity;
  }

}
