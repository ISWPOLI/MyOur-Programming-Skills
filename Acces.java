import java.awt.Desktop;
import java.io.File;
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

		MenuBar m = new MenuBar();
		m.prefWidthProperty().bind(stage.widthProperty());
		root.setTop(m);
		Menu menu = new Menu("Archivo");
		m.getMenus().add(menu);
		MenuItem s = new MenuItem("Salir");
		menu.getItems().add(s);

		s.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		Menu ayuda = new Menu("Ayuda");
		m.getMenus().add(ayuda);
		MenuItem manual = new MenuItem("Manual");
		ayuda.getItems().add(manual);

		ayuda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					//en google drive dropbox no se hacen 
					Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/0BzTC_LIXhClJZkJ4VDV4U2MtV00"));
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

		Button coach = new Button();
		coach.setLayoutX(95);
		coach.setLayoutY(232);
		coach.setPrefHeight(53);
		coach.setPrefWidth(60);
		coach.setStyle("-fx-background-color: transparent;");
//		coach.setBorder();
		coach.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.setCenter(new AccesCoach(stage));
			}
		});
		Button general = new Button();
		general.setLayoutX(168);
		general.setLayoutY(200);
		general.setPrefHeight(83);
		general.setPrefWidth(60);
		general.setStyle("-fx-background-color: transparent;");
		general.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.setCenter(new AccesGeneral(stage));
			}
		});
		Button marathoner = new Button();
		ap.getChildren().add(marathoner);
		marathoner.setLayoutX(241);
		marathoner.setLayoutY(170);
		marathoner.setPrefHeight(113);
		marathoner.setPrefWidth(61);
		marathoner.setStyle("-fx-background-color: transparent;");
		marathoner.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.setCenter(new AccesMarathoner(stage));
			}
		});

		ap.getChildren().add(icpc);
		ap.getChildren().add(poli);
		ap.getChildren().add(coach);
		ap.getChildren().add(general);

		
		root.setCenter(ap);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}