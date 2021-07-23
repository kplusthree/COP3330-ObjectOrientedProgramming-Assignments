// Kortney Menefee
// ko580767
// COP 3330-0001
// Fall 2019

import java.util.Arrays;

public class Strands
{
  // Checks if the string array is null or completely empty.
  public static int checkForNullOrEmpty(String [] strings)
  {
    int numOfStrings = strings.length;
    int counter = 0;

    // Checks if null.
    if (strings == null)
      return 1;
    // Checks if entire string is empty, if only part of it is
    // empty we'll just fill it with spaces later.
    for (int i = 0; i < numOfStrings; i++)
    {
      if ("".equals(strings[i]))
        counter++;
    }
    if (counter == numOfStrings)
      return 1;
    else
      return 0;
  }

  // Checks if the string array has parts where it needs to end
  // earlier than normally.
  public static int checkForSpaces(char [] array, int numOfStrings, int j)
  {
    int counter = 0;
    int k = j;

    if (array[k] == ' ')
    {
      // Checks through the rest of the char array.
      while (k < numOfStrings)
      {
        // If it finds a space, it adds to the counter
        if (array[k] == ' ')
          counter++;
        k++;
      }
      // If the rest of the array is just empty space, it will equal the
      // amount of space left, and the line should end early with a \n
      if (counter == numOfStrings - j)
        return 1;
    }
    return 0;
  }

  // Finds how long the longest string in the string array is.
  public static int findLongestString(String [] strings, int numOfStrings, int descending)
  {
    int length = 0;

    for(int i = 0; i < numOfStrings; i++)
    {
      int instanceLength = strings[i].length();

      // Accounts for how far down the string is getting pushed.
      if (descending == 2)
      {
        instanceLength += i;
      }
      if (length < instanceLength)
      {
        length = instanceLength;
        // Checks for what type of descending order is needed
        if (descending == 1 && i % 2 != 0)
        {
          length++;
        }
      }
    }
    return length;
  }

  public static char [] stringToCharArray(String str)
  {
    // If the string is null, the method will return an empty char array.
    if (str == null)
    {
      char [] array = new char[0];
      return array;
    }

    // If it is a normal string, it will convert that string into a char array.
    int strLength = str.length();
    char [] array = new char[strLength];

    for (int i = 0; i < strLength; i++)
    {
      array[i] = str.charAt(i);
    }
    return array;
  }

  // Will take all the needed chars from each string in the array for the current line.
  public static char [] stringArrayToCharArray(String [] strings, int numOfStrings, int length, int i, int descending) // did it?
  {
    // Makes an array as long as the number of strings in the string array.
    char [] array = new char[numOfStrings];
    // Loop long enough to fill the new array.
    for (int j = 0; j < numOfStrings; j++)
    {
      // If it is an even string or an non-descending string, don't descend.
      if ((j % 2 == 0 && descending < 2) || descending == 0 || (descending == 2 && j == 0))
      {
        // If the string being accessed is smaller than the longest string, fill
        // it with a space to avoid going outside the index, and fill out the line
        if (strings[j].length() <= i)
        {
          // Print a space instead of a char.
          array[j] = ' ';
          continue;
        }
        array[j] = strings[j].charAt(i);
      }
      else if (descending == 1)
      {
        // If it's an odd string or the first char in an odd string:
        if (strings[j].length() + 1 <= i || i == 0)
        {
          // Print a space instead of a char.
          array[j] = ' ';
          continue;
        }
        // Fill the array with the previous lines char because it got
        // pushed down a space.
        array[j] = strings[j].charAt(i - 1);
      }
      else
      {
        if (strings[j].length() + j <= i || i - j < 0)
        {
          // Print a space instead of a char.
          array[j] = ' ';
          continue;
        }
        array[j] = strings[j].charAt(i - j);
      }
    }
    return array;
  }

  // Prints out the amount of spaces you need.
  public static void printSpace(int n)
  {
    for (int i = 1; i <= n; i++)
    {
      System.out.print(' ');
    }
  }

  // Prints the beginning spaces before a string according to meanderingPath
  public static void printPattern(int i, int counter)
  {
    int pattern[] = { 2, 2, 2, 3, 4, 5, 5, 5, 4, 3 };
    // The first part of any string is an exception to the pattern
    // (3 instead of 2) but that's a simple fix.
    if (i == 0)
      printSpace(3);
    else
      printSpace(pattern[counter]);
  }

  public static void printString(String str, int numOfSpaces, boolean hasPattern)
  {
    // Converts a string into a char array.
    char [] array = stringToCharArray(str);
    int strLength = array.length;
    // Because null strings get converted into empty char arrays, both
    // null and empty strings print out "Pshh!" at the same place.
    if (strLength == 0)
      System.out.println("Pshh!");
    else
    {
      // counter is for what section of the pattern of meanderingPath we're on
      int counter = 0;
      int patternLength = 10;
      for (int i = 0; i < strLength; i++)
      {
        // If there is a space, we print only a new line and move
        // move to the next char.
        if (array[i] == ' ')
        {
          // We still have to watch our counter though.
          if(counter == patternLength)
            counter = counter - patternLength;
          System.out.print("\n");
          counter++;
          continue;
        }
        // Since most of the methods use this pattern, we'll deal with it first.
        if (hasPattern == true)
        {
          // If we get to the end of our pattern, we'll just loop around.
          if(counter == patternLength)
            counter = counter - patternLength;
          printPattern(i, counter);
          counter++;
        }
        // The straightAndNarrow methods don't need such a complicated method
        // of printing spaces, so we'll just add numOfSpaces to make it quicker.
        else
        {
          printSpace(numOfSpaces);
        }
        System.out.println(array[i]);
      }
    }
  }

  // descending's purpose is to dictate what descending order we're using:
  // classicRapunzel = 0 = no descension; steamyMocha = 1 = one level of
  // descension; cascadingWaterfall = 2 = multiple levels of descension.
  public static void printStringArray(String [] strings, int numOfSpaces, int descending)
  {
    int patternLength = 10;
    // Check for null or completely empty arrays.
    int isNullOrEmpty = checkForNullOrEmpty(strings);
    if (isNullOrEmpty == 1)
    {
      System.out.println("Pshh!");
      return;
    }
    else
    {
      int numOfStrings = strings.length;
      int length = findLongestString(strings, numOfStrings, descending);
      int counter = 0;

      // Loop as long as the longest string in the array.
      for (int i = 0; i < length; i++)
      {
        // Loops the pattern from meanderingPath.
        if(counter == patternLength)
          counter = counter - patternLength;
        // Gets the current lines char array.
        char [] array = stringArrayToCharArray(strings, numOfStrings, length, i, descending);
        // Loops through the whole char array.
        int spaceCounter = 0;
        // Loop as long as the number of strings in the array.
        for (int j = 0; j < numOfStrings; j++)
        {
          // Checks if the array is full of only spaces, if so, end the line early.
          spaceCounter = checkForSpaces(array, numOfStrings, j);
          if (spaceCounter == 1)
            break;
          // If it's the first part of the line, add the meanderingPath pattern
          if (j == 0)
            printPattern(i, counter);
          // Prints the char.
          System.out.print(array[j]); //
          // If there are more chars to print, seperate them by 2 spaces.
          if (j < numOfStrings - 1)
          {
            // Checks if there are anymore chars to print, or if it should end early
            spaceCounter = checkForSpaces(array, numOfStrings, j + 1);
            if (spaceCounter == 1)
              break;
            printSpace(numOfSpaces);
          }
        }
        // Prints the new line and adds to the counter for the meanderingPath counter.
        System.out.print('\n');
        counter++;
      }
    }
  }

  // The trues and falses let us see which method of printing spaces we need.
  // A simple loop of the same number, or multiple loops to keep track of the pattern.
  public static void straightAndNarrow(String str)
  {
    printString(str, 2, false);
  }

  public static void straightAndNarrow(String str, int n)
  {
    printString(str, n, false);
  }

  public static void meanderingPath(String str)
  {
    printString(str, 0, true);
  }

  public static void classicRapunzel(String [] strings)
  {
    printStringArray(strings, 2, 0);
  }

  public static void steamyMocha(String [] strings)
  {
    printStringArray(strings, 2, 1);
  }

  public static void cascadingWaterfall(String [] strings)
  {
    printStringArray(strings, 2, 2);
  }

  public static double difficultyRating()
  {
    return 2.0;
  }
  public static double hoursSpent()
  {
    return 6.0;
  }
}
