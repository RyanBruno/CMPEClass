package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;

/**
 * Tests the initialization of Environment.
 * 
 * SWE 200 Programmers: Ryan Bruno, Richard Capper
 */
public class TestEnvironment {

  @Test
  public void testInitialization() {
    Environment environment = new Environment(1, 1);
    assertNull(environment.theCells[0][0].getLifeForm());
  }

  /**
   * Tests the adding of a LifeForm.
   */
  @Test
  public void testAddLifeForm() {
    Environment environment = new Environment(10, 10);

    assertTrue(environment.addLifeForm(new LifeForm("Bob", 50), 4, 7));
    assertEquals("Bob", environment.theCells[4][7].getLifeForm().getName());

    assertFalse(environment.addLifeForm(new LifeForm("Jim", 60), 4, 7));
  }

  /**
   * Test if Environment handles out of bounds exceptions.
   */
  @Test
  public void testBorderCase() {
    Environment environment = new Environment(10, 10);
    assertTrue(environment.addLifeForm(new LifeForm("Bob", 50), 4, 7));
    assertFalse(environment.addLifeForm(new LifeForm("Jim", 50), 11, 7));
    assertTrue(environment.addLifeForm(new LifeForm("Obama", 5), 4, 1));
    assertFalse(environment.addLifeForm(new LifeForm("Richard", -1), -2, -7));
    assertFalse(environment.addLifeForm(new LifeForm("Ryan", Integer.MAX_VALUE), 4, -2000));
  }

  /**
   * Tests removal of a LifeForm.
   */
  @Test
  public void testRemoveLifeForm() {
    Environment environment = new Environment(10, 10);

    environment.addLifeForm(new LifeForm("Bob", 50), 4, 7);

    environment.removeLifeForm(4, 7);
    environment.removeLifeForm(4, 7);

    environment.removeLifeForm(-1, 2);
    environment.removeLifeForm(1, 2300);
    
    assertNull(environment.getLifeForm(4, 7));
  }

}
