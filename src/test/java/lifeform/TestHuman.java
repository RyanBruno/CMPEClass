package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHuman {

  @Test
  public void testInitialization() {
    Human human = new Human("Bob", 100, 50);

    assertEquals(50, human.getArmorPoints());
    assertEquals(100, human.getCurrentLifePoints());
    assertEquals("Bob", human.getName());
  }

  @Test
  public void setArmorPoints() {
    Human human = new Human("Bob", 100, 50);

    assertEquals(50, human.getArmorPoints());
    human.setArmorPoints(40);
    assertEquals(40, human.getArmorPoints());
  }

  @Test
  public void getArmorPoints() {
    Human human = new Human("Bob", 100, 1000);

    assertEquals(1000, human.getArmorPoints());
    human.takeHit(500);
    assertEquals(1000, human.getArmorPoints());
    human.takeHit(1005);
    assertEquals(1000, human.getArmorPoints());
    assertEquals(95, human.getCurrentLifePoints());

  }

  @Test
  public void testInvalidArmorPoints() {
    Human human = new Human("Bob", 100, -100);
    assertEquals(0, human.getArmorPoints());
    human.setArmorPoints(-10);
    assertEquals(0, human.getArmorPoints());
  }

  @Test
  public void testDefaultAttackStrenght() {
    Human human = new Human("Bob", 100, 5);
    assertEquals(5, human.getAttackStrength());
  }

  @Test
  public void testArmorAbsorbed() {
    Human human = new Human("Bob", 100, 5);
    human.takeHit(4);
    assertEquals(100, human.getCurrentLifePoints());
  }

  @Test
  public void testArmorReduced() {
    Human human = new Human("Bob", 100, 5);
    human.takeHit(10);
    assertEquals(95, human.getCurrentLifePoints());
  }

  @Test
  public void testArmorEquals() {
    Human human = new Human("Bob", 100, 5);
    human.takeHit(5);
    assertEquals(100, human.getCurrentLifePoints());
  }
}
