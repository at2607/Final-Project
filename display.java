
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;



public class display extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root,Color.LIGHTSKYBLUE);
        //Image character = new Image(character.png);
        //primaryStage.getIcons().add(character);
        primaryStage.setTitle("Stage Demo");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(750);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        
        Text text = new Text();
        text.setText("test");
        text.setX(450);
        text.setY(450);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.LIMEGREEN);
        
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(100);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);
        line.setRotate(45);
        
        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.BLUE);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.BLACK);
        rectangle.setRotate(45);
        
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll
        (
        200.0,200.0,
        300.0,300.0,
        200.0,300.0);
        triangle.setFill(Color.YELLOW);
        
        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(75);
        circle.setFill(Color.ORANGE);
        
        Image image1 = new Image("character.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image1);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
        imageView.setX(700);
        imageView.setY(400);
        
        
        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
