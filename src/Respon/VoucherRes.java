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
import model.Staff;
import model.Voucher;

/**
 *
 * @author PC
 */
public class VoucherRes {

    Connection con = null;
    PreparedStatement sttm = null;
    ResultSet rs = null;

    public ArrayList<Voucher> getAllVoucher() {
        ArrayList<Voucher> list = new ArrayList<>();

        try {
            String sql = "select * from voucher";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);
            rs = sttm.executeQuery();

            while (rs.next()) {
                Voucher v = new Voucher();
                v.setMaVC(rs.getInt("maKM"));
                v.setTenVC(rs.getString("tenKM"));
                v.setMenhGia(rs.getDouble("gia"));
                v.setTrangThai(rs.getBoolean("trangthai"));
                list.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Integer AddVC(Voucher v) {
        try {
            String sql = "insert into voucher values (?,?,?);";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);

            //sttm.setInt(1, s.getMaNV());
            sttm.setString(1, v.getTenVC());
            sttm.setDouble(2, v.getMenhGia());
            sttm.setBoolean(3, v.isTrangThai());

            int rowsAffected = sttm.executeUpdate();
            if (rowsAffected > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Integer delVC(int maKM) {
        Integer row = null;
        try {
            String sql = "delete from voucher where maKM = ?";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);
            sttm.setInt(1, maKM);
            row = sttm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
    public Integer updateNhanVien(Voucher s, int maKM) {
        Integer row = null;
        try {
            String sql = "UPDATE voucher SET tenKM = ?,gia = ?, trangthai = ? where maKM=?";
            con = DatabaseHelper.getDBConnect();
            sttm = con.prepareStatement(sql);
            sttm.setString(1, s.getTenVC());
            sttm.setDouble(2, s.getMenhGia());
            sttm.setBoolean(3, s.isTrangThai());
            sttm.setInt(4, maKM);
            row = sttm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
}
