package com.mycompany.tugas_pbo;

import java.util.Scanner;
public class Tugas_PBO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
        do{
            System.out.println("Pilih Login: ");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan: ");
            
            if(scanner.hasNextInt()){
                pilihan = scanner.nextInt();
                scanner.nextLine();
                
                if(pilihan == 1 || pilihan == 2){
                    break;
                }
            }else{
                scanner.nextLine();
            }
            System.out.println("Pilihan tidak valid!\n");
        }while(true);
        
        switch(pilihan){
            case 1:
                System.out.print("\nMasukkan Username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scanner.nextLine();
                
                if(username.equals("Admin342") && password.equals("password342")) {
                    System.out.print("Login Admin berhasil!");
                }else{
                    System.out.print("Login gagal! Username atau password salah.");
                }
                break;
                
            case 2:
                System.out.print("\nMasukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                
                if(nama.equals("Muhamad Ridwan Ardiansyah") && nim.equals("202410370110342")) {
                    System.out.println("Login Mahasiswa berhasil, SELAMAT DATANG!!");
                    System.out.println("Nama: " + nama);
                    System.out.println("NIM: " + nim);
                }else{
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
                break;
        }              
    }
}
