import java.util.ArrayList;
import java.util.Random;

/* Animal on the Farm */
public abstract class Animal extends Farm {

    private boolean goingRight;

  /**
   * Randomly assigns this animal a location.
   *
   * @return this
   */
  Animal assignLocation() {
    Random ran = new Random();
    // generating integer
    int h = ran.nextInt(rightBound - 1);
    int v = ran.nextInt(lowBound - 1);
    this.setLocation(h + 1, v + 1);
    return this;
  }

  /** Builds and initializes this Animal's forward and backward appearances. */
  private String reverseAppearance() {
    StringBuilder reverse = new StringBuilder();
      for (int i = this.getAppearance().length() - 1; i >= 0; i--) {
          switch (this.getAppearance().charAt(i)) {
        case '\\':
          reverse.append('/');
          break;
        case '/':
          reverse.append('\\');
          break;
        case ')':
          reverse.append('(');
          break;
        case '(':
          reverse.append(')');
          break;
        case '>':
          reverse.append('<');
          break;
        case '<':
          reverse.append('>');
          break;
        case '}':
          reverse.append('{');
          break;
        case '{':
          reverse.append('}');
          break;
        case '[':
          reverse.append(']');
          break;
        case ']':
          reverse.append('[');
          break;
        default:
            reverse.append(this.getAppearance().charAt(i));
          break;
      }
    }
    return reverse.toString();
  }

  /** Turns this animal around. */
  void turnAround() {
      this.setGoingRight(!this.isGoingRight());
      this.setAppearance(reverseAppearance());
  }

  void goRight() {
      if (this.getX() < rightBound) {
          this.setX(this.getX() + 1);
    }
  }

  void goLeft() {
      if (this.getX() > leftBound) {
          this.setX(this.getX() - 1);
    }
  }

  void goUp() {
      if (this.getY() > upBound) {
          this.setY(this.getY() - 1);
    }
  }

  void goDown() {
      if (this.getY() < lowBound) {
          this.setY(this.getY() + 1);
    }
  }

  /**
   * Causes Animal to find an item on the farm and approaches to it. When this animal gets its
   * target, the item will be removed from the farm.
   *
   * @param myTargetList A list including the item that Animal wants to find.
   * @param target       The target item of this animal
   * @return true when this animal gets the target, false if this animal is still on its way
   */
  boolean getTarget(ArrayList myTargetList, Farm target) {
      if (this.getX() == target.getX() && this.getY() == target.getY()) {
      myTargetList.remove(target);
      return true;
    } else {
      // moves horizontally towards the egg
          if (this.getX() < target.getX()) {
        // turns human around if facing towards the wrong direction
              if (!this.isGoingRight()) {
          this.turnAround();
        }
        this.goRight();
          } else if (this.getX() > target.getX()) {
              if (this.isGoingRight()) {
          this.turnAround();
        }
        this.goLeft();
      }
      // moves human vertically towards the egg
          if (this.getY() < target.getY()) {
        this.goDown();
          } else if (this.getY() > target.getY()) {
        this.goUp();
      }
      return false;
    }
  }

  protected void move() {}

    /**
     * Indicates whether this Animal is moving right or left.
     */
    boolean isGoingRight() {
        return goingRight;
    }

    void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }
}
