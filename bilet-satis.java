import java.util.Scanner;

public class SinemaKayitSistemi {
    private static final int MAX_FILM = 10;
    private static final int MAX_MUSTERI = 20;
    private static String[] filmAdlari = new String[MAX_FILM];
    private static int[] filmSureleri = new int[MAX_FILM];
    private static String[] filmTurleri = new String[MAX_FILM];
    private static String[] musteriAdlari = new String[MAX_MUSTERI];
    private static String[] musteriEmailleri = new String[MAX_MUSTERI];
    private static int[] biletler = new int[MAX_MUSTERI]; // Musterinin sectigi film indeksi
    private static int filmSayisi = 0;
    private static int musteriSayisi = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;
        
        do {
            System.out.println("\nSinema Musteri Kayit Sistemi");
            System.out.println("1. Film Ekle");
            System.out.println("2. Musteri Ekle");
            System.out.println("3. Bilet Kaydi Yap");
            System.out.println("4. Biletleri Listele");
            System.out.println("5. Cikis");
            System.out.print("Seciminizi yapin: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    filmEkle(scanner);
                    break;
                case 2:
                    musteriEkle(scanner);
                    break;
                case 3:
                    biletKaydiYap(scanner);
                    break;
                case 4:
                    biletleriListele();
                    break;
                case 5:
                    System.out.println("Cikis yapiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz secim. Tekrar deneyin.");
            }
        } while (secim != 5);
    }

    private static void filmEkle(Scanner scanner) {
        if (filmSayisi >= MAX_FILM) {
            System.out.println("Maksimum film sayisina ulasildi!");
            return;
        }
        System.out.print("Film adi: ");
        filmAdlari[filmSayisi] = scanner.nextLine();
        System.out.print("Film suresi (dakika): ");
        filmSureleri[filmSayisi] = scanner.nextInt();
        scanner.nextLine(); // Yeni satir karakterini temizle
        System.out.print("Film turu: ");
        filmTurleri[filmSayisi] = scanner.nextLine();
        filmSayisi++;
        System.out.println("Film basariyla eklendi!");
    }

    private static void musteriEkle(Scanner scanner) {
        if (musteriSayisi >= MAX_MUSTERI) {
            System.out.println("Maksimum musteri sayisina ulasildi!");
            return;
        }
        System.out.print("Musteri adi: ");
        musteriAdlari[musteriSayisi] = scanner.nextLine();
        System.out.print("Musteri email: ");
        musteriEmailleri[musteriSayisi] = scanner.nextLine();
        musteriSayisi++;
        System.out.println("Musteri basariyla eklendi!");
    }

    private static void biletKaydiYap(Scanner scanner) {
        if (musteriSayisi == 0 || filmSayisi == 0) {
            System.out.println("Once film ve musteri eklenmelidir!");
            return;
        }
        System.out.println("Musteriler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(i + ". " + musteriAdlari[i]);
        }
        System.out.print("Musteri numarasini secin: ");
        int musteriIndex = scanner.nextInt();

        System.out.println("Filmler:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(i + ". " + filmAdlari[i] + " (" + filmSureleri[i] + " dk) - " + filmTurleri[i]);
        }
        System.out.print("Film numarasini secin: ");
        int filmIndex = scanner.nextInt();

        if (musteriIndex >= 0 && musteriIndex < musteriSayisi && filmIndex >= 0 && filmIndex < filmSayisi) {
            biletler[musteriIndex] = filmIndex;
            System.out.println("Bilet kaydi basariyla yapildi!");
        } else {
            System.out.println("Gecersiz musteri veya film secimi!");
        }
    }

    private static void biletleriListele() {
        if (musteriSayisi == 0) {
            System.out.println("Hic musteri kaydi bulunmamaktadir!");
            return;
        }
        System.out.println("Musteri - Film Eslesmeleri:");
        for (int i = 0; i < musteriSayisi; i++) {
            if (biletler[i] >= 0) {
                System.out.println(musteriAdlari[i] + " -> " + filmAdlari[biletler[i]]);
            }
        }
    }
}