package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

public class DataUtilitiesTestCalculateRowTotal {

    private Mockery context;
    private Values2D values2D;

    @Before
    public void setUp() {
        context = new Mockery();
        values2D = context.mock(Values2D.class);
    }

    // Test Case ID: DU_006
    // Tests contains valid Values2D object with multiple columns
    @Test
    public void testCalculateRowTotal_MultipleColumns() {
        context.checking(new Expectations() {{
            allowing(values2D).getColumnCount();
            will(returnValue(2));

            allowing(values2D).getValue(0, 0);
            will(returnValue(2.0));

            allowing(values2D).getValue(0, 1);
            will(returnValue(3.0));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0);
        assertEquals(5.0, result, 0.0001); // Expected: 2.0 + 3.0 = 5.0
    }

    // Test Case ID: DU_007
    // Test contains valid Values2D object with zero columns
    @Test
    public void testCalculateRowTotal_ZeroColumns() {
        context.checking(new Expectations() {{
            allowing(values2D).getColumnCount();
            will(returnValue(0));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 1);
        assertEquals(0.0, result, 0.0001); // No columns, so sum is 0
    }

	 // Test Case ID: DU_008
	 // Test contains invalid Values2D object (null)
	 @Test(expected = NullPointerException.class)
	 public void testCalculateRowTotal_NullValues2D() {
	     DataUtilities.calculateRowTotal(null, 1);
	 }

    // Test Case ID: DU_009
    // Test contains row index at the lower boundary (0)
    @Test
    public void testCalculateRowTotal_LowerBoundaryRowIndex() {
        context.checking(new Expectations() {{
            allowing(values2D).getColumnCount();
            will(returnValue(2));

            allowing(values2D).getValue(0, 0);
            will(returnValue(5.0));

            allowing(values2D).getValue(0, 1);
            will(returnValue(7.0));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0);
        assertEquals(12.0, result, 0.0001); // 5.0 + 7.0 = 12.0
    }
    
    // Test Case ID: DU_010
    // Test contains row index at the upper boundary (number of rows - 1)
    @Test
    public void testCalculateRowTotal_UpperBoundaryRowIndex() {
        context.checking(new Expectations() {{
            allowing(values2D).getRowCount();
            will(returnValue(3)); // Assume 3 rows (index 0, 1, 2)

            allowing(values2D).getColumnCount();
            will(returnValue(2));

            allowing(values2D).getValue(2, 0);
            will(returnValue(8.0));

            allowing(values2D).getValue(2, 1);
            will(returnValue(6.0));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 2);
        assertEquals(14.0, result, 0.0001); // 8.0 + 6.0 = 14.0
    }
}

