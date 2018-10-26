![ParfA logo](http://i.imgur.com/yPF8UfJ.png)

Programming is becoming an increasingly valuable skill in the Digital Age. However, when learning a programming language for the first time, many beginners struggle to simultaneously learn the fundamental logic behind programming along with the complicated syntax that comes with these languages. These languages are very powerful in the right hands, but they can be daunting and even discouraging for beginners.

ParfA is a text-based programming language made specifically for beginners; although it doesn't have all the functionality of a real programming language, it can still be used to make a variety of programs, from text-based games to quizzes, in a matter of minutes. 

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
Daunting, right? Let's take a look at this same program in ParfA:
````
ask "What is the length?"
create number length store answer
ask "What is the width?"
create number width store answer
announce "The area is " + length * width + "."
````
This code is a lot more easy to read. Of course, there's a lot more to ParfA than simple calculations - there's loops, 
## Download and Learn ParfA Today

Read the tutorial page of our wiki [here](https://github.com/arjunvnair/ParfA/wiki/Tutorial) to get started. Good luck, and if you encounter any problems along the way, don't hesitate to report them on the [Issues Tracker](https://github.com/arjunvnair/ParfA/wiki/Tutorial).
