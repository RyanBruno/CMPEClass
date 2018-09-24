package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import recovery.RecoveryLinear;

public class TestAlien {

  @Test
  public void testInitialization() {
    Alien alien = new Alien("Hele", 50);

    assertEquals(50, alien.getMaxLifePoints());
    assertEquals(0, alien.getRecoveryRate());
  }

  @Test
  public void testLinarRecovery() {
    Alien alien = new Alien("Begagg", 100, new RecoveryLinear(10));

    alien.takeHit(50);
    assertEquals(50, alien.getCurrentLifePoints());
    alien.recover();
    assertEquals(60, alien.getCurrentLifePoints());

  }

}
