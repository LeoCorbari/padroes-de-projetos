// Classes de Contato
class ContatoInternet {
    private String nome;
    private String email;

    public ContatoInternet(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String toString() {
        return "ContatoInternet { Nome: " + nome + ", Email: " + email + " }";
    }
}

class ContatoTelefone {
    private String nome;
    private String telefone;

    public ContatoTelefone(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String toString() {
        return "ContatoTelefone { Nome: " + nome + ", Telefone: " + telefone + " }";
    }
}

class ContatoCompleto {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public ContatoCompleto(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String toString() {
        return "ContatoCompleto { Nome: " + nome + ", Endereço: " + endereco + ", Telefone: " + telefone + ", Email: "
                + email + " }";
    }
}

// Interface Builder
interface ContatoBuilder {
    void buildNome(String nome);

    void buildEndereco(String endereco);

    void buildTelefone(String telefone);

    void buildEmail(String email);

    Object getContato();
}

// Concrete Builders
class ContatoInternetBuilder implements ContatoBuilder {
    private String nome;
    private String email;

    public void buildNome(String nome) {
        this.nome = nome;
    }

    public void buildEndereco(String endereco) {
        // Não utilizado
    }

    public void buildTelefone(String telefone) {
        // Não utilizado
    }

    public void buildEmail(String email) {
        this.email = email;
    }

    public ContatoInternet getContato() {
        return new ContatoInternet(nome, email);
    }
}

class ContatoTelefoneBuilder implements ContatoBuilder {
    private String nome;
    private String telefone;

    public void buildNome(String nome) {
        this.nome = nome;
    }

    public void buildEndereco(String endereco) {
        // Não utilizado
    }

    public void buildTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void buildEmail(String email) {
        // Não utilizado
    }

    public ContatoTelefone getContato() {
        return new ContatoTelefone(nome, telefone);
    }
}

class ContatoCompletoBuilder implements ContatoBuilder {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public void buildNome(String nome) {
        this.nome = nome;
    }

    public void buildEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void buildTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void buildEmail(String email) {
        this.email = email;
    }

    public ContatoCompleto getContato() {
        return new ContatoCompleto(nome, endereco, telefone, email);
    }
}

// Director
class ContatoDirector {
    private ContatoBuilder builder;

    public ContatoDirector(ContatoBuilder builder) {
        this.builder = builder;
    }

    public void construirContato(String nome, String endereco, String telefone, String email) {
        builder.buildNome(nome);
        builder.buildEndereco(endereco);
        builder.buildTelefone(telefone);
        builder.buildEmail(email);
    }

    public Object getContato() {
        return builder.getContato();
    }
}

// Cliente
public class ClienteContato {
    public static void main(String[] args) {
        ContatoInternetBuilder internetBuilder = new ContatoInternetBuilder();
        ContatoTelefoneBuilder telefoneBuilder = new ContatoTelefoneBuilder();
        ContatoCompletoBuilder completoBuilder = new ContatoCompletoBuilder();

        ContatoDirector director = new ContatoDirector(internetBuilder);
        director.construirContato("John Doe", "", "", "john@example.com");
        System.out.println(director.getContato());

        director = new ContatoDirector(telefoneBuilder);
        director.construirContato("Jane Doe", "", "123-456-7890", "");
        System.out.println(director.getContato());

        director = new ContatoDirector(completoBuilder);
        director.construirContato("Jim Doe", "123 Elm St", "987-654-3210", "jim@example.com");
        System.out.println(director.getContato());
    }
}
