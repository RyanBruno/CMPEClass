package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the LifeForm class.
 * 
 * SWE 200 Programmers: Ryan Bruno, Richard Capper
 */
public class TestLifeForm {

  /**
   * Tests the initialization of LifeForm.
   */
  @Test
  public void testInitialization() {
    LifeForm entity = new LifeForm("Bob", 40);
    assertEquals("Bob", entity.getName());
    assertEquals(40, entity.getCurrentLifePoints());
  }

}
