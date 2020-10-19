# ZipCode

----------------------------------------------------------------------------------------------------------------------
# Problem Statement: 

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

# Input Description :
1) Assumed input to come as String : "[94133, 94133] [94200, 94299] [94600, 94699]"

# Java File Description:
1) App.java --> Main driver than reads the input and drives the zipcode processor
2) ZipCode.java --> Data model to store the lower bound and upper bound of zipcode
3) ZipCodeMerge.java --> Merge ZipCode Range 
4) ZipCodePreProcessor.java --> pre-process raw date into ZipCode Type, validate and sort them with List


# Output Description:
1) An List of ZipCode Type 

# Tests:
1) Wrote Junit tests to validate different scenarios of input

  
  
  
