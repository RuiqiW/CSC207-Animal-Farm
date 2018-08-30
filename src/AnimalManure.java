import javafx.scene.paint.Color;

/** Animal Manure produced by NonHuman animals. */
public class AnimalManure extends Farm {

  /* The time this AnimalManure being produced. */
  private Long timeStart;

  /**
   * Constructs a new AnimalManure.
   *
   * @param newAppearance the appearance of animal manure that is obtained from NonHuman.
   */
  AnimalManure(String newAppearance) {
    this.setColour(Color.BLACK.darker().darker().darker());
    this.setAppearance(newAppearance);
    this.setTimeStart(System.currentTimeMillis());
  }

  Long getTimeStart() {
    return timeStart;
  }

  private void setTimeStart(Long timeStart) {
    this.timeStart = timeStart;
  }
}
