// Sean Szumlanski
// COP 3330, Fall 2019

// =============================
// PotionMaster: TestCase15.java
// =============================
// A small test for the canBrewPotion(PotionInfo, Set) method.


import java.util.*;

public class TestCase15
{
	// Test Case: Many reagents required, many reagents (but not all required reagents) on hand.
	public static void main(String [] args)
	{
		PotionInfo potion = PotionInfo.LEZNUPARS_DRAUGHT();
		Set<String> reagents = new HashSet<>();

		reagents.add("Icethorn");
		reagents.add("12-ounce Can of Root Beer");
		reagents.add("Vial of Unicorn Tears");
		reagents.add("Pygmy Oil");
		reagents.add("Frost Lotus");
		reagents.add("Phoenix Feather");
		reagents.add("Rain from a Category 4 Hurricane");
		reagents.add("Wax from a Partially Burned Candle");
		reagents.add("Black Lotus");

		// Note: We CANNOT brew Leznupar's Draught.
		boolean result = PotionMaster.canBrewPotion(potion, reagents);
		System.out.println((result == false) ? "Hooray!" : "oh no :(");
	}
}
