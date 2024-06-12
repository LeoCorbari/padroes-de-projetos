import java.io.FileWriter;
import java.io.IOException;

// Produto
interface Log {
    void log(String mensagem);
}

// Concrete Product para log em arquivo
class LogArquivo implements Log {
    public void log(String mensagem) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(mensagem + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Concrete Product para log no console
class LogConsole implements Log {
    public void log(String mensagem) {
        System.out.println(mensagem);
    }
}

// Creator
abstract class LogFactory {
    public abstract Log createLog();
}

// Concrete Creator para log em arquivo
class LogArquivoFactory extends LogFactory {
    public Log createLog() {
        return new LogArquivo();
    }
}

// Concrete Creator para log no console
class LogConsoleFactory extends LogFactory {
    public Log createLog() {
        return new LogConsole();
    }
}

// Cliente
public class Contador {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Contador <arquivo|console>");
            return;
        }

        LogFactory factory;
        if ("arquivo".equals(args[0])) {
            factory = new LogArquivoFactory();
        } else {
            factory = new LogConsoleFactory();
        }

        Log log = factory.createLog();

        for (int i = 1; i <= 10; i++) {
            log.log("Número: " + i);
        }
    }
}
