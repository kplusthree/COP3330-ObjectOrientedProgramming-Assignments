// Kortney Menefee
// ko580767
// COP 3330-0001
// Fall 2019

public class Bonfire
{

  public static int getThirdLargest(int [] array)
  {
    if (array.length < 3)
    {
      return Integer.MIN_VALUE;
    }

    int largest = Integer.MIN_VALUE;
    int largest2 = Integer.MIN_VALUE;
    int largest3 = 0;

    // Loops 3 times to get the largest number each time
    for (int j = 1; j <= 3; j++)
    {
      int max = Integer.MIN_VALUE;
      int index = 0;
      // Loops through each number in the array
      for (int i = 0; i < array.length; i++)
      {
        // Checks to see if the number is larger than current max
        // and checks to make sure it isn't a previous largest number
        if (max <= array[i] && i != largest && i != largest2)
        {
          max = array[i];
          index = i;
          // Assigns the index to whichever loop it is currently in
          if (j == 1)
          {
            largest = index;
          }
          else if (j == 2)
          {
            largest2 = index;
          }
          else
          {
            largest3 = max;
          }
        }
      }
    }
    return largest3;
  }

  public static void printThirdLargest(int [] array)
  {
    int value = getThirdLargest(array);
    System.out.print(value + "\n");
  }

  public static boolean isRotation(int [] array1, int [] array2)
  {
    if (array1.length != array2.length)
    {
      return false;
    }
    if (array1.length == 0 && array2.length == 0)
    {
      return true;
    }

    // counter acts as a way of noting how many times the arrays match
    int counter = 0;
    for (int j = 0; j < array1.length; j++)
    {
      for (int i = 0; i < array1.length; i++)
      {
        // If the values don't match, it continues looking
        if (array1[i] != array2[counter])
        {
          continue;
        }
        // If the values do match, it adds to the counter, and breaks to
        // check if this is a rotation, or if that match was a coincidence
        else if (array1[i] == array2[counter])
        {
          counter++;
          break;
        }
      }
    }

    // If the counter reaches the length of the array, it means it matched
    // every time, and that these arrays are rotaions of each other
    boolean returnValue = false;
    if (counter == array1.length)
    {
      returnValue = true;
    }
    else
    {
      returnValue = false;
    }
    return returnValue;
  }

  public static int [] generateNthRotation(int [] array, int n)
  {
    int al = array.length;
    int [] secondArray = new int[al];
    int howManyTurns = n;

    if (al == 0 && secondArray.length == 0)
    {
      return array;
    }

    // Since we cannot loop through more than 'n' number of times, we
    // can't have n be more than the array.length or 'al'

    // This will cover #s 1 - #s < al
    if (n < al && n > 0)
    {
      howManyTurns = n;
    }
    // This will cover #s -1 - -#s < -al
    else if (n < al && n > al * -1)
    {
      howManyTurns = n;
    }
    // This will condense multiple rotations into just one for -#s
    else if (n < al)
    {
      int negative = 0;
      negative = n * -1;
      howManyTurns = ((n % al) * -1);
    }
    // This will condense multiple rotations into just one for +#s
    else if (n > al)
    {
      howManyTurns = n % al;
    }
    // This is for any rotation that won't actually change
    if (n == al || howManyTurns == 0)
    {
      return array;
    }

    int correctI = 0;
    int sub = 0;
    int temp = 0;
    // Will create a new array and fill it with adjusted rotations
    for (int i = 0; i < al; i++)
    {
      correctI = i + howManyTurns;
      if (correctI >= al)
      {
        // will adjust numbers that need to loop back to the beginning
        temp = correctI;
        sub = temp - al;
        correctI = sub;
      }
      if (correctI < 0)
      {
        // will adjust numbers that need to loop back to the end
        temp = correctI;
        sub = temp + al;
        correctI = sub;
      }
      secondArray[correctI] = array[i];
    }
    return secondArray;
  }

  public static void printChar(char ch, int n)
  {
    for (int i = 1; i <= n; i++)
    {
      System.out.print(ch);
    }
  }

  public static void printBorder(int width)
  {
    System.out.print('+');
    printChar('-', width);
    System.out.print('+');
    System.out.print("\n");
  }

  public static void eraseLastCharacter(int n, int counter, int position, char ch)
  {
    // Positions are what order each character is in
    int availableSpace = n * position;
    if (counter < availableSpace)
    {
      // Accounts for what space is left for each group of characters
      int diff = availableSpace - counter;
      if (diff >= n)
      {
        return;
      }
      else
      {
        // If there isn't enough room for say, all the '@'s, it prints
        // however many can still fit
        printChar(ch, n - diff);
      }
    }
    else
    {
      // If there is enough room for all of them, it prints them all
      printChar(ch, n);
    }
  }

  // Prints each individual line
  public static void printLine(int n, int counter)
  {
    // Accounts for how much of each character can still be printed
    eraseLastCharacter(n, counter, 1, '@');
    eraseLastCharacter(n, counter, 2, 'o');
    eraseLastCharacter(n, counter, 3, '@');
    // Accounts for leftover space at the end that needs to be filled with spaces
    if (counter > n * 3)
    {
      int diff = counter - n * 3;
      if (diff > 0);
      {
        printChar(' ', diff);
        diff--;
      }
    }
    System.out.print('|');
    System.out.print("\n");
  }

  // Prints out all the lines
  public static void moveRibbon(int n, int width)
  {
    // The counter represents how much space isn't filled with a space at the start
    int counter = width;
    for (int i = 0; i < width; i++)
    {
      System.out.print('|');
      printChar(' ', i);
      printLine(n, counter);
      counter--;
    }
  }

  // Prints everything
  public static void printRibbon(int n, int width)
  {
    printBorder(width);
    moveRibbon(n, width);
    printBorder(width);
  }

  public static double difficultyRating()
  {
    return 2.5;
  }
  public static double hoursSpent()
  {
    return 13;
  }
}
