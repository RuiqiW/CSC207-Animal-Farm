/** Non-human animal on the farm. */
public abstract class NonHuman extends Animal {

    private String manureAppearance;

    private boolean goingUp;

    private boolean beingHungry;

  private static int nextFood = 0;

  private AnimalFood targetFood = null;

    /**
     * Index of next Food in Farm.myAnimalFood to eat.
     */
    private static int getNextFood() {
        return nextFood;
    }

    private static void setNextFood(int nextFood) {
        NonHuman.nextFood = nextFood;
    }

  /** Helps animal clear stomach when there is food in stomach */
  private void clearStomach() {
      AnimalManure newManure = new AnimalManure(this.getManureAppearance());
      newManure.setLocation(this.getX(), this.getY());
      Farm.getMyAnimalManure().add(newManure);
  }

  /**
   * Causes this animal to take its turn in the farm-pen simulation. The animal can randomly go in
   * four directions, turn around and clearStomach. When hungry, this animal will move towards food
   * if there is any, then eats food and becomes full.
   */
  @Override
  protected void move() {
      // searches for food when hungry
      if (getTargetFood() == null && isBeingHungry()) {
          if (Farm.getMyAnimalFood().size() > getNextFood()) {
              setTargetFood(Farm.getMyAnimalFood().get(getNextFood()));
              setNextFood(getNextFood() + 1);
          }
      }
      if (getTargetFood() != null) {
          if (this.getTarget(Farm.getMyAnimalFood(), this.getTargetFood())) {
              this.setTargetFood(null);
          }
      } else {
          // no food to eat
          double d = Math.random();
          // digests from time to time
          if (d < 0.3) {
              setBeingHungry(true);
          } else if (d < 0.4) {
              this.clearStomach();
          }

          // wanders around
          d = Math.random();
          if (d < 0.1) {
              this.turnAround();
          } else if (d < 0.3) {
              this.setGoingUp(!this.isGoingUp());
          }
          if (this.isGoingUp()) {
              this.goUp();
          } else {
              this.goDown();
          }
          if (this.isGoingRight()) {
              this.goRight();
          } else {
              this.goLeft();
          }
      }
  }

    /**
     * Appearance of Animal's manure on the screen
     */
    private String getManureAppearance() {
        return manureAppearance;
    }

    void setManureAppearance(String manureAppearance) {
        this.manureAppearance = manureAppearance;
    }

    /**
     * Indicates whether this Animal is moving up or down.
     */
    boolean isGoingUp() {
        return goingUp;
    }

    void setGoingUp(boolean goingUp) {
        this.goingUp = goingUp;
    }

    /**
     * Indicates whether this Animal needs food.
     */
    private boolean isBeingHungry() {
        return beingHungry;
    }

    void setBeingHungry(boolean beingHungry) {
        this.beingHungry = beingHungry;
    }

    /**
     * The food to eat
     */
    private AnimalFood getTargetFood() {
        return targetFood;
    }

    private void setTargetFood(AnimalFood targetFood) {
        this.targetFood = targetFood;
    }
}
