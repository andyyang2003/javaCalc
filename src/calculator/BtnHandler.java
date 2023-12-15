package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * parent class BtnHandler creates instance of calc
 */
public class BtnHandler implements ActionListener{
    /**
     * instance of calc to be used by all buttons
     */
    protected Calculator calc; //instance of calc

    /**
     * whenever btnhandler is called, must put in the instance of calc and will compose of all the calc stuff yk
     * @param calc
     */
    public BtnHandler(Calculator calc){
        this.calc = calc; // set constructor to use this instance
    }

    /**
     * is implimented per button depending on needed action
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // to be implimented
    }

    /**
     * Contains basic operations and error checking when needed
     * @param operand1 0 by default, input saved b4 operator input
     * @param operand2 0 by default, input saved after operator input
     * @param operator string operator set manually by press of button
     * @return returns value of operation
     */
    public double operation(double operand1, double operand2, String operator) {

        switch (operator){
            case "*":
                return operand1 * operand2;
            case "/":
                if (Double.isNaN(operand1/operand2) || Double.isInfinite(operand1/operand2)){
                    return -1.0;
                }
                return operand1 / operand2;
            case "-":
                return operand1 - operand2;
            case "+":
                return operand1 + operand2;
            case "^":
                return Math.pow(operand1, operand2);
            case "%":
                return (operand1)/100;
            case "x^2":
                return (operand1)*operand1;
            default:
                return 0.0;
        }
    }

}

/**
 * includes actionPerformed listener for each of the number buttons,
 * handles decimal input by textField processing
 */
class NumBtnHandler extends BtnHandler {

    public NumBtnHandler(Calculator calc){
        super(calc);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String s = e.getActionCommand();
        //THIS WAS FOR TESTING System.out.println(s);
        JTextField textField = calc.getTextField();
        String text = textField.getText();
        if (s.equals(".")){
            if (!text.contains(".")){
                calc.setTextField(text + s);
                calc.operand1 = Double.parseDouble(textField.getText());
                //THIS WAS FOR TESTING System.out.println(calc.operand1);
            }
        }else if (s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.charAt(0) == '.') {
            if (calc.operator.equals("\0")) {
                if (text.equals("0") && s.charAt(0) != '.') { // if text is start and non decimal
                    calc.setTextField(s); //s = 1
                    calc.operand1 = Double.parseDouble(s);//op1 = 1
                    //THIS WAS FOR TESTING System.out.println("This is calc.operand1: " + calc.operand1);
                } else if (!text.contains(".") || s.charAt(0) != '.') {// if not decimal already and input none dec
                    textField.setText(text + s);
                    calc.operand1 = Double.parseDouble(textField.getText());
                    //THIS WAS FOR TESTING System.out.println("This is calc.operand1: " + calc.operand1);
                }
            } else {
                textField.setText(textField.getText() + s);
                calc.operand2 = Double.parseDouble(textField.getText());
                //THIS WAS FOR TESTING System.out.println("This is calc.operand2: " + calc.operand2);
            }
        }
    }
}

/**
 * same as num handler, calls on operation() when needed and houses the complex operations
 * complex operations have built in error check when needed
 */
class OpBtnHandler extends BtnHandler {

    public OpBtnHandler(Calculator calc) {
        super(calc);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String s = e.getActionCommand();
        //THIS WAS FOR TESTING System.out.println(s);
        JTextField textField = calc.getTextField();
        String text = textField.getText();
        if (s.equals("+")){
            textField.setText("");
            calc.operator = "+";
        }
        if (s.equals("-")){
            textField.setText("");
            calc.operator = "-";
        }
        if (s.equals("/")){
            textField.setText("");
            calc.operator = "/";
        }
        if (s.equals("*")){
            textField.setText("");
            calc.operator = "*";
        }
        //operation buttons
        if (s.equals("x^y")){
            textField.setText("");
            calc.operator = "^";
        }
        if (s.equals("x^2")){
            calc.operand1 *= calc.operand1;
            if (calc.operand1 % 1 != 0) {

                textField.setText(calc.operand1.toString()); //double result
            }
            textField.setText(String.valueOf(calc.operand1.intValue())); //integer result
        }
        if (s.equals("%")){
            calc.operand1 = operation(calc.operand1, 0.0, "%");
            textField.setText(calc.operand1.toString());
        }
        if (s.equals("sqrt")){
            calc.operand1 = Math.sqrt(Double.parseDouble(textField.getText()));
            if (!Double.isNaN(calc.operand1)) {
                if (calc.operand1 % 1 != 0) {

                    textField.setText(calc.operand1.toString()); //double result
                }
                textField.setText(String.valueOf(calc.operand1.intValue())); //integer result
            }
            else {
                textField.setText("ERROR");
                calc.operator = "\0";
                calc.operand1 = 0.0;
                calc.operand2 = 0.0;
            }
        }
        if (s.equals("-/+")){
            calc.operand1 = Double.parseDouble(textField.getText()) * -1;
            textField.setText(calc.operand1.toString());
        }
        if (s.equals("ln")){
            calc.operand1 = Math.log(calc.operand1);
            if (!Double.isNaN(calc.operand1)) {
                if (calc.operand1 % 1 != 0) {
                    textField.setText(calc.operand1.toString()); //double result
                }
                textField.setText(String.valueOf(calc.operand1.intValue())); //integer result
            }
            else {
                textField.setText("ERROR");
                calc.operator = "\0";
                calc.operand1 = 0.0;
                calc.operand2 = 0.0;
            }
        }
        if (s.equals("AC")){
            textField.setText("0");
            calc.operator = "\0";
            calc.operand1 = 0.0;
            calc.operand2 = 0.0;
        }
        if (s.equals("=")){
            Double result = operation(calc.operand1, calc.operand2, calc.operator);
            //THIS WAS FOR TESTING System.out.println(result);
            calc.operand1 = result;
            calc.operand2 = 0.0;
            if (result%1 != 0) {
                textField.setText(result.toString());
            }
            else if (result%1 == 0)
            {
                textField.setText(String.valueOf(result.intValue()));
            }
            if (result == -1) {
                textField.setText("ERROR");
                calc.operator = "\0";
                calc.operand1 = 0.0;
                calc.operand2 = 0.0;
            }
            calc.operator = "\0";
        }
        if (s.equals("M+")){
            calc.mValue += Double.parseDouble(textField.getText());
            //THIS WAS FOR TESTING System.out.println();
        }
        if (s.equals("M-")){
            calc.mValue -= Double.parseDouble(textField.getText());
        }
        if (s.equals("MR")){
            textField.setText(calc.mValue.toString());
        }
        if (s.equals("MC")){
            calc.mValue = 0.0;
            textField.setText(String.valueOf(calc.mValue.intValue()));
        }
    }
}


