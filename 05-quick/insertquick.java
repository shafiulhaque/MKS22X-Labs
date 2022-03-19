public class insertquick{
  public static void main(String args[]){
    int joe = Integer.parseInt(args[0]);

    int[][] bro = new int[2][joe];
    int[] bro1 = new int[joe];
    for(int j = 0; j < joe; j++){
      bro1[j] =(int)(Math.random()*100000);
    }

    for(int i = 0; i < 2; i++){
      for (int j = 0; j < joe; j++){
        bro[i][j] = bro1[j];
      }
    }
    
    long start = System.nanoTime();
    for(int i = 0; i < 1; i++){
      Quick.quicksort(bro[i]);
    }
    long end = System.nanoTime();
    long bruh = end - start;
    System.out.println("QUICK SORT: " + end + ", " + start + ", " + bruh);

    long start2 = System.nanoTime();
    for(int i = 0; i < 1; i++){
      Quick.insertionSort(bro[i+1]);
    }
    long end2 = System.nanoTime();
    long bruh2 = end2 - start2;
    System.out.println("INSERTION SORT: " + end2 + ", " + start2 + ", " + bruh2);

  }
}
