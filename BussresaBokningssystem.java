package busbokning;

import java.util.Scanner;

public class BussresaBokningssystem {

    public static void main(String[] args) {

        int antalBokadePlatser = 0;
        int maxAntalPlatser = 21;
        int[] bokadePlatser = new int[maxAntalPlatser];
        int vuxenbiljett = 0;
        int barnbiljett = 0;
        int pension�r = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("V�lkommen till bokningssystemet f�r bussresa!");
            System.out.println("V�nligen v�lj en av f�ljande alternativ:");
            System.out.println("1. L�gg till en passagerare � boka en obokad plats");
            System.out.println("2. Skriv ut hur m�nga lediga platser det finns");
            System.out.println("3. Hitta bokad plats efter personnummer");
            System.out.println("4. Ta bort bokad plats efter personnummer");
            System.out.println("5. Ber�kna total vinnst med alla �ldersklasser");
            System.out.println("6. Skriv ut alla personer �ver och under 18 �r");
            System.out.println("7. Boka f�nsterplats");
            System.out.println("8. Avsluta programmet");

            int val = input.nextInt();
            switch (val) {
                case 1:
                    System.out.println("Ange f�delsedatum (yyyymmdd) f�r passageraren:");
                    int fodelseDatum = input.nextInt();
                    if (antalBokadePlatser == maxAntalPlatser) {
                        System.out.println("Tyv�rr �r alla platser uppbokade.");
                    } else {
                        for (int i = 0; i <= maxAntalPlatser; i++) {
                        
                            if (bokadePlatser[i] == 0) {
                                bokadePlatser[i] = fodelseDatum;
                                antalBokadePlatser++;
                                System.out.println("Plats bokad!");
                                break;
                                }
                            }
                        }
                    
                    break;
                case 2:
                    int ledigaPlatser = maxAntalPlatser - antalBokadePlatser;
                    System.out.println("Antal lediga platser: " + ledigaPlatser);
                    break;
                case 3:
                    System.out.println("Ange personnummer som s�ks, yyyymmdd");
                    int pnrs = input.nextInt();
                    int ingenplatshittad = 1;
                    for (int z = 0; z < 21; z++) {
                        if (bokadePlatser[z] == pnrs){
                            System.out.println("Det finns en plats bokad under personnummret: "+pnrs +" p� plats "+(z+1) +" i bussen");
                            ingenplatshittad = 0;
                        }                        
                }
                    if (ingenplatshittad == 1){
                        System.out.println("Det finns inga platser bokade under personnummret "+pnrs);
                    }
                    break;
                case 4:
                   System.out.println("Ange personnummer som s�ks, yyyymmdd");
                    pnrs = input.nextInt();
                    ingenplatshittad = 1;
                    for (int z = 0; z < 21; z++) {
                        if (bokadePlatser[z] == pnrs){
                            System.out.println("Det finns en plats bokad under personnummret: "+pnrs +" p� plats "+(z+1) +" i bussen. Denna bokning �r nu borttagen");
                            bokadePlatser[z] = 0;
                            ingenplatshittad = 0;
                        }                        
                }
                    if (ingenplatshittad == 1){
                        System.out.println("Det finns inga platser bokade under personnummret "+pnrs +" som kan tas bort");
                    }
                    break;
                
                case 5:
                    for (int z = 0; z < 21; z++) {
                        if (20230512 - bokadePlatser[z] >= 180000 && 20230512 - bokadePlatser[z] <= 690000 ){
                            vuxenbiljett++;
                            break;
                        }
                        else if(20230512 - bokadePlatser[z] < 180000){
                            barnbiljett++;
                            break;
                        }
                        else if(20230512 - bokadePlatser[z] > 690000 ){
                            pension�r++;
                            break;
                        }
                    }
                    double slutpris = (vuxenbiljett * 299.90) + (barnbiljett*149.90) + (pension�r*200.0) ;
                    System.out.println("Vinnsten av alla s�lda biljetter ligger p� "+slutpris);
                    break;
                case 6:
                    for (int z = 0; z < 21; z++) {
                        if(20230512 - bokadePlatser[z] == 20230512){
                            System.out.println("Inga fler platser �r uppbokade");
                            break;
                            }
                        else if (20230512 - bokadePlatser[z] > 180000){
                            System.out.println("Plats " +(z+1)+" �r uppbokad av en person �ver 18 �r");
                        }
                        else if(20230512 - bokadePlatser[z] < 180000){
                            System.out.println("Plats " +(z+1)+" �r uppbokad av en person under 18 �r");
                                }                       
                    }
                   
                    break;
                case 7:
                    if (antalBokadePlatser == maxAntalPlatser) {
                        System.out.println("Tyv�rr �r alla platser uppbokade.");
                    } 
                    else{
                        System.out.println("Ange f�delsedatum (yyyymmdd) f�r passageraren:");
                        fodelseDatum = input.nextInt();
                        for(int i = 0; i < maxAntalPlatser; i++) {
                            if(bokadePlatser[i] > 0){
                                i++;
                            }
                            else if(i%4 == 0 || (i-1)%4 == 0){
                            bokadePlatser[i] = fodelseDatum;
                            antalBokadePlatser++;
                            System.out.println("F�nsterplats bokad!");
                            break;
                        }
                        }
                        break;
                    }
                case 8:
                    System.out.println("Tack f�r bes�ket!");
                    System.exit(0);   
                default:
                    System.out.println("Ogiltigt val. F�rs�k igen.");
            }
        }
    }
}
