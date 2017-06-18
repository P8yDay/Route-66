import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculatorView extends GridPane {
    public static final int BUTTON_UNIT_SIZE = 70;

    private TextField       displayField;
    private Button[]        numbers;
    private Button          pi, oneDividedBy, factorial, zero, decimal, equals, squareRoot,
                            exponent, cos, sin, tan, clear, divide, multiply, subtract, add;

    private Calculator      model;

    // get/set methods
    public Button[] getNumbers() { return numbers; }
    public Button getPi() { return pi; }
    public Button getOneDividedBy() { return oneDividedBy; }
    public Button getFactorial() { return factorial; }
    public Button getZero() { return zero; }
    public Button getDecimal() { return decimal; }
    public Button getEquals() { return equals; }
    public Button getSquareRoot() { return squareRoot; }
    public Button getExponent() { return exponent; }
    public Button getCos() { return cos; }
    public Button getSin() { return sin; }
    public Button getTan() { return tan; }
    public Button getClear() { return clear; }
    public Button getDivide() { return divide; }
    public Button getMultiply() { return multiply; }
    public Button getSubtract() { return subtract; }
    public Button getAdd() { return add; }

    // constructor method
    public CalculatorView(Calculator m) {
        model = m;
        setPadding(new Insets(10));

        displayField = new TextField();
        displayField.setStyle("-fx-font: 40 helvetica;");
        displayField.setAlignment(Pos.CENTER_RIGHT);
        displayField.setMinHeight(BUTTON_UNIT_SIZE);
        displayField.setFocusTraversable(false);
        displayField.setEditable(false);
        setMargin(displayField, new Insets(5));
        add(displayField, 0, 0, 5, 1);

        pi = new Button("π");
        pi.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        pi.setFocusTraversable(false);
        setMargin(pi, new Insets(5));
        pi.setStyle("-fx-base: #a9a9a9;");
        add(pi, 0, 1);

        oneDividedBy = new Button("1/x");
        oneDividedBy.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        oneDividedBy.setFocusTraversable(false);
        setMargin(oneDividedBy, new Insets(5));
        oneDividedBy.setStyle("-fx-base: #a9a9a9;");
        add(oneDividedBy, 1, 1);

        factorial = new Button("x!");
        factorial.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        factorial.setFocusTraversable(false);
        setMargin(factorial, new Insets(5));
        factorial.setStyle("-fx-base: #a9a9a9;");
        add(factorial, 2, 1);

        int count = 1;
        numbers = new Button[9];
        for (int i = 4; i > 1; i--) {
            for (int j = 0; j < 3; j++) {
                Button num = new Button("" + count);
                num.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
                num.setFocusTraversable(false);
                setMargin(num, new Insets(5));
                add(num, j, i);
                numbers[count-1] = num;
                count++;
            }
        }

        zero = new Button("0");
        zero.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        zero.setFocusTraversable(false);
        setMargin(zero, new Insets(5));
        add(zero, 0, 5);

        decimal = new Button(".");
        decimal.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        decimal.setFocusTraversable(false);
        setMargin(decimal, new Insets(5));
        add(decimal, 1, 5);

        equals = new Button("=");
        equals.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        equals.setFocusTraversable(false);
        setMargin(equals, new Insets(5));
        equals.setStyle("-fx-base: #1e90ff;");
        add(equals, 2, 5);

        squareRoot = new Button("√");
        squareRoot.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        squareRoot.setFocusTraversable(false);
        setMargin(squareRoot, new Insets(5));
        squareRoot.setStyle("-fx-base: #a9a9a9;");
        add(squareRoot, 3, 1);

        exponent = new Button("y^x");
        exponent.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        exponent.setFocusTraversable(false);
        setMargin(exponent, new Insets(5));
        exponent.setStyle("-fx-base: #a9a9a9;");
        add(exponent, 3, 2);

        cos = new Button("cos(x)");
        cos.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        cos.setFocusTraversable(false);
        setMargin(cos, new Insets(5));
        cos.setStyle("-fx-base: #a9a9a9;");
        add(cos, 3, 3);

        sin = new Button("sin(x)");
        sin.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        sin.setFocusTraversable(false);
        setMargin(sin, new Insets(5));
        sin.setStyle("-fx-base: #a9a9a9;");
        add(sin, 3, 4);

        tan = new Button("tan(x)");
        tan.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        tan.setFocusTraversable(false);
        setMargin(tan, new Insets(5));
        tan.setStyle("-fx-base: #a9a9a9;");
        add(tan, 3, 5);

        clear = new Button("Clear");
        clear.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        clear.setFocusTraversable(false);
        setMargin(clear, new Insets(5));
        clear.setStyle("-fx-base: #a9a9a9;");
        add(clear, 4, 1);

        divide = new Button("÷");
        divide.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        divide.setFocusTraversable(false);
        setMargin(divide, new Insets(5));
        divide.setStyle("-fx-base: #a9a9a9;");
        add(divide, 4, 2);

        multiply = new Button("x");
        multiply.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        multiply.setFocusTraversable(false);
        setMargin(multiply, new Insets(5));
        multiply.setStyle("-fx-base: #a9a9a9;");
        add(multiply, 4, 3);

        subtract = new Button("-");
        subtract.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        subtract.setFocusTraversable(false);
        setMargin(subtract, new Insets(5));
        subtract.setStyle("-fx-base: #a9a9a9;");
        add(subtract, 4, 4);

        add = new Button("+");
        add.setMinSize(BUTTON_UNIT_SIZE, BUTTON_UNIT_SIZE);
        add.setFocusTraversable(false);
        setMargin(add, new Insets(5));
        add.setStyle("-fx-base: #a9a9a9;");
        add(add, 4, 5);

        update();
    }

    // update method
    public void update() {
        // update displayField
        displayField.setText(String.format("%1.10f", model.getResult()));
    }
}
