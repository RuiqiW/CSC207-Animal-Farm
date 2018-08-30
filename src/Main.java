import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Our take on the "classical" game Farm Ville */
public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("FarmVille");

    Group root = new Group();
    Scene theScene = new Scene(root);
    primaryStage.setScene(theScene);
    Canvas canvas = new Canvas(1024, 720);
    root.getChildren().add(canvas);

    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Sets up new farm animals at random location. 3 geese, 3 chicken, 1 pig, 1 cow, 2 humans in
    // total.
    for (int i = 0; i < 3; i++) {
      Farm.getMyFarmAnimals().add(new Chicken().assignLocation());
      Farm.getMyFarmAnimals().add(new Goose().assignLocation());
    }
    Farm.getMyFarmAnimals().add(new Pig().assignLocation());
    Farm.getMyFarmAnimals().add(new Cow().assignLocation());
    Farm.getMyFarmAnimals().add(new Human().assignLocation());
    Farm.getMyFarmAnimals().add(new Human().assignLocation());

    drawShapes(gc);

    Timeline gameLoop = new Timeline();
    gameLoop.setCycleCount(Timeline.INDEFINITE);

    KeyFrame kf =
        new KeyFrame(
            Duration.seconds(0.5),
            ae -> {
              // things take turns to move
              for (int i = 0; i < Farm.getMyFarmAnimals().size(); i++) Farm.getMyFarmAnimals().get(i).move();
              for (int i = 0; i < Farm.getMyAnimalManure().size(); i++)
                if ((System.currentTimeMillis() - Farm.getMyAnimalManure().get(i).getTimeStart()) >= 10000) {
                  Farm.getMyAnimalManure().remove(i);
                  i--; // ensures index referring to the next manure
                }
              for (int i = 0; i < Farm.getMyAnimalFood().size(); i++)
                if (Farm.getMyAnimalFood().get(i) != null) Farm.getMyAnimalFood().get(i).move();

              // Clears the canvas
              gc.clearRect(0, 0, 1024, 720);
              drawShapes(gc);
            });

    gameLoop.getKeyFrames().add(kf);
    gameLoop.play();
    primaryStage.show();
  }

  private void drawShapes(GraphicsContext gc) {
    // Tells all the farmyard items to draw themselves.
    for (int i = 0; i < Farm.getMyFarmAnimals().size(); i++) Farm.getMyFarmAnimals().get(i).draw(gc);
    for (int i = 0; i < Farm.getMyAnimalManure().size(); i++) Farm.getMyAnimalManure().get(i).draw(gc);
    for (int i = 0; i < Farm.getEggs().size(); i++) Farm.getEggs().get(i).draw(gc);
    for (int i = 0; i < Farm.getMyAnimalFood().size(); i++) Farm.getMyAnimalFood().get(i).draw(gc);
  }
}
