package exceptions;

@SuppressWarnings("serial")
public class RecoveryRateException extends Exception {
  public RecoveryRateException() {
    super();
  }
  
  public RecoveryRateException(String message) {
    super(message);
  }
}
