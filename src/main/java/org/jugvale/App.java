package org.jugvale;

import java.util.Optional;

import org.jugvale.service.InscritosService;
import org.jugvale.view.LoginDialog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class App extends Application {
		
		public static void main(String[] args) {
			launch();
		}

	@Override
	public void start(Stage stage) throws Exception {
		Optional<Pair<String, String>> credenciais = LoginDialog.createAndShow();
		credenciais.orElseThrow(() -> new Error("Preciso das credenciais!"));
		credenciais.get();
		InscritosService s = new InscritosService(credenciais.get().getKey(), credenciais.get().getValue());
		
		// TODO: pegar os inscritos, colocar em uma tabela e permitir filtro para marcar presença
		s.todosInscritos().forEach(System.out::println);;
		StackPane root = new StackPane();
		stage.setScene(new Scene(root, 800, 600));
		stage.setTitle("Marque sua presença no JUG!");
		stage.show();
	}

}
