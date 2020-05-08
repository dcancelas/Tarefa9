package tarefa9.empregado;

/**
 * @author dcancelas
 */
public class Secretario extends Empregado {

    //Datos principais
    private String despacho;
    private String numFax;

    public Secretario() {
    }
    public Secretario(String nome, String apelidos, String DNI, String direccion, int antiguedade, String telefono, float salario, String despacho, String numFax) {
        super(nome, apelidos, DNI, direccion, antiguedade, telefono, salario);
        this.despacho = despacho;
        this.numFax = numFax;
    }

    @Override
    public String[] imprimir() {
        return new String[] {
                "INFORMACIÓN PERSOAL" +
                "\nNome: " + nome +
                "\nApelidos: " + apelidos +
                "\nDNI: " + DNI +
                "\ndDirección: " + direccion,
                "DATOS PRINCIPAIS" +
                "\nPosto na empresa: Secretario" +
                "\nAntigüidade: " + antiguedade + " anos" +
                "\nTeléfono: " + telefono +
                "\nNúmero de fax: " + numFax +
                "\nDespacho: " + despacho +
                "\nSupervisor: " + supervisor +
                "\n\nSalario: " + salario + " €/mes"
        };
    }

    @Override
    public String incrementarSalario() {
        salario = salarioBase + (((5 * salarioBase) / 100) * antiguedade);
        return "O salario foi incrementado con éxito";
    }
}
