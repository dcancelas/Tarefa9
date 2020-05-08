package tarefa9;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import tarefa9.empregado.Empregado;
import tarefa9.empregado.Secretario;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public ComboBox<String> selectorEmpregados;

    ArrayList<Empregado> listaEmpregados = new ArrayList<>();
    ObservableList<String> nomeEmpregados = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectorEmpregados.setItems(nomeEmpregados);
        listaEmpregados.add(new Secretario("Antonio", "García", "346984RD", "Avenida mi pana", 6, "603057532", 2300, "5B", "843754156"));
        this.cargarEmpregados();
    }

    public void cargarEmpregados() {
        for (Empregado listaEmpregado : listaEmpregados) {
            nomeEmpregados.add(listaEmpregado.getNomeApelidos());
        }
    }

    public void novoEmpregado(ActionEvent event) throws IOException {
        Stage stageCrearEmpregado = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CrearEmpregado.fxml"));
        stageCrearEmpregado.setTitle("Tarefa9");
        stageCrearEmpregado.setScene(new Scene(root, 400, 580));
        stageCrearEmpregado.setResizable(false);
        stageCrearEmpregado.show();
    }
}
