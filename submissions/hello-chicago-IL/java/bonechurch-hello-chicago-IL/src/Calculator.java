public class Calculator {
    public static final byte    WAITING_TO_BEGIN = 0;
    public static final byte    OP1_IN_PROGRESS = 1;
    public static final byte    OP2_IN_PROGRESS = 2;

    public enum BinaryOperator {
        addition, subtraction, multiplication, division, exponentiation;
    }

    private double          op1, op2, result;
    private String          operand;
    private boolean         buildingOp;
    private byte            mode;
    private BinaryOperator  binary;

    // constructor methods
    public Calculator() {
        op1 = 0;
        op2 = 0;
        result = 0;
        operand = "";
        buildingOp = false;
        mode = WAITING_TO_BEGIN;
    }

    // get/set methods
    public double getOp1() { return op1; }
    public double getOp2() { return op2; }
    public double getResult() { return result; }
    public String getOperand() { return operand; }
    public boolean isBuildingOp() { return buildingOp; }
    public byte getMode() { return mode; }

    // methods
    public void handlePiPressed() {
        if (mode == WAITING_TO_BEGIN || mode == OP1_IN_PROGRESS) {
            op1 = Math.PI;
            operand = "";
            buildingOp = false;
        } else if (mode == OP2_IN_PROGRESS) {
            op2 = Math.PI;
            operand = "";
            buildingOp = false;
        }
    }

    public void handleOneDividedByPressed() {
        if (mode == OP1_IN_PROGRESS) {
            result = 1 / op1;
            operand = "";
            buildingOp = false;
        } else if (mode == OP2_IN_PROGRESS) {
            result = 1 / op2;
            operand = "";
            buildingOp = false;
        }
        mode = WAITING_TO_BEGIN;
    }

    public void handleFactorialPressed() {
        if (mode == OP1_IN_PROGRESS) {
            result = factorial(op1);
            operand = "";
            buildingOp = false;
        } else if (mode == OP2_IN_PROGRESS) {
            result = factorial(op2);
            operand = "";
            buildingOp = false;
        }
        mode = WAITING_TO_BEGIN;
    }

    private double factorial(double num) {
        if (num == 0) return 1;
        return factorial(num-1) * num;
    }

    public void handleZeroPressed() {
        if (mode == OP1_IN_PROGRESS || mode == OP2_IN_PROGRESS) {
            operand += "0";
            buildingOp = true;
        }
    }

    public void handleDecimalPressed() {
        if (mode == OP1_IN_PROGRESS || mode == OP2_IN_PROGRESS) {
            operand += ".";
            buildingOp = true;
        }
    }

    public void handleEqualsPressed() {
        if (mode == OP2_IN_PROGRESS) {
            op2 = Double.parseDouble(operand);
            if (op2 != 0) result = evaluate();
        }
    }

    private double evaluate() {
        switch (binary) {
            case addition:
                return op1 + op2;
            case subtraction:
                return op1 - op2;
            case multiplication:
                return op1 * op2;
            case division:
                return op1 / op2;
            case exponentiation:
                return Math.pow(op1, op2);
        }
        return 0;
    }

    public void handleSquareRootPressed() {
        if (mode == OP1_IN_PROGRESS) {
            result = Math.sqrt(op1);
            operand = "";
            buildingOp = false;
        } else if (mode == OP2_IN_PROGRESS) {
            result = 1 / op2;
            operand = "";
            buildingOp = false;
        }
        mode = WAITING_TO_BEGIN;
    }

    public void handleExponentPressed() {

    }

    public void handleCosPressed() {

    }

    public void handleSinPressed() {

    }

    public void handleTanPressed() {

    }

    public void handleClearPressed() {

    }

    public void handleDividePressed() {

    }

    public void handleMultiplyPressed() {

    }

    public void handleSubtractPressed() {

    }

    public void handleAddPressed() {

    }

    public void handleNumberedButtonPressed(int number) {
        if (mode == WAITING_TO_BEGIN || mode == OP1_IN_PROGRESS) {
            operand += number;
            buildingOp = true;
            mode = OP1_IN_PROGRESS;
        } else if (mode == OP2_IN_PROGRESS) {
            operand += number;
            buildingOp = true;
        } else {

        }
    }
}
