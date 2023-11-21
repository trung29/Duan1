/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class QuaTang {
 private int ID;
 private String name;
 private int soluong;
 private String mota;
 private int danhmuc;

    public QuaTang() {
    }

    public QuaTang(int ID, String name, int soluong, String mota, int danhmuc) {
        this.ID = ID;
        this.name = name;
        this.soluong = soluong;
        this.mota = mota;
        this.danhmuc = danhmuc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(int danhmuc) {
        this.danhmuc = danhmuc;
    }
 
}
