import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MoveObjectWithKeyboard extends Application {

    private Circle circle;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setFullScreen(true);

        circle = new Circle(350, 350, 50, Color.BLACK);

        Line l1 = new Line(0, 106, 500, 106);
        l1.setStrokeWidth(5);
        l1.setStroke(Color.RED);

        Line l2 = new Line(500, 106, 500, 300);
        l2.setStrokeWidth(5);
        l2.setStroke(Color.RED);

        Line l3 = new Line(500, 300, 106, 300);
        l3.setStrokeWidth(5);
        l3.setStroke(Color.RED);

        Circle r = new Circle(50, 50, 50, Color.GREEN);
        r.setOpacity(0.8);

        Text text = new Text("You WIN!");
        text.setX(600);
        text.setY(75);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.LIMEGREEN);

        pane.getChildren().addAll(l1, l2, l3, r, circle);

        scene.setOnKeyPressed(event -> {
            double moveDistance = 10;

            switch (event.getCode()) {
                case A:
                    moveCircle(-moveDistance, 0, pane.getWidth(), pane.getHeight());
                    break;
                case D:
                    moveCircle(moveDistance, 0, pane.getWidth(), pane.getHeight());
                    break;
                case W:
                    moveCircle(0, -moveDistance, pane.getWidth(), pane.getHeight());
                    break;
                case S:
                    moveCircle(0, moveDistance, pane.getWidth(), pane.getHeight());
                    break;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Move Object with Keyboard");
        primaryStage.show();
    }

    private void moveCircle(double deltaX, double deltaY, double paneWidth, double paneHeight) {
        double newX = circle.getCenterX() + deltaX;
        double newY = circle.getCenterY() + deltaY;

        // Check for collisions with red lines
        if (!collidesWithRedLines(newX, newY, circle.getRadius(), paneWidth, paneHeight)) {
            circle.setCenterX(newX);
            circle.setCenterY(newY);
        }
    }

    private boolean collidesWithRedLines(double x, double y, double radius, double paneWidth, double paneHeight) {
        // Check for collisions with red lines
        return x - radius <= 0 || x + radius >= paneWidth || y - radius <= 106 || y + radius >= 300;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
