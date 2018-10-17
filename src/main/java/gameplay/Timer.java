package gameplay;

public interface Timer {

  void addTimeObserver(TimerObserver observer);
  
  void removeTimeObserver​(TimerObserver observer);
  
  void timeChanged();

}
