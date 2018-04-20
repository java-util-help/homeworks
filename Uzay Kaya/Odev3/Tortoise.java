
package pkg14253039uzaykayaödev3;

public class Tortoise {
        private int currentTortoisePosition;
        enum TortoisePlays{FASTPLOD,SLIP,SLOWPLOD};//Kaplumbagalarin hareketleri.
        TortoisePlays tortoisePlay;
        public int getCurrentTortoisePosition(){
            return currentTortoisePosition;
        }
        public void setCurrentTortoisePosition(int currentTortoisePosition){
            this.currentTortoisePosition = currentTortoisePosition;
        }
        
            public Tortoise(){
                this.currentTortoisePosition = 1; //Baslangic pozisyonu.
            }
       
            void NextTortoiseMove(int randomValue){
                /*Gelecek olan random sayıya göre secilecek hareketin pozisyona etkisini gösteren ve
                  eger 70'i gecerse kontrol kolayligi acisindan 70'e ve 1'den az duruma gelirse 1'e esitleyen method.                  
                */
                    if(randomValue>=1 && randomValue<=50){
                        tortoisePlay = TortoisePlays.FASTPLOD;
                        this.currentTortoisePosition += 3;
                            if(this.currentTortoisePosition>70){
                                this.currentTortoisePosition = 70 ;
                            }                            
                    }
                    else if(randomValue>=51 && randomValue<=70){
                        tortoisePlay = TortoisePlays.SLIP;
                        this.currentTortoisePosition -= 6; 
                            if(this.currentTortoisePosition<1){
                                this.currentTortoisePosition = 1;                                   
                            }
                    }  
                    else if(randomValue>=71 && randomValue<=100){
                        tortoisePlay = TortoisePlays.SLOWPLOD;
                        this.currentTortoisePosition += 1; 
                            if(this.currentTortoisePosition>70){
                                this.currentTortoisePosition = 70 ;
                            }                            
                    }                       
            }
}
