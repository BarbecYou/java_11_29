package hu.petrik.rekurzio;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //System.out.println(faktorialis(4));
        //System.out.println(hatvany(2, 4));

//        int db = 10;int db = 10;
//        int max = 10;
//        int[] tomb = new int[db];
//        lottoSorsolas(tomb, max, db);
//        for (int szam : tomb) {
//            System.out.println(szam);
//        }
        int db = 40;
        int max = 200;
        int[] szamok = new int[db];
        lottoSorsolas(szamok, max,db);
        szamok[12] = 17;
        Arrays.sort(szamok);

        System.out.println(lkr(szamok, 0, szamok.length, 17));
    }

    public static int lkr(int[] tomb, int bal, int jobb, int ertek){
        if (bal > jobb){
            return 0;
        } else {
            int center = (int)(Math.floor((bal + jobb) / 2));
            if (tomb[center] == ertek){
                return center;
            } else {
                if (tomb[center] > ertek) {
                    return lkr(tomb, bal, center - 1, ertek);
                } else {
                    return lkr(tomb, center + 1, jobb, ertek);
                }
            }
        }

    }

    public static int faktorialis(int N){
        if (N > 0) {
            return N * (faktorialis(N - 1));
        }
        return 1;
    }

    public static int hatvany(int a, int N){
        if (N > 0){
            return hatvany(a, N - 1) * a;
        }
        return 1;
    }

    static int[] winningNumbers;
    static int[] totalNumbers;

    public static int lottoSorsolas(int[] szamok, int max, int db){
        if (db > 0) {
            int proba = (int)(Math.random() * max + 1);
            boolean benneVan = Arrays.stream(szamok).anyMatch(szam -> szam == proba);

            if (benneVan){
                lottoSorsolas(szamok, max, db);
            } else {
                szamok[db - 1] = proba;
                lottoSorsolas(szamok, max, db - 1);
            }

        }
        return 0;
    }


}
