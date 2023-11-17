/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Respon;

import connect.DatabaseHelper;
import model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class productRes {

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<>();

        try {
            String sql = "SELECT sp.*, dm.TenDM FROM SanPham sp JOIN DanhMuc dm ON sp.MaDM = dm.MaDM";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setMaSP(rs.getInt("MaSP"));
                p.setTenSP(rs.getString("TenSP"));
                p.setTrangthai(rs.getBoolean("TrangThai"));
                p.setGia(rs.getFloat("Gia"));
                p.setMaDM(rs.getInt("MaDM"));
                p.setMota(rs.getString("MoTa"));

                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Integer AddProduct(Product p) {
        try {
            String sql = "INSERT INTO SanPham (TenSP, TrangThai, Gia, MaDM, MoTa) VALUES (?, ?, ?, ?, ?)";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, p.getTenSP());
            pstmt.setBoolean(2, p.isTrangthai());
            pstmt.setInt(3, (int) p.getGia());
            pstmt.setInt(4, p.getMaDM());
            pstmt.setString(5, p.getMota());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return 1; // Thêm sản phẩm thành công
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Thêm sản phẩm thất bại
    }

    public int UpdateProduct(Product p) {
        try {
            String sql = "UPDATE SanPham SET TenSP = ?, TrangThai = ?, Gia = ?, MaDM = ?, MoTa = ? WHERE MaSP = ?";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, p.getTenSP());
            pstmt.setBoolean(2, p.isTrangthai());
            pstmt.setDouble(3, p.getGia());  // Sử dụng setDouble cho giá
            pstmt.setInt(4, p.getMaDM());
            pstmt.setString(5, p.getMota());
            pstmt.setInt(6, p.getMaSP());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        } finally {
            // Đóng các resource
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1;
    }

    public Integer Delete(int maSP) {
        try {
            System.out.println("Deleting product with ID: " + maSP); // In ra giá trị của maSP
            String sql = "DELETE FROM SanPham WHERE MaSP = ?";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);

            // Chuyển đổi maSP thành kiểu dữ liệu phù hợp (ví dụ: nếu maSP là kiểu int)
            pstmt.setInt(1, maSP);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xoa thanh cong");
                return 1; // Xoá thành công
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        } finally {
            // Đóng các resource
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return -1; // Xoá thất bại
    }

}
