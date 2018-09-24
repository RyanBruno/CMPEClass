package lifeform;

import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

public class Alien extends LifeForm {

  private int maxLifePoints;
  private int recoveryRate;
  private RecoveryBehavior recoveryBehavior;

  /**
   * Create an Alien with a RecoveryBehavior of RecoveryNone. By default Aliens
   * have an attack strength of 10 and a recovery Rate of 0 (will never recover).
   * 
   * @param name
   * @param maxHP
   */
  public Alien(String name, int maxHP) {
    super(name, maxHP);
    maxLifePoints = maxHP;
    recoveryBehavior = new RecoveryNone();
    recoveryRate = 0;
  }

  /**
   * Create an Alien with the given RecoveryBehavior. By default Aliens have an
   * attack strength of 10 and a recovery Rate of 0 (will never recover).
   * 
   * @param name
   * @param maxHP
   * @param behavior
   */
  public Alien(String name, int maxHP, RecoveryBehavior behavior) {
    this(name, maxHP);
    this.recoveryBehavior = behavior;
  }

  /**
   * Create an Alien with the given RecoveryBehavior and RecoveryRate. Aliens have
   * an attack strength of 10, by default.
   * 
   * @param name
   * @param maxHP
   * @param behavior
   * @param recoveryRate
   */
  public Alien(String name, int maxHP, RecoveryBehavior behavior, int recoveryRate) {
    this(name, maxHP, behavior);
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
    super.takeHit((recoveryBehavior.calculateRecovery(getCurrentLifePoints(), maxLifePoints) - getCurrentLifePoints()) * -1);
  }

}
