package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * big boy parent class
 */
public class Calculator {
    private JPanel mainPanel;
    private JTextField textField;
    private JButton fourBtn;
    private JButton sevenBtn;
    private JButton mClearBtn;
    private JButton mRecallBtn;
    private JButton squareBtn;
    private JButton clearBtn;
    private JButton oneBtn;
    private JButton zeroBtn;
    private JButton mAddBtn;
    private JButton powerBtn;
    private JButton logBtn;
    private JButton signBtn;
    private JButton percentageBtn;
    private JButton eightBtn;
    private JButton nineBtn;
    private JButton fiveBtn;
    private JButton sixBtn;
    private JButton threeBtn;
    private JButton twoBtn;
    private JButton digitBtn;
    private JButton mSubBtn;
    private JButton sqrBtn;
    private JButton divideBtn;
    private JButton mulBtn;
    private JButton minusBtn;
    private JButton addBtn;
    private JButton equalBtn;
    /**
     * operand 1, used by everything and described more in BtnHandler.java/operation()
     */
    public Double operand1;
    /**
     * operand 2, used by everything and described more in BtnHandler.java/operation()
     */
    public Double operand2;
    /**
     * mValue used to store memory value for memory functions
     */
    public Double mValue = 0.0;
    /**
     * default operator for operations() switch case
     */
    public String operator = "\0";

    /**
     * initializes class variables to default values and creates all 27 instances of listeners
     */
    public Calculator() {
    textField.setText("0");
    operand1 = 0.0;
    operand2 = 0.0;
    oneBtn.addActionListener(new NumBtnHandler(this));
    twoBtn.addActionListener(new NumBtnHandler(this));
    threeBtn.addActionListener(new NumBtnHandler(this));
    fourBtn.addActionListener(new NumBtnHandler(this));
    fiveBtn.addActionListener(new NumBtnHandler(this));
    sixBtn.addActionListener(new NumBtnHandler(this));
    sevenBtn.addActionListener(new NumBtnHandler(this));
    eightBtn.addActionListener(new NumBtnHandler(this));
    nineBtn.addActionListener(new NumBtnHandler(this));
    zeroBtn.addActionListener(new NumBtnHandler(this));

    clearBtn.addActionListener(new OpBtnHandler(this));
    equalBtn.addActionListener(new OpBtnHandler(this));
    signBtn.addActionListener(new OpBtnHandler(this));
    percentageBtn.addActionListener(new OpBtnHandler(this));
    sqrBtn.addActionListener(new OpBtnHandler(this));
    logBtn.addActionListener(new OpBtnHandler(this));
    squareBtn.addActionListener(new OpBtnHandler(this));
    addBtn.addActionListener(new OpBtnHandler(this));
    minusBtn.addActionListener(new OpBtnHandler(this));
    mulBtn.addActionListener(new OpBtnHandler(this));
    divideBtn.addActionListener(new OpBtnHandler(this));
    digitBtn.addActionListener(new NumBtnHandler(this));
    powerBtn.addActionListener(new OpBtnHandler(this));
    mAddBtn.addActionListener(new OpBtnHandler(this));
    mSubBtn.addActionListener(new OpBtnHandler(this));
    mRecallBtn.addActionListener(new OpBtnHandler(this));
    mClearBtn.addActionListener(new OpBtnHandler(this));
    }

    /**
     * retriever method used in BtnHandler
     * @return
     */
    protected JTextField getTextField() {
        return textField;
    }
    /**
     * setter method used in BtnHandler
     *
     */
    protected void setTextField(String t) {
         textField.setText(t);
    }

    /**
     * initializes calculator class, frame and displays
     * @param args main args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        Calculator calculator = new Calculator();

        frame.setContentPane(new Calculator().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * test func from instructing staff
     * @param button for SampleTest.java
     */
    public void test( String button){
        switch (button){
            case "0": zeroBtn.doClick();break;
            case "1": oneBtn.doClick();break;
            case "2": twoBtn.doClick();break;
            case "3": threeBtn.doClick();break;
            case "4": fourBtn.doClick();break;
            case "5": fiveBtn.doClick();break;
            case "6": sixBtn.doClick();break;
            case "7": sevenBtn.doClick();break;
            case "8": eightBtn.doClick();break;
            case "9": nineBtn.doClick();break;
            case "%": percentageBtn.doClick();break;
            case "-/+": signBtn.doClick();break;
            case "AC": clearBtn.doClick();break;
            case "*2": squareBtn.doClick();break;
            case "sqr": sqrBtn.doClick();break;
            case "log": logBtn.doClick();break;
            case ".": digitBtn.doClick();break;
            case "+": addBtn.doClick();break;
            case "-": minusBtn.doClick();break;
            case "*": mulBtn.doClick();break;
            case "/": divideBtn.doClick();break;
            case "**": powerBtn.doClick();break;
            case "M+": mAddBtn.doClick();break;
            case "M-": mSubBtn.doClick();break;
            case "MR": mRecallBtn.doClick();break;
            case "MC": mClearBtn.doClick();break;
            case "=": equalBtn.doClick();break;
            case "txt": System.out.println("The result is: " +
                    textField.getText());break;
            default:System.out.println("invalid input");break;
        }
    }
}
