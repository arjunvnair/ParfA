# ParfA
Relying on a basic I/O scheme and lexicon that can be understood by the average English speaker, ParfA's goal is to be the programming language that anyone can learn.

## Easier Than Java

Take a look at this area calculation program in Java:
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
Now take a look at this same program in ParfA.
````
ask "What is the length?"
create number length store answer
ask "What is the width?"
create number width store answer
announce "The area is " + length * width + "."
````

## How to Learn ParfA

Read the home page of our wiki [here](https://github.com/arjunvnair/ParfA/wiki).

## How to Run ParfA On Your Computer

Download the latest release of the ParfA compiler, ParfA.bat and ParfA.jar, [here](https://github.com/arjunvnair/ParfA/releases). Create a .txt file with your ParfA code in a text editor such as NotePad, copy its file path, double click ParfA.bat, and input the file path to run the code.
