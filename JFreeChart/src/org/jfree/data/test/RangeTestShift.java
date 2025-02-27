package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

public class RangeTestShift {

    // Test Case ID: RU_018
    // Test shift with valid range and positive delta
    @Test
    public void testShift_ValidRange_PositiveDelta() {
        Range base = new Range(2.0, 6.0);
        Range result = Range.shift(base, 3.0);
        assertEquals(5.0, result.getLowerBound(), 0.0001);
        assertEquals(9.0, result.getUpperBound(), 0.0001);
    }

    // Test Case ID: RU_019
    // Test shift with valid range and negative delta
    @Test
    public void testShift_ValidRange_NegativeDelta() {
        Range base = new Range(2.0, 6.0);
        Range result = Range.shift(base, -2.0);
        assertEquals(0.0, result.getLowerBound(), 0.0001);
        assertEquals(4.0, result.getUpperBound(), 0.0001);
    }
    
    // Test Case ID: RU_020
    // Test shift with null range (should throw exception)
    @Test(expected = NullPointerException.class)
    public void testShift_NullRange() {
        Range.shift(null, 2.0);
    }
    
    // Test Case ID: RU_021
    // Test shift with delta at the lower boundary (0)
    @Test
    public void testShift_LowerBoundary() {
        Range base = new Range(2.0, 6.0);
        Range result = Range.shift(base, 0.0);
        assertEquals(2.0, result.getLowerBound(), 0.0001);
        assertEquals(6.0, result.getUpperBound(), 0.0001);
    }
    
    // Test Case ID: RU_022
    // Test shift with delta at the upper boundary (large value)
    @Test
    public void testShift_UpperBoundary() {
        Range base = new Range(2.0, 6.0);
        double maxDelta = Double.MAX_VALUE / 2; // Prevent overflow
        Range result = Range.shift(base, maxDelta);
        assertEquals(2.0 + maxDelta, result.getLowerBound(), 0.0001);
        assertEquals(6.0 + maxDelta, result.getUpperBound(), 0.0001);
    }
}
