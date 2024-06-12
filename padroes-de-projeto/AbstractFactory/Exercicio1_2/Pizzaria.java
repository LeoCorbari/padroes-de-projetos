import java.util.Calendar;
import java.util.GregorianCalendar;

// Produto abstrato
interface Pizza {
    void printIngredients();
}

// Produtos concretos
class CalabresaPizza implements Pizza {
    public void printIngredients() {
        System.out.println("Ingredientes: Queijo, Calabresa, Tomate");
    }
}

class PresuntoPizza implements Pizza {
    public void printIngredients() {
        System.out.println("Ingredientes: Queijo, Presunto, Tomate");
    }
}

// Fábrica abstrata
interface PizzaioloFactory {
    Pizza createPizza();
}

// Fábricas concretas
class CalabresaPizzaioloFactory implements PizzaioloFactory {
    public Pizza createPizza() {
        return new CalabresaPizza();
    }
}

class PresuntoPizzaioloFactory implements PizzaioloFactory {
    public Pizza createPizza() {
        return new PresuntoPizza();
    }
}

// Cliente
public class Pizzaria {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Formato de data inválido. Utilize dd/mm/yyyy.");
            return;
        }

        String[] dateParts = args[0].split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]) - 1; // Calendar.MONTH é zero-based
        int year = Integer.parseInt(dateParts[2]);

        Calendar date = new GregorianCalendar(year, month, day);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);

        PizzaioloFactory factory;

        switch (dayOfWeek) {
            case Calendar.MONDAY:
            case Calendar.WEDNESDAY:
            case Calendar.FRIDAY:
                factory = new CalabresaPizzaioloFactory();
                break;
            case Calendar.TUESDAY:
            case Calendar.THURSDAY:
            case Calendar.SATURDAY:
                factory = new PresuntoPizzaioloFactory();
                break;
            case Calendar.SUNDAY:
                System.out.println("A pizzaria está fechada aos domingos.");
                return;
            default:
                throw new IllegalStateException("Dia da semana inválido: " + dayOfWeek);
        }

        Pizza pizza = factory.createPizza();
        pizza.printIngredients();
    }
}
