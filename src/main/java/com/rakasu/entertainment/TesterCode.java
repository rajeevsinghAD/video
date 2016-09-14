package com.rakasu.entertainment;

import java.io.*;
import java.util.*;

// Read only region start
class TesterCode {

	public static void main(String[] args) {
		TesterCode tc = new TesterCode();
		String subString=tc.GetSubString("this is a test", "tist");
		System.out.println("Substring: "+ subString);

	}

	public String GetSubString(String input1, String input2) {
		// Read only region end
		String minSubString = null;
		Map<Character, Integer> referenceCountMap = new HashMap<Character, Integer>();
		for (int i = 0; i < input2.length(); i++) {
			char strChar = input2.charAt(i);
			Integer charRefCount = referenceCountMap.get(strChar);
			int incrementedRefCount = 0;
			if (charRefCount == null) {
				// initialize the ref count
				incrementedRefCount = 1;
			} else {
				incrementedRefCount = charRefCount.intValue() + 1;
			}
			referenceCountMap.put(strChar, incrementedRefCount);
		}

		for (int i = 0; i < input1.length(); i++) {
			Integer refCountOuter = referenceCountMap.get(input1.charAt(i));

			// First char found start the parsing
			if (refCountOuter != null) {
				Map<Character, Integer> referenceCountMapClone = (Map<Character, Integer>) ((HashMap) referenceCountMap)
						.clone();
				StringBuilder minSubStringSb = new StringBuilder();
				for (int firstCount = i; firstCount < input1.length()
						&& !referenceCountMapClone.isEmpty(); firstCount++) {
					char strChar = input1.charAt(firstCount);
					Integer refCountOfChar = referenceCountMapClone.get(strChar);
					if (refCountOfChar != null) {
						int refCountIntVal = refCountOfChar.intValue();
						if (refCountIntVal == 1) {
							// if only one reference then evict from reference
							// counter
							referenceCountMapClone.remove(strChar);
						} else {
							refCountIntVal--;
							referenceCountMapClone.put(strChar, refCountIntVal);
						}
					}
					minSubStringSb.append(strChar);
				}
				String minSubCandidate = minSubStringSb.toString();
				if (referenceCountMapClone.isEmpty()) {
					System.out.println("Substring candidate: "+ minSubCandidate);
					// if reference count has been exahusted i.e a substring has
					// been found
					if (minSubString == null)
						minSubString = minSubCandidate;
					else if (minSubCandidate.length() < minSubString.length()) {
						minSubString = minSubCandidate;
					}
				}
			}
		}
		return minSubString;
		// throw new UnsupportedOperationException("GetSubString(String
		// input1,String input2)");
	}

}
