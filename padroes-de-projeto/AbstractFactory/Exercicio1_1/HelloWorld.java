import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

// Interface para o Produto
interface HelloWorldPrinter {
    void print();
}

// Implementação de Produto para impressão na tela
class ScreenPrinter implements HelloWorldPrinter {
    public void print() {
        System.out.println("Hello, World!");
    }
}

// Implementação de Produto para impressão em arquivo
class FilePrinter implements HelloWorldPrinter {
    public void print() {
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Interface para a Fábrica
interface HelloWorldFactory {
    HelloWorldPrinter createPrinter();
}

// Implementação da Fábrica para impressão na tela
class ScreenPrinterFactory implements HelloWorldFactory {
    public HelloWorldPrinter createPrinter() {
        return new ScreenPrinter();
    }
}

// Implementação da Fábrica para impressão em arquivo
class FilePrinterFactory implements HelloWorldFactory {
    public HelloWorldPrinter createPrinter() {
        return new FilePrinter();
    }
}

// Classe principal
public class HelloWorld {
    public static void main(String[] args) {
        Random random = new Random();
        HelloWorldFactory factory;

        if (random.nextBoolean()) {
            factory = new ScreenPrinterFactory();
        } else {
            factory = new FilePrinterFactory();
        }

        HelloWorldPrinter printer = factory.createPrinter();
        printer.print();
    }
}
