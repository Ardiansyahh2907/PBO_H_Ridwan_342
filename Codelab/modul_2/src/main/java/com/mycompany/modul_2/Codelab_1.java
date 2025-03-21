package com.mycompany.modul_2;

class Hewan {
    String nama;
    String jenis;
    String suara;

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
        System.out.println();
    }
}
public class Codelab_1 {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();
        
        hewan1.nama = "Kucing";
        hewan1.jenis = "Mamalia";
        hewan1.suara = "Nyann~~";
        
        hewan2.nama = "Anjing";
        hewan2.jenis = "Mamalia";
        hewan2.suara = "Woof-Woof!!";
        
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
    }
}
