
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

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
	private static DataHandler bd;
	private static Text nombre, usuario, pass, repass;
	private static TextField nombreTF, usuarioTF;
	private static PasswordField passTF, repassTF;
	private static Button add;

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
				if (p.equals(rp)) {
					String name = nombreTF.getText();
					String user = usuarioTF.getText();
					boolean add = Add(user, name, p);
					if (add) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Administrador");
						alert.setHeaderText(null);
						alert.setContentText("Usuario creado!");
						alert.showAndWait();
						limpiar();
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Administrador");
						alert.setHeaderText(null);
						alert.setContentText(
								"No se pudo crear el usuario\n o ya hay un usuario con ese nombre\n intentelo de nuevo");
						alert.showAndWait();
					}
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Password");
					alert.setHeaderText(null);
					alert.setContentText("Las contraseñas no son iguales");
					alert.showAndWait();
				}
			}

		});

	}

	public static boolean Add(String user, String name, String pass) {
		try {
			DataHandler sys = new DataHandler("System", "Poli123");
			sys.getDBConnection();
			sys.escribir("create user " + user + " identified by "+pass+ "\ndefault tablespace users"
					+ "\ntemporary tablespace temp" + "\nquota unlimited on users");
			sys.escribir("grant coach to " + user);
			sys.escribir("grant create session to " + user);
		} catch (SQLSyntaxErrorException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	private static void limpiar() {
		nombreTF.clear();
		usuarioTF.clear();
		passTF.clear();
		repassTF.clear();
	}

	public static boolean Delete(String user) {
		try {
			DataHandler sys = new DataHandler("System", "Poli123");
			sys.getDBConnection();
			sys.escribir("drop user " + user);
		} catch (SQLException e) {
			return false;
		}

		return true;
	}
}
