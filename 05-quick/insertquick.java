public class insertquick{
  public static void main(String args[]){
    int[][] bruh = new int[2][1000];
    for(int i = 0; i < 2; i++){
      for (int j = 0; j < 1000; j++){
        bruh[i][j] =(int)(Math.random()*100000);
      }
    }
    long start = System.currentTimeMillis();
    for(int i = 0; i < 1; i++){
      Quick.quicksort(bruh[i]);
    }
    long end = System.currentTimeMillis();
    long bruh2 = end - start;
    System.out.println("QUICK SORT: " + bruh2);

    long start2 = System.currentTimeMillis();
    for(int i = 0; i < 1; i++){
      Quick.insertionSort(bruh[i+1]);
    }
    long end2 = System.currentTimeMillis();
    long bruh3 = end2 - start2;
    System.out.println("INSERTION SORT: " + bruh3);

  }
}
