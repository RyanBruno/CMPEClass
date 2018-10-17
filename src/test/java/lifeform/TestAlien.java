package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.RecoveryRateException;
import gameplay.SimpleTimer;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;

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
  
  @Test
  public void testAttackStrength() {
    Alien alien = new Alien("Hele", 50);
    assertEquals(10, alien.getAttackStrength());
  }
  
  @Test
  public void testRecoveryRate() throws RecoveryRateException {
    Alien alien = new Alien("Hele", 50, new RecoveryNone(), 50);
    assertEquals(50, alien.getRecoveryRate());
  }
  
  @Test
  public void testRecoveryNone() throws RecoveryRateException {
    Alien alien = new Alien("Hele", 50, new RecoveryLinear(10), 0);
    alien.takeHit(10);
    alien.updateTime​(1);
    assertEquals(40, alien.getCurrentLifePoints());

  }

  @Test
  public void testRecoverySet() throws RecoveryRateException {
    Alien alien = new Alien("Hele", 50, new RecoveryNone(), 50);
    assertEquals(50, alien.getRecoveryRate());
  }
  
  @Test
  public void testRecovery() throws RecoveryRateException {
    Alien alien = new Alien("Hele", 50, new RecoveryLinear(10), 1);
    alien.takeHit(20);
    assertEquals(30, alien.getCurrentLifePoints());
    alien.updateTime​(1);
    assertEquals(40, alien.getCurrentLifePoints());
  }
  
  @Test
  public void testRecovery2() throws RecoveryRateException {
    Alien alien = new Alien("Hele", 50, new RecoveryLinear(10), 10);
    alien.takeHit(20);
    assertEquals(30, alien.getCurrentLifePoints());
    for (int i = 1; i <= 20; i++) {
      alien.updateTime​(i);
    }
    assertEquals(50, alien.getCurrentLifePoints());
  }
  
  @Test
  public void testObserversFuntionality() throws RecoveryRateException {
    Alien blob = new Alien("Blob", 100, new RecoveryLinear(10), 1);
    SimpleTimer st = new SimpleTimer(1000);

    st.addTimeObserver(blob);
    blob.takeHit(20);
    assertEquals(80, blob.getCurrentLifePoints());
    st.timeChanged();
    assertEquals(90, blob.getCurrentLifePoints());
  }
  
  @Test
  public void testRemoveObserversFuntionality() throws RecoveryRateException {
    Alien blob = new Alien("Blob", 100, new RecoveryLinear(10), 1);
    SimpleTimer st = new SimpleTimer(1000);

    st.addTimeObserver(blob);
    blob.takeHit(20);
    st.removeTimeObserver​(blob);
    assertEquals(80, blob.getCurrentLifePoints());
    st.timeChanged();
    assertEquals(80, blob.getCurrentLifePoints());
  }
  
  @Test
  public void testInvalidRecoveryRate() {
    try {
      new Alien("Blob", 100, new RecoveryNone(), -1);
      fail();
    } catch (RecoveryRateException e) {
      assertTrue(true);
    }

  }

}
