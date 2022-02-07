public class toWords{
  public static String toWords(int n){
    String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
    String[] tens = {"teen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    if(n<=10){
      return ones[n];
    }
    if(n>10 && n <= 19){
      return teens[n-11];
    }
    if (n >= 20 && n < 100){
      int ten = n/10;
      if (n%10 == 0) return tens[ten-1];
      return tens[ten-1] + "-" + toWords(n%10);
    }
    if (n >= 100 && n < 1000){
      int hun = n/100;
      if (n%100 == 0) return ones[hun] + " hundred";
      return ones[hun] + " hundred and " + toWords(n%100);
    }
    if (n >= 1000 && n < 10000){
      int thou = n/1000;
      if (n%1000 == 0) return ones[thou] + " thousand";
      return ones[thou] + " thousand " + toWords(n%1000);
    }
    return "didn't work";
  }
  public static void main (String args[]){
    int joe = 0;
    for (int i = 0; i <= 99; i++){
      System.out.println(toWords(i));
    }
    for (int i = 1; i <= 1000; i++){
      for(int j = 0; j < toWords(i).length(); j++){
        if (toWords(i).charAt(j) != ' ' && toWords(i).charAt(j) != '-'){
          joe++;
        }
      }
      System.out.println(joe);
    }
  }
}
