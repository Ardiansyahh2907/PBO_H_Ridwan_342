package com.mycompany.modul_4;

import com.mycompany.modul_4.perpustakaan.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Buku buku1 = new Fiksi("Laskar Pelangi", "Andrea Hirata");
        Buku buku2 = new NonFiksi("Educated", "Tara Westover");

        System.out.println("Daftar Buku:");
        buku1.displayInfo();
        System.out.println();
        buku2.displayInfo();
        System.out.println();

        System.out.print("Masukkan nama anggota: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan ID anggota: ");
        String id = scanner.nextLine();

        Anggota anggota = new Anggota(nama, id);

        System.out.print("Masukkan judul buku: ");
        String inputJudul = scanner.nextLine();

        if(inputJudul.equals(buku1.getJudul())){
            prosesPeminjaman(scanner, anggota, buku1.getJudul());
        }else if(inputJudul.equals(buku2.getJudul())){
            prosesPeminjaman(scanner, anggota, buku2.getJudul());
        }else{
            System.out.println("Buku tidak tersedia!");
        }
        scanner.close();
    }

    public static void prosesPeminjaman(Scanner scanner, Anggota anggota, String judul){
        System.out.print("Masukkan berapa hari peminjaman: ");
        int durasi = scanner.nextInt();
        scanner.nextLine();

        anggota.pinjamBuku(judul);
        anggota.pinjamBuku(judul, durasi);
        
        System.out.print("Ingin mengembalikan buku?(y/t): ");
        String kembali = scanner.nextLine();

        if (kembali.equals("y")) {
            anggota.kembalikanBuku(judul);
        } else {
            System.out.println("Buku belum dikembalikan!.");
        }
    }
}
