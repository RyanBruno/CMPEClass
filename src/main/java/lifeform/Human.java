package lifeform;

public class Human extends LifeForm {

  private int armor;

  public Human(String name, int lifePoints, int armor) {
    super(name, lifePoints);
    this.armor = armor > 0 ? armor : 0;
  }

  @Override
  public void takeHit(int damage) {
    armor -= damage;
    if (armor < 0) {
      super.takeHit(armor * -1);
      armor = 0;
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
