import javafx.scene.paint.Color;

/**
 * A Cow which does what NonHuman animals do
 */
public class Cow extends NonHuman {
  /** Constructs a new Cow. */
  Cow() {
    this.setColour(Color.PINK.darker().darker());
    this.setAppearance("MOO");
    this.setManureAppearance("&");
    this.setGoingRight(false);
    this.setGoingUp(false);
    this.setBeingHungry(false);
  }
}
