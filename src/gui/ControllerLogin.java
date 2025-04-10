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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerLogin {
    GestorDB baseDeDatos;
    @FXML private Button btnLogin;
    @FXML private Button btnRegistro;
    @FXML private ImageView imagenUsuario;
    @FXML private Label etiquetaEmail;
    @FXML private Label etiquetaPassword;
    @FXML private Label etiquetaTitulo;
    @FXML private TextField campoEmail;
    @FXML private PasswordField campoPassword;
    
    public void initialize(){
        baseDeDatos = new GestorDB("EjemploLogin");
    }
    
    @FXML
    public void handlebtnLogin (MouseEvent e) throws SQLException{
        System.out.println(campoEmail.getText());
        System.out.println(campoPassword.getText());
        USUARIO miUsuario = baseDeDatos.buscarUsuario(campoEmail.getText(), "email");
        if(miUsuario == null){
            System.out.println("El usuario no se encuentra en la base de datos");
        }
        else if (!miUsuario.getPassword().equals(campoPassword.getText())){
            System.out.println("La contraseña no es correcta");
        }
        else{
            System.out.println("Login realizado con exito");
        }
    }
    
    @FXML
    public void handlebtnRegistro (MouseEvent e) throws IOException{
        Stage stage = (Stage) btnRegistro.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("registro.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Registro de usuario");
        stage.setScene(scene);
        stage.show();
    }
}
