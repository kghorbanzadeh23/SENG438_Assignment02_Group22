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

Our test strategy focuses on applying black-box testing techniques, specifically Equivalence Class Testing (ECT) and Boundary Value Testing (BVT) to thoroughly test the DataUtilities and Range classes. These techniques allow us to effectively test the functionality without knowledge of the internal implementation.

## Partitions and Boundary Values for DataUtilities Class

### 1. calculateColumnTotal(Values2D data, int column)

**Parameter: data**
- *Valid Partitions:*
    - Valid Values2D object with multiple rows
    - Valid Values2D object with zero rows
- *Invalid Partitions:*
    - null Values2D
- *Boundary Values:* N/A

**Parameter: column**
- *Valid Partitions:*
    - Valid column index within range of data
- *Invalid Partitions:*
    - Negative column index
    - Column index is greater than or equal to number of columns
- *Boundary Values:*
    - Lower bound: 0
    - Upper bound: number of columns - 1

**Values:**
- *Valid Partitions:*
    - Rows with numeric values
    - Rows with null values (should be ignored)
- *Invalid Partitions:* N/A
- *Boundary Values:* N/A

### 2. calculateRowTotal(Values2D data, int row)

**Parameter: data**
- *Valid Partitions:*
    - Valid Values2D object with multiple columns
    - Valid Values2D object with zero columns
- *Invalid Partitions:*
    - null Values2D
- *Boundary Values:* N/A

**Parameter: row**
- *Valid Partitions:*
    - Valid row index within range of data
- *Invalid Partitions:*
    - Negative row index
    - Row index is greater than or equal number of rows
- *Boundary Values:*
    - Lower bound: 0
    - Upper bound: number of rows - 1

**Values:**
- *Valid Partitions:*
    - Columns with numeric values
    - Columns with null values (should be ignored)
- *Invalid Partitions:* N/A
- *Boundary Values:* N/A

### 3. createNumberArray(double[] data)

**Parameter: data**
- *Valid Partitions:*
    - Valid double array with multiple elements
    - Valid double array with zero elements
- *Invalid Partitions:*
    - null double array
- *Boundary Values:*
    - Lower bound: array length = 0
    - Upper bound: large array size

### 4. createNumberArray2D(double[][] data)

**Parameter: data**
- *Valid Partitions:*
    - Valid 2D array with multiple rows and columns
    - Valid 2D array with zero rows/columns
    - Valid 2D array with rows and zero columns
- *Invalid Partitions:*
    - null 2D array
    - 2D array containing null rows
    - 2D array containing NaN values
- *Boundary Values:*
    - Lower bound: 0 rows, 0 columns
    - Upper bound: large array dimensions

### 5. getCumulativePercentages(KeyedValues data)

**Parameter: data**
- *Valid Partitions:*
    - Valid KeyedValues with multiple keys
    - Valid KeyedValues with zero keys
- *Invalid Partitions:*
    - null KeyedValues
- *Boundary Values:*
    - Lower bound: 1 key
    - Upper bound: large dataset

**Values:**
- *Valid Partitions:*
    - All positive values
    - Mixed positive and zero values
- *Invalid Partitions:*
    - Negative values (behavior undefined)
- *Boundary Values:* N/A

## Partitions and Boundary Values for Range Class

### 1. getCentralValue()

**Parameter: Range bounds**
- *Valid Partitions:*
    - Range with positive bounds
    - Range with negative bounds
    - Range with zero bounds
    - Range with negative lower bound and positive upper bound
- *Invalid Partitions:*
    - Range with lower bound is greater than upper bound
- *Boundary Values:*
    - Lower boundary: extremely large negative value
    - Upper boundary: extremely large positive value

### 2. contains(double value)

**Parameter: value**
- *Valid Partitions:*
    - Value within range
    - Value outside range (less than lower bound)
    - Value outside range (greater than upper bound)
- *Invalid Partitions:* N/A
- *Boundary Values:*
    - Value at lower boundary
    - Value at upper boundary

### 3. expand(Range base, double lowerMargin, double upperMargin)

**Parameter: base**
- *Valid Partitions:*
    - Valid Range
- *Invalid Partitions:*
    - null Range
- *Boundary Values:* N/A

**Parameter: lowerMargin**
- *Valid Partitions:*
    - Zero margin
    - Positive margin
- *Invalid Partitions:*
    - Negative margin (behavior undefined)
- *Boundary Values:*
    - Lower bound: 0
    - Upper bound: 1.0 (or larger)

**Parameter: upperMargin**
- *Valid Partitions:*
    - Zero margin
    - Positive margin
- *Invalid Partitions:*
    - Negative margin (behavior undefined)
- *Boundary Values:*
    - Lower bound: 0
    - Upper bound: 1.0 (or larger)

### 4. shift(Range base, double delta)

**Parameter: base**
- *Valid Partitions:*
    - Valid Range
- *Invalid Partitions:*
    - null Range
- *Boundary Values:* N/A

**Parameter: delta**
- *Valid Partitions:*
    - Zero delta
    - Positive delta
    - Negative delta
- *Invalid Partitions:* N/A
- *Boundary Values:*
    - Lower bound: 0
    - Upper bound: large value

### 5. combine(Range range1, Range range2)

**Parameter: range1**
- *Valid Partitions:*
    - Valid Range
- *Invalid Partitions:*
    - null Range
- *Boundary Values:*
    - Range with extremely low bounds
    - Range with extremely high bounds

**Parameter: range2**
- *Valid Partitions:*
    - Valid Range
- *Invalid Partitions:*
    - null Range
- *Boundary Values:*
    - Range with extremely low bounds
    - Range with extremely high bounds

**Combination:**
- *Valid Partitions:*
    - Two valid ranges
    - One valid range and one null range
    - Two null ranges
- *Invalid Partitions:* N/A
- *Boundary Values:* N/A

# 3 Test cases developed

### DataUtilities Class

#### calculateColumnTotal(Values2D data, int column)

- **testCalculateColumnTotal_ValidMultipleRows()**
    - *Partitions tested:* Valid Values2D with multiple rows, Valid column index, Rows with numeric values
    - *Boundary values tested:* N/A

- **testCalculateColumnTotal_EmptyData()**
    - *Partitions tested:* Valid Values2D with zero rows
    - *Boundary values tested:* N/A

- **testCalculateColumnTotal_NullInput_ThrowsException()**
    - *Partitions tested:* null Values2D
    - *Boundary values tested:* N/A

- **testCalculateColumnTotal_WithNullValues_Ignored()**
    - *Partitions tested:* Rows with null values (should be ignored)
    - *Boundary values tested:* N/A

- **testCalculateColumnTotal_IndexOutOfBounds()**
    - *Partitions tested:* Column index greater than or equal to number of columns
    - *Boundary values tested:* N/A

#### calculateRowTotal(Values2D data, int row)

- **testCalculateRowTotal_ValidMultipleColumns()**
    - *Partitions tested:* Valid Values2D with multiple columns, Valid row index, Columns with numeric values
    - *Boundary values tested:* N/A

- **testCalculateRowTotal_EmptyRow()**
    - *Partitions tested:* Valid Values2D with zero columns
    - *Boundary values tested:* N/A

- **testCalculateRowTotal_NullInput_ThrowsException()**
    - *Partitions tested:* null Values2D
    - *Boundary values tested:* N/A

- **testCalculateRowTotal_RowIndexLowerBoundary()**
    - *Partitions tested:* Valid row index
    - *Boundary values tested:* Lower bound: row index = 0

- **testCalculateRowTotal_RowIndexUpperBoundary()**
    - *Partitions tested:* Valid row index
    - *Boundary values tested:* Upper bound: row index = number of rows - 1

#### createNumberArray(double[] data)

- **testCreateNumberArray_ValidArray()**
    - *Partitions tested:* Valid double array with multiple elements
    - *Boundary values tested:* N/A

- **testCreateNumberArray_EmptyArray()**
    - *Partitions tested:* Valid double array with zero elements
    - *Boundary values tested:* Lower bound: array length = 0

- **testCreateNumberArray_NullArray_ThrowsIllegalArgumentException()**
    - *Partitions tested:* null double array
    - *Boundary values tested:* N/A

- **testCreateNumberArray_LowerBoundary()**
    - *Partitions tested:* Valid double array with zero elements
    - *Boundary values tested:* Lower bound: array length = 0

- **testCreateNumberArray_UpperBoundary()**
    - *Partitions tested:* Valid double array with multiple elements
    - *Boundary values tested:* Upper bound: large array size (100,000 elements)

#### createNumberArray2D(double[][] data)

- **testCreateNumberArray2D_Valid2DArray()**
    - *Partitions tested:* Valid 2D array with multiple rows and columns
    - *Boundary values tested:* N/A

- **testCreateNumberArray2D_Empty2DArray()**
    - *Partitions tested:* Valid 2D array with zero rows/columns
    - *Boundary values tested:* Lower bound: 0 rows, 0 columns

- **testCreateNumberArray2D_NullArray_ThrowsIllegalArgumentException()**
    - *Partitions tested:* null 2D array
    - *Boundary values tested:* N/A

- **testCreateNumberArray2D_ContainingNullRow_ThrowsException()**
    - *Partitions tested:* 2D array containing null rows
    - *Boundary values tested:* N/A

- **testCreateNumberArray2D_NullColumn_ThrowsException()**
    - *Partitions tested:* 2D array containing NaN values
    - *Boundary values tested:* N/A

- **testCreateNumberArray2D_ZeroColumns()**
    - *Partitions tested:* Valid 2D array with rows and zero columns
    - *Boundary values tested:* N/A

- **testCreateNumberArray2D_DimensionsLowerBoundary()**
    - *Partitions tested:* Valid 2D array with zero rows/columns
    - *Boundary values tested:* Lower bound: 0 rows, 0 columns

- **testCreateNumberArray2D_DimensionsUpperBoundary()**
    - *Partitions tested:* Valid 2D array with multiple rows and columns
    - *Boundary values tested:* Upper bound: large array dimensions (500x500)

#### getCumulativePercentages(KeyedValues data)

- **testGetCumulativePercentages_MultipleKeys()**
    - *Partitions tested:* Valid KeyedValues with multiple keys, All positive values
    - *Boundary values tested:* N/A

- **testGetCumulativePercentages_EmptyDataset()**
    - *Partitions tested:* Valid KeyedValues with zero keys
    - *Boundary values tested:* N/A

- **testGetCumulativePercentages_NullInput_ThrowsIllegalArgumentException()**
    - *Partitions tested:* null KeyedValues
    - *Boundary values tested:* N/A

- **testGetCumulativePercentages_SingleKeyBoundary()**
    - *Partitions tested:* Valid KeyedValues with multiple keys
    - *Boundary values tested:* Lower bound: 1 key

- **testGetCumulativePercentages_UpperBoundaryWithLargeDataset()**
    - *Partitions tested:* Valid KeyedValues with multiple keys
    - *Boundary values tested:* Upper bound: large dataset (10,000 keys)

### Range Class

#### getCentralValue()

- **testGetCentralValue_PositiveBounds()**
    - *Partitions tested:* Range with positive bounds
    - *Boundary values tested:* N/A

- **testGetCentralValue_NegativeBounds()**
    - *Partitions tested:* Range with negative bounds
    - *Boundary values tested:* N/A

- **testGetCentralValue_ZeroBounds()**
    - *Partitions tested:* Range with zero bounds
    - *Boundary values tested:* N/A

- **testGetCentralValue_NegativeLower_PositiveUpper()**
    - *Partitions tested:* Range with negative lower bound and positive upper bound
    - *Boundary values tested:* N/A

- **testGetCentralValue_LowerBoundary()**
    - *Partitions tested:* Range with negative bounds
    - *Boundary values tested:* Lower boundary: extremely large negative value

- **testGetCentralValue_InvalidRange_ThrowsException()**
    - *Partitions tested:* Range with lower bound > upper bound
    - *Boundary values tested:* N/A

- **testGetCentralValue_UpperBoundary()**
    - *Partitions tested:* Range with positive bounds
    - *Boundary values tested:* Upper boundary: extremely large positive value

#### contains(double value)

- **testContains_ValueWithinRange()**
    - *Partitions tested:* Value within range
    - *Boundary values tested:* N/A

- **testContains_ValueBelowRange()**
    - *Partitions tested:* Value outside range (less than lower bound)
    - *Boundary values tested:* N/A

- **testContains_ValueAboveRange()**
    - *Partitions tested:* Value outside range (greater than upper bound)
    - *Boundary values tested:* N/A

- **testContains_ValueAtLowerBoundary()**
    - *Partitions tested:* Value within range
    - *Boundary values tested:* Value at lower boundary

- **testContains_ValueAtUpperBoundary()**
    - *Partitions tested:* Value within range
    - *Boundary values tested:* Value at upper boundary

#### expand(Range base, double lowerMargin, double upperMargin)

- **testExpand_ValidRange_PositiveMargins()**
    - *Partitions tested:* Valid Range, Positive margin
    - *Boundary values tested:* N/A

- **testExpand_ValidRange_ZeroMargins()**
    - *Partitions tested:* Valid Range, Zero margin
    - *Boundary values tested:* N/A

- **testExpand_NullRange_ThrowsIllegalArgumentException()**
    - *Partitions tested:* null Range
    - *Boundary values tested:* N/A

- **testExpand_MarginsAtLowerBoundary()**
    - *Partitions tested:* Valid Range, Zero margin
    - *Boundary values tested:* Lower bound: margin = 0

- **testExpand_MarginsAtUpperBoundary()**
    - *Partitions tested:* Valid Range, Positive margin
    - *Boundary values tested:* Upper bound: margin = 1.0

#### shift(Range base, double delta)

- **testShift_ValidRange_PositiveDelta()**
    - *Partitions tested:* Valid Range, Positive delta
    - *Boundary values tested:* N/A

- **testShift_ValidRange_NegativeDelta()**
    - *Partitions tested:* Valid Range, Negative delta
    - *Boundary values tested:* N/A

- **testShift_NullRange_ThrowsException()**
    - *Partitions tested:* null Range
    - *Boundary values tested:* N/A

- **testShift_DeltaAtLowerBoundary()**
    - *Partitions tested:* Valid Range, Zero delta
    - *Boundary values tested:* Lower bound: delta = 0

- **testShift_DeltaAtUpperBoundary()**
    - *Partitions tested:* Valid Range, Positive delta
    - *Boundary values tested:* Upper bound: large value (Double.MAX_VALUE/2)

#### combine(Range range1, Range range2)
- **testCombine_TwoValidRanges()**
    - *Partitions tested:* Two valid ranges
    - *Boundary values tested:* N/A

- **testCombine_FirstRangeNull()**
    - *Partitions tested:* One null range + one valid range
    - *Boundary values tested:* N/A

- **testCombine_SecondRangeNull()**
    - *Partitions tested:* One valid range + one null range
    - *Boundary values tested:* N/A

- **testCombine_BothRangesNull()**
    - *Partitions tested:* Two null ranges
    - *Boundary values tested:* N/A

- **testCombine_LowerBoundary()**
    - *Partitions tested:* Two valid ranges
    - *Boundary values tested:* Range with extremely low bounds (Double.NEGATIVE_INFINITY)

- **testCombine_UpperBoundary()**
    - *Partitions tested:* Two valid ranges
    - *Boundary values tested:* Range with extremely high bounds (Double.POSITIVE_INFINITY)

- **Benefits and Drawbacks of Mocking**
  - **Benefits:**
    - Mocking allows us to isolate whatever code is under test by simulating dependencies, letting us do more focused testing of specific functionalities without requiring that the components actually be implemented.
    - It enables testing of scenarios that might be difficult to reproduce with real dependencies.
    - Increases test speed by eliminating the need to set up complex dependency chains.
    - Provides better control over test conditions, allowing for precise testing of edge cases.
  
  - **Drawbacks:**
    - Creating and configuring mock objects can be time-consuming, especially for complex interfaces like KeyedValues.
    - Mocks may not perfectly replicate the behavior of real objects, potentially leading to tests that pass but fail in production.
    - Over-reliance on mocks can create a disconnect between tests and actual runtime conditions.
    - When interfaces change, all associated mocks require updates, increasing maintenance overhead.
    - Debugging can become more challenging when tests involve multiple layers of mocked objects.

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