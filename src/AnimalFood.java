import javafx.scene.paint.Color;

/** Animal Food */
public class AnimalFood extends Farm {
  /** Constructs a new food. */
  AnimalFood() {
      this.setColour(Color.GRAY.darker().darker().darker());
      this.setAppearance("%");
  }

  /** Causes this food to take its turn in the farm-pen simulation. It moves due to strong winds. */
  void move() {
    // Be blown up, down or neither
      int d = Wind.getVerticalDirection();
      this.setY(this.getY() + d);
    // if out of bound
      if (this.getY() > lowBound || this.getY() < upBound) {
          this.setY(this.getY() - d);
    }
    // Be blown left, right or neither
      d = Wind.getHorizontalDirection();
      this.setX(this.getX() + d);
      if (this.getX() > rightBound || this.getX() < leftBound) {
          this.setX(this.getX() - d);
    }
  }
}
