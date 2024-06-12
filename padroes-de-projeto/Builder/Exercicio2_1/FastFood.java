
// Importando a classe Pedido
import java.util.*;

// Interface Builder
interface PedidoBuilder {
    void buildSanduiche();

    void buildBatata();

    void buildBrinquedo();

    void buildBebida();

    Pedido getPedido();
}

// Concreto Builder
class PedidoConcreteBuilder implements PedidoBuilder {
    private Pedido pedido;

    public PedidoConcreteBuilder() {
        this.pedido = new Pedido();
    }

    public void buildSanduiche() {
        pedido.adicionarDentroDaCaixa("Cheeseburger");
    }

    public void buildBatata() {
        pedido.adicionarDentroDaCaixa("Batata média");
    }

    public void buildBrinquedo() {
        pedido.adicionarDentroDaCaixa("Carrinho");
    }

    public void buildBebida() {
        pedido.adicionarForaDaCaixa("Coca");
    }

    public Pedido getPedido() {
        return pedido;
    }
}

// Director
class Atendente {
    private PedidoBuilder builder;

    public Atendente(PedidoBuilder builder) {
        this.builder = builder;
    }

    public void fazerPedido() {
        builder.buildSanduiche();
        builder.buildBatata();
        builder.buildBrinquedo();
        builder.buildBebida();
    }

    public Pedido getPedido() {
        return builder.getPedido();
    }
}

// Cliente
public class FastFood {
    public static void main(String[] args) {
        PedidoBuilder builder = new PedidoConcreteBuilder();
        Atendente atendente = new Atendente(builder);

        atendente.fazerPedido();
        Pedido pedido = atendente.getPedido();

        System.out.println(pedido);
    }
}
