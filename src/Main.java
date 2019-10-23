
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Reyhan
 */
public class Main {

    private static DecimalFormat decimalFormat = new DecimalFormat();
    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Integer> arrayListPersamaan = new ArrayList<>();
    private static ArrayList<Integer> arrayListTurunanPersamaan = new ArrayList<>();
    private static ArrayList<NewtonRaphson> arrayListNewtonRaphson = new ArrayList<>();

    private static String ulang;
    private static int i;
    private static double error, xr, xr1, fxr, ftxr, xr1xr;
    private static String iterasi;

    public static void main(String[] args) {
        
        decimalFormat.applyPattern("###.########");

        do {
            ulang = "t";
            System.out.print("Masukkan Koefisien Persamaan: ");
            i = scanner.nextInt();
            if (i != 0) {
                arrayListPersamaan.add(i);
                do {
                    System.out.print("Apakah anda ingin menambah koefisien? (Y\\T) ");
                    ulang = scanner.next();
                } while (!(ulang.equalsIgnoreCase("t") || ulang.equalsIgnoreCase("y")));
            } else {
                System.out.println("Maaf, nilai koefisien tidak boleh \"0\"");
            }
            System.out.println("");
        } while (ulang.equalsIgnoreCase("y") || i == 0);

        for (int i = 0, j = arrayListPersamaan.size() - 1; i < arrayListPersamaan.size() - 1; i++, j--) {
            arrayListTurunanPersamaan.add(arrayListPersamaan.get(i) * j);
        }
        
        System.out.print("Masukkan nilai titik awal: ");
        xr = scanner.nextDouble();
        System.out.println("");
        System.out.print("Masukkan nilai error: ");
        error = scanner.nextDouble();
        
        do {
            NewtonRaphson nr = new NewtonRaphson();
            nr.setXr(xr);
            
            fxr = 0;
            for (int j = 0, k = arrayListPersamaan.size() - 1; j < arrayListPersamaan.size() - 1; j++, k--) {
                fxr = fxr + (arrayListPersamaan.get(j) * Math.pow(xr, k));
            }
            fxr = fxr + arrayListPersamaan.get(arrayListPersamaan.size()-1);
            nr.setFxr(fxr);
            
            ftxr = 0;
            for (int j = 0, k = arrayListTurunanPersamaan.size() - 1; j < arrayListTurunanPersamaan.size() - 1; j++, k--) {
                ftxr = ftxr + (arrayListTurunanPersamaan.get(j) * Math.pow(xr, k));
            }
            ftxr = ftxr + arrayListTurunanPersamaan.get(arrayListTurunanPersamaan.size()-1);
            nr.setFtxr(ftxr);
            
            xr1 = xr - (fxr/ftxr);
            nr.setXr1(xr1);
            
            xr1xr = xr1 - xr;
            if (xr1xr < 0) {
                xr1xr = xr1xr * -1;
            }
            nr.setXr1xr(xr1xr);
            
            iterasi = "Lanjut";
            if (xr1xr < error) {
                iterasi = "Berhenti";
            }
            nr.setIterasi(iterasi);
            
            arrayListNewtonRaphson.add(nr);
            
            xr = xr1;
        } while (iterasi.equalsIgnoreCase("Lanjut"));
        
        for (int j = 0; j < arrayListNewtonRaphson.size(); j++) {
            System.out.print(String.valueOf(j));
            System.out.print("\t" + decimalFormat.format(arrayListNewtonRaphson.get(j).getXr()));
            System.out.print("\t" + decimalFormat.format(arrayListNewtonRaphson.get(j).getXr1()));
            System.out.print("\t" + decimalFormat.format(arrayListNewtonRaphson.get(j).getFxr()));
            System.out.print("\t" + decimalFormat.format(arrayListNewtonRaphson.get(j).getFtxr()));
            System.out.print("\t" + decimalFormat.format(arrayListNewtonRaphson.get(j).getXr1xr()));
            System.out.print("\t" + arrayListNewtonRaphson.get(j).getIterasi());
            System.out.println("");
        }
    }
}
