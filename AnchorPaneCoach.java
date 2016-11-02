
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AnchorPaneCoach extends AnchorPane {
	public AnchorPaneCoach() {
		Text nombre = new Text("Nombre :");
		this.getChildren().add(nombre);
		nombre.setLayoutX(63);
		nombre.setLayoutY(93);

		Text usuario = new Text("Usuario :");
		this.getChildren().add(usuario);
		usuario.setLayoutX(63);
		usuario.setLayoutY(135);

		ImageView foto = new ImageView(new Image("CoachDes.png"));
		this.getChildren().add(foto);
		foto.setFitWidth(172);
		foto.setFitHeight(150);
		foto.setLayoutX(293);
		foto.setLayoutY(47);

		TableView<String> tabla1 = new TableView<>();
		this.getChildren().add(tabla1);
		tabla1.setPrefSize(215, 150);
		tabla1.setLayoutX(35);
		tabla1.setLayoutY(219);
		tabla1.setEditable(false);
		TableColumn use = new TableColumn("Usuario");
		use.setMinWidth(107);
		TableColumn name = new TableColumn("Nombre");
		name.setMinWidth(108);
		tabla1.getColumns().addAll(use,name);

		// CARGAR DATOS DE LA BASE DE DATOS
		
		TableView<String> tabla2 = new TableView<>();
		this.getChildren().add(tabla2);
		tabla2.setPrefSize(163, 150);
		tabla2.setLayoutX(279);
		tabla2.setLayoutY(219);
		tabla2.setEditable(false);
		TableColumn nombreEquipo = new TableColumn("Nombre Equipo");
		nombreEquipo.setMinWidth(163);
		tabla2.getColumns().add(nombreEquipo);

		// CARGAR DATOS DE LA BASE DE DATOS

	}
}