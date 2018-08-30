import javafx.scene.paint.Color;

/**
 * A Pig which does what NonHuman animals do
 */
public class Pig extends NonHuman {

  /** Constructs a new Pig. */
  Pig() {
    this.setColour(Color.PINK.darker().darker().darker());
    this.setAppearance(":(8)");
    this.setManureAppearance("*");
    this.setGoingRight(true);
    this.setGoingUp(false);
    this.setBeingHungry(true);
  }
}
