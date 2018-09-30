package recovery;

public class RecoveryLinear implements RecoveryBehavior {

  private int step;

  /**
   * @param step How much to recovery every recovery period.
   */
  public RecoveryLinear(int step) {
    this.step = step;
  }

  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    if (currentLife <= 0) {
      return 0;
    }
    return maxLife - currentLife > step ? step + currentLife : maxLife;
  }

}
