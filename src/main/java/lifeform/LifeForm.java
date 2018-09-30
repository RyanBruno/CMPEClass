package lifeform;

/**
 * Holds information about a LifeForm.
 *
 * SWE200 Programmers: Ryan Bruno, Richard Clapper
 */
public abstract class LifeForm {

  private String myName;

  private int currentLifePoints;

  /**
   * Creates and instance of Lifeform.
   * 
   * @param name The name of the Lifeform
   * @param lifePoints The Starting lifepoints of the Lifeform
   */
  public LifeForm(String name, int lifePoints) {
    myName = name;
    currentLifePoints = lifePoints;
  }

  /**
   * @return the Lifeform's name.
   */
  public String getName() {
    return myName;
  }

  /**
   * @return the current life points.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * Reduced LifeForm's life points by the damage A LifeForm cannot have
   * life points less than zero.
   *
   * @param damage
   */
  public void takeHit(int damage) {
    currentLifePoints -= damage;
    if (currentLifePoints < 0) {
      currentLifePoints = 0;
    }
  }

}
