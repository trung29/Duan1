/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Respon;

import connect.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Ncc;
import model.Staff;

/**
 *
 * @author hadac
 */
public class staffRes {

    Connection con = null;
    PreparedStatement sttm = null;
    ResultSet rs = null;

    public ArrayList<Staff> getAllNhanVien() {
        ArrayList<Staff> list = new ArrayList<>();

        try {
            String sql = "select * from nhanvien";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);
            rs = sttm.executeQuery();

            while (rs.next()) {
                Staff n = new Staff();
                n.setMaNV(rs.getInt("maNV"));
                n.setTenNV(rs.getString("tenNV"));
                n.setEmail(rs.getString("email"));
                n.setSdt(rs.getString("sdt"));
                n.setGioitinh(rs.getBoolean("gioitinh"));
                n.setPassword(rs.getString("password"));
                n.setRole(rs.getBoolean("role"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Integer AddStaff(Staff s) {
        try {
            String sql = "insert into nhanvien values (?,?,?,?,?,?);";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);

            //sttm.setInt(1, s.getMaNV());
            sttm.setString(1, s.getTenNV());
            sttm.setString(2, s.getEmail());
            sttm.setString(3, s.getSdt());
            sttm.setBoolean(4, s.isGioitinh());
            sttm.setString(5, s.getPassword());
            sttm.setBoolean(6, s.isRole());
            
            int rowsAffected = sttm.executeUpdate();
            if (rowsAffected > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
