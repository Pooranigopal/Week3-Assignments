package Week3Assignments;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "welcome to Selenium automation";
		String replace = name.replace(" ", "");
		//System.out.println(replace);
		char[] charArray = name.toCharArray();
		Map<Character, Integer> charoccur = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < charArray.length; i++) {

			if (charoccur.containsKey(charArray[i]))

				charoccur.put(charArray[i], charoccur.get(charArray[i]) + 1);
			else
				charoccur.put(charArray[i], 1);
		}

		System.out.println(charoccur);

	}

}
