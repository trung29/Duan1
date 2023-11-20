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
import model.Client;
import model.Product;

public class ClientRes {

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public ArrayList<Client> getAllClient() {
        ArrayList<Client> list = new ArrayList<>();

        try {
            String sql = "select * from khachhang";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Client c = new Client();
                c.setID(rs.getInt("MaKH"));
                c.setName(rs.getString("TenKH"));
                c.setGioitinh(rs.getBoolean("gioitinh"));
                c.setEmail(rs.getString("email"));
                c.setSdt(rs.getString("sdt"));
                c.setDieml(rs.getInt("diem"));

                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Integer AddClient(Client c) {
        try {
            String sql = "insert into khachhang values (?,?,?,?,?);";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getSdt());
            pstmt.setBoolean(4, c.isGioitinh());
            pstmt.setInt(5, c.getDieml());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return 1; // Thêm sản phẩm thành công
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Thêm sản phẩm thất bại
    }

    public int UpdateClient(Client c) {
        try {
            String sql = "update khachhang set tenKH=?,Email=?,sdt=?, gioitinh=?, diem=? where maKH=?";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getEmail());
            pstmt.setString(3, c.getSdt());
            pstmt.setBoolean(4, c.isGioitinh());
            pstmt.setInt(5, c.getDieml());

            pstmt.setInt(6, c.getID());

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

    public Integer Delete(int maKH) {
        try {
            System.out.println("Deleting product with ID: " + maKH);
            String sql = "DELETE FROM khachhang WHERE MaKH = ?";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);

            // Chuyển đổi maSP thành kiểu dữ liệu phù hợp (ví dụ: nếu maSP là kiểu int)
            pstmt.setInt(1, maKH);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xoa thanh cong");
                return 1; // Xoá thành công
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
        return -1; // Xoá thất bại
    }
}
