package com.mycompany.modul_4.perpustakaan;

public class Anggota implements Peminjaman{
    private String nama;
    private String id;

    public Anggota(String nama, String idAnggota){
        this.nama = nama;
        this.id = id;
    }

    @Override
    public void pinjamBuku(String judul){
        System.out.println(nama + " meminjam buku " + judul);
    }

    @Override
    public void pinjamBuku(String judul, int durasi){
        System.out.println(nama + " meminjam buku " + judul + " selama " + durasi + " hari");
    }
    
    @Override
    public void kembalikanBuku(String judul){
        System.out.println(nama + " mengembalikan buku " + judul);
    }

    public String getNama(){
        return nama;
    }

    public String getId(){
        return id;
    }
}