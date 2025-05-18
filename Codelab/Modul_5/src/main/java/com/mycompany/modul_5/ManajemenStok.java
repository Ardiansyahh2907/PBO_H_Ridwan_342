package com.mycompany.modul_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

public class ManajemenStok{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Barang("Buku", 30));
        daftarBarang.add(new Barang("Penggaris", 20));
        daftarBarang.add(new Barang("Pulpen", 50));

        int pilihan;
        do{
            System.out.println("\n===== Menu Manajemen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Cari Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            try{
                pilihan = scanner.nextInt();
                scanner.nextLine(); 
                switch(pilihan){
                    case 1:
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan stok awal: ");
                        try{
                            int stok = scanner.nextInt();
                            scanner.nextLine();
                            daftarBarang.add(new Barang(nama, stok));
                            System.out.println("Barang '" + nama + "' berhasil ditambahkan.");
                        }catch (InputMismatchException e){
                            System.out.println("Input stok harus angka!");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        if(daftarBarang.isEmpty()){
                            System.out.println("Stok barang kosong.");
                        }else{
                            System.out.println("\n--- Daftar Barang ---");
                            Iterator<Barang> iterator = daftarBarang.iterator();
                            int index = 0;
                            while(iterator.hasNext()){
                                Barang b = iterator.next();
                                System.out.println(index + ". Nama: " + b.getNama() + " - Stok: " + b.getStok());
                                index++;
                            }
                            System.out.println("----------------------");
                        }
                        break;


                    case 3:
                        if(daftarBarang.isEmpty()){
                            System.out.println("Stok barang kosong.");
                            break;
                        }
                        System.out.println("\n--- Daftar Barang(Pilih untuk Kurangi Stok) ---");
                        for(int i = 0; i < daftarBarang.size(); i++){
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                        }

                        try{
                            System.out.print("Masukkan nomor barang: ");
                            int indeks = scanner.nextInt();
                            Barang barangDipilih = daftarBarang.get(indeks);

                            System.out.print("Masukkan jumlah stok yang akan diambil: ");
                            int jumlahDiambil = scanner.nextInt();

                            if(jumlahDiambil > barangDipilih.getStok()){
                                throw new StokTidakCukupException("Stok untuk '" + barangDipilih.getNama() +
                                        "' hanya tersisa " + barangDipilih.getStok());
                            }

                            barangDipilih.setStok(barangDipilih.getStok() - jumlahDiambil);
                            System.out.println("Stok barang '" + barangDipilih.getNama() + "' berhasil dikurangi. Sisa stok: " + barangDipilih.getStok());
                        }catch(InputMismatchException e){
                            System.out.println("Input harus angka!");
                            scanner.nextLine();
                        }catch(IndexOutOfBoundsException e){
                            System.out.println("Pilihan tidak valid.");
                        }catch(StokTidakCukupException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    
                    case 4:
                        System.out.print("Masukkan nama barang yang dicari: ");
                        String keyword = scanner.nextLine().toLowerCase();
                        boolean ditemukan = false;

                        System.out.println("\n--- Hasil Pencarian ---");
                        for(int i = 0; i < daftarBarang.size(); i++){
                            Barang b = daftarBarang.get(i);
                        if(b.getNama().toLowerCase().contains(keyword)){
                            System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                            ditemukan = true;
                            }
                        }
                        if(!ditemukan){
                            System.out.println("Barang '" + keyword + "' tidak ditemukan.");
                        }
                        System.out.println("------------------------");
                        break;

                    case 0:
                        System.out.println("Terima kasih!!.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }catch(InputMismatchException e){
                System.out.println("Input harus angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        }while(pilihan != 0);

        scanner.close();
    }
}

