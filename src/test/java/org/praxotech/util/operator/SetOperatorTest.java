/**
 * Copyright (c) 2005 - 2011, PraxaTech Org. All rights reserved.
 */
package org.praxotech.util.operator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


/**
 * @author fyang
 *
 */
public class SetOperatorTest {

  /**
   * Test method for {@link org.praxotech.util.operator.Operand#evaluate()}.
   */
  @Test
  public void testEvaluate() {
    Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(4, 5, 6, 7, 8, 9));
    Set<Integer> s3 = new HashSet<Integer>(Arrays.asList(2, 5, 8, 9, 10, 11, 12, 13, 14, 15));

    Operand<Set<Integer>> opn1 = new ConstantOperand<Set<Integer>>(s1);
    Operand<Set<Integer>> opn2 = new ConstantOperand<Set<Integer>>(s2);
    Operand<Set<Integer>> opn3 = new ConstantOperand<Set<Integer>>(s3);
    
    // test for exclusion
    SetExclusion<Integer> excl = new SetExclusion<Integer>();
    try {
      excl.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 0");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    excl.addOperand(opn1);
    assertEquals(s1, excl.evaluate());
    excl.addOperand(opn2);
    assertEquals(new HashSet<Integer>(Arrays.asList(1, 2, 3)), excl.evaluate());
    excl.addOperand(opn3);
    assertEquals(new HashSet<Integer>(Arrays.asList(1, 3)), excl.evaluate());
    
    // test for intersection
    SetIntersection<Integer> i = new SetIntersection<Integer>();
    try {
      i.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 0");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    i.addOperand(opn1);
    assertEquals(s1, i.evaluate());
    i.addOperand(opn2);
    assertEquals(new HashSet<Integer>(Arrays.asList(4, 5)), i.evaluate());
    i.addOperand(opn3);
    assertEquals(new HashSet<Integer>(Arrays.asList(5)), i.evaluate());
    
    // test for union
    SetUnion<Integer> u = new SetUnion<Integer>();
    try {
      u.evaluate(); // making sure evaluate() calls the validate() and validate() behaves correctly
      fail("Invalid number of operands: 0");
    }
    catch (OperandValidationException e) {
      assertTrue(true);
    }
    u.addOperand(opn1);
    assertEquals(s1, u.evaluate());
    u.addOperand(opn2);
    assertEquals(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)), u.evaluate());
    u.addOperand(opn3);
    assertEquals(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)), u.evaluate());
  }
}
