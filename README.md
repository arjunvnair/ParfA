![ParfA logo](http://i.imgur.com/yPF8UfJ.png)

## What is ParfA?

ParfA (pronounced "parfait") is a simple text-based programming language made specifically for beginners. Although it doesn't have all the functionality of a real programming language, it can still be used to make a variety of programs, from text-based games to quizzes and calculators, in a matter of minutes. 

## What is ParfA useful for?

ParfA helps beginners write simple program with as little code as possible. Let's consider a program that prompts the user for the length and width of a rectangle. 

In Java, it would look something like this:

````
package com.github;

import java.util.Scanner;

public class CalculateArea
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the length? ");
        double length = scan.nextDouble();
        System.out.println("What is the width? ");
        double width = scan.nextDouble();
        System.out.println("The area is " + length * width + ".");
    }
}
````
What might this program look like in ParfA?
````
ask "What is the length?"
create number length store answer
ask "What is the width?"
create number width store answer
announce "The area is " + length * width + "."
````
This code is a lot easier to read! Of course, there's a lot more to ParfA than performing simple calculations; ParfA has loops, logic operations, and most other features taught in a first year computer science course. Through ParfA, beginners can learn how basic programming structures work on a fundamental level before learning languages like Java that provide more robust functionality at the cost of simplicity. 

## Download and Learn ParfA Today

Read the tutorial page of our wiki [here](https://github.com/arjunvnair/ParfA/wiki/Tutorial) to get started. Good luck, and if you encounter any problems along the way, don't hesitate to report them on the [Issues Tracker](https://github.com/arjunvnair/ParfA/issues).
