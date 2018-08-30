import javafx.scene.paint.Color;

/** A Goose which does what NonHuman animals do and eats AnimalFood */
public class Goose extends NonHuman {

  /** Constructs a new Goose. */
  Goose() {
      this.setManureAppearance("#");
      this.setColour(Color.CHOCOLATE);
      this.setAppearance("(^)>");
      this.setGoingRight(true);
      this.setGoingUp(true);
      this.setBeingHungry(true);
  }

  /**
   * This goose will move forward 2 steps with no wind, 7 steps with the wind of the same direction
   * and -3 steps with the wind of the opposite direction.
   */
  private void glide() {
    int stepv = Wind.getVerticalDirection() * 5;
    int steph = Wind.getHorizontalDirection() * 5;
      if (this.isGoingUp()) {
        stepv -= 2;
    } else {
      stepv += 2;
    }
      if (this.isGoingRight()) {
      steph += 2;
    } else {
      steph -= 2;
    }
    for (int i = 0; i < stepv; i++) {
      this.goUp();
    }
    for (int i = 0; i < steph; i++) {
      this.goRight();
    }
  }

  /* Inherits all movement from NonHuman. While this goose can glide with wind as well */
  @Override
  protected void move() {
    super.move();
    if (Math.random() < 0.2) {
      this.glide();
    }
  }
}
