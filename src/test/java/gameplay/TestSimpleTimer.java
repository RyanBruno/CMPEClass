package gameplay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSimpleTimer {

  @Test
  public void testSimpleTimerAsThread() throws InterruptedException {
    SimpleTimer st = new SimpleTimer(1000);
    st.start();
    Thread.sleep(250);
    for (int x = 0; x < 5; x++ ) {
      assertEquals(x, st.getRound());
      Thread.sleep(1000);
    }
  }

}
