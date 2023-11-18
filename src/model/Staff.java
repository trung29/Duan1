/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hadac
 */
public class Staff {
      private int maNV;
    private String tenNV;
    private String email;
    private String sdt;
    private boolean gioitinh;
    private String password;
    private boolean role;

    public Staff() {
    }

    public Staff(int maNV, String tenNV, String email, String sdt, boolean gioitinh, String password, boolean role) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.password = password;
        this.role = role;
    }



    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
    
}
