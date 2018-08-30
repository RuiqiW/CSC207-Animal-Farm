import javafx.scene.paint.Color;

/** A Chicken which does what NonHuman animals do and lays Eggs */
public class Chicken extends NonHuman {

  /** Constructs a new Chicken. */
  Chicken() {
    this.setManureAppearance(".");
    this.setColour(Color.RED);
    this.setAppearance("/'/>");
    this.setGoingRight(true);
    this.setGoingUp(true);
    this.setBeingHungry(false);
  }

  /**
   * Causes this chicken to take its turn in the farm-pen simulation. This chicken can does what
   * non-human animals do and lays eggs randomly as well.
   */
  @Override
  protected void move() {
    super.move();
    // Every now and then lay an egg.
    if (Math.random() < 0.1) {
      this.layEgg();
    }
  }

  private void layEgg() {
    Egg egg = new Egg();
    egg.setLocation(this.getX(), this.getY());
    Farm.getEggs().add(egg);
  }
}
