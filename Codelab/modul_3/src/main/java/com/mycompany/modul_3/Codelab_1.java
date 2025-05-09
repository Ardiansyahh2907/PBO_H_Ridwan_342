package com.mycompany.modul_3;

// Untuk meng-import Scanner yang digunakan untuk membaca input dari user
import java.util.Scanner;   

// Class karakterGame yang berisi 3 atribut dengan akses private(cuma bisa diakses di class karakterGame saja)
class KarakterGame {
    private String nama;    // atribut nama yang bertipe String dengan akses private 
    private int kesehatan;  // atribut kesehatan yg bertipe integer dengan akses private
    private int booster;    // atribut booster yg bertipe integer dengan akses private

    // Construktor dengan parameter(berguna untuk menginisialisasi nilai awal dari sebuah atribut)
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;           // mengisi atribut nama dengan nilai dari parameter nama
        this.kesehatan = kesehatan; // mengisi atribut kesehatan dengan nilai dari parameter kesehatan
        this.booster = 0;           // mengatur atribut booster ke nilai default yaitu 0
    }

    // Metode getter(get) yg digunakan untuk mengambil nilai atribut nama dari objek
    public String getNama() {
        return nama;         // mengembalikan nilai dari atribut nama
    }

    // Metode getter(get) yg digunakan untuk mengambil nilai atribut kesehatan dari objek
    public int getKesehatan() {
        return kesehatan;   // mengembalikan nilai dari atribut kesehatan
    }

    // Metode getter(get) yg digunakan untuk mengambil nilai atribut booster dari objek
    public int getBooster() {
        return booster;     // mengembalikan nilai dari atribut booster
    }

    // Metode setter(set) yg digunakan untuk mengubah nilai atribut kesehatan
    public void setKesehatan(int kesehatan) {
        //atribut kesehatan pada objek this yg dipanggil dan mengatur agar nilai kesehatan tidak bisa negatif, dan ketika negatif nilai 0 yg disimpan
        this.kesehatan = Math.max(kesehatan, 0); 
    }

    // Metode setter(set) yg digunakan untuk mengubah nilai atribut booster
    public void setBooster() {
        this.kesehatan += 10;   // menambah 10 pada atribut kesehatan ketika dipanggil menyerang
        System.out.println(nama + " mendapatkan booster! Kesehatan bertambah 10."); // mencetak namaKarakter yang mendapatkan booster
    }

    // Menerima objek KarakterGame lain sebagai target serangan
    public void serang(KarakterGame target) {
        //  disini akan dioverride oleh subclass
    }
}

// Menunjukkan kelas pahlawan adalah subclass dari KarakterGame yang mewarisi properti dan method dari KarakterGame
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);     // Memanggil konstruktor KarakterGame dengan parameter nama dan kesehatan yang menggunakan key super
    }
    
    @Override       // Memberitahu bahwa method serang di sini menggantikan method yang ada diKarakterGame
    public void serang(KarakterGame target) {   // menerima objek target lawan yang akan diserang
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!"); // Mencetak pesan menyerang lawan ke layar
        target.setKesehatan(target.getKesehatan() - 20); // Mengurangi kesehatan lawan sebanyak 20 poin, dan menggunakan getter untuk mendapatkan nilai kesehatan serta setter untuk kesehatan lawan
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan()); // Mencetak pesan kesehatan terbaru dari lawan ke layar
    }
}

// Menunjukkan kelas penyihir adalah subclass dari KarakterGame yang mewarisi properti dan method dari KarakterGame
class Penyihir extends KarakterGame {
    public Penyihir(String nama, int kesehatan) {
        super(nama, kesehatan);     // Memanggil konstruktor KarakterGame dengan parameter nama dan kesehatan yang menggunakan key super
    }

    @Override       // Memberitahu bahwa method serang di sini menggantikan method yang ada diKarakterGame
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Fire Ball!");
        target.setKesehatan(target.getKesehatan() - 40); // Mengurangi kesehatan lawan sebanyak 40 poin
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

// Menunjukkan kelas musuh adalah subclass dari KarakterGame yang mewarisi properti dan method dari KarakterGame
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);     // Memanggil konstruktor KarakterGame dengan parameter nama dan kesehatan yang menggunakan key super
    }

    @Override       // Memberitahu bahwa method serang di sini menggantikan method yang ada diKarakterGame
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15); // Mengurangi kesehatan lawan sebanyak 15 poin
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}


public class Codelab_1 {
   public static void main(String[] args) {         // Main method(awal dieksekusi program)
        Scanner scanner = new Scanner(System.in);   // Membuat objek Scanner untuk membaca input dari user

        Pahlawan brimstone = new Pahlawan("Brimstone", 160);   // Membuat objek brimstone dari kelas Pahlawan dan memanggil constructor
        Penyihir alcatroz = new Penyihir("Alcatroz", 120);     // Membuat objek alcatroz dari kelas Penyihir dan memanggil constructor
        Musuh viper = new Musuh("Viper", 200);                 // Membuat objek viper dari kelas Musuh  dan memanggil constructor

        // Mencetak pesan yang memanggil getter nama dan getter kesehatan ke layar
        System.out.println("=== Welcome to Battle Java ===");
        System.out.println("1. " + brimstone.getNama() + "(Pahlawan) - Kesehatan: " + brimstone.getKesehatan());
        System.out.println("2. " + alcatroz.getNama() + "(Penyihir) - Kesehatan: " + alcatroz.getKesehatan());
        System.out.println("3. " + viper.getNama() + "(Musuh) - Kesehatan: " + viper.getKesehatan());

        KarakterGame pemain;    // Mendeklarasikan variabel pemain dari KarakterGame
        System.out.print("\nPilih karakter Anda (1 untuk Brimstone, 2 untuk Alcatroz, 3 untuk Viper): ");
        int pilihan = scanner.nextInt();    // Membaca input angka dari user menggunakan scanner.nextInt() dan menyimpan ke variabel pilihan

        // Menentukan pilihan berdasarkan kondisi yang dipilih oleh user berdasarkan input angka yang dimasukkan
        if (pilihan == 1) {
            pemain = brimstone;
        } else if (pilihan == 2) {
            pemain = alcatroz;
        } else if (pilihan == 3) {
            pemain = viper;
        } else {
            System.out.println("Pilihan tidak valid. Keluar dari permainan.");
            return;
        }

       KarakterGame lawan;  // Mendeklarasikan variabel lawan untuk menyimpan karakter lawan dari user
        if (pemain == viper) {     // Jika user memilih karakter Viper, maka diminta memilih lawan Brimstone(1) atau Alcatroz(2)
            System.out.print("Pilih lawan Anda (1 untuk Brimstone, 2 untuk Alcatroz): ");
            int lawanPilihan = scanner.nextInt();
            if (lawanPilihan == 1) {
                lawan = brimstone;
            } else if (lawanPilihan == 2) {
                lawan = alcatroz;
            } else {
                System.out.println("Pilihan lawan tidak valid. Keluar dari permainan.");
                return;
            }
        } else {
            lawan = viper;  // Jika user memilih Brimstone(1) atau Alcatroz(2), maka lawan yg terpilih otomatis adalah Viper
        }

        System.out.println("\nAnda bermain sebagai: " + pemain.getNama());
        System.out.println("Lawan Anda adalah: " + lawan.getNama());

        System.out.println("\n=== Pertarungan Dimulai! ===");
        pemain.serang(lawan);   // memanggil metode serang() dari objek pemain yang menyerang lawan

        if (lawan.getKesehatan() > 0) {     // Jika kesehatan lawan masih lebih dari 0,                                            
            lawan.serang(pemain);           //-maka lawan akan menyerang balik ke pemain
        } else {
            System.out.println(lawan.getNama() + " telah kalah!");  // Jika lawan kalah (kesehatannya kurang dari 0),
            pemain.setBooster();                                    //-maka pemain akan mendapatkan booster sebesar 10
            System.out.println("Kesehatan " + pemain.getNama() + " sekarang: " + pemain.getKesehatan());
        }

        scanner.close();    // untuk menutup objek Scanner setelah selesai digunakan
    }
}
