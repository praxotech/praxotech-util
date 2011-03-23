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
public class ComparativeOperatorTest {

  /**
   * Test method for {@link org.praxotech.util.operator.Operand#evaluate()}.
   */
  @Test
  public void testEvaluate() {
    Operand<Double> opn1 = new ConstantOperand<Double>(1.3728);
    Operand<Double> opn2 = new ConstantOperand<Double>(1.3716);
    Operand<Double> opn3 = new ConstantOperand<Double>(1.3728);
    ComparativeEQ<Double> eq = new ComparativeEQ<Double>();
    ComparativeGE<Double> ge = new ComparativeGE<Double>();
    ComparativeGT<Double> gt = new ComparativeGT<Double>();
    ComparativeLE<Double> le = new ComparativeLE<Double>();
    ComparativeLT<Double> lt = new ComparativeLT<Double>();
    ComparativeNE<Double> ne = new ComparativeNE<Double>();
    
    // test for eq
    eq.addOperand(opn1);
    try {
      eq.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 1");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    eq.addOperand(opn3);
    assertTrue(eq.evaluate()); // opn1 == opn3
    eq.addOperandAt(1, opn2); // now there are 3 operands in eq: {opn1, opn2, opn3}
    try {
      eq.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 3");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    eq.removeOperandAt(2);
    assertFalse(eq.evaluate()); // opn1 != opn2
    
    // test for ge
    ge.addOperand(opn1);   
    try {
      ge.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 1");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    ge.addOperand(opn2);
    assertTrue(ge.evaluate());  // opn1 >= opn2
    ge.addOperandAt(1, opn3); // {opn1, opn3, opn2}
    try {
      ge.evaluate();
      fail("Invalid number of operands: 3");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    ge.removeOperandAt(2);
    assertTrue(ge.evaluate()); // opn1 >= opn3
    ge.addOperandAt(0, opn2);
    ge.removeOperandAt(2);
    assertFalse(ge.evaluate()); // !(opn2 >= opn1)
    
    // test for gt
    gt.addOperand(opn1);
    try {
      gt.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 1");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    gt.addOperand(opn2);
    assertTrue(gt.evaluate()); // opn1 > opn2
    gt.addOperandAt(1, opn3); // {opn1, opn3, opn2}
    try {
      gt.evaluate();
      fail("Invalid number of operands: 3");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    gt.removeOperandAt(2);
    assertFalse(gt.evaluate()); // !(opn1 > opn3)
    gt.addOperandAt(0, opn2);
    gt.removeOperandAt(2);
    assertFalse(gt.evaluate()); // !(opn2 > opn1)
    
    // test for le
    le.addOperand(opn2);
    try {
      le.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 1");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    le.addOperand(opn1);
    assertTrue(le.evaluate()); // opn2 <= opn1
    le.addOperand(opn3); // {opn2, opn1, opn3}
    try {
      le.evaluate();
      fail("Invalid number of operands: 3");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    le.removeOperandAt(0);
    assertTrue(le.evaluate()); // opn1 <= opn3
    le.addOperand(opn2);
    le.removeOperandAt(0);
    assertFalse(le.evaluate()); // !(opn3 <= opn2)
    
    // test for lt
    lt.addOperand(opn2);
    try {
      lt.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 1");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    lt.addOperand(opn1);
    assertTrue(lt.evaluate()); // opn2 < opn1
    lt.addOperand(opn3); // {opn2, opn1, opn3}
    try {
      lt.evaluate();
      fail("Invalid number of operands: 3");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    lt.removeOperandAt(0);
    assertFalse(lt.evaluate()); // !(opn1 < opn3)
    lt.addOperand(opn2);
    lt.removeOperandAt(0);
    assertFalse(lt.evaluate()); // !(opn3 < opn2)
    
    // test for ne
    ne.addOperand(opn2);
    try {
      ne.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 1");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    ne.addOperand(opn1);
    assertTrue(ne.evaluate()); // opn2 != opn1
    ne.addOperand(opn3); // {opn2, opn1, opn3}
    try {
      ne.evaluate();
      fail("Invalid number of operands: 3");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    ne.removeOperandAt(0);
    assertFalse(ne.evaluate()); // !(opn1 != opn3)
    ne.addOperand(opn2);
    ne.removeOperandAt(0);
    assertTrue(ne.evaluate()); // opn3 != opn2
    
  }

}
