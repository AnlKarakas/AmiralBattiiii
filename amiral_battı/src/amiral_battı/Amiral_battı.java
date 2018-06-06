/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiral_battı;

import java.util.Scanner;

/**
 *
 * @author Emre
 */
public class Amiral_battı {

       public static void main(String args[]) throws Exception
   {
 
      java.util.Random generator = new java.util.Random(System.currentTimeMillis());
 
      //gemilerin yerleştirildiği matris
      int tahta[][] = new int [10][10];
 
      //oyuncunun hamlelerinin tutulduğu matris
      int oyuncu[][] = new int [10][10];
 
      //gemilerin adedini tutan dizi  
      int gemi[] = {0, 4, 3, 2, 1};
 
      int i, j, satır, sutun;
      int yön, gemiBuyuklugu, sayac, satırKordinat, sutunKordinat, satırSınır, sutunSınır, kontrol;
      int sag, asagı, isabet;
 
      satır = 10;
      sutun = 10;
 
      sayac = 0;
      gemiBuyuklugu = 1;
 
      while (gemiBuyuklugu <= 4) {
         //yon üretiliyor (0 sağa, 1 aşağıya)
         yön = generator.nextInt(2);
 
         //yöne göre satır sütun sınırları ve yerleştirilecek geminin sınırları belirleniyor
         if (yön == 0) {
            satırSınır = satır;
            sutunSınır = sutun - gemiBuyuklugu + 1;
            sag = 2 + gemiBuyuklugu;
            asagı = 3;
         }
         else {
            satırSınır = satır - gemiBuyuklugu + 1;
            sutunSınır = sutun;
            sag = 3;
            asagı = 2 + gemiBuyuklugu;
         }
 
         //geminin nereye yerleştirileceği üretiliyor
         satırKordinat = generator.nextInt(satırSınır);
         sutunKordinat = generator.nextInt(sutunSınır);
 
         //geminin yerleştirileceği yerin boş olup olmadığına bakılıyor
         kontrol = 0;
         for (i = satırKordinat-1; i < (satırKordinat-1) + asagı; i = i + 1)
            for (j = sutunKordinat-1; j < (sutunKordinat-1) + sag; j = j + 1)
               if (i >=0 && i < satır && j >= 0 && j < sutun)
                  if (tahta[i][j] != 0)
                     kontrol = 1;
 
         //kontrol'ün 0'a eşit olması geminin yerleştirileceği yerin boş olduğunu gösteriyor.
         if (kontrol == 0) {
            //gemi yerleştiriliyor
            for (i = satırKordinat; i < satırKordinat + asagı - 2; i = i + 1)
               for (j = sutunKordinat; j < sutunKordinat + sag - 2; j = j + 1)
                  tahta[i][j] = gemiBuyuklugu;
 
            //adet bir arttırılıyor
            sayac = sayac + 1;
 
            //gemiden istenen adet yerleştirilmişse bir sonraki gemiye geçiliyor
            if (gemi[gemiBuyuklugu] == sayac) {
               gemiBuyuklugu = gemiBuyuklugu + 1;
               sayac = 0;
 
            }
         }
      }
 
      System.out.println();
 
      //toplam 20 isabetli atış yapıldığında oyun bitiyor
      sayac = 0;
      isabet = 0;
      while(isabet < 20) {
         //atış sayısı bir arttırılıyor
         sayac = sayac + 1;
 
         //atış yapılıyor
         Scanner input = new Scanner(System.in);
         System.out.print("Satiri giriniz : ");
         satırKordinat = input.nextInt();
         if(satırKordinat < 1 || satırKordinat > 10) {
            System.out.print("Satiri giriniz : ");
            satırKordinat = input.nextInt();
         }
         satırKordinat = satırKordinat -1;
         System.out.print("Sutunu giriniz : ");
         sutunKordinat = input.nextInt();
         if(sutunKordinat < 1 || sutunKordinat > 10) {
            System.out.print("Satiri giriniz : ");
            sutunKordinat = input.nextInt();
         }
         sutunKordinat = sutunKordinat - 1;
 
 
 
         //atışın isabetli olup olmadığına bakılıyor 
         //eğer isabetli ise oyuncunun matrisine
         //gemi numarası yazdırılıyor
         //değilse 9 sayısı yazdırılıyor
         if (tahta[satırKordinat][sutunKordinat] != 0){
            isabet = isabet + 1;
            oyuncu[satırKordinat][sutunKordinat] = tahta[satırKordinat][sutunKordinat];
         }
         else
            oyuncu[satırKordinat][sutunKordinat] = 9;

         //oyuncunun matrisi yazdırılıyor
         for (i = 0; i < satır; i = i + 1) {
            for (j = 0; j < sutun; j = j + 1) 
               System.out.print(oyuncu[i][j] + " ");
            System.out.println();
         }
      }
      System.out.println("Tebrikler! " + sayac + " adimda tamamladınız."); 
   }
    
}
