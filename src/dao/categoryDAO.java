/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.DatabaseHelper;
import entity.categoryEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hadac
 */
public class categoryDAO {

    private categoryEntity cate;
    private categoryDAO cateDAO;

    Connection conn = null;
    PreparedStatement sttm = null;

    public List<categoryEntity> getAll() {
        List<categoryEntity> ls = new ArrayList<>();
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT * FROM categoryEntity";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                categoryEntity cate = new categoryEntity();
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

    public categoryEntity findById(int maDM) {
      
        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT * FROM DanhMuc where maDM='" + maDM + "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                categoryEntity cate = new categoryEntity();
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

    public List<categoryEntity> findByName(String tenDM) {

        ResultSet rs = null;
        Statement sttm = null;
        List<categoryEntity> ls = new ArrayList<>();
        try {
            String sSQL = "SELECT * FROM DanhMuc where tenDM like '%" + tenDM + "%'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                categoryEntity cate = new categoryEntity();
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

    public categoryEntity getByName(String tenDM) {

        ResultSet rs = null;
        Statement sttm = null;
        try {
            String sSQL = "SELECT * FROM DanhMuc where tenDM ='" + tenDM + "'";
            conn = DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                categoryEntity cate = new categoryEntity();
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

    public int add(categoryEntity cate) {
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

    public int update(categoryEntity cate) {
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
