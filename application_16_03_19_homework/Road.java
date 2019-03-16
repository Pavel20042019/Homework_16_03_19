package application_16_03_19_homework;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
public class Road extends Application {
	public Road () {
	}
	public void start (Stage stage) {
		stage.setTitle ("Road");
		Group root = new Group ();
		Scene scene = new Scene (root);
		stage.setScene (scene);
		Canvas canvas = new Canvas (512, 512);
		root.getChildren ().add (canvas);
		Image car = new Image ("application_16_03_19_homework/car.png"), road_marking = new Image ("application_16_03_19_homework/road_marking.png");
		GraphicsContext gc = canvas.getGraphicsContext2D ();
		Paint green = Color.rgb (0, 200, 0), grey = Color.rgb (127, 127, 127);
		long startNanoTime = System.nanoTime ();
		new AnimationTimer () {
			public void handle (long t) {
				double position = 63 - ((t - startNanoTime) / 4000000.0) % 128;
				gc.setStroke (green);
				gc.setFill (green);
				gc.fillRect (0, 0, 512, 192);
				gc.fillRect (0, 320, 512, 192);
				gc.setStroke (grey);
				gc.setFill (grey);
				gc.fillRect (0, 192, 512, 128);
				gc.drawImage (road_marking, position, 248);
				gc.drawImage (car, 189, 223);
			}
		}.start ();
		stage.show ();
	}
	public static void main (String [] args) {
		launch (args);
	}
}