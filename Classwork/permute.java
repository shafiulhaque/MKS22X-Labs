public class permute{
  //current is the current index, which starts at 0 when you invoke the method in your main
  //the sentence starts at "", the recursion concatenates the words
  //base case should print the sentence
  public static void permute(String[][]lists, String sentence, int current){
    if (current == lists.length){
      System.out.println(sentence.substring(0, sentence.length()-1) + ".");
    } else {
    for (int i = 0; i < lists[current].length; i++){
      permute(lists, sentence + lists[current][i] + " ", current+1);
    }
  }
  }

  public static void main(String args[]){
    String[][]wordlists = {
    {"The dog", "The pro skater"},
    {"plays" , "empathises with" },
    {"chess", "ball", "the voiceless masses"}
    };
    permute(wordlists,"",0);

  }
}
