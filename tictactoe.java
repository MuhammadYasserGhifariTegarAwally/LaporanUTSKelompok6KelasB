//Program TicTacToe
//Muhammad Yasser Ghifari Tegar Awally - G1A023030
//Adani Saputra - G1A023???

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class tictactoe {

    static ArrayList<Integer> PosisiPlayer = new ArrayList<Integer>();
    static ArrayList<Integer> PosisiPlayer2 = new ArrayList<Integer>();

    public static void main(String[] args) {

        char [][] papan = {{'_','_','_','_','_','_','_','_','_','_','_','_','_'},
                {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                {'|','_','_','_','|','_','_','_','|','_','_','_','|'},
                {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                {'|','_','_','_','|','_','_','_','|','_','_','_','|'},
                {'|',' ',' ',' ','|',' ',' ',' ','|',' ',' ',' ','|'},
                {'|','_','_','_','|','_','_','_','|','_','_','_','|'}};

        System.out.println("TicTacToe");
        System.out.println("Masukan angka 1-9 untuk memilih posisi");
        printPapan(papan);



        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Giliran pemain 1");
            int posisipl = sc.nextInt();
            while (PosisiPlayer.contains(posisipl) || PosisiPlayer2.contains(posisipl)){
                System.out.println("Posisi telah diambil! Pilih posisi yang kosong");
                posisipl = sc.nextInt();
            }
            masukanpos(papan, posisipl, "Pemain 1");
            printPapan(papan);
            String hasil1 = cekMenang();
            if (hasil1.length() > 0) {
                System.out.println(hasil1);
                break;
            }

            System.out.println("Giliran pemain 2");
            int posisipl2 = sc.nextInt();
            while (PosisiPlayer.contains(posisipl2) || PosisiPlayer2.contains(posisipl2)){
                System.out.println("Posisi telah diambil! Pilih posisi yang kosong");
                posisipl2 = sc.nextInt();
            }
            masukanpos(papan, posisipl2, "Pemain 2");
            printPapan(papan);
            String hasil = cekMenang();
            if (hasil.length() > 0){
                System.out.println(hasil);
                break;
            }


        }
            }
            public static void printPapan(char[][] papan) {
        
                for(char[] baris : papan) {
                    for(char a : baris){
                        System.out.print(a);
            }
                    System.out.println();
        }

    }
    public static void masukanpos(char[][] papan, int posisi, String pemain){
        char symbol = ' ';

        if (pemain.equals("Pemain 1")){
            symbol = 'X';
            PosisiPlayer.add(posisi);

        } else if (pemain.equals("Pemain 2")) {
            symbol = 'O';
            PosisiPlayer2.add(posisi);

        }


        switch (posisi) {
            case 1:
                papan[1][2] = symbol;
                break;
            case 2:
                papan[1][6] = symbol;
                break;
            case 3:
                papan[1][10] = symbol;
                break;
            case 4:
                papan[3][2] = symbol;
                break;
            case 5:
                papan[3][6] = symbol;
                break;
            case 6:
                papan[3][10] = symbol;
                break;
            case 7:
                papan[5][2] = symbol;
                break;
            case 8:
                papan[5][6] = symbol;
                break;
            case 9:
                papan[5][10] = symbol;
                break;
            default:
                break;

        }

    }

    public static String cekMenang(){
        List barisAtas = Arrays.asList(1, 2, 3);
        List barisTengah = Arrays.asList(4, 5, 6);
        List barisBawah = Arrays.asList(7, 8, 9);
        List kolomKiri = Arrays.asList(1, 4, 7);
        List kolomTengah = Arrays.asList(2, 5, 8);
        List kolomKanan = Arrays.asList(3, 6, 9);
        List diagonal1 = Arrays.asList(1, 5, 9);
        List diagonal2 = Arrays.asList(7, 5, 3);

        List<List> menang = new ArrayList<List>();
        menang.add(barisAtas);
        menang.add(barisTengah);
        menang.add(barisBawah);
        menang.add(kolomKiri);
        menang.add(kolomTengah);
        menang.add(kolomKanan);
        menang.add(diagonal1);
        menang.add(diagonal2);

        for (List l : menang) {
            if (PosisiPlayer.containsAll(l)){
                return "Selamat Pemain 1, kamu menang!";
            } else if (PosisiPlayer2.containsAll(l)) {
                return "Selamat Pemain 2, kamu menang!";
            } else if (PosisiPlayer.size() + PosisiPlayer2.size() == 9) {
                return "Seri!";

            }
        }

        return "";

    }


}
