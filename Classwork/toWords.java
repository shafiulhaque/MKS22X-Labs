public class toWords{
  public static String toWords(int n){
    String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen"};
    String[] tens = {"teen", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    if(n<=13){
      return ones[n];
    }
    if (n > 13 && n < 100){
      int ten = n/10;
      if (n%10 == 0) return tens[ten-1];
      if (ten-1 == 0) return toWords(n%10) + tens[ten-1];
      return tens[ten-1] + " " + toWords(n%10);
    }
    if (n > 100 && n < 1000){
      int hun = n/100;
      return ones[hun] + " hundred and " + toWords(n%100);
    }
    return "didn't work";
  }
  public static void main (String args[]){
    for (int i = 0; i <= 100; i++){
      System.out.println(toWords(i));
    }
  }
}
