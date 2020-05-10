package tarefa9.empregado;

import java.util.ArrayList;

/**
 * @author dcancelas
 */
public class Vendedor extends Empregado {

    //Datos principais
    private String telMovil;
    private String area;
    private int porcentVendas;
    ArrayList<String> listaClientes;
    //Coche de empresa
    private String matricula;
    private String marca;
    private String modelo;

    public Vendedor() {
    }
    public Vendedor(String nome, String apelidos, String DNI, String direccion, int antiguedade, String telefono, float salario, String telMovil, String area, int porcentVendas) {
        super(nome, apelidos, DNI, direccion, antiguedade, telefono, salario);
        this.telMovil = telMovil;
        this.area = area;
        this.porcentVendas = porcentVendas;
    }

    @Override
    public String[] imprimir() {
        return new String[] {
                "INFORMACIÓN PERSOAL" +
                "\nNome: " + nome +
                "\nApelidos: " + apelidos +
                "\nDNI: " + DNI +
                "\nDirección: " + direccion,
                "DATOS PRINCIPAIS" +
                "\nPosto na empresa: Vendedor" +
                "\nAntigüidade: " + antiguedade + " anos" +
                "\nTeléfono: " + telefono +
                "\nTeléfono móvil: " + telMovil +
                "\nÁrea de venda: " + area +
                "\nPorcentaxe das vendas: " + porcentVendas + "%" +
                "\nSupervisor: " + supervisor.nome + " " + supervisor.apelidos +
                "\n\nSalario: " + salario + " €/mes",
                "COCHE DE EMPRESA" +
                "\nMatrícula: " + matricula +
                "\nMarca: " + marca +
                "\nModelo: " + modelo,
                "Lista de clientes: " + listaClientes
        };
    }

    @Override
    public String incrementarSalario() {
        salario = salarioBase + (((10 * salarioBase) / 100) * antiguedade);
        return "O salario foi incrementado con éxito";
    }

    public String altaCliente(String cliente) {
        listaClientes.add(cliente);
        return "O cliente foi dado de alta con éxito";
    }

    public String baixaCliente(String cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).equals(cliente)) {
                listaClientes.remove(i);
                return "O cliente foi dado de baixa con éxito";
            }
        }
        return "ERROR: O nome non aparece na base de datos";
    }

    public String cambiarCoche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        return "O coche foi cambiado con éxito";
    }
}
