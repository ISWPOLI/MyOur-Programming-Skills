
import java.sql.SQLException;

import Conection.DataHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccesMarathoner extends AnchorPane {
	public AccesMarathoner(Stage stage) {

		stage.setTitle("Beta Marathoner");

		ImageView c = new ImageView(new Image("Marathoner.png"));
		this.getChildren().add(c);
		c.setFitWidth(150);
		c.setFitHeight(150);
		c.setX(122);
		c.setY(25);

		Text user = new Text("Usuario");
		this.getChildren().add(user);
		user.setLayoutX(95);
		user.setLayoutY(223);

		TextField userText = new TextField("Usuario");
		this.getChildren().add(userText);
		userText.setLayoutX(173);
		userText.setLayoutY(206);

		Text pass = new Text("Contrase�a");
		this.getChildren().add(pass);
		pass.setLayoutX(95);
		pass.setLayoutY(252);

		PasswordField Password = new PasswordField();
		this.getChildren().add(Password);
		Password.setLayoutX(173);
		Password.setLayoutY(235);

		Button entrar = new Button("Entrar");
		this.getChildren().add(entrar);
		entrar.setLayoutX(173);
		entrar.setLayoutY(280);
		entrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String u = userText.getText();
				String p = Password.getText();
				try {
					DataHandler ok = new DataHandler(u, p);
					ok.getDBConnection();
					if (ok.connect()) {
						stage.close();
						try {
							MarathonerPrincipal a = new MarathonerPrincipal();
							a.set(u, p);
							a.start(new Stage());
						} catch (Exception e) {
						}
					}
				} catch (SQLException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Login");
					alert.setHeaderText(null);
					alert.setContentText("Usuario / Contrase�a   Incorrecta");
					alert.showAndWait();
				}
			}
		});

		Button volver = new Button("Atr�s");
		this.getChildren().add(volver);
		volver.setLayoutX(275);
		volver.setLayoutY(280);
		volver.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.close();
				try {
					new Acces().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
