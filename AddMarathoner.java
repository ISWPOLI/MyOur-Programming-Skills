import Conection.DataHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddMarathoner extends Application {
	private static DataHandler bd;
	private Text cedula, nombre, usuario, pass, confirPass;
	private TextField cedulaTF, nombreTF, usuarioTF;
	private PasswordField passPF, confirPassPF;
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
				// agregar usuario a la base de datos con bd
			}
		});

		stage.setResizable(false);
		stage.setScene(s);
		stage.show();
	}
}
