package net.avalith.service;

import net.avalith.conection.Conection;
import net.avalith.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Crud {

    private final String SQL_INSERT = "INSERT INTO products(name, price, brand, unit, quantity, discount) values(?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE products SET name=?, price=? , brand=? , unit=?, quantity=?, discount=? where id=?";
    private final String SQL_SELECT_BY_ID = "select * from products where id=?";

    public int insert(Product productDto) throws SQLException {

        int rows = 0;
        Connection conn = Conection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);

        try {
            int index = 1;

            stmt.setString(index++, productDto.getName());
            stmt.setDouble(index++, productDto.getPrice());
            stmt.setString(index++, productDto.getBrand());
            stmt.setInt(index++, productDto.getUnit());
            stmt.setInt(index++, productDto.getQuantity());
            stmt.setDouble(index++, productDto.getDiscount());

            System.out.println("Query: " + stmt);
            rows = stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conection.close(conn);
        }
        return rows;
    }

    public int update(Product productDto) throws SQLException {

        int rows = 0;
        Connection conn = Conection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);

        try {
            int index = 1;

            stmt.setString(index++, productDto.getName());
            stmt.setDouble(index++, productDto.getPrice());
            stmt.setString(index++, productDto.getBrand());
            stmt.setInt(index++, productDto.getUnit());
            stmt.setInt(index++, productDto.getQuantity());
            stmt.setDouble(index++, productDto.getDiscount());
            stmt.setInt(index++, productDto.getId());

            System.out.println("Query: " + stmt);
            rows = stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conection.close(conn);
        }
        return rows;
    }

    public Optional<Product> getById(int id) throws SQLException {

        ResultSet rs;
        Product product = null;

        Connection conn = Conection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

        try {
            int index = 1;

            stmt.setInt(index++, id);

            System.out.println("Query: " + stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                product = new Product.Builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .price(rs.getDouble(3))
                        .brand(rs.getString(4))
                        .unit(rs.getInt(5))
                        .quitity(rs.getInt(6))
                        .discount(rs.getDouble(7))
                        .build();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conection.close(conn);
        }
        return Optional.ofNullable(product);
    }
}
