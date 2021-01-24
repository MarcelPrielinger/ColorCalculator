package controllerview;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import model.ColorCalculator;
import model.ModularCounter;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorCalculatorC implements Initializable {

    @FXML
    private Label lab_hex;
    @FXML
    private Button btn_color;
    @FXML
    private TextField red;
    @FXML
    private TextField green;
    @FXML
    private TextField blue;


    private ColorCalculator calc = new ColorCalculator();

    /*private ModularCounter red = new ModularCounter(0,255);
    private ModularCounter green = new ModularCounter(0,255);
    private ModularCounter blue = new ModularCounter(0,255);

    ColorCalculator cc = new ColorCalculator(red,green,blue);*/

    @FXML
    private void colors_input(KeyEvent event)
    {
        try {
            TextField txt = (TextField) event.getSource();
            calc.changeColorViaAbsoluteValue(txt.getId(), txt.getText());
            String hexcode = calc.getHex();
            btn_color.setStyle("-fx-background-color: " + hexcode + ";");
            lab_hex.setText(hexcode);
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }

    @FXML
    private void btn_relativeChangeP(Event event)
    {
        Button btn = (Button)event.getSource();
        calc.changeColorViaRelativeValue(btn.getId(),10,"+");
        String hexcode = calc.getHex();
        update_numbers();
        btn_color.setStyle("-fx-background-color: " + hexcode + ";");
        lab_hex.setText(hexcode);
    }

    @FXML
    public void btn_relativeChangeM(Event event)
    {
        Button btn = (Button)event.getSource();
        calc.changeColorViaRelativeValue(btn.getId(),10,"-");
        String hexcode = calc.getHex();
        update_numbers();
        btn_color.setStyle("-fx-background-color: " + hexcode + ";");
        lab_hex.setText(hexcode);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void update_numbers()
    {
        red.setText(String.valueOf(calc.getRed().getValue()));
        green.setText(String.valueOf(calc.getGreen().getValue()));
        blue.setText(String.valueOf(calc.getBlue().getValue()));
    }

}
