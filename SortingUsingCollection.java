package Week3Assignments;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input = { "HCL", "Wipro", "Aspire Systems", "CTS" };
//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)
//		get the length of the array		
		// sort the array
//		Iterate it in the reverse order
//		print the array
//		Required Output: Wipro, HCL , CTS, Aspire Systems

		List<String> names = new ArrayList<String>();
		names.add("HCL");
		names.add("Wipro");
		names.add("Aspire Systems");
		names.add("CTS");
		System.out.println("Before sorting " + names);
		System.out.println("************************************************");
		System.out.println();

		int Arraysize = names.size();

		System.out.println("The Size of the array is: " + Arraysize);
		System.out.println();

		Collections.sort(names);

		System.out.println("After Sorting " + names);
		System.out.println("************************************************");
		System.out.println();

		Collections.reverse(names);
		System.out.println("Reverse the List " + names);

	}

}
