import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Produto
interface ProvedoraDeInformacao {
    String obterInformacao() throws IOException;
}

// Concrete Product para informação pública
class InformacaoPublica implements ProvedoraDeInformacao {
    public String obterInformacao() throws IOException {
        return new String(Files.readAllBytes(Paths.get("publico.txt")));
    }
}

// Concrete Product para informação confidencial
class InformacaoConfidencial implements ProvedoraDeInformacao {
    public String obterInformacao() throws IOException {
        return new String(Files.readAllBytes(Paths.get("confidencial.txt")));
    }
}

// Creator
abstract class InformacaoFactory {
    public abstract ProvedoraDeInformacao createProvedora();
}

// Concrete Creator para informação pública
class InformacaoPublicaFactory extends InformacaoFactory {
    public ProvedoraDeInformacao createProvedora() {
        return new InformacaoPublica();
    }
}

// Concrete Creator para informação confidencial
class InformacaoConfidencialFactory extends InformacaoFactory {
    public ProvedoraDeInformacao createProvedora() {
        return new InformacaoConfidencial();
    }
}

// Cliente
public class SistemaDeInformacao {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java SistemaDeInformacao <senha>");
            return;
        }

        String senha = args[0];
        InformacaoFactory factory;

        if ("designpatterns".equals(senha)) {
            factory = new InformacaoConfidencialFactory();
        } else {
            factory = new InformacaoPublicaFactory();
        }

        ProvedoraDeInformacao provedora = factory.createProvedora();
        try {
            System.out.println(provedora.obterInformacao());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
