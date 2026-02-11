package bo.sigep.sample.pedidos;

import bo.sigep.sample.clientes.domain.Domain;

public class Application {

    public void print() {
        System.out.println("this is the application tier **********");
        Domain domain = new Domain();
        domain.print();
    }

}
