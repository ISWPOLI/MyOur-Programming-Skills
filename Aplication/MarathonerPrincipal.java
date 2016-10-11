
import Conection.DataHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MarathonerPrincipal extends Application {
	
	public String user,pass;
	@Override
	public void start(Stage Stage) throws Exception {
		BorderPane root = new BorderPaneMarathoner(Stage,new DataHandler(user, pass));
		Scene s = new Scene(root,500,300,Color.GRAY);
		Stage.setTitle("Beta Marathoner");

		root.setCenter(new AnchorPaneMarathoner());

		Stage.setResizable(false);
		Stage.setScene(s);
		Stage.show();
	}
	public void set(String user,String pass){
		this.user=user;
		this.pass=pass;
	}
}
