package lifeform;

public class Human extends LifeForm {

  private int armor;

  /**
   * Creates an instance of Human with a default attack strength of 5.
   *
   * @param name The human's name.
   * @param lifePoints The human's LifePoints.
   * @param armor The human's armor.
   */
  public Human(String name, int lifePoints, int armor) {
    super(name, lifePoints, 5);
    this.armor = armor > 0 ? armor : 0;
  }

  @Override
  public void takeHit(int damage) {
    damage -= armor;
    if (damage > 0) {
      super.takeHit(damage);
    }
  }

  /**
   * @return current armor points.
   */
  public int getArmorPoints() {
    return armor;
  }

  /**
   * Sets armor points. Armor points cannot be less than 0. If a value less than 0
   * is given, the armor points remain unchanged.
   *
   * @param points
   */
  public void setArmorPoints(int points) {
    if (points > 0) {
      armor = points;
    }
  }
}
