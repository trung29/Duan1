/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Respon;

import connect.DatabaseHelper;
import java.sql.*;
import java.sql.PreparedStatement;
import model.Staff;

/**
 *
 * @author hadac
 */
public class loginRes {

    private Staff staff;
    private staffRes staffDAO;
    Connection conn = null;
    PreparedStatement sttm = null;

    public Staff getByPhone(String sdt) {
        Staff sta = null;
        conn = DatabaseHelper.getDBConnect();
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE sdt = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, sdt);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Tạo một đối tượng Employee từ dữ liệu của ResultSet
                        sta = new Staff();
                        sta.setMaNV(resultSet.getInt("maNV"));
                        sta.setTenNV(resultSet.getString("tenNV"));
                        sta.setEmail(resultSet.getString("email"));
                        sta.setSdt(resultSet.getString("sdt"));
                        sta.setGioitinh(resultSet.getBoolean("gioitinh"));
                        sta.setPassword(resultSet.getString("password"));
                        sta.setRole(resultSet.getBoolean("role"));

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sta;
    }
}
