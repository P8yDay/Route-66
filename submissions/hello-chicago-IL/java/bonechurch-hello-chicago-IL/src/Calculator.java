public class Calculator {
    public static final byte    FIELD_LENGTH = 13;

    private enum                Operator { UNDEFINED, ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, EXPONENTIATION }

    private String              operand, snapshot;
    private boolean             binaryExp, build;
    private Operator            exp;


    // constructor methods

    public Calculator() {
        operand = "";
        snapshot = "";
        binaryExp = false;
        build = false;
        exp = Operator.UNDEFINED;
    }

    // numbers, constants, decimals

    public void handlePiPressed() {
        operand = String.format("%1.11f", Math.PI);
    }

    public void handleNumberedButtonPressed(String number) {
        reset();
        if (operand.equals("0")) operand = number;
        else if (operand.length() < FIELD_LENGTH) operand += number;
    }

    public void handleZeroPressed() {
        reset();
        if (!operand.isEmpty() && !operand.equals("0") && operand.length() < FIELD_LENGTH) operand += "0";
        else if (operand.isEmpty()) operand += "0.";
        build = true;   // allows for decimals and zeros to display properly
    }

    public void handleDecimalPressed() {
        reset();
        if (!operand.isEmpty() && !operand.contains(".") && operand.length() < FIELD_LENGTH) operand += ".";
        build = true;   // allows for decimals and zeros to display properly
    }

    // unary operators

    public void handleNegationPressed() {
        reset();
        if (!operand.isEmpty()) {
            if (Double.parseDouble(operand) > 0) operand = "-" + operand;
            else operand = operand.substring(1);
        }
    }

    public void handleSquareRootPressed() {
        reset();
        if (!operand.isEmpty() && !binaryExp) operand = String.format("%1.11f", (Math.sqrt(Double.parseDouble(operand))));
    }

    public void handleCosPressed() {
        reset();
        if (!operand.isEmpty() && !binaryExp) operand = String.format("%1.11f", (Math.cos(Double.parseDouble(operand))));
    }

    public void handleSinPressed() {
        reset();
        if (!operand.isEmpty() && !binaryExp) operand = String.format("%1.11f", (Math.sin(Double.parseDouble(operand))));
    }

    public void handleTanPressed() {
        reset();
        if (!operand.isEmpty() && !binaryExp) operand = String.format("%1.11f", (Math.tan(Double.parseDouble(operand))));
    }

    public void handleOneDividedByPressed() {
        reset();
        if (!operand.isEmpty() && !binaryExp) operand = String.format("%1.11f", (1 / Double.parseDouble(operand)));
    }

    // binary operators

    public void handleDividePressed() {
        binaryExpPressed(Operator.DIVISION);
    }

    public void handleMultiplyPressed() {
        binaryExpPressed(Operator.MULTIPLICATION);
    }

    public void handleSubtractPressed() {
        binaryExpPressed(Operator.SUBTRACTION);
    }

    public void handleAddPressed() {
        binaryExpPressed(Operator.ADDITION);
    }

    public void handleExponentPressed() {
        binaryExpPressed(Operator.EXPONENTIATION);
    }

    private void binaryExpPressed(Operator op) {
        reset();
        if (!operand.isEmpty() && !binaryExp) {
            snapshot = operand;
            operand = "";
            binaryExp = true;
            exp = op;
        }
    }

    // other functions

    public void handleEqualsPressed() {
        reset();
        if (!operand.isEmpty() && binaryExp) {
            switch (exp) {
                case ADDITION:
                    operand = String.format("%1.11f", (Double.parseDouble(snapshot) + Double.parseDouble(operand)));
                    break;
                case SUBTRACTION:
                    operand = String.format("%1.11f", (Double.parseDouble(snapshot) - Double.parseDouble(operand)));
                    break;
                case MULTIPLICATION:
                    operand = String.format("%1.11f", (Double.parseDouble(snapshot) * Double.parseDouble(operand)));
                    break;
                case DIVISION:
                    operand = String.format("%1.11f", (Double.parseDouble(snapshot) / Double.parseDouble(operand)));
                    break;
                case EXPONENTIATION:
                    operand = String.format("%1.11f", Math.pow(Double.parseDouble(snapshot), Double.parseDouble(operand)));
                    break;
            }
            snapshot = "";
            binaryExp = false;
            exp = Operator.UNDEFINED;
        }
    }

    public void handleClearPressed() {
        operand = "";
        snapshot = "";
        binaryExp = false;
        build = false;
        exp = Operator.UNDEFINED;
    }

    public String display() {
        if (operand.contains(".") && !build) {
            while (operand.endsWith("0")) operand = operand.substring(0, operand.length()-1);
            if (operand.endsWith(".")) operand = operand.substring(0, operand.length()-1);
        }
        build = false;
        return operand;
    }

    private void reset() {
        if (operand.equals("NaN") || operand.equals("Infinity")) operand = "";
    }
}
