package com.mycompany.modul_2;

class RekeningBank{
    String nomorRekening;
    String namaPemilik;
    double saldo;
    
    public void tampilkanInfo(){
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp " + saldo);
        System.out.println();
    }

    public void setorUang(double jumlah){
        saldo += jumlah;
        System.out.print(namaPemilik + " menyetor Rp " + jumlah + " Saldo sekarang: Rp " + saldo);
        System.out.println();
    }

    public void tarikUang(double jumlah){
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.print(namaPemilik + " menarik Rp " + jumlah + " (Berhasil) Saldo sekarang: Rp " + saldo);
        } else {
            System.out.println(namaPemilik + " menarik Rp " + jumlah + " (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp " + saldo);
        }
        System.out.println();
    }
}

public class Codelab_2 {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();
        
        rekening1.nomorRekening = "202410370110342";
        rekening1.namaPemilik = "Ridwan";
        rekening1.saldo = 500000;
        
        rekening2.nomorRekening = "202410370110332";
        rekening2.namaPemilik = "Yazid";
        rekening2.saldo = 450000;
        
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
        
        rekening1.setorUang(200000);
        rekening2.setorUang(50000);
        System.out.println();

        rekening1.tarikUang(100000);
        rekening2.tarikUang(950000);
        System.out.println();
        
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
        
        System.out.println("Code Selesai!");
        
    }    
}
