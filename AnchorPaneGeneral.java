
import Conection.DataHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AnchorPaneGeneral extends AnchorPane {
	private DataHandler bd;
	private Text nombre,usuario,pass,repass;
	private TextField nombreTF,usuarioTF;
	private PasswordField passTF,repassTF;
	private Button add;
	public AnchorPaneGeneral(DataHandler bd) {

		this.bd = bd;

		nombre = new Text("Nombre : ");
		this.getChildren().add(nombre);
		nombre.setLayoutX(70);
		nombre.setLayoutY(61);
		
		nombreTF = new TextField();
		this.getChildren().add(nombreTF);
		nombreTF.setPrefWidth(189);
		nombreTF.setPrefHeight(25);
		nombreTF.setLayoutX(141);
		nombreTF.setLayoutY(44);
		
		usuario = new Text("Usuario : ");
		this.getChildren().add(usuario);
		usuario.setLayoutX(70);
		usuario.setLayoutY(111);
		
		usuarioTF = new TextField();
		this.getChildren().add(usuarioTF);
		usuarioTF.setPrefWidth(189);
		usuarioTF.setPrefHeight(25);
		usuarioTF.setLayoutX(141);
		usuarioTF.setLayoutY(94);
		
		pass = new Text("Contraseña : ");
		this.getChildren().add(pass);
		pass.setLayoutX(70);
		pass.setLayoutY(161);
		
		passTF = new PasswordField();
		this.getChildren().add(passTF);
		passTF.setPrefWidth(189);
		passTF.setPrefHeight(25);
		passTF.setLayoutX(141);
		passTF.setLayoutY(144);

		repass = new Text("Confirmar \nContraseña : ");
		this.getChildren().add(repass);
		repass.setLayoutX(70);
		repass.setLayoutY(200);
		
		repassTF = new PasswordField();
		this.getChildren().add(repassTF);
		repassTF.setPrefWidth(189);
		repassTF.setPrefHeight(25);
		repassTF.setLayoutX(141);
		repassTF.setLayoutY(196);

		add = new Button("Agregar");
		this.getChildren().add(add);
		add.setPrefWidth(87);
		add.setPrefHeight(25);
		add.setLayoutX(166);
		add.setLayoutY(249);
		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String p = passTF.getText();
				String rp = repassTF.getText();
				if(p.equals(rp)){
					String name = nombreTF.getText();
					String user = usuarioTF.getText();

					// agregar el usuario a la base de datos

				}else{
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Password");
					alert.setHeaderText(null);
					alert.setContentText("Las contraseñas no son iguales");
					alert.showAndWait();
				}
			}

		});

	}
}
