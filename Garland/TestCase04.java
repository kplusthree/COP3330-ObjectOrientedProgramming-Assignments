// Sean Szumlanski
// COP 3330, Fall 2019

// ========================
// Garland: TestCase04.java
// ========================
// A small test of the stringToLinkedList() method.


public class TestCase04
{
	public static void main(String [] args)
	{
		Node head = Garland.stringToLinkedList(null);
		System.out.println(head == null ? "Hooray!" : "oh no :(");
	}
}
