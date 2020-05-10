package tarefa9;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import tarefa9.empregado.Empregado;
import tarefa9.empregado.Vendedor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author dcancelas
 */
public class MainController implements Initializable {

    public TextArea infoPersoal;
    public TextArea datosPrincipais;
    public TextArea cocheEmpresa;
    public TextArea listaPersoas;
    public ComboBox<String> selectorEmpregados;
    static Stage stageCrearEmpregado = new Stage();

    final static List<Empregado> listaEmpregados = new ArrayList<>();
    static ObservableList<String> nomeEmpregados = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectorEmpregados.setItems(nomeEmpregados);
    }

    public void novoEmpregado(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CrearEmpregado.fxml"));
        stageCrearEmpregado.setTitle("Tarefa9");
        stageCrearEmpregado.setScene(new Scene(root, 400, 700));
        stageCrearEmpregado.setResizable(false);
        stageCrearEmpregado.show();
    }

    public Empregado buscarEmpregado() {
        for (Empregado listaEmpregado : listaEmpregados) {
            if (listaEmpregado.getNomeApelidos().equals(selectorEmpregados.getValue()))
                return listaEmpregado;
        }
        return null;
    }

    public void borrarEmpregado(ActionEvent actionEvent) {
        for (Empregado listaEmpregado : listaEmpregados) {
            System.out.println(listaEmpregado.getNomeApelidos());
        }
    }

    public void cargarInfo(ActionEvent actionEvent) {
        String[] imprimir = this.buscarEmpregado().imprimir();
        infoPersoal.setText(imprimir[0]);
        datosPrincipais.setText(imprimir[1]);
        cocheEmpresa.setText(imprimir[2]);
        listaPersoas.setText(imprimir[3]);
    }
}
