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
   * Test method for {@link org.praxotech.util.DualObject#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObject() {
    DualObject<String, Integer> o1 = new DualObject<String, Integer>("a", Integer.valueOf(1));
    DualObject<String, Integer> o2 = new DualObject<String, Integer>(null, Integer.valueOf(1));
    DualObject<String, Integer> o3 = new DualObject<String, Integer>("a", null);
    DualObject<String, Long> o4 = new DualObject<String, Long>("a", Long.valueOf(1));
    DualObject<String, Integer> o5 = new DualObject<String, Integer>("a", Integer.valueOf(1));
    
    assertEquals(o1, o5);
    assertFalse(o2.equals(o1));
    assertFalse(o3.equals(o1));
    assertFalse(o1.equals(o4));
  }

}
