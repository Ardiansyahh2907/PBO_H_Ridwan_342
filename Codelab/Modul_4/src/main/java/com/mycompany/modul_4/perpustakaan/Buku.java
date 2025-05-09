package com.mycompany.modul_4.perpustakaan;

public abstract class Buku{
    protected String judul;
    protected String penulis;
    
    public String getJudul(){
        return judul;
    }

    public Buku(String judul, String penulis){
        this.judul = judul;
        this.penulis = penulis;
    }

    public abstract void displayInfo();
}