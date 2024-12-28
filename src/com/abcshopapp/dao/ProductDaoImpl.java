package com.abcshopapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.abcshopapp.dto.Product;
import com.abcshopapp.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO product_tbl(product_name, product_price, mfd, category) VALUES(?, ?, ?, ?)";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getProductPrice());
            ps.setDate(3, Date.valueOf(product.getMfd()));
            ps.setString(4, product.getCategory());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int productId) {
        String sql = "SELECT * FROM product_tbl WHERE product_id = ?";
        Product product = null;

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getDouble(3));
                product.setMfd(rs.getDate(4).toLocalDate());
                product.setCategory(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product_tbl";

        try (Connection con = DBUtil.getDBConnection();
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setProductPrice(rs.getDouble(3));
                product.setMfd(rs.getDate(4).toLocalDate());
                product.setCategory(rs.getString(5));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
