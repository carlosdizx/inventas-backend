package arena;

import arena.entity.ItemFactura;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventasApplication {

    public static void main(String[] args) {
        final ItemFactura itemFactura = new ItemFactura();
        System.out.println(itemFactura);
        SpringApplication.run(InventasApplication.class, args);
    }

}
