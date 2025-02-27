**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group 22:      |     |
| -------------- | --- |
| Kamand         |     |
| Issy           |     |
| Spiro          |     |
| Dylan          |     |

# 1 Introduction

In this lab, we tested several methods from JFreeChart, an open-source Java Framework for chart calculation, creation, and display. We explored the basics of automated unit testing using JUnit 4 and mock objects. We applied black-box case design techniques such as Equivalence Class Testing (ECT) and Boundary Value Testing (BVT).    

# 2 Detailed description of unit test strategy

Our unit test strategy is based on black-box testing techniques with a strong focus on Equivalence Partitioning and Boundary Value Analysis. Specifically, we designed our test cases to validate the behavior of the `DataUtilities` and `Range` classes by:

- **Identifying Equivalence Classes:**  
  For each method, we classified input data into valid and invalid partitions. For example, for the method `calculateColumnTotal`, we considered a valid `Values2D` object with multiple rows, an empty data scenario, and an invalid (null) input. Similar partitions were defined for other methods such as `calculateRowTotal`, `createNumberArray`, `createNumberArray2D`, and `getCumulativePercentages` within the `DataUtilities` class, as well as for the methods in the `Range` class like `getCentralValue`, `contains`, `expand`, `shift`, and `combine`.

- **Defining Boundary Values:**  
  We paid special attention to the edge cases by setting boundary conditions. For instance, tests for index boundaries in the `calculateColumnTotal` and `calculateRowTotal` methods were created to verify behavior at the lower (0) and upper limits (number of rows/columns - 1). Similarly, methods that transform arrays (`createNumberArray` and `createNumberArray2D`) have tests to validate behavior on arrays of minimum (0) and maximum achievable sizes. The same approach applies for margin, delta or range limits in the `Range` methods.

- **Test Case Design for Complex Scenarios:**  
  For methods like `getCumulativePercentages`, which involve aggregating data from a range of keys, our tests ensure that scenarios with a single key, multiple keys, and even empty or null inputs are thoroughly considered. The tests verify that cumulative values are calculated correctly across increasing keys and also handle unexpected or edge inputs gracefully.

- **Focus on Expected Exceptions and Failures:**  
  In addition to validating correct calculations, our test strategy accounts for improper usage scenarios such as null inputs or out-of-bound indices. In these cases, the tests are designed to confirm that the appropriate exceptions (e.g., NullPointerException or IllegalArgumentException) are thrown as per the specifications.

- **Structured Test Cases:**  
  Each method is tested by multiple cases that cover typical use cases and edge cases. For instance, the `Range` class methods like `getCentralValue` and `contains` are tested with ranges consisting of positive, negative, and zero values. The `expand`, `shift`, and `combine` methods are tested both with valid ranges and with scenarios where one or both operands are null, ensuring robust handling even when the inputs are at their boundaries.

Overall, this strategy ensures that both normal and edge-case behaviors are verified, contributing to a comprehensive assessment of the functionality and reliability of the JFreeChart utility classes.

# 3 Test cases developed

The following test methods were implemented in our test classes to cover the partitions described in our test strategy:

DataUtilities Class

    calculateColumnTotal(Values2D data, int column)
        Equivalence & Boundary Tests:
            testCalculateColumnTotal_ValidMultipleRows()
                Tests a valid Values2D with multiple rows and a typical column index.
            testCalculateColumnTotal_EmptyData()
                Tests a Values2D with zero rows (empty data) to ensure the total is zero.
            testCalculateColumnTotal_NullInput_ThrowsException()
                Verifies that a null input throws a NullPointerException.
            testCalculateColumnTotal_WithNullValues_Ignored()
                Ensures that null values within a column are properly ignored during summing.
            testCalculateColumnTotal_IndexOutOfBounds()
                Confirms that an out-of-bound column index raises an IndexOutOfBoundsException.

    calculateRowTotal(Values2D data, int row)
        Equivalence & Boundary Tests:
            testCalculateRowTotal_ValidMultipleColumns()
                Checks that the sum is correctly computed for a valid row with several columns.
            testCalculateRowTotal_EmptyRow()
                Tests a row with zero columns to return a total of 0.0.
            testCalculateRowTotal_NullInput_ThrowsException()
                Verifies expected exception behavior when a null dataset is passed.
            testCalculateRowTotal_RowIndexLowerBoundary()
                Covers the lower boundary by testing row index 0.
            testCalculateRowTotal_RowIndexUpperBoundary()
                Covers the upper row index (number of rows - 1).
            
    createNumberArray(double[] data)
        Equivalence & Boundary Tests:
            testCreateNumberArray_ValidArray()
                Verifies proper conversion with a typical double array.
            testCreateNumberArray_EmptyArray()
                Tests conversion with an empty array (length 0).
            testCreateNumberArray_NullArray_ThrowsIllegalArgumentException()
                Confirms a null array input throws the proper exception.
            testCreateNumberArray_LowerBoundary()
                Checks behavior when array length is zero (lower boundary).
            testCreateNumberArray_UpperBoundary()
                Uses a large array (upper boundary) to validate conversion consistency.

    createNumberArray2D(double[][] data)
        Equivalence & Boundary Tests:
            testCreateNumberArray2D_Valid2DArray()
                Tests a typical 2D double array with multiple rows and columns.
            testCreateNumberArray2D_Empty2DArray()
                Verifies that an empty 2D array (0 rows/columns) is handled correctly.
            testCreateNumberArray2D_NullArray_ThrowsIllegalArgumentException()
                Ensures a null 2D array input throws an exception.
            testCreateNumberArray2D_ContainingNullRow_ThrowsException()
                Tests a 2D array that includes a null row as invalid input.
            testCreateNumberArray2D_NullColumn_ThrowsException()
                Checks handling when a column contains a null (or NaN) value.
            testCreateNumberArray2D_ZeroColumns()
                Validates behavior with rows defined but zero columns.
            testCreateNumberArray2D_DimensionsLowerBoundary()
                Covers the lower boundary for the dimensions of the array.
            testCreateNumberArray2D_DimensionsUpperBoundary()
                Uses a large 2D array to verify the upper boundary constraints.

    getCumulativePercentages(KeyedValues data)
        Equivalence & Boundary Tests:
            testGetCumulativePercentages_MultipleKeys()
                Ensures proper cumulative calculations for a dataset with several keys.
            testGetCumulativePercentages_EmptyDataset()
                Verifies that an empty dataset returns an empty result.
            testGetCumulativePercentages_NullInput_ThrowsIllegalArgumentException()
                Checks for the proper exception when a null KeyedValues object is provided.
            testGetCumulativePercentages_SingleKeyBoundary()
                Tests the lower boundary with just one key.
            testGetCumulativePercentages_UpperBoundaryWithLargeDataset()
                Validates cumulative percentage calculations when using a dataset at the upper boundary.

Range Class

    getCentralValue()
        Equivalence & Boundary Tests:
            testGetCentralValue_PositiveBounds()
                Tests calculation with a range that has positive lower and upper bounds.
            testGetCentralValue_NegativeBounds()
                Covers the scenario where both bounds are negative.
            testGetCentralValue_ZeroBounds()
                Verifies behavior when both lower and upper bounds are zero.
            testGetCentralValue_NegativeLower_PositiveUpper()
                Checks the central value calculation for a range straddling zero.
            testGetCentralValue_LowerBoundary()
                Tests behavior at the extreme lower boundary (e.g., very large negative value).
            testGetCentralValue_InvalidRange_ThrowsException()
                Ensures that a reverse range (lower bound greater than upper) throws an exception.
            testGetCentralValue_UpperBoundary()
                Covers the upper boundary with extremely large positive values.
            
    contains(double value)
        Equivalence & Boundary Tests:
            testContains_ValueWithinRange()
                Verifies that a value clearly within the range returns true.
            testContains_ValueBelowRange()
                Checks that a value below the lower bound is correctly identified as false.
            testContains_ValueAboveRange()
                Ensures that a value above the upper bound is not contained in the range.
            testContains_ValueAtLowerBoundary()
                Tests inclusion of a value exactly equal to the lower boundary.
            testContains_ValueAtUpperBoundary()
                Tests inclusion of a value exactly equal to the upper boundary.
            
    expand(Range base, double lowerMargin, double upperMargin)
        Equivalence & Boundary Tests:
            testExpand_ValidRange_PositiveMargins()
                Checks that positive margins correctly expand the range.
            testExpand_ValidRange_ZeroMargins()
                Verifies that zero margins leave the range unchanged.
            testExpand_NullRange_ThrowsIllegalArgumentException()
                Ensures a null range input results in an exception.
            testExpand_MarginsAtLowerBoundary()
                Covers the condition where margins are at their lower limit (0).
            testExpand_MarginsAtUpperBoundary()
                Tests the situation with maximum margin values.
            
    shift(Range base, double delta)
        Equivalence & Boundary Tests:
            testShift_ValidRange_PositiveDelta()
                Verifies that the range shifts correctly when a positive delta is applied.
            testShift_ValidRange_NegativeDelta()
                Checks proper shift for a negative delta.
            testShift_NullRange_ThrowsException()
                Ensures that shifting a null range throws an exception.
            testShift_DeltaAtLowerBoundary()
                Tests the scenario where the delta is zero (lower boundary).
            testShift_DeltaAtUpperBoundary()
                Covers the behavior when the delta is a very large number (upper boundary).
        
    combine(Range range1, Range range2)
        Equivalence & Boundary Tests:
            testCombine_TwoValidRanges()
                Verifies that combining two valid ranges produces the correct overall range.
            testCombine_FirstRangeNull()
                Checks that combining a null first range with a valid second range returns the second range.
            testCombine_SecondRangeNull()
                Ensures that combining a valid first range with a null second range returns the first range.
            testCombine_BothRangesNull()
                Verifies that combining two null ranges returns a null result.
            testCombine_RangeBoundsAtLowerBoundary()
                Tests combining ranges with extreme lower boundary values.
            testCombine_RangeBoundsAtUpperBoundary()
                Tests combining ranges with extreme upper boundary values.

Each test method was designed to target specific equivalence classes (valid inputs, empty inputs, and null or invalid inputs) as well as to check behavior at the boundaries (e.g., first/last indices, zero or maximum sizes, extreme numeric limits). This approach ensures comprehensive coverage of both typical and edge-case scenarios for the JFreeChart utility classes.

# 4 How the team work/effort was divided and managed

We divided up the methods between us and each team member wrote unit tests for two or three methods. Then we pushed our code to Github and reviewed each other's test cases. We each wrote tests for the following methods:

**Kamand:**
- *DataUtils:* caculateColumnTotal & calculateRowTotal
- *Range:* getCentralValue & Contains

**Issy:**
- *DataUtils:* getCumlativePercentages
- *Range:* expand

**Spiro:**
- *DataUtils:* createNumberArray & createNumberArray2D
- *Range:* N/A

**Dylan:**
- *DataUtils:* N/A
- *Range:* shift & combine<br>


# 5 Difficulties encountered, challenges overcome, and lessons learned

**Kamand:** It was a bit difficult to develop the partitions and boundary values for testing some methods as the documentation was limited or unclear, so some of the things were left to the tester's assumptions and understanding. For instance, the documentation stated that for the caulcateColumnTotal method, a total of zero will be returned for invalid inputs but then stated an InvalidParameterException is thrown if an invalid data object is passed in. 

**Issy:** When it came to the getCumlativePercentages function, I found the macking one the KeyedValues object parameter to be complex. This is due to that there was no way to create and assign values to the object without seeing the code for it, meaning I had to mock all of its function calls. Similarly, I found writing unit tests for black testing to be kinda difficult and potentially counterproductive as I spent additional time mocking functions which the function I am testing may never even call. This sometimes made it difficult to identify whether a test was failing due to how it was created or due the function itself. The documentation was also slightly vague for this function as it did not specify what should happen in specific use cases. For instance, if the KeyedValues contained a negative value we do not know what the expected output of the function should be, without this information unit tests could not be written for it. 

**Spiro:** I would say it was a bit more challenging than the first assignment; a lot more to learn. One thing I noticed was that cetain methods testing would have multiple opinions on how to go about testing them. Specifically with the createNumberArray method. Overall, I personally learned a lot and am looking forward to the upcoming assignments. 

**Dylan:** Theorizing boundary values and making sure all cases were covered was challenging. In the Range class, there were several functions such as intersacts and equals where I found bugs in scenarios that I had not considered earlier. I learned the importance of utilizing parameterized tests when working with redundant test cases. Both equal and intersecting classes had two basic outcomes; true or false. By parameterized tests, I was able to set up two general functions that were run through a dataset depending on their expected outcomes. 

# 6 Comments/feedback on the lab itself
**Kamand:** Overall the lab was a good introduction to black-box testing, especially using Junit and JMock. There were some discrepancies between the lab document and the JFreeChart SUT provided (eg. the number of methods specified in the lab document for Range versus how many were in the code files). 

**Issy:** The lab was a great introduction to using Junit and JMock. I appreciated that there were instructions on how to set up your eclipse environment for running unit tests. This displayed the benefits and drawbacks of black-box testing and why it is needed. 

**Spiro:** The lab itself was a great way to start with automated testing using JUnit. I did find the instructions to be of great help overall. 

**Dylan:**I enjoyed that lab as it gave a hands-on experience in testing a sizable system. I believe it helped me grasp the concepts of unit testing and gave me a good idea of how to test for external dependencies using mocking. 