
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;

public class TextImageDisplay extends Application {

    @Override
    public void start(Stage stage) {

        // Create the label
        Label label = new Label("Hello, JavaFX!");

        // Load the image from the resources folder
        InputStream imageStream =
                TextImageDisplay.class.getResourceAsStream("/sample.png");

        if (imageStream == null) {
            throw new RuntimeException(
                    "Image not found! Check src/main/resources/sample.png"
            );
        }

        Image image = new Image(imageStream);

        if (image.isError()) {
            throw new RuntimeException(
                    "Unable to load the image",
                    image.getException()
            );
        }

        // Display the image
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        // Arrange the label and image vertically
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, imageView);

        // Create the scene
        Scene scene = new Scene(root, 600, 400);

        // Configure the stage
        stage.setTitle("Text and Image Display");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

