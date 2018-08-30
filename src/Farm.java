import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/** Farm object in farm ville. */
public abstract class Farm {

  private final static ArrayList<Animal> myFarmAnimals = new ArrayList<>();

  private final static ArrayList<AnimalFood> myAnimalFood = new ArrayList<>();

  private final static ArrayList<AnimalManure> myAnimalManure = new ArrayList<>();

  private final static ArrayList<Egg> eggs = new ArrayList<>();

  /** The width of a character. */
  static final int charWidth = 6;

  /** The height of a character. */
  static final int charHeight = 10;

  /** The boundary of this farm that things can go to. */
  static final int leftBound = 1;

  static final int rightBound = 960 / charWidth;

  static final int upBound = 1;

  static final int lowBound = 640 / charHeight;

  private String appearance;

  private int x;

  private int y;

  private Color colour;

  /**
   * Records all Animals on the Farm.
   */
  static ArrayList<Animal> getMyFarmAnimals() {
    return myFarmAnimals;
  }

  /**
   * Records the food Human spread.
   */
  static ArrayList<AnimalFood> getMyAnimalFood() {
    return myAnimalFood;
  }

  /**
   * Records the manure NonHuman animals produced.
   */
  static ArrayList<AnimalManure> getMyAnimalManure() {
    return myAnimalManure;
  }

  /**
   * Records the eggs Chicken laid.
   */
  static ArrayList<Egg> getEggs() {
    return eggs;
  }

  /**
   * Set this item's location.
   *
   * @param a the first coordinate.
   * @param b the second coordinate.
   */
  void setLocation(int a, int b) {
    this.setX(a);
    this.setY(b);
  }

  /**
   * Draws this farm pen item.
   *
   * @param g the graphics context in which to draw this item.
   */
  protected void draw(GraphicsContext g) {
    g.setFill(this.getColour());
    g.fillText(this.getAppearance(), this.getX() * charWidth, this.getY() * charHeight);
  }

  /**
   * This Farm object's appearance on the screen.
   */
  String getAppearance() {
    return appearance;
  }

  void setAppearance(String appearance) {
    this.appearance = appearance;
  }

  /**
   * This Farm object's first coordinate.
   */
  int getX() {
    return x;
  }

  void setX(int x) {
    this.x = x;
  }

  /**
   * This Farm object's second coordinate.
   */
  int getY() {
    return y;
  }

  void setY(int y) {
    this.y = y;
  }

  /**
   * The colour of this Farm object.
   */
  private Color getColour() {
    return colour;
  }

  void setColour(Color colour) {
    this.colour = colour;
  }
}
