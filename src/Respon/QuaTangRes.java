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
import model.QuaTang;

public class QuaTangRes {

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public ArrayList<QuaTang> getAllQT() {
        ArrayList<QuaTang> list = new ArrayList<>();

        try {
            String sql = "select * from QuaTang";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                QuaTang q = new QuaTang();
                q.setID(rs.getInt("MaQT"));
                q.setName(rs.getString("TenQT"));
                q.setSoluong(rs.getInt("soluong"));
                q.setMota(rs.getString("MoTa"));
                q.setDanhmuc(rs.getInt("MaDM"));

                list.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
