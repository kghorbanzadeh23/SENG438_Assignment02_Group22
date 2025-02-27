Using Test_Plan_Sample on d2L (under chapter 2) as reference.
# Test Plan
### SENG 438 Assignment 2

## Table of Contents
- [INTRODUCTION](#introduction)
- [1 TEST STRATEGY](#1-test-strategy)
  - [1.1 Test Type](#11-test-type)
  - [1.2 Scope of Testing](#12-scope-of-testing)
    - [1.2.1 Features to be Tested](#121-features-to-be-tested)
    - [1.2.2 Features Not to be Tested](#122-features-not-to-be-tested)
  - [1.3 Risk and Issues](#13-risk-and-issues)
  - [1.4 Test Logistics](#14-test-logistics)
    - [1.4.1 Who will test?](#141-who-will-test)
    - [1.4.2 When will test occur?](#142-when-will-test-occur)
- [2 TEST OBJECTIVE](#2-test-objective)
- [3 TEST CRITERIA](#3-test-criteria)
  - [3.1 Suspension Criteria](#31-suspension-criteria)
  - [3.2 Exit Criteria](#32-exit-criteria)
- [4 RESOURCE PLANNING](#4-resource-planning)
  - [4.1 System Resource](#41-system-resource)
  - [4.2 Human Resource](#42-human-resource)
- [5 TEST ENVIRONMENT](#5-test-environment)
- [6 SCHEDULE & ESTIMATION](#6-schedule--estimation)
  - [6.1 All project task and estimation](#61-all-project-task-and-estimation)
  - [6.2 Schedule to complete these tasks](#62-schedule-to-complete-these-tasks)
- [7 TEST DELIVERABLES](#7-test-deliverables)
  - [7.1 Before testing phase](#71-before-testing-phase)
  - [7.2 During the testing](#72-during-the-testing)
  - [7.3 After the testing cycles is over](#73-after-the-testing-cycles-is-over)
- [8 TEST CASE DESIGN](#8-test-case-design)
  - [8.1 Equivalence Partitioning and Boundary Value Analysis](#81-equivalence-partitioning-and-boundary-value-analysis)
    - [8.1.1 DataUtilities class](#811-datautilities-class)
    - [8.1.2 Range class](#812-range-class)
- [9 TEST CASES](#9-test-cases)
  - [9.1 DataUtilities class](#91-datautilities-class)
  - [9.2 Range class](#92-range-class)
- [CONCLUSION](#conclusion)

## INTRODUCTION
The objective of this test plan is to create unit tests for the `org.jfree.data.DataUtilities` and `org.jfree.data.Range` classes based on their specifications. The tests will ensure that the methods in these classes function correctly and handle edge cases appropriately.

## 1 TEST STRATEGY
### 1.1 Test Type
- **Unit Testing**: Testing individual methods and classes.
- **Integration Testing**: Testing the interaction between methods and classes.
- **Black-box testing**: Since we are given requirements only, we applied black-box test case design techniques.

### 1.2 Scope of Testing
#### 1.2.1 Features to be Tested
- All methods of `DataUtilities`:
  - `calculateColumnTotal(Values2D data, int column)`
  - `calculateRowTotal(Values2D data, int row)`
  - `createNumberArray(double[] data)`
  - `createNumberArray2D(double[][] data)`
  - `getCumulativePercentages(KeyedValues data)`
- Selected methods of `Range` (5 of 15):
  - `getCentralValue()`
  - `contains(double value)`
  - `expand(Range base, double lowerMargin, double upperMargin)`
  - `shift(Range base, double delta)`
  - `combine(Range range1, Range range2)`

#### 1.2.2 Features Not to be Tested
- User interfaces.
- Performance and load testing.

### 1.3 Risk and Issues
- **Risk**: Incompatibility of library versions.
  - **Mitigation**: Verify compatibility of Java SE, JUnit, and JMock versions before starting.

### 1.4 Test Logistics
#### 1.4.1 Who will test?
- For this assignment, all 4 team members acted as testers to ensure thorough testing.

#### 1.4.2 When will test occur?
- The tester will start the test execution when all the following inputs are ready:
  - Software is available for testing.
  - Test Specification is created.
  - Test Environment is built.
  - Enough human resources for testing.

## 2 TEST OBJECTIVE
The test objectives are to verify the functionality of the `org.jfree.data.DataUtilities` and `org.jfree.data.Range` classes. The test cases should focus on testing the methods to guarantee they work correctly in various scenarios.

## 3 TEST CRITERIA
### 3.1 Suspension Criteria
- If 40% of test cases fail, suspend testing until the development team fixes all the failed cases.

### 3.2 Exit Criteria
- All test cases must be executed.
- Pass rate must be at least 80%.

## 4 RESOURCE PLANNING
### 4.1 System Resource
- Eclipse IDE with JUnit and jMock plugins.
- Java SE Development Kit.

### 4.2 Human Resource
- Test Manager: Oversees the testing process.
- Testers: Write and execute test cases.
- Developers: Fix issues found during testing.

## 5 TEST ENVIRONMENT
- **Hardware**: Computers with at least 4GB RAM and dual-core processors.
- **Software**: Windows 10, Eclipse IDE, Java SE Development Kit, JUnit, jMock.

## 6 SCHEDULE & ESTIMATION
### 6.1 All project task and estimation
- **Create Test Specification**: 20 hours.
- **Write Test Cases**: 30 hours.
- **Execute Tests**: 20 hours.
- **Report Results**: 10 hours.
These are all hypothetical. For this assignment, scheduling is not necessary; however, it is included to mirror the provided example on d2L.

### 6.2 Schedule to complete these tasks
- **Week 1**: Create test specification.
- **Week 1**: Write test cases.
- **Week 2**: Execute tests.
- **Week 2**: Report results.

## 7 TEST DELIVERABLES
### 7.1 Before testing phase
- Test plan document.
- Test cases document.

### 7.2 During the testing
- Test execution logs.
- Defect logs.

### 7.3 After the testing cycles is over
- Test results report.
- Defect report.
- Final test summary.

## 8 TEST CASE DESIGN

### 8.1 Equivalence Partitioning and Boundary Value Analysis

#### 8.1.1 DataUtilities class (5 methods)

#### Method: `calculateColumnTotal(Values2D data, int column)`
- **Equivalence Classes**:
  - Valid `Values2D` object with multiple rows.
  - Valid `Values2D` object with zero rows.
  - Invalid `Values2D` object (null).
- **Boundary Values**:
  - Column index at the lower boundary (0).
  - Column index at the upper boundary (number of columns - 1).

#### Method: `calculateRowTotal(Values2D data, int row)`
- **Equivalence Classes**:
  - Valid `Values2D` object with multiple columns.
  - Valid `Values2D` object with zero columns.
  - Invalid `Values2D` object (null).
- **Boundary Values**:
  - Row index at the lower boundary (0).
  - Row index at the upper boundary (number of rows - 1).

#### Method: `createNumberArray(double[] data)`
- **Equivalence Classes**:
  - Valid double array with multiple elements.
  - Valid double array with zero elements.
  - Invalid double array (null).
- **Boundary Values**:
  - Array length at the lower boundary (0).
  - Array length at the upper boundary (maximum array size).

#### Method: `createNumberArray2D(double[][] data)`
- **Equivalence Classes**:
  - Valid 2D double array with multiple rows and columns.
  - Valid 2D double array with zero rows and columns.
  - Invalid 2D double array (null or containing null rows/columns).
  - Valid rows with zero columns or zero rows with valid columns.
- **Boundary Values**:
  - Array dimensions at the lower boundary (0).
  - Array dimensions at the upper boundary (maximum array size).

#### Method: `getCumulativePercentages(KeyedValues data)`
- **Equivalence Classes**:
  - Valid `KeyedValues` object with multiple keys.
  - Valid `KeyedValues` object with zero keys.
  - Invalid `KeyedValues` object (null).
- **Boundary Values**:
  - Number of keys at the lower boundary (0).
  - Number of keys at the upper boundary (maximum number of keys).

#### 8.1.2 Range class (5 of 15 methods)

#### Method: `getCentralValue()`
- **Equivalence Classes**:
  - Range with positive bounds.
  - Range with negative bounds.
  - Range with zero bounds.
  - Range with a negative lower bound and a positive upper bound.
  - Range with a positive lower bound and a negative upper bound.
- **Boundary Values**:
  - Lower bound at the lower boundary.
  - Upper bound at the upper boundary.

#### Method: `contains(double value)`
- **Equivalence Classes**:
  - Value within the range.
  - Value outside the range.
- **Boundary Values**:
  - Value at the lower boundary.
  - Value at the upper boundary.

#### Method: `expand(Range base, double lowerMargin, double upperMargin)`
- **Equivalence Classes**:
  - Valid range with positive margins.
  - Valid range with negative margins.
  - Invalid range (null).
- **Boundary Values**:
  - Margins at the lower boundary (0).
  - Margins at the upper boundary (maximum margin).

#### Method: `shift(Range base, double delta)`
- **Equivalence Classes**:
  - Valid range with positive delta.
  - Valid range with negative delta.
  - Invalid range (null).
- **Boundary Values**:
  - Delta at the lower boundary (0).
  - Delta at the upper boundary (maximum delta).

#### Method: `combine(Range range1, Range range2)`
- **Equivalence Classes**:
  - Two valid ranges.
  - One valid and one null range.
  - Two null ranges.
- **Boundary Values**:
  - Range bounds at the lower boundary.
  - Range bounds at the upper boundary.

## 9 TEST CASES
Using TestCase_Sample on D2L (under chapter 2) as rough reference - not followed exactly and modified to adhere to requirements.

### 9.1 DataUtilities class

#### Test Case ID: DU_001
Test Case Description: Test `calculateColumnTotal` with multiple rows, summing column correctly<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br> 
Test Data: Values2D with three rows: {1.5, 2.5, 3.0} in column index 0<br>
Expected Results: 7.0 (1.5 + 2.5 + 3.0)<br>
Actual Results: 7.0<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_002
Test Case Description: Test `calculateColumnTotal` with an empty Values2D (no rows)<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br> 
Test Data: Empty Values2D with zero rows<br>
Expected Results: 0.0 (no data to sum)<br>
Actual Results: 0.0<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_003
Test Case Description: Test `calculateColumnTotal` with a null Values2D, expecting an exception<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br> 
Test Data: null passed as Values2D<br>
Expected Results: NullPointerException<br>
Actual Results: NullPointerException<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_004
Test Case Description: Test `calculateColumnTotal` with null values in the column (should be ignored)<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br> 
Test Data: Values2D with three rows: {null, 4.0, 6.0} in column index 0<br>
Expected Results: 10.0 (null ignored, so 4.0 + 6.0 = 10.0)<br>
Actual Results: 11.0<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_005
Test Case Description: Test `calculateColumnTotal` with an out-of-bounds column index<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br> 
Test Data: Values2D with three rows, attempting to access column index 5 (out of bounds)<br>
Expected Results: IndexOutOfBoundsException<br>
Actual Results: IndexOutOfBoundsException<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_006
Test Case Description: Test `calculateRowTotal` with a valid Values2D object containing multiple columns.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Values2D object with 1 row and 2 columns, row index 0, values: 2.0 in column 0, 3.0 in column 1.<br>
Expected Results: 5.0 (2.0 + 3.0).<br>
Actual Results: 2.0.<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_007
Test Case Description: Test `calculateRowTotal` with a valid Values2D object containing zero columns.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Values2D object with 1 row and 0 columns, row index 1.<br>
Expected Results: 0.0 (sum of zero columns is 0.0).<br>
Actual Results: 0.0.<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_008
Test Case Description: Test `calculateRowTotal` when Values2D object is null.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Values2D object is null, row index 1.<br>
Expected Results: Throws a NullPointerException.<br>
Actual Results: NullPointerException thrown.<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_009
Test Case Description: Test `calculateRowTotal` when row index is at the lower boundary (0).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Values2D object with 1 row and 2 columns, row index 0, values: 5.0 in column 0, 7.0 in column 1.<br>
Expected Results: 12.0 (5.0 + 7.0).<br>
Actual Results: 5.0.<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_010
Test Case Description: Test `calculateRowTotal` when row index is at the upper boundary (number of rows - 1).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Values2D object with 3 rows and 2 columns, row index 2, values: 8.0 in column 0, 6.0 in column 1.<br>
Expected Results: 14.0 (8.0 + 6.0).<br>
Actual Results: 8.0.<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_011
Test Case Description: Test `createNumberArray` with a valid double array containing multiple elements.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {1.0, 2.0, 3.0}<br>
Expected Results: {1.0, 2.0, 3.0} as Number[]<br>
Actual Results: {1.0} as Number[]<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_012
Test Case Description: Test `createNumberArray` with an empty double array.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {} (empty array)<br>
Expected Results: {} as Number[]<br>
Actual Results: {} as Number[]<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_013
Test Case Description: Test `createNumberArray` with a null array (invalid input).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: null<br>
Expected Results: IllegalArgumentExceptionActual<br> 
Results: IllegalArgumentException<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_014
Test Case Description: Test `createNumberArray` with an array length at the lower boundary (0 elements).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {} (empty array)<br>
Expected Results: {} as Number[]<br>
Actual Results: {} as Number[]<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_015
Test Case Description: Test `createNumberArray` with an array length at the upper boundary (large array size).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Large array with 100000 elements, {0.0, 1.0, 2.0, ..., 99999.0}Expected Results: Converted to Number[] with the same values<br>
Actual Results: Converted to Number[] with incorrect values<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_016
Test Case Description: Test `createNumberArray2D` with multiple rows and columns. <br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {{1.0, 2.0}, {3.0, 4.0}}<br>
Expected Results: {{1.0, 2.0}, {3.0, 4.0}} as Number[][]<br>
Actual Results: Unexpected value conversion error<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_017
Test Case Description: Test `createNumberArray2D` with zero rows and columns.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {} (empty 2D array)<br>
Expected Results: {} as Number[][]<br>
Actual Results: {} as Number[][]<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_018
Test Case Description: Test `createNumberArray2D` with a null array (invalid input).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: null<br>
Expected Results: IllegalArgumentException<br>
Actual Results: IllegalArgumentException<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_019
Test Case Description: Test `createNumberArray2D` with a 2D array containing a null row.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {{1.0, 2.0}, null, {3.0, 4.0}}<br>
Expected Results: IllegalArgumentException<br>
Actual Results: IllegalArgumentException<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_020
Test Case Description: Test `createNumberArray2D` with a 2D array containing a null column.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {{1.0, 2.0}, {3.0, Double.NaN}, {5.0, 6.0}}<br>
Expected Results: IllegalArgumentException<br>
Actual Results: Function does not properly handle Double.NaN as a null column<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_021
Test Case Description: Test `createNumberArray2D` with valid rows and zero columns.<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: {{}, {}, {}}<br>
Expected Results: {{}, {}, {}} as Number[][]<br>
Actual Results: {{}, {}, {}} as Number[][]<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_022
Test Case Description: Test `createNumberArray2D` with array dimensions at the lower boundary (0 rows, 0 columns).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: new double[0][0]<br>
Expected Results: new Number[0][0]<br>
Actual Results: new Number[0][0]<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: DU_023
Test Case Description: Test `createNumberArray2D` with array dimensions at the upper boundary (maximum size).<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Large 2D array with 500x500 elements<br>
Expected Results: Correct conversion to Number[][]<br>
Actual Results: Unexpected value conversion error<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: DU_024
Test Case Description: Test `getCumulativePercentages` with multiple keys.
Reviewed By: Group 22
Version: 1.0
Date Tested: 24-Feb-2025
Test Data: {("A", 2.0), ("B", 3.0), ("C", 5.0)}
Expected Results: {("A", 0.2), ("B", 0.5), ("C", 1.0)}
Actual Results: Incorrect percentage calculations
Test Case (Pass/Fail/Not Executed): Fail

#### Test Case ID: DU_025
Test Case Description: Test `getCumulativePercentages` with zero keys (empty dataset).
Reviewed By: Group 22
Version: 1.0
Date Tested: 24-Feb-2025
Test Data: {}
Expected Results: {}
Actual Results: {}
Test Case (Pass/Fail/Not Executed): Pass

#### Test Case ID: DU_026
Test Case Description: Test `getCumulativePercentages` with a null KeyedValues object.
Reviewed By: Group 22
Version: 1.0
Date Tested: 24-Feb-2025
Test Data: null
Expected Results: IllegalArgumentException
Actual Results: IllegalArgumentException
Test Case (Pass/Fail/Not Executed): Pass

#### Test Case ID: DU_027
Test Case Description: Test `getCumulativePercentages` at the lower boundary (1 key).
Reviewed By: Group 22
Version: 1.0
Date Tested: 24-Feb-2025
Test Data: {("X", 4.0)}
Expected Results: {("X", 1.0)}
Actual Results: Incorrect calculation
Test Case (Pass/Fail/Not Executed): Fail

#### Test Case ID: DU_028
Test Case Description: Test `getCumulativePercentages` at the upper boundary (large dataset).
Reviewed By: Group 22
Version: 1.0
Date Tested: 24-Feb-2025
Test Data: {(1, 1.0), (2, 1.0), ..., (10000, 1.0)}
Expected Results: {(10000, 1.0)}
Actual Results: Unexpected cumulative percentage errors
Test Case (Pass/Fail/Not Executed): Fail

### 9.2 Range class

#### Test Case ID: RU_001

Test Case Description: Test `getCentralValue` with positive bounds<br>
Reviewed By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025 <br>
Test Data: Range with lower bound 10.0 and upper bound 20.0 <br>
Expected Results: 15.0 <br>
Actual Results: 15.0<br> 
Test Case (Pass/Fail/Not Executed): Pass <br>

#### Test Case ID: RU_002

Test Case Description: Test `getCentralValue` with negative bounds<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound -20.0 and upper bound -10.0<br>
Expected Results: -15.0<br>
Actual Results: -15.0<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_003

Test Case Description: Test `getCentralValue` with zero bounds<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 0.0 and upper bound 0.0<br>
Expected Results: 0.0<br>
Actual Results: 0.0<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_004

Test Case Description: Test `getCentralValue` with a negative lower bound and positive upper bound <br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound -10.0 and upper bound 10.0<br>
Expected Results: 0.0<br>
Actual Results: 0.0<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_005

Test Case Description: Test `getCentralValue` with lower bound at the lower boundary (extremely large negative value)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound -Double.MAX_VALUE and upper bound -Double.MAX_VALUE + 10<br>
Expected Results: -Double.MAX_VALUE + 5<br>
Actual Results: -Double.MAX_VALUE + 5<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_006

Test Case Description: Test `getCentralValue` with a positive lower bound and negative upper bound (invalid range)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 10.0 and upper bound -10.0<br>
Expected Results: IllegalArgumentExceptionActual<br>
Results: IllegalArgumentException<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_007

Test Case Description: Test `getCentralValue` with upper bound at the upper boundary (extremely large positive value)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound Double.MAX_VALUE - 10 and upper bound Double.MAX_VALUE<br>
Expected Results: Double.MAX_VALUE - 5<br>
Actual Results: Double.MAX_VALUE - 5<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_008

Test Case Description: Test `contains` with value within the range<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 1.0 and upper bound 5.0, value = 3.0<br>
Expected Results: true<br>
Actual Results: true<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_009

Test Case Description: Test `contains` with value outside the range (less than lower bound)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 1.0 and upper bound 5.0, value = 0.0<br>
Expected Results: false<br>
Actual Results: false<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_010

Test Case Description: Test `contains` with value outside the range (greater than upper bound)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 1.0 and upper bound 5.0, value = 6.0<br>
Expected Results: false<br>
Actual Results: false<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_011

Test Case Description: Test `contains` with value at the lower boundary<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 1.0 and upper bound 5.0, value = 1.0<br>
Expected Results: true<br>
Actual Results: true<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_012

Test Case Description: Test `contains` with value at the upper boundary<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 1.0 and upper bound 5.0, value = 5.0<br>
Expected Results: true<br>
Actual Results: true<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_013

Test Case Description: Test `expand` with valid range and positive margins<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, lower margin = 0.5, upper margin = 0.5<br>
Expected Results: Lower bound = 0.0, Upper bound = 8.0<br>
Actual Results: Lower bound != 0.0, Upper bound != 8.0<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_014

Test Case Description: Test `expand` with valid range and zero margins<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, lower margin = 0.0, upper margin = 0.0<br>
Expected Results: Lower bound = 2.0, Upper bound = 6.0<br>
Actual Results: Lower bound != 2.0, Upper bound != 6.0<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_015

Test Case Description: Test `expand` with null range<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Null range, lower margin = 0.5, upper margin = 0.5<br>
Expected Results: IllegalArgumentException thrown<br>
Actual Results: IllegalArgumentException thrown<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_016

Test Case Description: Test `expand` with margins at the lower boundary (0)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, lower margin = 0.0, upper margin = 0.0<br>
Expected Results: Lower bound = 2.0, Upper bound = 6.0<br>
Actual Results: Lower bound != 2.0, Upper bound != 6.0<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_017

Test Case Description: Test `expand` with margins at the upper boundary (maximum margin)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, lower margin = 1.0, upper margin = 1.0<br>
Expected Results: Lower bound = -2.0, Upper bound = 10.0<br>
Actual Results: Lower bound != -2.0, Upper bound != 10.0<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_018

Test Case Description: Test `shift` with valid range and positive delta<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, delta = 3.0<br>
Expected Results: Lower bound = 5.0, Upper bound = 9.0<br>
Actual Results: Unexpected values returned<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_019

Test Case Description: Test `shift` with valid range and negative delta<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, delta = -2.0<br>
Expected Results: Lower bound = 0.0, Upper bound = 4.0<br>
Actual Results: Unexpected values returned<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_020

Test Case Description: Test `shift` with null range<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Null range, delta = 2.0<br>
Expected Results: Exception thrown<br>
Actual Results: Exception thrown<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_021

Test Case Description: Test `shift` with delta at the lower boundary (0)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, delta = 0.0<br>
Expected Results: Lower bound = 2.0, Upper bound = 6.0<br>
Actual Results: Unexpected values returned<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

 #### Test Case ID: RU_022

Test Case Description: Test `shift` with delta at the upper boundary (large value)<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range with lower bound 2.0 and upper bound 6.0, delta = Double.MAX_VALUE / 2<br>
Expected Results: Lower bound = 2.0 + Double.MAX_VALUE / 2, Upper bound = 6.0 + Double.MAX_VALUE / 2<br>
Actual Results: Lower bound = 2.0 + Double.MAX_VALUE / 2, Upper bound = 6.0 + Double.MAX_VALUE / 2<br>
Test Case (Pass/Fail/Not Executed): Pass<br>


#### Test Case ID: RU_024

Test Case Description: Test `combine` with two valid ranges<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range1 (2.0, 6.0), Range2 (4.0, 8.0)<br>
Expected Results: Lower bound = 2.0, Upper bound = 8.0<br>
Actual Results: Incorrect Result<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_025

Test Case Description: Test `combine` with first range null and second range valid<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range1 = null, Range2 (3.0, 7.0)<br>
Expected Results: Lower bound = 3.0, Upper bound = 7.0<br>
Actual Results: Incorrect result<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_026

Test Case Description: Test `combine` with first range valid and second range null<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range1 (1.0, 5.0), Range2 = null<br>
Expected Results: Lower bound = 1.0, Upper bound = 5.0<br>
Actual Results: Incorrect result<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_027

Test Case Description: Test `combine` with both ranges null<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range1 = null, Range2 = null<br>
Expected Results: Null result<br>
Actual Results: Null result<br>
Test Case (Pass/Fail/Not Executed): Pass<br>

#### Test Case ID: RU_028

Test Case Description: Test `combine` with range bounds at the lower boundary<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range1 (Double.NEGATIVE_INFINITY, -10.0), Range2 (-20.0, -5.0)<br>
Expected Results: Lower bound = Double.NEGATIVE_INFINITY, Upper bound = -5.0<br>
Actual Results: Incorrect Result<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

#### Test Case ID: RU_029

Test Case Description: Test `combine` with range bounds at the upper boundary<br>
Created By: Group 22<br>
Version: 1.0<br>
Date Tested: 24-Feb-2025<br>
Test Data: Range1 (10.0, Double.POSITIVE_INFINITY), Range2 (5.0, 20.0)<br>
Expected Results: Lower bound = 5.0, Upper bound = Double.POSITIVE_INFINITY<br>
Actual Results: Incorrect result<br>
Test Case (Pass/Fail/Not Executed): Fail<br>

# Conclusion
This test plan outlines the strategy and approach for testing the `org.jfree.data.DataUtilities` and `org.jfree.data.Range` classes. The test cases are designed using black-box testing techniques such as equivalence partitioning and boundary value analysis. The tests will be executed in the Eclipse IDE using JUnit and jMock.
