package com.rakasu.entertainment;

// Read only region start
public class Ropehanger {

	public int GetVisibleCount(int input1, int input2, int[][] input3) {
		// Read only region end
		int ropeLength = input1;
		int noOfCloths = input2;
		int[][] ropeArrangement = input3;
		int[] rope = new int[ropeLength];
		// hang the cloths
		for (int clothCount = 0; clothCount < noOfCloths; clothCount++) {
			int[] clothConfig = ropeArrangement[clothCount];
			int startPosition = clothConfig[0];
			int endPosition = startPosition + clothConfig[1] - 1;
			for (int fillCount = startPosition; fillCount <= endPosition; fillCount++) {
				rope[fillCount] = clothCount;
			}
		}

		// count visible cloths
		int noOfVisibleCloths = 0;
		for (int clothCount = 0; clothCount < noOfCloths; clothCount++) {
			int[] clothConfig = ropeArrangement[clothCount];
			int startPosition = clothConfig[0];
			int endPosition = startPosition + clothConfig[1] - 1;
			for (int ropeCount = startPosition; ropeCount <= endPosition; ropeCount++) {
				int clothIdValue = rope[ropeCount];
				if (clothIdValue == clothCount) {
					noOfVisibleCloths++;
					break;
				}
			}
		}

		return noOfVisibleCloths;
		// throw new UnsupportedOperationException("GetVisibleCount(int
		// input1,int input2,int[][] input3)");
	}
}
