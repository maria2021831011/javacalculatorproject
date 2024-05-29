import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tttt {
    private JPanel calculator;
    private JTextField txtDisplay;
    private JButton a0Button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton ACButton;
    private JButton button6;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton button11;
    private JButton x2Button;
    private JButton a7Button;
    private JButton a4Button;
    private JButton button15;
    private JButton button10;
    private JButton a1XButton;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a1Button;
    public tttt() {
        ACButton.addActionListener(e -> txtDisplay.setText(""));
        a7Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a7Button.getText()));
        a8Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a8Button.getText()));
        a9Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a9Button.getText()));
        a4Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a4Button.getText()));
        a5Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a5Button.getText()));
        a6Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a6Button.getText()));
        a1Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a1Button.getText()));
        a2Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a2Button.getText()));
        a3Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a3Button.getText()));
        a0Button.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + a0Button.getText()));
        button10.addActionListener(e -> txtDisplay.setText(txtDisplay.getText() + "."));


        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String backspace = null;
                if (txtDisplay.getText().length() > 0) {
                    StringBuilder strB = new StringBuilder(txtDisplay.getText());
                    strB.deleteCharAt(txtDisplay.getText().length() - 1);
                    backspace = String.valueOf(strB);
                    txtDisplay.setText(backspace);
                }
            }
        });


        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtDisplay.getText();
                double result = 0.0;
                double a = 0.0;
                double b = 0.0;
                String op = "";

                // Iterate over the input string to extract operands and operator
                String numBuffer = "";
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (Character.isDigit(c) || c == '.') {
                        numBuffer += c;
                    } else {
                        if (!numBuffer.isEmpty()) {
                            if (a == 0) {
                                a = Double.parseDouble(numBuffer);
                            } else {
                                b = Double.parseDouble(numBuffer);
                            }
                            numBuffer = "";
                        }
                        if (c == '+' || c == '-' || c == '*' || c == '/') {
                            op = String.valueOf(c);
                        }
                    }
                }
                if (!numBuffer.isEmpty()) {
                    b = Double.parseDouble(numBuffer);
                }

                // Perform the arithmetic operation
                switch (op) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b != 0) {
                            result = a / b;
                        } else {
                            txtDisplay.setText("Error: Division by zero");
                            return;
                        }
                        break;
                    default:
                        txtDisplay.setText("Invalid input");
                        return;
                }
                txtDisplay.setText(String.valueOf(result));
            }
        });
        x2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtDisplay.getText();
                if (!input.isEmpty()) {
                    double num = Double.parseDouble(input);
                    double result = num * num;
                    txtDisplay.setText(String.valueOf(result));
                }
            }
        });
        a1XButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtDisplay.getText();
                if (!input.isEmpty()) {
                    double num = Double.parseDouble(input);
                    if (num != 0) {
                        double result = 1 / num;
                        txtDisplay.setText(String.valueOf(result));
                    } else {
                        txtDisplay.setText("Error: Division by zero");
                    }
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "+");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "-");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "*");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + "/");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("tttt");
        frame.setContentPane(new tttt().calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    }
