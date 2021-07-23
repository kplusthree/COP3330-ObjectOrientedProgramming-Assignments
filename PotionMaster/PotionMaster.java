// Kortney Menefee
// ko580767
// COP 3330, Fall 2019
import java.util.*;

public class PotionMaster
{
	 public static Map<String, Set<String>> potionToReagentsMap(List<PotionInfo> potionsManual)
	 {
		 // Create a new map, we're gonna use hashes because we don't need sorting.
		 Map<String, Set<String>> hashMap = new HashMap<>();

		 // Loop through all the potions in the manual
		 for (PotionInfo p : potionsManual)
		 {
			 // Amount of reagents in a potion
			 int size = p.reagents.size();
			 // Create a new set, we're gonna use hashes because we don't need sorting.
			 Set<String> hashSet = new HashSet<>();

			 // Loop through the amount of reagents
			 for (int i = 0; i < size; i++)
			 {
				 // Add each reagent
				 hashSet.add(p.reagents.get(i));
			 }

			 // Key the names of potions to their reagents
			 hashMap.put(p.name, hashSet);
		 }
		 return hashMap;
	 }

	 public static Map<String, Set<String>> reagentToPotionsMap(List<PotionInfo> potionsManual)
	 {
		 // Create a new map
		 Map<String, Set<String>> hashMap = new HashMap<>();

		 // Loop through all the potions in the manual
		 for (PotionInfo p : potionsManual)
		 {
			 // Loop through each reagent
			 for (String r : p.reagents)
			 {
				 // If the reagent is already a key, add the potion name to the set
				 if (hashMap.containsKey(r))
				 {
					 hashMap.get(r).add(p.name);
				 }
				 // Otherwise, make the reagent a key, and add that potion name to the set
				 else
				 {
					 Set<String> hashSet = new HashSet<>();
					 hashSet.add(p.name);
					 // Put the reagents and their keyed potions to the map
					 hashMap.put(r, hashSet);
				 }
			 }
		 }
		 return hashMap;
	 }

	 public static boolean canBrewPotion(PotionInfo potionInfo, Set<String> reagentsOnHand)
	 {
		 // Create a new set
		 Set<String> hashSet = new HashSet<>();

		 // Loop through each reagent needed
		 for (String r : potionInfo.reagents)
		 {
			 // Add those reagents to the set
			 hashSet.add(r);
		 }

		 // See if the required reagents are in reagentsOnHand
		 boolean canBrew = reagentsOnHand.containsAll(hashSet);
		 // Return true or false
		 return canBrew;
	 }


	 public static boolean canBrewPotion(String potionToBrew,
	 																		 Map<String, Set<String>> potionToReagentsMap,
																			 Set<String> reagentsOnHand)
	 {
		 // If the potionToBrew isn't in the map, it'll return null, so we'll return false
		 if (potionToReagentsMap.get(potionToBrew) == null)
		 {
			 return false;
		 }

		 // Convert the map to an array
		 String[] tempArray = potionToReagentsMap.get(potionToBrew).toArray(new String [0]);
		 // Create an array list
		 List<String> reagentList = new ArrayList<>();

		 // Loop through the reagents in the array
		 for (String r : tempArray)
		 {
			 // Add the reagents into the array list.
			 // I want to pass the info we have to the previous method, but to do so
			 // we have to change the set to a list for that method's constructor.
			 reagentList.add(r);
		 }

		 // Use the potion we want to look at, a filler description,
		 // and the reagents of that potion to create a PotionInfo Object.
		 PotionInfo temp = new PotionInfo(potionToBrew, "Description", reagentList);
		 // Pass that object and the reagentsOnHand to the previous method,
		 // which will tell us whether we can brew the potion or not.
		 boolean result = canBrewPotion(temp, reagentsOnHand);
		 return result;
	 }

	 public static Set<String> allPossiblePotions(Map<String, Set<String>> potionToReagentsMap,
																	     					Map<String, Set<String>> reagentToPotionsMap,
																	  	 					Set<String> reagentsOnHand)
	 {
		 // Create a set for all the possible potions we can make
		 Set<String> allPossiblePotions = new HashSet<>();

		 // Loop through all the potions in the map
		 for (String p : potionToReagentsMap.keySet())
		 {
			 // Pass the potion info to the previous method
			 if (canBrewPotion(p, potionToReagentsMap, reagentsOnHand) == true)
			 {
				 // If it's true, add it to the set. If not, do nothing
				 allPossiblePotions.add(p);
			 }
		 }

		 return allPossiblePotions;
	 }

	public static double difficultyRating()
	{
		return 2.5;
	}

	public static double hoursSpent()
	{
		return 5.0;
	}
}
