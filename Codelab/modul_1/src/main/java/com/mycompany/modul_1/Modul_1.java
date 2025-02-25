package com.mycompany.modul_1;

import java.time.LocalDate;
import java.util.Scanner;
public class Modul_1 {
    public static void main(String[] args) {
        String nama;
        char gender;
        int tahunLahir; 
        Scanner objInput = new Scanner(System.in);
        
        System.out.print("Masukkan Nama: ");
        nama = objInput.nextLine();
        
        System.out.print("Masukkan Jenis Kelamin(P/L): ");
        gender = objInput.next().toUpperCase().charAt(0);
        
        System.out.print("Masukkan Tahun Lahir: ");
        tahunLahir = objInput.nextInt(); 
        
        String genderStr;
        if (gender == 'L'){
            genderStr = "Laki-laki";
        }else if(gender == 'P'){
            genderStr = "Perempuan";
        }else{
            genderStr = "Tidak diketahui";
        }
        
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;
        
        System.out.println("\nData Diri:");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin : " + genderStr);
        System.out.println("Umur          : " + umur + " tahun");
        
        objInput.close();
    }
}

