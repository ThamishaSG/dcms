package com.agent.dcms.service.repappoinment;

/**
 * <code>RepAppoinmentServiceException</code> is to handle service exceptions gracefully when back end
 * system services failed for data related systems.
 */
public class RepAppoinmentServiceException extends RuntimeException {
  /** Default serial version uid. */
  private static final long serialVersionUID = 1L;

  /** Create a {@link RepAppoinmentServiceException} */
  // Parameterless Constructor
  public RepAppoinmentServiceException() {
    super();
  }

  /**
   * Create a {@link RepAppoinmentServiceException} with the specific message.
   *
   * @param message the message
   */
  // Constructor that accepts a message
  public RepAppoinmentServiceException(String message) {
    super(message);
  }

  /**
   * Create a {@link RepAppoinmentServiceException} with the specific message.
   *
   * @param message custom message or information of the exception
   * @param exception handled {@link Exception}
   */
  public RepAppoinmentServiceException(final String message, final Throwable exception) {
    super(message, exception);
  }
}
