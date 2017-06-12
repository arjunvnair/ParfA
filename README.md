# ParfA
Relying on a basic I/O scheme and lexicon that can be understood by the average English speaker, ParfA's goal is to be the programming language that even your grandpa can pick up in a few minutes.

## White Space
````
;
\t 
````

Semicolons, tabs, and, of course, blank spaces, are not recognized by the compiler. To distinguish between statements, press enter or return, depending on whether the computer is running Windows OS or Mac OS respectively

## Keywords
````
if(condition) {} //Executes the block of code if condition is true
wait(num) //Waits num seconds
waitUntil(condition) //Waits until the condition is true before moving on to the next statements
repeatUntil(condition) {} //Repeats the block of code until condition is true
loop(num) {} //Loops through block of code num times
forever {} //Loops through block of code until program stops running
announce (statement) //Prints statement to screen
ask (statement) //Prints statement to screen and requests user input
answer //Whatever the user typed in
````

## Separators
````
() //Parentheses
{} //Brackets for holding together several statements of code
````

## Operators
````
+, -, *, / //Arithmetic operators, order of operations applies
% //Modulus, gives you the remainder after dividing the first number by the second number
and, &, && //Used to connect two boolean statements, indicating that both of them must be true for the entire AND statement to evaluate as true
or, |, || //Used to connect two boolean statements, indicating that at least one of them must be true for the entire OR statement to evaluate as true
not, ! //Used to negate a boolean statement, returning the opposite of the boolean's value (ex. true becomes false, false becomes true)
equals, == //Used to check equality between two elements, evaluates to true if the data is equal
doesnotequal, != //Used to check inequality between two elements, evaluates to true if the data is not equal
store, = //Used to store the value on the right in the variable on the left
````
