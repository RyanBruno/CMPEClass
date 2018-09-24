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
    assertEquals(500, human.getArmorPoints());
    human.takeHit(550);
    assertEquals(0, human.getArmorPoints());
    assertEquals(50, human.getCurrentLifePoints());

  }

  public void testInvalidArmorPoints() {
    Human human = new Human("Bob", 100, -100);
    assertEquals(0, human.getArmorPoints());
    human.setArmorPoints(-10);
    assertEquals(0, human.getArmorPoints());
  }
}
