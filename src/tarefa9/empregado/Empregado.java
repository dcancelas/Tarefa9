package tarefa9.empregado;

/**
 * @author dcancelas
 */
public abstract class Empregado {

    //Información persoal
    protected String nome;
    protected String apelidos;
    protected String DNI;
    protected String direccion;
    //Datos principais
    protected int antiguedade;
    protected String telefono;
    protected float salario;
    protected float salarioBase;
    protected Empregado supervisor;

    public Empregado() {
    }
    public Empregado(String nome, String apelidos, String DNI, String direccion, int antiguedade, String telefono, float salario) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.antiguedade = antiguedade;
        this.telefono = telefono;
        this.salario = salario;
        this.salarioBase = salario;
    }

    public String[] imprimir() {
        return new String[] {
                "INFORMACIÓN PERSOAL" +
                "\nNome: " + nome +
                "\nApelidos: " + apelidos +
                "\nDNI: " + DNI +
                "\ndDirección: " + direccion,
                "DATOS PRINCIPAIS" +
                "\nAntigüidade: " + antiguedade + " anos" +
                "\nTeléfono: " + telefono +
                "\nSupervisor: " + supervisor.nome + " " + supervisor.apelidos +
                "\n\nSalario: " + salario + " €/mes"
        };
    }

    public String getNomeApelidos() {
        return nome + " " + apelidos;
    }

    public String cambiarSupervisor(Empregado supervisor) {
        this.supervisor = supervisor;
        return "O supervisor foi cambiado con éxito";
    }

    public abstract String incrementarSalario();
}
