/**
 * Copyright (c) 2005 - 2011, PraxaTech Org. All rights reserved.
 */
package org.praxotech.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author fyang
 *
 */
public class DualObjectTest {

  /**
   * Test method for {@link org.praxotech.util.OrderedDualObject#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObject() {
    OrderedDualObject<String, Integer> o1 = new OrderedDualObject<String, Integer>("a", Integer.valueOf(1));
    OrderedDualObject<String, Integer> o2 = new OrderedDualObject<String, Integer>(null, Integer.valueOf(1));
    OrderedDualObject<String, Integer> o3 = new OrderedDualObject<String, Integer>("a", null);
    OrderedDualObject<String, Long> o4 = new OrderedDualObject<String, Long>("a", Long.valueOf(1));
    OrderedDualObject<String, Integer> o5 = new OrderedDualObject<String, Integer>("a", Integer.valueOf(1));
    
    assertEquals(o1, o5);           // equality of two instance of same value
    assertFalse(o2.equals(o1));     // inequality when first of first is null (NPE should not occur)
    assertFalse(o3.equals(o1));     // inequality when second of first is null (NPE should not occur)
    assertFalse(o1.equals(o2));     // inequality when first of second is null (NPE should not occur)
    assertFalse(o1.equals(o3));     // inequality when second of second is null (NPE should not occur)
    assertFalse(o1.equals(o4));     // inequality of different data types
  }

}
