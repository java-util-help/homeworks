
package pkg14253039uzaykayaödev3;
import java.util.Random;
import java.util.Arrays;

public class Race {
       private String raceTrack[]; //Yaris kulvarini tanimlayan degisken.
       private int iteration;      //Iterasyonlarin indexini tutmak icin kullandigim degisken.
       Hare racerHare[];           //Yarisan tavsanlarin nesne dizisi.
       Tortoise racerTortoise[];   //Yarisan kaplumbagalarin nesne dizisi.

       //Degiskenlerin set ve get methodlari.
       public String[] getRaceTrack(){
            return raceTrack;
       }
       public int getIteration(){
            return iteration;
       }
       public void setRaceTrack(String raceTrack[]){
            this.raceTrack = raceTrack;
       }
       public void setIteration(int iteration){
            this.iteration = iteration;
       }

            public Race(int hareIndex,int tortoiseIndex){
            //Yarisacak tavsan sayisini ve kaplumbaga sayisini parametre olarak alan constructor.
                this.raceTrack = new String[70];                  //70 lik yaris kulvari.
                Arrays.fill(raceTrack, "_");                      //Kulvari en basta "_" ile doldurdum.
                this.iteration = 1;                               //Iterasyon 1'den itibaren baslattim.
            //Nesne dizilerini parametre olarak aldigimiz degerler ile olusturuyoruz(Kullanicidan aldigimiz degerler ile).
            //ve Dizi elemanlarini olusturuyoruz.
                this.racerHare = new Hare[hareIndex];
                this.racerTortoise = new Tortoise[tortoiseIndex];                
                    for(int createHare=0;createHare<hareIndex;createHare++){
                        racerHare[createHare] = new Hare();
                    }
                    for(int createTortoise=0;createTortoise<tortoiseIndex;createTortoise++){
                        racerTortoise[createTortoise] = new Tortoise();
                    }                    
            }
            void StartAnnouncement(int hareIndex,int tortoiseIndex){  
                Random Move = new Random();                                //Hareketleri sececegimiz sayiyi olusturmak icin random nesnesi yaratiyoruz.
                int MoveSelect,haresPosition,tortoisesPosition,winners=0;  //Kodun devaminda kullandigim degiskenler.              
                int winnerAnimals[] = new int[hareIndex+tortoiseIndex];    //Yarisi bitiren hayvanlari tutmak icin kullandigim dizi.
                
                while(true){
                //Yarisma bitene kadar donecek olan dongu yapisi.    
                    Arrays.fill(raceTrack, "_");   // Her iterasyonda konumlar degisecegi icin tekrar kulvari "_" ile doldurdum.                 
                    for(haresPosition=0;haresPosition<hareIndex;haresPosition++){
                        MoveSelect = Move.nextInt(100)+1;                       //1 ile 100 arasinda bir sayi tutmak icin. 
                        this.racerHare[haresPosition].NextHareMove(MoveSelect); //Tuttugumuz sayi ile tavsanlarin hareketlerini seciyoruz.
                        
                            if(racerHare[haresPosition].getCurrentHarePosition() == 70){
                                //Yarismadaki tavsanlardan yarisi bitirenleri indexleriyle diziye atiyoruz.
                                winnerAnimals[haresPosition] = haresPosition+1;
                                
                            }
                            if("_".equals(raceTrack[racerHare[haresPosition].getCurrentHarePosition()-1])){
                                //Eger tavsanin olusan pozisyonunun kulvarda karsiligi "_" ise baska yarismaci olmadigini anliyoruz.
                                raceTrack[racerHare[haresPosition].getCurrentHarePosition()-1] = "H"+(haresPosition+1);
                            }
                            else if(!"_".equals(raceTrack[racerHare[haresPosition].getCurrentHarePosition()-1])){
                                //Eger tavsanin olusan pozisyonunun kulvarda karsiligi "_" degil ise orada bulunan yarismaci ile ayni string icinde gosteriyoruz.
                                raceTrack[racerHare[haresPosition].getCurrentHarePosition()-1] += "-H"+(haresPosition+1);
                            }
                    }
                    for(tortoisesPosition=0;tortoisesPosition<tortoiseIndex;tortoisesPosition++){
                        //TAVSANLAR ICIN YUKARIDA YAPILAN ISLEMLERIN KAPLUMBAGALAR ICIN TEKRARI.
                        MoveSelect = Move.nextInt(100)+1;
                        this.racerTortoise[tortoisesPosition].NextTortoiseMove(MoveSelect); 
                            if(racerTortoise[tortoisesPosition].getCurrentTortoisePosition() == 70){
                                winnerAnimals[haresPosition+tortoisesPosition] = (tortoisesPosition +1);
                            }
                            if("_".equals(raceTrack[racerTortoise[tortoisesPosition].getCurrentTortoisePosition()-1])){
                                raceTrack[racerTortoise[tortoisesPosition].getCurrentTortoisePosition()-1] = "T"+(tortoisesPosition+1);
                            }
                            else if(!"_".equals(raceTrack[racerTortoise[tortoisesPosition].getCurrentTortoisePosition()-1])){
                                raceTrack[racerTortoise[tortoisesPosition].getCurrentTortoisePosition()-1] += "-T"+(tortoisesPosition+1);
                            }
                    }
                    ShowRaceState(); //Iterasyonun durumunu bastiran method.
                    
                    if(!"_".equals(raceTrack[69])){
                    /*
                            Yarismayi bitiren varsa yani kulvar dizisinin son elemani "_" 'a esit degil ise isteneni bastirip sonsuz while dongusunden
                        cikmak icin olusturdugum yapi.
                            Bu yapiyi ustteki hareketleri belirleyen forlarin icinde daha az satir kullanarak olusturmamamin sebebi yarismayi bitiren olup
                        olmadigini kontrol edip dongudan cikmak icin ilk olarak butun yarismacilarin hareketlerini tamamlaması gerekmesi(Esitlik icin).
                            Ornek olarak eger H1 70 oldugu an donguden cikip "Hare 1 wins yuch" yazdirirsam daha oyunun onun hareketi ile bitmesi gereken 
                        T1'in son rotasyonunu saymamis olucaz.(1 tavsan ve 1 kaplumbaga oldugunu ve kendi yapimi oyle kurdugum icin tavsan ile basladigimizi
                        referans aliyorum.)
                    */    
                        for(int winnerIndex=0;winnerIndex<hareIndex+tortoiseIndex;winnerIndex++){
                            if(winnerAnimals[winnerIndex] != 0){
                               winners++; //Kac tane kazanan oldugunu tutan degisken. 
                            }
                        }
                        for(int winnerIndex=0;winnerIndex<hareIndex+tortoiseIndex;winnerIndex++){
                            if(winners == 1 && winnerAnimals[winnerIndex] != 0 && winnerIndex < hareIndex){
                               /*Eger 1 tane kazanan var ise ve daha once kazanlarin indexlerini attigimiz dizi o an 0'a esit degilse 
                                 kazanan tavsanimizin indexini bulmus oluyoruz.
                                 Tavsan oldugunu anlamamizin sebebide hareIndexten kucuk dizi elemanlarinin tavsanlara ait olmasi.
                                */
                               System.out.println("HARE "+(winnerIndex+1)+" WINS!        YUCH!");
                               break;
                            }
                            else if(winners == 1 && winnerAnimals[winnerIndex] !=0 && winnerIndex >= hareIndex){
                               /*Eger 1 tane kazanan var ise ve daha once kazanlarin indexlerini attigimiz dizi o an 0'a esit degilse 
                                 kazanan kaplumbagamizin indexini bulmus oluyoruz.
                                 Kaplumbaga oldugunu anlamamizin sebebide hareIndexten buyuk veya esit dizi elemanlarinin tavsanlara ait olmasi.
                                */                                
                               System.out.println("TORTOISE "+(winnerIndex-(hareIndex-1))+" WINS!    YAY!");
                               break;
                            }                           
                            else if(winners>1){
                               /*Eger 1'den fazla kazanan yarismaci var ise dizi ıcından kazanlarin indexlerini ve tavsan veya kaplumbaga
                                 olup olmadiklarini bulup yazdiriyoruz.
                                 Yukarida ki yapilara benzer oldugu icin cok detayli aciklamadim.
                                */ 
                               System.out.print("It's a tie between");                                 
                               for(int tieIndex=0;tieIndex<hareIndex+tortoiseIndex;tieIndex++){
                                   if(winnerAnimals[tieIndex]!=0 && tieIndex<hareIndex){
                                      System.out.print(" HARE "+(tieIndex+1)); 
                                   }
                                   else if(winnerAnimals[tieIndex]!=0 && tieIndex>=hareIndex){
                                      System.out.print(" TORTOISE "+(tieIndex-(hareIndex-1)));
                                   }
                               }
                            System.out.println(); //BUILD SUCCESSFUL yazisini alta gecirmek icin.                                
                            break;                          
                            }
                        }  
                        break; // while dongusunden cikmak icin.
                    }     
                }            
            }
            void ShowRaceState(){
                
                    System.out.print(this.iteration+". iterasyon :"); //Iterasyonu belirtmek icin.
                    this.iteration++;                                 //Iterasyonu dongu ıcınde artirmak icin.
                    
                    for(int iterationLooks=0;iterationLooks<70;iterationLooks++){
                        //Iterasyonu goruntulemek icin.
                        System.out.print(this.raceTrack[iterationLooks]);
                    }   
                    System.out.println(); //Sonraki ıterasyona alt satirdan devam etmesi icin.               
            }
}
