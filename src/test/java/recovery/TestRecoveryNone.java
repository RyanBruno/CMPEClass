package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryNone {

  @Test
  public void testCurrentEqualsMax() {
    RecoveryNone none = new RecoveryNone();

    assertEquals(100, none.calculateRecovery(100, 100));
  }

  @Test
  public void testCurrentLessMax() {
    RecoveryNone none = new RecoveryNone();

    assertEquals(50, none.calculateRecovery(50, 100));
  }
}
