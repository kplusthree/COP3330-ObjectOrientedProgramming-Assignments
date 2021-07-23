// Sean Szumlanski
// COP 3330, Fall 2019

// ========================
// Bonfire: TestCase01.java
// ========================
// A brief test case to help ensure you've implemented the difficultyRating()
// and hoursSpent() methods correctly.
//
// For detailed compilation and testing instructions, see the assignment PDF.


import java.io.*;
import java.util.*;

public class TestCase01
{
	public static void main(String [] args)
	{
		double difficulty = Bonfire.difficultyRating();
		System.out.println((difficulty < 1.0 || difficulty > 5.0) ? "fail whale :(" : "Hooray!");

		double hours = Bonfire.hoursSpent();
		System.out.println((hours <= 0.0) ? "fail whale :(" : "Hooray!");
	}
}