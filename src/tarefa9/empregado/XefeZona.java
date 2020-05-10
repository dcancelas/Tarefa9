package tarefa9.empregado;

import java.util.ArrayList;

/**
 * @author dcancelas
 */
public class XefeZona extends Empregado {

    //Datos principais
    private String despacho;
    private Secretario secretario;
    ArrayList<Vendedor> listaVendedores;
    //Coche de empresa
    private String matricula;
    private String marca;
    private String modelo;

    public XefeZona() {
    }
    public XefeZona(String nome, String apelidos, String DNI, String direccion, int antiguedade, String telefono, float salario, String despacho) {
        super(nome, apelidos, DNI, direccion, antiguedade, telefono, salario);
        this.despacho = despacho;
        this.secretario = new Secretario();
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
                "\nPosto na empresa: Xefe de zona" +
                "\nAntigüidade: " + antiguedade + " anos" +
                "\nTeléfono: " + telefono +
                "\nDespacho: " + despacho +
                "\nSecretario: " + secretario.nome + " " + secretario.apelidos +
                "\n\nSalario: " + salario + " €/mes",
                "COCHE DE EMPRESA" +
                "\nMatrícula: " + matricula +
                "\nMarca: " + marca +
                "\nModelo: " + modelo,
                "Lista de vendedores: " + listaVendedores
        };
    }

    @Override
    public String incrementarSalario() {
        salario = salarioBase + (((20 * salarioBase) / 100) * antiguedade);
        return "O salario foi incrementado con éxito";
    }

    public String cambiarSecretario(Secretario secretario) {
        this.secretario = secretario;
        return "O secretario foi cambiado con éxito";
    }

    public String cambiarCoche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        return "O coche foi cambiado con éxito";
    }

    public String altaVendedor(Vendedor vendedor) {
        listaVendedores.add(vendedor);
        return "O cliente foi dado de alta con éxito";
    }

    public String baixaVendedor(Vendedor vendedor) {
        for (int i = 0; i < listaVendedores.size(); i++) {
            if (listaVendedores.get(i) == vendedor) {
                listaVendedores.remove(i);
                return "O cliente foi dado de baixa con éxito";
            }
        }
        return "ERROR: O nome non aparece na base de datos";
    }
}
