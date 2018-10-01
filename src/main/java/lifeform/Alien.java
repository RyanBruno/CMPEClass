package lifeform;

import exceptions.RecoveryRateException;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

public class Alien extends LifeForm implements TimerObserver {

  private int maxLifePoints;
  private int recoveryRate;
  private RecoveryBehavior recoveryBehavior;

  /**
   * Create an Alien with a RecoveryBehavior of RecoveryNone. By default Aliens
   * have an attack strength of 10 and a recovery Rate of 0 (will never recover).
   *
   * @param name
   * @param maxHp
   */
  public Alien(String name, int maxHp) {
    super(name, maxHp);
    maxLifePoints = maxHp;
    recoveryBehavior = new RecoveryNone();
    recoveryRate = 0;
  }

  /**
   * Create an Alien with the given RecoveryBehavior. By default Aliens have an
   * attack strength of 10 and a recovery Rate of 0 (will never recover).
   *
   * @param name
   * @param maxHp
   * @param behavior
   */
  public Alien(String name, int maxHp, RecoveryBehavior behavior) {
    this(name, maxHp);
    this.recoveryBehavior = behavior;
  }

  /**
   * Create an Alien with the given RecoveryBehavior and RecoveryRate. Aliens have
   * an attack strength of 10, by default.
   *
   * @param name
   * @param maxHp
   * @param behavior
   * @param recoveryRate
   * @throws RecoveryRateException
   */
  public Alien(String name, int maxHp, RecoveryBehavior behavior, int recoveryRate)
      throws RecoveryRateException {
    this(name, maxHp, behavior);
    if (recoveryRate < 0) {
      throw new RecoveryRateException("Recovery Rate cannnon be less then zero.");
    }
    this.recoveryRate = recoveryRate;
  }

  /**
   * @return the recovery rate.
   */
  public int getRecoveryRate() {
    return recoveryRate;
  }

  /**
   * @return the maximum life points the Alien can have.
   */
  public int getMaxLifePoints() {
    return maxLifePoints;
  }

  /**
   * Recovers LifePoints based on the RecoveryBehavior.
   */
  protected void recover() {
    takeHit((recoveryBehavior.calculateRecovery(getCurrentLifePoints(), maxLifePoints)
        - getCurrentLifePoints()) * -1);
  }

  /**
   *
   * @param time
   */
  public void updateTime​(int time) {
    if (time % recoveryRate == 0) {
      recover();
    }
  }

}
