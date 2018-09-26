package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the LifeForm class.
 * 
 * SWE 200 Programmers: Ryan Bruno, Richard Capper
 */
public class TestLifeForm {

  @Test
  public void testInitialization() {
    LifeForm entity = new MockLifeForm("Bob", 40);
    assertEquals(40, entity.getCurrentLifePoints());
  }

  @Test
  public void testName() {
    LifeForm entity = new MockLifeForm("Bob", 40);
    assertEquals("Bob", entity.getName());
  }

  @Test
  public void testTakeHit() {
    LifeForm entity = new MockLifeForm("Bob", 40);
    entity.takeHit(10);
    assertEquals(30, entity.getCurrentLifePoints());
  }

  @Test
  public void testTakeHit2() {
    LifeForm entity = new MockLifeForm("Bob", 40);
    entity.takeHit(10);
    entity.takeHit(10);
    assertEquals(20, entity.getCurrentLifePoints());
  }

}
