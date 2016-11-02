import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import Conection.DataHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddMarathoner extends Application {
	private static DataHandler bd;
	private static Text cedula, nombre, usuario, pass, confirPass;
	private static TextField cedulaTF, nombreTF, usuarioTF;
	private static PasswordField passPF, confirPassPF;
	private Button agregar;

	public AddMarathoner(DataHandler bd) {
		this.bd = bd;
	}

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane ap = new AnchorPane();
		Scene s = new Scene(ap, 400, 300, Color.GRAY);
		ap.setStyle("-fx-base : GRAY");

		cedula = new Text("Cedula");
		ap.getChildren().add(cedula);
		cedula.setLayoutX(54);
		cedula.setLayoutY(57);

		cedulaTF = new TextField();
		ap.getChildren().add(cedulaTF);
		cedulaTF.setLayoutX(139);
		cedulaTF.setLayoutY(40);
		cedulaTF.setPrefSize(188, 25);

		nombre = new Text("Nombre");
		ap.getChildren().add(nombre);
		nombre.setLayoutX(54);
		nombre.setLayoutY(92);

		nombreTF = new TextField();
		ap.getChildren().add(nombreTF);
		nombreTF.setLayoutX(139);
		nombreTF.setLayoutY(75);
		nombreTF.setPrefSize(188, 25);

		usuario = new Text("Usuario");
		ap.getChildren().add(usuario);
		usuario.setLayoutX(54);
		usuario.setLayoutY(127);

		usuarioTF = new TextField();
		ap.getChildren().add(usuarioTF);
		usuarioTF.setLayoutX(139);
		usuarioTF.setLayoutY(110);
		usuarioTF.setPrefSize(188, 25);

		pass = new Text("Contraseña");
		ap.getChildren().add(pass);
		pass.setLayoutX(54);
		pass.setLayoutY(162);

		passPF = new PasswordField();
		ap.getChildren().add(passPF);
		passPF.setLayoutX(139);
		passPF.setLayoutY(145);
		passPF.setPrefSize(188, 25);

		confirPass = new Text("Confirmar\nContraseña");
		ap.getChildren().add(confirPass);
		confirPass.setLayoutX(54);
		confirPass.setLayoutY(197);

		confirPassPF = new PasswordField();
		ap.getChildren().add(confirPassPF);
		confirPassPF.setLayoutX(139);
		confirPassPF.setLayoutY(185);
		confirPassPF.setPrefSize(188, 25);

		agregar = new Button("Agregar");
		ap.getChildren().add(agregar);
		agregar.setLayoutX(242);
		agregar.setLayoutY(239);
		agregar.setPrefSize(60, 25);
		agregar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String p = passPF.getText();
				String rp = confirPassPF.getText();
				if (p.equals(rp)) {
					String name = nombreTF.getText();
					String user = usuarioTF.getText();
					boolean add = Add(user, name, p);
					if (add) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Coach");
						alert.setHeaderText(null);
						alert.setContentText("Usuario creado!");
						alert.showAndWait();
						limpiar();
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Coach");
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

		stage.setResizable(false);
		stage.setScene(s);
		stage.show();
	}
	private void limpiar() {
		cedulaTF.clear();
		nombreTF.clear();
		usuarioTF.clear();
		passPF.clear();
		confirPassPF.clear();
	}
	public static boolean Add(String user, String name, String pass) {
		try {
			DataHandler sys = new DataHandler("System", "Poli123");
			sys.getDBConnection();
			sys.escribir("create user " + user + " identified by "+pass+"\n"
					+ "default tablespace users"+"\n"
					+"temporary tablespace temp" + "\n"
					+ "quota unlimited on users");
			sys.escribir("grant marathoner to " + user);
			sys.escribir("grant create session to " + user);

		} catch (SQLSyntaxErrorException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}

		return true;
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
