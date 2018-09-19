package recovery;

public class RecoveryFractional implements RecoveryBehavior {

  private double recoveryFraction;
  
  /**
   * @param recoveryFraction What fraction to of the maxLife to recover by.
   */
  public RecoveryFractional(double recoveryFraction) {
    this.recoveryFraction = recoveryFraction;
  }
  
  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    return (int) ((maxLife - currentLife) * recoveryFraction) + maxLife;
  }

}
