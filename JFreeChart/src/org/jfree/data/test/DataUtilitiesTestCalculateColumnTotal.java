package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

public class DataUtilitiesTestCalculateColumnTotal {

    private Mockery context;
    private Values2D values2D;

    @Before
    public void setUp() {
        context = new Mockery();
        values2D = context.mock(Values2D.class);
    }

    // Test Case ID: DU_001
    // Test contains multiple rows, summing column correctly
    @Test
    public void testCalculateColumnTotal_ValidColumn() {
        context.checking(new Expectations() {{
            allowing(values2D).getRowCount();
            will(returnValue(3));

            allowing(values2D).getValue(0, 0);
            will(returnValue(1.5));

            allowing(values2D).getValue(1, 0);
            will(returnValue(2.5));

            allowing(values2D).getValue(2, 0);
            will(returnValue(3.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals(7.0, result, 0.0001); // 1.5 + 2.5 + 3.0 = 7.0
    }

    // Test Case ID: DU_002
    // Test contains with no rows in Values2D (should return 0)
    @Test
    public void testCalculateColumnTotal_EmptyData() {
        context.checking(new Expectations() {{
            allowing(values2D).getRowCount();
            will(returnValue(0));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals(0.0, result, 0.0001); // No rows, so sum is 0
    }

    // Test Case ID: DU_003
    // Test contains null Values2D (should throw IllegalArgumentException)
    @Test(expected = NullPointerException.class)
    public void testCalculateColumnTotal_NullValues2D() {
        DataUtilities.calculateColumnTotal(null, 0);
    }

    // Test Case ID: DU_004
    // Test contains handling null values in the column (should ignore nulls)
    @Test
    public void testCalculateColumnTotal_WithNullValues() {
        context.checking(new Expectations() {{
            allowing(values2D).getRowCount();
            will(returnValue(3));

            allowing(values2D).getValue(0, 0);
            will(returnValue(null)); // Should be ignored

            allowing(values2D).getValue(1, 0);
            will(returnValue(4.0));

            allowing(values2D).getValue(2, 0);
            will(returnValue(6.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals(10.0, result, 0.0001); // Null ignored, so 4.0 + 6.0 = 10.0
    }

    // Test Case ID: DU_005
    // Test contains out-of-bounds column index (should throw IndexOutOfBoundsException)
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateColumnTotal_InvalidColumnIndex() {
        context.checking(new Expectations() {{
            allowing(values2D).getRowCount();
            will(returnValue(3));

            allowing(values2D).getValue(0, 5);
            will(throwException(new IndexOutOfBoundsException()));

            allowing(values2D).getValue(1, 5);
            will(throwException(new IndexOutOfBoundsException()));

            allowing(values2D).getValue(2, 5);
            will(throwException(new IndexOutOfBoundsException()));
        }});

        DataUtilities.calculateColumnTotal(values2D, 5);
    }
}
