package homework_4.homework_4_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    public TextArea textArea;
    public Button equally;
    private boolean newCalculation;
    private final Calculator calculator = new Calculator();

    public void onClickNumber(ActionEvent actionEvent) {
        if (newCalculation) {
            textArea.clear();
            calculator.clean();
            newCalculation = false;
        }
        textArea.setText(textArea.getText() + ((Button) actionEvent.getSource()).getText());
        calculator.addNumber(((Button) actionEvent.getSource()).getText());
    }

    public void onClickOperation(ActionEvent actionEvent) {
        textArea.setText(textArea.getText() + ((Button) actionEvent.getSource()).getText());
        calculator.addOperation(((Button) actionEvent.getSource()).getText());
    }

    public void onClickEqually(ActionEvent actionEvent) {
        textArea.setText(textArea.getText() + ((Button) actionEvent.getSource()).getText());
        newCalculation = true;
        calculator.check();
        switch (calculator.getOperation()) {
            case "+":
                calculator.addition();
                break;
            case "-":
                calculator.subtraction();
                break;
            case "*":
                calculator.multiplication();
                break;
            case "/":
                calculator.division();
                break;
        }
        textArea.setText(textArea.getText() + (calculator.getResult()));
    }

}
