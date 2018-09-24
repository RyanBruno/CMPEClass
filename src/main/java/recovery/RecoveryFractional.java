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
    if (currentLife <= 0) {
      return 0;
    }

    if ((currentLife * recoveryFraction) + currentLife < maxLife) {
      return (int) (Math.ceil(currentLife * recoveryFraction) + currentLife);
    } else {
      return maxLife;
    }
  }

}
