package com.mycompany.modul_3;

import java.util.Scanner;

class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = Math.max(kesehatan, 0); // Kesehatan tidak bisa negatif
    }

    public void serang(KarakterGame target) {
        // Akan di-override oleh subclass
    }
}
// Subclass Pahlawan
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

// Subclass Musuh
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

public class Modul_3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        // Menampilkan status awal
        System.out.println("=== Selamat Datang di Pertarungan ===");
        System.out.println("1. " + brimstone.getNama() + " (Pahlawan) - Kesehatan: " + brimstone.getKesehatan());
        System.out.println("2. " + viper.getNama() + " (Musuh) - Kesehatan: " + viper.getKesehatan());

        // Pemilihan karakter oleh pengguna
        KarakterGame pemain;
        System.out.print("\nPilih karakter Anda (1 untuk Brimstone, 2 untuk Viper): ");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            pemain = brimstone;
        } else if (pilihan == 2) {
            pemain = viper;
        } else {
            System.out.println("Pilihan tidak valid. Keluar dari permainan.");
            return;
        }

        // Menentukan lawan
        KarakterGame lawan = (pemain == brimstone) ? viper : brimstone;

        System.out.println("\nAnda bermain sebagai: " + pemain.getNama());
        System.out.println("Lawan Anda adalah: " + lawan.getNama());

        // Memulai serangan
        System.out.println("\n=== Pertarungan Dimulai! ===");
        pemain.serang(lawan);

        // Lawan menyerang balik
        if (lawan.getKesehatan() > 0) {
            lawan.serang(pemain);
        } else {
            System.out.println(lawan.getNama() + " telah kalah!");
        }

        scanner.close();
    }
}
