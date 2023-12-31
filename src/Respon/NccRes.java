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
import model.Ncc;
import model.Product;

public class NccRes {

    Connection con = null;
    PreparedStatement sttm = null;
    ResultSet rs = null;

    public ArrayList<Ncc> getAllNCC() {
        ArrayList<Ncc> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM NhaCC";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);
            rs = sttm.executeQuery();

            while (rs.next()) {
                Ncc n = new Ncc();
                n.setMaNCC(rs.getInt("maNCC"));
                n.setTenNCC(rs.getString("tenNCC"));
                n.setEmail(rs.getString("email"));
                n.setSdt(rs.getString("sdt"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Ncc findById(int maNCC) {

        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT * FROM NCC where maNCC='" + maNCC + "'";
            con = DatabaseHelper.getDBConnect();
            sttm = con.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Ncc ncc = new Ncc();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setEmail(rs.getString(3));
                ncc.setSdt(rs.getString(4));
                return ncc;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                con.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public Integer AddNCC(Ncc n) {
        try {
            String sql = "insert into NhaCC values (?,?,?);";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);

            sttm.setString(1, n.getTenNCC());
            sttm.setString(2, n.getEmail());
            sttm.setString(3, n.getSdt());

            int rowsAffected = sttm.executeUpdate();
            if (rowsAffected > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int UpdateNCC(Ncc n) {
        try {
            String sql = "UPDATE NhaCC SET TenNCC = ?, email = ?, sdt = ? where maNCC=?";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);

            sttm.setString(1, n.getTenNCC());
            sttm.setString(2, n.getEmail());
            sttm.setString(3, n.getSdt());
            sttm.setString(4, String.valueOf(n.getMaNCC()));
        
            if (sttm.executeUpdate() > 0) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
        return -1;
    }

    public Integer Delete(int ma) {
        try {
            String sql = "DELETE FROM NhaCC WHERE maNCC = ?";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);

            sttm.setInt(1, ma);

            int rowsAffected = sttm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xoa thanh cong");
                return 1; // Xoá thành công
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
        return -1; // Xoá thất bại
    }
}
