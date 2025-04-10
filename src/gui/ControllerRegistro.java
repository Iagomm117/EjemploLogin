package gui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




public class ControllerRegistro {

@FXML private CheckBox boxAdministrador;    
@FXML private TextField campoEmail;
@FXML private TextField campoNombre;
@FXML private TextField campoApellido;
@FXML private PasswordField campoPassword;
@FXML private Button btnVolver;
@FXML private Button btnEnviar;
@FXML private Label etiquetaTitulo;
@FXML private Label etiquetaNombre;
@FXML private Label etiquetaApellido;
@FXML private Label etiquetaEmail;
@FXML private Label etiquetaPassword;


    @FXML
    public void handlebtnEnviar (MouseEvent e){
        
    }
    
    @FXML
    public void handlebtnVolver (MouseEvent e) throws IOException{
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}
