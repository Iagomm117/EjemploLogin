package gui;

import ejemplologin.GestorDB;
import ejemplologin.USUARIO;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;




public class ControllerRegistro {
    GestorDB baseDeDatos;
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

    public void initialize(){
        baseDeDatos = new GestorDB("EjemploLogin");
    }
    @FXML
    public void handlebtnEnviar (MouseEvent e) throws SQLException{
        System.out.println("Empezando a insertar el usuario");
        boolean tipo;
        if(boxAdministrador.isSelected()){
            tipo = true;
        }
        else {
            tipo = false;
        }
        USUARIO crearUsuario = new USUARIO(campoNombre.getText(),campoApellido.getText(),campoEmail.getText(),campoPassword.getText(),tipo);
        System.out.println(baseDeDatos.guardarUsuario(crearUsuario));
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
