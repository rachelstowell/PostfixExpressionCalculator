# PostfixExpressionCalculator
I. The Input

    All expressions are stored in a file called "testing.dat". The file 
contains a sequence of arithmetic expressions in the postfix form, 
one per line. For example, the following file has two expressions:

    2 3 ^ 35 5 / -
    1 2 + 3 * # 4 - 5 6 - + _

There is at least one space to separate the operators and operands.
All operands and values are considered as doubles. 

    The following are the operators:

    +, -, *, /    arithmetic operators
    _             unary negation
    #             square root
    ^             exponentiation (a b ^ = a raised to the power b)

    There is a carriage-return at the end of the last expression.

II. The Output

    For each expression, this program will print the expression,
calculate its value, and show the result.

III. An example

    Hello! This is a postfix expression calculator.

    The value of "2 3 ^ 35 5 / -" is 1.0

    The value of "1 2 + 3 * # 4 - 5 6 - + _" is 2.0

    Bye-bye!