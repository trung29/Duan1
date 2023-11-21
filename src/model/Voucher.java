/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Voucher {
    private int maVC;
    private String tenVC;
    private double menhGia;
    private boolean trangThai;

    public Voucher() {
    }

    public Voucher(int maVC, String tenVC, double menhGia, boolean trangThai) {
        this.maVC = maVC;
        this.tenVC = tenVC;
        this.menhGia = menhGia;
        this.trangThai = trangThai;
    }

    public int getMaVC() {
        return maVC;
    }

    public void setMaVC(int maVC) {
        this.maVC = maVC;
    }

    public String getTenVC() {
        return tenVC;
    }

    public void setTenVC(String tenVC) {
        this.tenVC = tenVC;
    }

    public double getMenhGia() {
        return menhGia;
    }

    public void setMenhGia(double menhGia) {
        this.menhGia = menhGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
}
