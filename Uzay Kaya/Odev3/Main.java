
package pkg14253039uzaykayaödev3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      //Kac tavsan ve kaplumbaga yarisacagini kullanicidan aliyoruz.  
        Scanner racer = new Scanner(System.in);
        
        System.out.print("Kac tane tavsan yarisacak : ");
        int hareIndex = racer.nextInt();
        System.out.print("Kac tane kaplumbaga yarisacak : ");
        int tortoiseIndex = racer.nextInt(); 
        
           Race startRace = new Race(hareIndex,tortoiseIndex);
           startRace.StartAnnouncement(hareIndex, tortoiseIndex);               
    }
    
}
