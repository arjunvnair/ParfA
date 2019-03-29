![ParfA logo](http://i.imgur.com/yPF8UfJ.png)

More people than ever before are trying to learn how to program. However, when learning a programming language for the first time, many beginners struggle to simultaneously learn the fundamental logic behind programming alongside the complicated syntax and structures that accompany these powerful languages.

ParfA (pronounced "parfait") is a simple text-based programming language made specifically for beginners. Although it doesn't have all the functionality of a real programming language, it can still be used to make a variety of programs, from text-based games to quizzes and calculators, in a matter of minutes. 

## Why Learn ParfA?

Most computer science students learn Java as their first language. Let's consider a program that prompts the user for the length and width of a rectangle

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
Scary, right? Let's take a look at this same program in ParfA:
````
ask "What is the length?"
create number length store answer
ask "What is the width?"
create number width store answer
announce "The area is " + length * width + "."
````
This code is a lot easier to read! Of course, there's a lot more to ParfA than performing simple calculations; ParfA has loops, logic operations, and most other features taught in a first year computer science course. In this manner, beginners can learn how these features work on a fundamental level before learning more robust languages like Java. 

## Download and Learn ParfA Today

Read the tutorial page of our wiki [here](https://github.com/arjunvnair/ParfA/wiki/Tutorial) to get started. Good luck, and if you encounter any problems along the way, don't hesitate to report them on the [Issues Tracker](https://github.com/arjunvnair/ParfA/issues).
