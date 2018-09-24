package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryFractional {

  @Test
  public void testCurrentEqualsMax() {
    RecoveryFractional fractional = new RecoveryFractional(.1);

    assertEquals(100, fractional.calculateRecovery(100, 100));
  }
  
  @Test
  public void testNearMax() {
    RecoveryFractional fractional = new RecoveryFractional(.1);

    assertEquals(100, fractional.calculateRecovery(98, 100));
  }
  
  @Test
  public void testNotNearMax() {
    RecoveryFractional fractional = new RecoveryFractional(.1);

    assertEquals(52, fractional.calculateRecovery(47, 100));
  }
  
  @Test
  public void testDead() {
    RecoveryFractional fractional = new RecoveryFractional(.1);

    assertEquals(0, fractional.calculateRecovery(0, 100));
  }
  
}
