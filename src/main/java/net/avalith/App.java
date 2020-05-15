package net.avalith;

import net.avalith.model.Product;
import net.avalith.service.Crud;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException {
        Crud crud = new Crud();
        Product product1 = new Product.Builder().name("PCGaming").price(1599.01).brand("IBAI").unit(1).quitity(1).discount(99.01).build();
        Product product2 = new Product.Builder().name("PCTrucha").price(599.01).brand("IVAI").unit(1).quitity(1).discount(9.01).id(2).build();

        crud.insert(product1);
        crud.update(product2);
        crud.getById(2);
    }
}
