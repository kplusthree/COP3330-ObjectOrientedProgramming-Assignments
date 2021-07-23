// Kortney Menefee
// ko580767
// COP 3330-0001
// Fall 2019

public class LyricalDecomposition
{
  public static void printSpiderRepeat()
  {
    System.out.println("She swallowed the spider to catch the fly.");
  }
  public static void printBirdRepeat()
  {
    System.out.println("She swallowed the bird to catch the spider;");
  }
  public static void printCatRepeat()
  {
    System.out.println("She swallowed the cat to catch the bird;");
  }
  public static void printEndingRepeat()
  {
    System.out.println("I don't know why she swallowed that fly;");
    System.out.println("Perhaps she'll die.");
  }
  public static void printSpace()
  {
    System.out.println("");
  }

  public static void printFirstVerse()
  {
    System.out.println("There was an old woman who swallowed a fly.");
    printEndingRepeat();
    printSpace();
  }
  public static void printSecondtVerse()
  {
    System.out.println("There was an old woman who swallowed a spider,");
    System.out.println("That wriggled and iggled and jiggled inside her!");
    printSpiderRepeat();
    printEndingRepeat();
    printSpace();
  }
  public static void printThirdVerse()
  {
    System.out.println("There was an old woman who swallowed a bird.");
    System.out.println("How absurd, to swallow a bird!");
    printBirdRepeat();
    printSpiderRepeat();
    printEndingRepeat();
    printSpace();
  }
  public static void printFourthVerse()
  {
    System.out.println("There was an old woman who swallowed a cat.");
    System.out.println("Imagine that, to swallow a cat!");
    printCatRepeat();
    printBirdRepeat();
    printSpiderRepeat();
    printEndingRepeat();
    printSpace();
  }
  public static void printFifthVerse()
  {
    System.out.println("There was an old woman who swallowed a dog.");
    System.out.println("What a hog, to swallow a dog!");
    System.out.println("She swallowed the dog to catch the cat;");
    printCatRepeat();
    printBirdRepeat();
    printSpiderRepeat();
    printEndingRepeat();
    printSpace();
  }
  public static void printSixthVerse()
  {
    System.out.println("There was an old woman who swallowed a horse.");
    System.out.println("She died, of course!");
  }

  public static void printLyrics()
  {
    printFirstVerse();
    printSecondtVerse();
    printThirdVerse();
    printFourthVerse();
    printFifthVerse();
    printSixthVerse();
  }

  public static double difficultyRating()
  {
    return 1.0;
  }
  public static double hoursSpent()
  {
    return 2.0;
  }
}
