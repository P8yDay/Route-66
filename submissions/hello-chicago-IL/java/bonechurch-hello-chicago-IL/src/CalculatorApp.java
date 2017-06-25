import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    private Calculator          model;
    private CalculatorView      view;

    public void start(Stage primaryStage) {
        model = new Calculator();
        view = new CalculatorView(model);

        // define event handlers

        view.getPi().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handlePiPressed(); view.update(); }
        });
        view.getOneDividedBy().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleOneDividedByPressed(); view.update(); }
        });
        view.getNegation().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleNegationPressed(); view.update(); }
        });
        view.getZero().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleZeroPressed(); view.update(); }
        });
        view.getDecimal().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleDecimalPressed(); view.update(); }
        });
        view.getEquals().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleEqualsPressed(); view.update(); }
        });
        view.getSquareRoot().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleSquareRootPressed(); view.update(); }
        });
        view.getExponent().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleExponentPressed(); view.update(); }
        });
        view.getCos().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleCosPressed(); view.update(); }
        });
        view.getSin().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleSinPressed(); view.update(); }
        });
        view.getTan().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleTanPressed(); view.update(); }
        });
        view.getClear().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleClearPressed(); view.update(); }
        });
        view.getDivide().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleDividePressed(); view.update(); }
        });
        view.getMultiply().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleMultiplyPressed(); view.update(); }
        });
        view.getSubtract().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleSubtractPressed(); view.update(); }
        });
        view.getAdd().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) { model.handleAddPressed(); view.update(); }
        });

        for (int i = 0; i < view.getNumbers().length; i++) {
            view.getNumbers()[i].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    model.handleNumberedButtonPressed(((Button)event.getSource()).getText());
                    view.update();
                }
            });
        }

        primaryStage.setTitle("Catch Capone Calculator");
        primaryStage.setScene(new Scene(view, 5 * (CalculatorView.BUTTON_UNIT_SIZE + 10) + 20,6 * (CalculatorView.BUTTON_UNIT_SIZE + 10) + 20));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
