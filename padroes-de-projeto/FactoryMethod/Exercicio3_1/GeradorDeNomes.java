import java.util.ArrayList;
import java.util.List;

// Produto
class Nome {
    private String nome;
    private String sobrenome;

    public Nome(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String toString() {
        return nome + " " + sobrenome;
    }
}

// Creator
abstract class NomeCreator {
    protected List<Nome> nomes = new ArrayList<>();

    public void addNome(String nomeCompleto) {
        Nome nome = createNome(nomeCompleto);
        nomes.add(nome);
    }

    public void imprimirNomes() {
        for (Nome nome : nomes) {
            System.out.println(nome);
        }
    }

    protected abstract Nome createNome(String nomeCompleto);
}

// Concrete Creator para "nome sobrenome"
class NomeSobrenomeCreator extends NomeCreator {
    protected Nome createNome(String nomeCompleto) {
        String[] partes = nomeCompleto.split(" ");
        return new Nome(partes[0], partes[1]);
    }
}

// Concrete Creator para "sobrenome, nome"
class SobrenomeNomeCreator extends NomeCreator {
    protected Nome createNome(String nomeCompleto) {
        String[] partes = nomeCompleto.split(", ");
        return new Nome(partes[1], partes[0]);
    }
}

// Cliente
public class GeradorDeNomes {
    public static void main(String[] args) {
        NomeCreator nomeSobrenomeCreator = new NomeSobrenomeCreator();
        NomeCreator sobrenomeNomeCreator = new SobrenomeNomeCreator();

        for (String arg : args) {
            if (arg.contains(",")) {
                sobrenomeNomeCreator.addNome(arg);
            } else {
                nomeSobrenomeCreator.addNome(arg);
            }
        }

        System.out.println("Nomes no formato 'nome sobrenome':");
        nomeSobrenomeCreator.imprimirNomes();

        System.out.println("\nNomes no formato 'sobrenome, nome':");
        sobrenomeNomeCreator.imprimirNomes();
    }
}
