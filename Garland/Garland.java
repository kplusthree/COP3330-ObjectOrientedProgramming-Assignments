// Kortney Menefee
// ko580767
// COP 3330-0001
// Fall 2019

import java.util.Arrays;

public class Garland
{
  private Node head; // Reference to the top-left node in this garland.
  private int size; // The number of strings currently in this garland.

  // checks if an index is a valid imput.
  public boolean checkIndex(int index)
  {
    if (index < 0 || index > size - 1)
      return false;

    else
      return true;
  }

  public static Node stringToLinkedList(String s)
  {
    // if null return null.
    if (s == null)
      return null;

    int stringLength = s.length();

    // if empty return null.
    if (stringLength == 0)
      return null;

    // make a new head node.
    Node current = new Node(s.charAt(0));
    // start at the head.
    Node newHead = current;

    // make as many nodes as the string is long.
    for (int i = 1; i < stringLength; i++)
    {
      // create a new node that connects to the previoius node.
      current.down = new Node(s.charAt(i));
      // go to the next node.
      current = current.down;
    }
    // return the head of the linked list.
    return newHead;
  }

  public static String linkedListToString(Node head)
  {
    // create a counter that will track how long a linked list is
    // and we start it at 1 because we're accounting for the head.
    int counter = 1;
    Node current = head;

    // if null return an empty space.
    if (head == null)
    {
      String str = "";
      return str;
    }

    // cycle through the linked list and count the nodes.
    while (current.down != null)
    {
      current = current.down;
      counter++;
    }

    // create a char array as long as the linked list
    char [] charArray = new char[counter];
    // start as the head.
    current = head;

    // loop through the linked list copying each char into the char array.
    for (int i = 0; i < counter; i++)
    {
      charArray[i] = current.data;
      current = current.down;
    }

    // convert char array to string.
    String s = new String(charArray);
    // return the string.
    return s;
  }

  // default constructor.
  Garland()
  {
  }

  // takes an array of strings, converts them into linked linkedListToString
  // and put them in the garland.
  Garland(String [] strings)
  {
    // if null, leave the method.
    if (strings == null)
      return;

    // How many strings are added to the garland.
    int numOfStrings = strings.length;

    // if empty, leave the method.
    if (strings.length == 0)
      return;

    // sets the head of the garland.
    head = stringToLinkedList(strings[0]);
    Node current = head;
    // accounts for the head.
    size = 1;

    // links the linked lists together and increases size.
    for (int i = 1; i < numOfStrings; i++)
    {
      current.next = stringToLinkedList(strings[i]);
      current = current.next;
      size++;
    }
  }

  public Node head()
  {
    return head;
  }

  public int size()
  {
    return size;
  }

  public void addString(String s)
  {
    // if null exit method.
    if (s == null)
      return;

    int stringLength = s.length();

    // if empty exit method.
    if (stringLength == 0)
      return;

    // converts string to linked list.
    Node headOfAddedString = stringToLinkedList(s);
    // start at head.
    Node current = head;

    // if the garland is empty, make this the first linked list.
    if (size == 0)
    {
      head = headOfAddedString;
      size++;
      return;
    }

    // cycle through the linked list to the end.
    while (current.next != null)
    {
      current = current.next;
    }

    // connect the new string to the end of the linked list.
    current.next = headOfAddedString;
    size++;
  }

  public Node getNode(int index)
  {
    // checks if the index is valid.
    boolean valid = checkIndex(index);
    if (valid == false)
    {
      return null;
    }

    // start at the head.
    Node current = head;

    // loop through the linked list until the desired index.
    for (int i = 1; i <= index; i++)
    {
      current = current.next;
    }

    // return the node at that index.
    return current;
  }

  public String getString(int index)
  {
    // use node from get node.
    Node headOfString = getNode(index);
    // use node to convert that linked list to a string.
    String gottenString = linkedListToString(headOfString);
    // print string.
    return gottenString;
  }

  public boolean removeString(int index)
  {
    // if the string is empty, leave method.
    if (size == 0)
    {
      return false;
    }

    // check if index is valid.
    boolean valid = checkIndex(index);
    if (valid == false)
    {
      return false;
    }

    // start at head
    Node current = head;

    // if the first string, set the second string as the first string.
    if (index == 0)
    {
      head = current.next;
      size--;
      return true;
    }

    // if a string beyond the first one, cycle through until the
    // string before the index.
    for (int i = 1; i <= index - 1; i++)
    {
      current = current.next;
    }

    // save reference to node.
    Node beforeRemovedString = current;

    // cycle through 2 more times to the string after the index.
    for (int i = 0; i < 2; i++)
    {
      current = current.next;
    }

    // set the string before index's next to the string after the index.
    beforeRemovedString.next = current;

    // adjust size.
    size--;
    return true;
  }

  public boolean printString(int index)
  {
    // checks index.
    boolean valid = checkIndex(index);
    if (valid == false)
    {
      System.out.println("(invalid index)");
      return false;
    }

    // prints the string from get string.
    System.out.println(getString(index));
    return true;
  }

  public void printStrings()
  {
    // checks for null.
    if (head == null)
    {
      System.out.println("(empty list)");
    }

    // prints all the strings according to size.
    for (int i = 0; i < size; i++)
    {
      printString(i);
    }
  }

  public static double difficultyRating()
  {
    return 1.0;
  }

  public static double hoursSpent()
  {
    return 4.0;
  }
}
