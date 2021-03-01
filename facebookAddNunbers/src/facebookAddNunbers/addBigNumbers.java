package facebookAddNunbers;

public class addBigNumbers {
	
	public static void main(String[] args){
		
		String string1 = "1.1234";
		String string2 = "10000000000000000000000000000000000000000000000564879";
		System.out.println(twoSum(string1, string2));
		
	}

	 static String twoSum(String string1, String string2) {
		 
		 
		 String intSum = "";
		 String decSum = "";
		 String finalSum = "";
		 int carry = 0;
		 int l1 = 0;
		 int l2 = 0;
		 int l3 = 0;
		 
		 String[] str1 = new String[2];
		 String[] str2 = new String[2];
		 
		 System.out.println(str1.length);
		 
		  
		 String[] temp1 = string1.split("\\.");
		 String[] temp2 = string2.split("\\.");
		 
		 System.out.println(temp1.length);
		 
		 if (temp1.length<2) {
			 str1[0] = temp1[0];
			 str1[1] = "0";
		 }else str1 = temp1;
			
		 if (temp2.length<2) {
			 str2[0] = temp2[0];
			 str2[1] = "0";
		 }else str2 = temp2;
			
		
		 if (str1[0].length() > str2[0].length()) {
			 String[] t = str1;
			 str1 = str2;
			 str2 = t;
		 } 
		 
		 l1=str1[0].length();
		 l2=str2[0].length();
		 
		 int decLength = Math.abs(str1[1].length()-str2[1].length());
		 
		 if (str1[1].length() < str2[1].length()){
			 for (int i=0;i<decLength;i++) {
				 str1[1] = str1[1]+"0";
			 }
		 }else if (str2[1].length() < str1[1].length()){
			 for (int i=0;i<decLength;i++) {
				 str2[1] = str2[1]+"0";
			 }
		 }
		 
		 //Set decimal length
		 l3=str1[1].length();
		 
		 //Add decimal parts and store result
		 //Reverse both decimals parts
		 str1[1]=new StringBuilder(str1[1]).reverse().toString();
		 str2[1]=new StringBuilder(str2[1]).reverse().toString();
		 
		 carry = 0;
		 for (int i=0;i<l3;i++) {
			 int sum = ((int)(str1[1].charAt(i) - '0') + (int)(str2[1].charAt(i) - '0') + carry);
			 decSum += (char)(sum % 10 + '0');
			 carry = sum/10;
		 }
		 //Reverse decimal part
		 decSum = new StringBuilder(decSum).reverse().toString();
		 
		 //Add integer parts and store result
		 
		 //Reverse both integer parts
		 str1[0]=new StringBuilder(str1[0]).reverse().toString();
		 str2[0]=new StringBuilder(str2[0]).reverse().toString();
		 
		
		 for (int i=0;i<l1;i++) {
			 int sum = ((int)(str1[0].charAt(i) - '0') + (int)(str2[0].charAt(i) - '0') + carry);
			 intSum += (char)(sum % 10 + '0');
			 carry = sum/10;
		 }
		 
		 //Add remaining digits not accounted for
		 for (int i=l1;i<l2;i++) {
			 int sum = ((int)(str2[0].charAt(i) - '0') + carry);
			 intSum += (char)(sum % 10 + '0');
			 carry = sum/10;
		 }
		 
		 //Add any remaining carry value
		 if (carry > 0)
			 intSum += (char)(carry + '0');
		 
		 //Reverse integer part
		 intSum = new StringBuilder(intSum).reverse().toString();
		 
		 //Combine and return result
		 finalSum = intSum+"."+decSum;
		 return finalSum;
		 
	 }
	 }

