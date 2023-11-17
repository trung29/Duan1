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
import view.category;

/**
 *
 * @author hadac
 */
public class categoryRes {

    private Category cate;
    private categoryRes cateDAO;

    Connection conn = null;
    PreparedStatement sttm = null;

    public List<Category> getAll() {
        List<Category> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT * FROM DanhMuc";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Category cate = new Category();
                cate.setMaDM(rs.getInt(1));
                cate.setTenDM(rs.getString(2));
                cate.setMota(rs.getString(3));
                ls.add(cate);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return ls;
    }

    public String getCategoryNameById(int categoryId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT TenDM FROM DanhMuc WHERE MaDM = ?";
            con = DatabaseHelper.getDBConnect();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, categoryId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("TenDM");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // hoặc một giá trị mặc định phù hợp
    }

    public Category findById(int maDM) {

        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT * FROM DanhMuc where maDM='" + maDM + "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Category cate = new Category();
                cate.setMaDM(rs.getInt(1));
                cate.setTenDM(rs.getString(2));
                cate.setMota(rs.getString(3));
                return cate;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public List<Category> findByName(String tenDM) {

        ResultSet rs = null;
        Statement sttm = null;
        List<Category> ls = new ArrayList<>();
        try {
            String sSQL = "SELECT * FROM DanhMuc where tenDM like '%" + tenDM + "%'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Category cate = new Category();
                cate.setMaDM(rs.getInt(1));
                cate.setTenDM(rs.getString(2));
                cate.setMota(rs.getString(3));
                ls.add(cate);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }

    public int add(Category cate) {
        try {
            String sSQL = "insert Danhmuc(TENDM,MOTA) values(?,?)";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, cate.getTenDM());
            sttm.setString(2, cate.getMota());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Add Category successfully");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }

    public int update(Category cate) {
        try {
            String sSQL = "update Danhmuc set TENDM=? ,MOTA=? where maDM=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, cate.getTenDM());
            sttm.setString(2, cate.getMota());
            sttm.setInt(3, cate.getMaDM());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Update Category successfully");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }

    public int delete(int maDM) {
        try {
            String sSQL = "delete DANHMUC where maDM=?";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, maDM);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Xóa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return -1;
    }
}
