package busbokning;

import java.util.Scanner;

public class BussresaBokningssystem {

    public static void main(String[] args) {

        int antalBokadePlatser = 0;
        int maxAntalPlatser = 21;
        int[] bokadePlatser = new int[maxAntalPlatser];
        int vuxenbiljett = 0;
        int barnbiljett = 0;
        int pensionär = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Välkommen till bokningssystemet för bussresa!");
            System.out.println("Vänligen välj en av följande alternativ:");
            System.out.println("1. Lägg till en passagerare – boka en obokad plats");
            System.out.println("2. Skriv ut hur många lediga platser det finns");
            System.out.println("3. Hitta bokad plats efter personnummer");
            System.out.println("4. Ta bort bokad plats efter personnummer");
            System.out.println("5. Beräkna total vinnst med alla åldersklasser");
            System.out.println("6. Skriv ut alla personer över och under 18 år");
            System.out.println("7. Boka fönsterplats");
            System.out.println("8. Avsluta programmet");

            int val = input.nextInt();
            switch (val) {
                case 1:
                    System.out.println("Ange födelsedatum (yyyymmdd) för passageraren:");
                    int fodelseDatum = input.nextInt();
                    if (antalBokadePlatser == maxAntalPlatser) {
                        System.out.println("Tyvärr är alla platser uppbokade.");
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
                    System.out.println("Ange personnummer som söks, yyyymmdd");
                    int pnrs = input.nextInt();
                    int ingenplatshittad = 1;
                    for (int z = 0; z < 21; z++) {
                        if (bokadePlatser[z] == pnrs){
                            System.out.println("Det finns en plats bokad under personnummret: "+pnrs +" på plats "+(z+1) +" i bussen");
                            ingenplatshittad = 0;
                        }                        
                }
                    if (ingenplatshittad == 1){
                        System.out.println("Det finns inga platser bokade under personnummret "+pnrs);
                    }
                    break;
                case 4:
                   System.out.println("Ange personnummer som söks, yyyymmdd");
                    pnrs = input.nextInt();
                    ingenplatshittad = 1;
                    for (int z = 0; z < 21; z++) {
                        if (bokadePlatser[z] == pnrs){
                            System.out.println("Det finns en plats bokad under personnummret: "+pnrs +" på plats "+(z+1) +" i bussen. Denna bokning är nu borttagen");
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
                            pensionär++;
                            break;
                        }
                    }
                    double slutpris = (vuxenbiljett * 299.90) + (barnbiljett*149.90) + (pensionär*200.0) ;
                    System.out.println("Vinnsten av alla sålda biljetter ligger på "+slutpris);
                    break;
                case 6:
                    for (int z = 0; z < 21; z++) {
                        if(20230512 - bokadePlatser[z] == 20230512){
                            System.out.println("Inga fler platser är uppbokade");
                            break;
                            }
                        else if (20230512 - bokadePlatser[z] > 180000){
                            System.out.println("Plats " +(z+1)+" är uppbokad av en person över 18 år");
                        }
                        else if(20230512 - bokadePlatser[z] < 180000){
                            System.out.println("Plats " +(z+1)+" är uppbokad av en person under 18 år");
                                }                       
                    }
                   
                    break;
                case 7:
                    if (antalBokadePlatser == maxAntalPlatser) {
                        System.out.println("Tyvärr är alla platser uppbokade.");
                    } 
                    else{
                        System.out.println("Ange födelsedatum (yyyymmdd) för passageraren:");
                        fodelseDatum = input.nextInt();
                        for(int i = 0; i < maxAntalPlatser; i++) {
                            if(bokadePlatser[i] > 0){
                                i++;
                            }
                            else if(i%4 == 0 || (i-1)%4 == 0){
                            bokadePlatser[i] = fodelseDatum;
                            antalBokadePlatser++;
                            System.out.println("Fönsterplats bokad!");
                            break;
                        }
                        }
                        break;
                    }
                case 8:
                    System.out.println("Tack för besöket!");
                    System.exit(0);   
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}
