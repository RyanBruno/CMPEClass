package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryLinear {

  @Test
  public void testCurrentEqualsMax() {
    RecoveryLinear linear = new RecoveryLinear(10);
    assertEquals(100, linear.calculateRecovery(100, 100));
  }

  @Test
  public void testNearMax() {
    RecoveryLinear linear = new RecoveryLinear(10);
    assertEquals(100, linear.calculateRecovery(98, 100));
  }

  @Test
  public void testNotNearMax() {
    RecoveryLinear linear = new RecoveryLinear(10);
    assertEquals(57, linear.calculateRecovery(47, 100));
  }

  @Test
  public void testDead() {
    RecoveryLinear linear = new RecoveryLinear(10);
    assertEquals(0, linear.calculateRecovery(0, 100));
  }
}
