import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** A Human who can spread food and collect egg */
public class Human extends Animal {

  private static int myBasket = 0;

  private static int nextEgg = 0;

  private Egg target = null;

  /** Constructs a new Human. */
  Human() {
      this.setColour(Color.SANDYBROWN.darker());
      this.setAppearance("human");
      this.setGoingRight(false);
  }

    /**
     * Number of eggs all Human collect.
     */
    private static int getMyBasket() {
        return myBasket;
    }

    private static void setMyBasket(int myBasket) {
        Human.myBasket = myBasket;
    }

    /**
     * Index of next Egg in Chicken.eggs that can be collected.
     */
    private static int getNextEgg() {
        return nextEgg;
    }

    private static void setNextEgg(int nextEgg) {
        Human.nextEgg = nextEgg;
  }

  /**
   * Draws the given Human in the given graphics context at at the given cursor location. Shows the
   * number of eggs all human collected.
   *
   * @param g the graphics context in which to draw the string.
   */
  @Override
  protected void draw(GraphicsContext g) {
      super.draw(g);
      g.fillText("Eggs: " + getMyBasket(), 2 * charWidth, 2 * charHeight);
  }

  /** Causes human to drop down 4 pieces of food all around. */
  private void dropFood() {
    AnimalFood fooood = new AnimalFood();
    // checks whether the place to drop food will be out of boundary
      if (this.getX() > leftBound) {
          if (this.getY() > upBound) {
              fooood.setLocation(getX() - 1, getY() - 1);
              Farm.getMyAnimalFood().add(fooood);
          }
          if (this.getY() < lowBound) {
        fooood = new AnimalFood();
              fooood.setLocation(getX() - 1, getY() + 1);
              Farm.getMyAnimalFood().add(fooood);
          }
      }
      if (this.getX() < rightBound) {
          if (this.getY() > upBound) {
        fooood = new AnimalFood();
              fooood.setLocation(getX() + 1, getY() - 1);
              Farm.getMyAnimalFood().add(fooood);
          }
          if (this.getY() < lowBound) {
        fooood = new AnimalFood();
              fooood.setLocation(getX() + 1, getY() + 1);
              Farm.getMyAnimalFood().add(fooood);
      }
    }
  }

  /**
   * Causes Human to take its turn in the farm-pen simulation. Human drops food and picks eggs, or
   * wanders around.
   */
  @Override
  protected void move() {
      if (this.getTarget() == null) {
          if (Farm.getEggs().size() > getNextEgg()) {
              this.setTarget(Farm.getEggs().get(getNextEgg()));
              setNextEgg(getNextEgg() + 1);
          }
      }
      if (getTarget() != null) {
          if (this.getTarget(Farm.getEggs(), this.getTarget())) {
              // clears target if get the egg
              this.setTarget(null);
              setMyBasket(getMyBasket() + 1);
          }
      } else {
          // Moves this human around when no egg to pick up
          double d = Math.random();
          if (d < 0.1) {
              this.goUp();
          } else if (d < 0.2) {
              this.goDown();
          } else if (d < 0.3) {
              this.turnAround();
          }
          if (this.isGoingRight()) {
              this.goRight();
          } else {
              this.goLeft();
          }
      }
      if (Math.random() < 0.02) {
          this.dropFood();
      }
  }

    /**
     * The egg to be collected by Human
     */
    private Egg getTarget() {
        return target;
    }

    private void setTarget(Egg target) {
        this.target = target;
    }
}
