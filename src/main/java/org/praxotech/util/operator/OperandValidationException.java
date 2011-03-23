/**
 * Copyright (c) 2005 - 2011, PraxaTech Org. All rights reserved.
 */
package org.praxotech.util.operator;

/**
 * @author fyang
 *
 */
public class OperandValidationException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -624993838454330954L;

  public OperandValidationException() {
    super();
  }

  public OperandValidationException(String message, Throwable cause) {
    super(message, cause);
  }

  public OperandValidationException(String message) {
    super(message);
  }

  public OperandValidationException(Throwable cause) {
    super(cause);
  }

}
