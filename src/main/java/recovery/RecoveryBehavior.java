package recovery;

public interface RecoveryBehavior {

  /**
   * @param currentLife the lifeforms current lifepoints.
   * @param maxLife the lifeforms maxLife.
   * @return the amount of lifepoints to be recovered.
   */
  int calculateRecovery(int currentLife, int maxLife);
  
  
}
