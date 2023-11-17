/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author hadac
 */
public class productEnitty {
    private int maSP;
    private String tenSP;
    private int soluong;
    private double gia;
    private categoryEntity maDM;

    public productEnitty() {
    }

    public productEnitty(int maSP, String tenSP, int soluong, double gia, categoryEntity maDM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.gia = gia;
        this.maDM = maDM;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public categoryEntity getMaDM() {
        return maDM;
    }

    public void setMaDM(categoryEntity maDM) {
        this.maDM = maDM;
    }
    
}
