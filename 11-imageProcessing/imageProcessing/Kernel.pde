public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = new float[init.length][init[0].length];
    for (int i = 0; i < init.length; i++) {
      for (int j = 0; j < init[i].length; j++) {
        kernel[i][j] = init[i][j];
      }
    }
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    return 0;
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    source.loadPixels();
    for (int i = 0; i < source.width; i++) {
      for (int j = 0; j < source.height; j++) {
        color col = calcNewColor(source, i, j);
        destination.set(i, j, col);
      }
    }
  }
}
