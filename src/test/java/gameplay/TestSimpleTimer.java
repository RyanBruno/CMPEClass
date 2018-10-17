package gameplay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.RecoveryRateException;
import lifeform.Alien;
import recovery.RecoveryLinear;

public class TestSimpleTimer {
  
  @Test
  public void testInitialization() {
    SimpleTimer st = new SimpleTimer(1000);
    assertEquals(0, st.getRound());
  }
  
  @Test
  public void testTimeUpdate() {
    SimpleTimer st = new SimpleTimer(1000);
    st.timeChanged();
    assertEquals(1, st.getRound());
  }
  
  @Test
  public void testAddingObservers() {
    SimpleTimer st = new SimpleTimer(1000);
    Alien blob = new Alien("Blob", 100);
    st.addTimeObserver​(blob);
    assertEquals(1, st.getNumObservers());
  }
  
  @Test
  public void testObserversFuntionality() throws RecoveryRateException {
    SimpleTimer st = new SimpleTimer(1000);
    Alien blob = new Alien("Blob", 100, new RecoveryLinear(10), 1);
    st.addTimeObserver​(blob);
    blob.takeHit(20);
    assertEquals(80, blob.getCurrentLifePoints());
    st.timeChanged();
    assertEquals(90, blob.getCurrentLifePoints());
  }

  @Test
  public void testSimpleTimerAsThread() throws InterruptedException {
    SimpleTimer st = new SimpleTimer(1000);
    st.start();
    Thread.sleep(250);
    for (int x = 0; x < 5; x++) {
      assertEquals(x, st.getRound());
      Thread.sleep(1000);
    }
  }

}
