/**
 * Copyright (c) 2005 - 2011, PraxaTech Org. All rights reserved.
 */
package org.praxotech.util.operator;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author fyang
 *
 */
public class LogicalOperatorTest {

  /**
   * Test method for {@link org.praxotech.util.operator.Operand#evaluate()}.
   */
  @Test
  public void testEvaluate() {
    Operand<Boolean> t1 = new ConstantOperand<Boolean>(true);
    Operand<Boolean> t2 = new ConstantOperand<Boolean>(true);
    Operand<Boolean> f1 = new ConstantOperand<Boolean>(false);
    Operand<Boolean> f2 = new ConstantOperand<Boolean>(false);
    
    // test for and
    LogicalAnd a = new LogicalAnd();
    try {
      a.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 0");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    a.addOperand(t1);
    assertTrue(a.evaluate()); // t1
    a.addOperand(t2);
    assertTrue(a.evaluate()); // t1 && t2
    a.addOperand(f1);
    assertFalse(a.evaluate()); // t1 && t2 && f1
    a.removeOperandAt(0);
    a.removeOperandAt(0);
    assertFalse(a.evaluate()); // f1
    a.addOperand(f2);
    assertFalse(a.evaluate()); // f1 && f2
    
    // test for or
    LogicalOr o = new LogicalOr();
    try {
      o.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 0");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    o.addOperand(t1);
    assertTrue(o.evaluate()); // t1
    o.addOperand(t2);
    assertTrue(o.evaluate()); // t1 || t2
    o.addOperand(f1);
    assertTrue(o.evaluate()); // t1 || t2 || f1
    o.removeOperandAt(0);
    o.removeOperandAt(0);
    assertFalse(o.evaluate()); // f1
    o.addOperand(f2);
    assertFalse(o.evaluate()); // f1 && f2
    
    // test for not
    LogicalNot n = new LogicalNot();
    try {
      n.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 2");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    n.addOperand(t1);
    assertFalse(n.evaluate()); // t1
    n.addOperand(t2);
    try {
      n.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 2");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    n.removeOperandAt(0);
    n.removeOperandAt(0);
    n.addOperand(f1);
    assertTrue(n.evaluate()); // f1
  }
}
