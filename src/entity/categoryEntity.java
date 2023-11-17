/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author hadac
 */
public class categoryEntity {
    private int maDM;
    private String tenDM;
    private String mota;

    public categoryEntity() {
    }

    public categoryEntity(int maDM, String tenDM, String mota) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.mota = mota;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

   
    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "categoryEntity{" + "maDM=" + maDM + ", tenDM=" + tenDM + ", mota=" + mota + '}';
    }
    
}
