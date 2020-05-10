package tarefa9;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import tarefa9.empregado.Secretario;
import tarefa9.empregado.Vendedor;
import tarefa9.empregado.XefeZona;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author dcancelas
 */
public class CrearEmpregado implements Initializable {

    public TextField nomeField;
    public TextField apelidosField;
    public TextField DNIField;
    public TextField direccionField;
    public ComboBox<String> postoComboBox;
    public TextField antigField;
    public TextField telfField;
    public TextField movilField;
    public TextField faxField;
    public TextField despachoField;
    public TextField areaField;
    public TextField porcentField;
    public TextField salarioField;
    public HBox movilBox;
    public HBox faxBox;
    public HBox despachoBox;
    public HBox areaBox;
    public HBox porcentBox;
    public Button crearButton;

    ObservableList<String> postosEmpresa = FXCollections.observableArrayList("Secretario", "Vendedor", "Xefe de zona");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        postoComboBox.setItems(postosEmpresa);
        postoComboBox.setValue("Selecciona un posto");
        movilBox.setDisable(true);
        faxBox.setDisable(true);
        despachoBox.setDisable(true);
        areaBox.setDisable(true);
        porcentBox.setDisable(true);
    }

    public void cambiarPosto(ActionEvent actionEvent) {
        if (postoComboBox.getValue().equals("Secretario")) {
            movilBox.setDisable(true);
            faxBox.setDisable(false);
            despachoBox.setDisable(false);
            areaBox.setDisable(true);
            porcentBox.setDisable(true);
        }
        if (postoComboBox.getValue().equals("Vendedor")) {
            movilBox.setDisable(false);
            faxBox.setDisable(true);
            despachoBox.setDisable(true);
            areaBox.setDisable(false);
            porcentBox.setDisable(false);
        }
        if (postoComboBox.getValue().equals("Xefe de zona")) {
            movilBox.setDisable(true);
            faxBox.setDisable(true);
            despachoBox.setDisable(false);
            areaBox.setDisable(true);
            porcentBox.setDisable(true);
        }
    }

    public void crearEmpregado(ActionEvent actionEvent) {
        if (postoComboBox.getValue().equals("Secretario")) {
            //Secretario secretario = new Secretario(nomeField.getText(), apelidosField.getText(), DNIField.getText(), direccionField.getText(), Integer.parseInt(antigField.getText()), telfField.getText(), Float.parseFloat(salarioField.getText()), despachoField.getText(), faxField.getText());
            Secretario secretario = new Secretario("Juan", "Pérez", "700698F", "Avenida de exemplo", 6, "7657755", 2300, "B1", "574647457");
            MainController.listaEmpregados.add(secretario);
            MainController.nomeEmpregados.add(secretario.getNomeApelidos());
            MainController.stageCrearEmpregado.close();
        }
        if (postoComboBox.getValue().equals("Vendedor")) {
            //Vendedor vendedor = new Vendedor(nomeField.getText(), apelidosField.getText(), DNIField.getText(), direccionField.getText(), Integer.parseInt(antigField.getText()), telfField.getText(), Float.parseFloat(salarioField.getText()), movilField.getText(), areaField.getText(), Integer.parseInt(porcentField.getText()));
            Vendedor vendedor = new Vendedor("María", "Rodriguez", "767575A", "Avenida de exemplo", 6, "603057532", 2300, "864245173", "Área de exemplo", 20);
            MainController.listaEmpregados.add(vendedor);
            MainController.nomeEmpregados.add(vendedor.getNomeApelidos());
            MainController.stageCrearEmpregado.close();
        }
        if (postoComboBox.getValue().equals("Xefe de zona")) {
            //XefeZona xefeZona = new XefeZona(nomeField.getText(), apelidosField.getText(), DNIField.getText(), direccionField.getText(), Integer.parseInt(antigField.getText()), telfField.getText(), Float.parseFloat(salarioField.getText()), despachoField.getText());
            XefeZona xefeZona = new XefeZona("Antonio", "García", "346984RD", "Avenida de exemplo", 6, "603057532", 2300, "A2");
            MainController.listaEmpregados.add(xefeZona);
            MainController.nomeEmpregados.add(xefeZona.getNomeApelidos());
            MainController.stageCrearEmpregado.close();
        }
        if (postoComboBox.getValue().equals("Selecciona un posto"))
            JOptionPane.showMessageDialog(null, "Tes que seleccionar un posto de traballo!", "Tarefa9", JOptionPane.ERROR_MESSAGE);
    }
}