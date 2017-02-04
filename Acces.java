import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Acces extends Application {
	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Beta Acces");

		BorderPane root = new BorderPane();
		root.setStyle("-fx-base : GRAY;");
		Scene scene = new Scene(root,395, 335, Color.BLACK);

		MenuBar bar = new MenuBar();
		bar.prefWidthProperty().bind(stage.widthProperty());
		root.setTop(bar);
		Menu menu = new Menu("Archivo");
		bar.getMenus().add(menu);
		MenuItem s = new MenuItem("Salir");
		menu.getItems().add(s);

		s.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		Menu ayuda = new Menu("Ayuda");
		bar.getMenus().add(ayuda);
		MenuItem manual = new MenuItem("Manual");
		ayuda.getItems().add(manual);

		ayuda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/0BzTC_LIXhClJUHE4MUFUUm52LU0/view?usp=drive_web"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				
			}
		});

		AnchorPane ap = new AnchorPane();

		ap.setPrefHeight(400);
		ap.setPrefWidth(330);
		ImageView poli = new ImageView(new Image("poli.jpg"));
		poli.setFitWidth(300);
		poli.setFitHeight(180);
		poli.setX(50);
		poli.setY(0);

		ImageView icpc = new ImageView(new Image("icpc-logo.png"));
		icpc.setFitWidth(207);
		icpc.setFitHeight(135);
		icpc.setX(95);
		icpc.setY(170);

		Button coachB = new Button();
		coachB.setLayoutX(95);
		coachB.setLayoutY(232);
		coachB.setPrefHeight(53);
		coachB.setPrefWidth(60);
		coachB.setStyle("-fx-background-color: transparent;");
		coachB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.setCenter(new AccesCoach(stage));
			}
		});
		Button generalB = new Button();
		generalB.setLayoutX(168);
		generalB.setLayoutY(200);
		generalB.setPrefHeight(83);
		generalB.setPrefWidth(60);
		generalB.setStyle("-fx-background-color: transparent;");
		generalB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.setCenter(new AccesGeneral(stage));
			}
		});
		Button marathonerB = new Button();
		ap.getChildren().add(marathonerB);
		marathonerB.setLayoutX(241);
		marathonerB.setLayoutY(170);
		marathonerB.setPrefHeight(113);
		marathonerB.setPrefWidth(61);
		marathonerB.setStyle("-fx-background-color: transparent;");
		marathonerB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.setCenter(new AccesMarathoner(stage));
			}
		});

		ap.getChildren().add(icpc);
		ap.getChildren().add(poli);
		ap.getChildren().add(coachB);
		ap.getChildren().add(generalB);

		
		root.setCenter(ap);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}