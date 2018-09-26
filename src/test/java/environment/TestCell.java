package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import environment.Cell;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * Tests the Cell class.
 * 
 * SWE 200 Programmers: Ryan Bruno, Richard Clapper
 */
public class TestCell {

  /**
   * Tests the initialization of the Cell class.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }

  /**
   * Check to see if a Cell holds a Lifeform properly.
   */
  @Test
  public void testAddLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);

    Cell cell = new Cell();

    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
  }

  /**
   * Tests that you cannot add multiple LifeForms.
   */
  @Test
  public void testAddingTwoEntities() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("fred", 40);

    Cell cell = new Cell();

    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());

    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }

  /**
   * Tests if Cell can remove a LifeForm.
   */
  @Test
  public void testRemoveLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);

    Cell cell = new Cell();

    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());

    cell.removeLifeForm();

    LifeForm fred = new MockLifeForm("fred", 40);
    
    success = cell.addLifeForm(fred);
    assertTrue(success);
    assertEquals(fred, cell.getLifeForm());
  }
}
