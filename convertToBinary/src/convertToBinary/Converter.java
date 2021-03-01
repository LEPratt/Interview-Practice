package convertToBinary;




public class Converter{

    static String toBinary(int num) {

String binary="";
while(num > 0) {
   binary = (num%2)+binary;
   num /= 2;
      }
   return binary;
}


}


