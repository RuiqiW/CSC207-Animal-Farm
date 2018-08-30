public class Wind {
  /**
   * The previous vertical direction wind goes. -1 if wind is blowing up, 1 if wind is blowing down,
   * 0 if no wind.
   */
  private static int lastUp = 0;

  /**
   * The previous horizontal direction wind goes. -1 if wind is blowing left, 1 if wind is blowing
   * right, 0 if no wind.
   */
  private static int lastLeft = 0;

  /**
   * If wind is blowing, There is 30% of chance for it to keep blowing in the same direction, 10% of
   * chance to turn around. Otherwise it will stop. If wind is not blowing, there is 10% of chance
   * for it to blow up, 10% of chance to blow down. Otherwise it will stay still.
   *
   * @param last an integer indicating the direction this food moving towards
   */
  private static int blowing(int last) {
    double d = Math.random();
    // The wind is blowing
    if (last != 0) {
      if (d < 0.1) {
        last = -last;
      } else if (d > 0.4) {
        last = 0;
      }
    } else {
      // The wind is not blowing
      if (d < 0.1) {
        last = -1;
      } else if (d < 0.2) {
        last = 1;
      }
    }
    return last;
  }

  static int getVerticalDirection() {
    lastUp = blowing(lastUp);
    return lastUp;
  }

  static int getHorizontalDirection() {
    lastLeft = blowing(lastLeft);
    return lastLeft;
  }
}
