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
}
