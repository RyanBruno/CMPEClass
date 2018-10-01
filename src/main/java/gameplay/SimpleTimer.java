package gameplay;

import java.util.ArrayList;
import java.util.List;

public class SimpleTimer extends Thread implements Timer {

  private List<TimerObserver> obs = new ArrayList<TimerObserver>();
  
  private int round = 0;

  private long roundLength;
  
  public SimpleTimer() {
    roundLength = 1000;
  }
  
  public SimpleTimer(int sleep) {
    roundLength = sleep;
  }
  
  @Override
  public void addTimeObserver​(TimerObserver observer) {
    obs.add(observer);
  }
  
  @Override
  public void removeTimeObserver​(TimerObserver observer) {
    obs.remove(observer);
  }
  
  @Override
  public void timeChanged() {
    obs.forEach((o) -> o.updateTime​(round));
  }
  
  @Override
  public void run() {
    while (round < 50) {
      try {
        Thread.sleep(roundLength);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      round +=1;
    }
  }
  
  public int getNumObservers() {
    return obs.size();
  }
  
  public int getRound() {
    return round;
  }

}
