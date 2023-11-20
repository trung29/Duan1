/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Client {

    private int ID;
    private String name;
    private String email;
    private String sdt;
    private boolean gioitinh;
    private int dieml;

    public Client() {
    }

    public Client(int ID, String name, String email, String sdt, boolean gioitinh, int dieml) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.dieml = dieml;
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

    public int getDieml() {
        return dieml;
    }

    public void setDieml(int dieml) {
        this.dieml = dieml;
    }

}
