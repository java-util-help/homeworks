
package pkg14253039uzaykayaödev3;

public class Hare {
        private int currentHarePosition;
        enum HarePlays{SLEEP,BIGHOP,BIGSLIP,SMALLHOP,SMALLSLIP}; //Tavşanlarin hareketleri.
        HarePlays harePlay;
        public int getCurrentHarePosition(){
            return currentHarePosition;
        }
        public void setCurrentHarePosition(int currentHarePosition){
            this.currentHarePosition = currentHarePosition;  
        }
        
            public Hare(){
                this.currentHarePosition = 1; //Başlangic pozisyonu.
            }
            
            void NextHareMove(int randomValue){
                /*Gelecek olan random sayıya göre secilecek hareketin pozisyona etkisini gösteren ve
                  eger 70'i gecerse kontrol kolayligi acisindan 70'e ve 1'den az duruma gelirse 1'e esitleyen method.  
                */    
                if(randomValue>=1 && randomValue<=20){
                   harePlay = HarePlays.SLEEP;
                }
                else if(randomValue>=21 && randomValue<=40){
                   harePlay = HarePlays.BIGHOP;
                   this.currentHarePosition += 9; 
                            if(this.currentHarePosition>70){
                               this.currentHarePosition = 70 ;
                            }                   
                }       
                else if(randomValue>=41 && randomValue<=50){
                   harePlay = HarePlays.BIGSLIP;
                   this.currentHarePosition -= 9;
                            if(this.currentHarePosition<1){
                               this.currentHarePosition = 1 ;
                            }
                }    
                else if(randomValue>=51 && randomValue<=80){
                   harePlay = HarePlays.SMALLHOP;   
                   this.currentHarePosition += 1;
                            if(this.currentHarePosition>70){
                               this.currentHarePosition = 70 ;
                            }                   
                }
                else if(randomValue>=81 && randomValue<=100){
                   harePlay = HarePlays.SMALLSLIP; 
                   this.currentHarePosition -= 2; 
                            if(this.currentHarePosition<1){
                               this.currentHarePosition = 1 ;
                            }                   
                }
            }            
}
