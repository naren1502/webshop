package methodVerification;

import generic.UtilityMethods;

public class GenerateRandomNumberWithGivenRange {
	public static void main(String[] args) {
		UtilityMethods utill=new UtilityMethods(null);
		
		int randomnum = utill.generateRandomNumberByGivenRange(100,115);
		System.out.println(randomnum);
		
		
	}
}
