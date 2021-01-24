package controllerview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.ColorCalculator;
import model.ModularCounter;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorCalculatorC implements Initializable {

    @FXML
    private static Label lab_red;
    @FXML
    private static Label lab_green;
    @FXML
    private static Label lab_blue;
    @FXML
    private static Label lab_hex;
    @FXML
    private static TextField red;
    @FXML
    private static TextField green;
    @FXML
    private static TextField blue;
    @FXML
    private static Button btn_color;
    @FXML
    private static Button btn_pRed;
    @FXML
    private static Button btn_pGreen;
    @FXML
    private static Button btn_pBlue;
    @FXML
    private static Button btn_mRed;
    @FXML
    private static Button btn_mGreen;
    @FXML
    private static Button btn_mBlue;

    private ModularCounter red1 = new ModularCounter(0,255);
    private ModularCounter green1 = new ModularCounter(0,255);
    private ModularCounter blue1 = new ModularCounter(0,255);

    ColorCalculator cc = new ColorCalculator(red1,green1,blue1);

    public void colors_input(KeyEvent event)
    {
        TextField txt = (TextField)event.getSource();
        cc.changeColorViaAbsoluteValue(txt.getId(),txt.getText());

        cc.toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
