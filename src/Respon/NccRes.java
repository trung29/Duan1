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
            String sql = "SELECT *from NhaCC";
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
}
