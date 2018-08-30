import javafx.scene.paint.Color;

/** An egg that a chicken lays and farmer collects. */
public class Egg extends Farm {
  /** Constructs a new Egg. */
  Egg() {
    this.setColour(Color.ROSYBROWN);
    this.setAppearance("o");
  }
}
