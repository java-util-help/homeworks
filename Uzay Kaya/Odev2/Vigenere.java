
package pkg14253039uzaykayaödev2;

import java.util.Scanner;

public final class Vigenere {
         private String inputMessage;
         private String lockWord;
         private String lockWordUptade;
         private String alphabet = "abcdefghijklmnopqrstuvwxyz";
                    public String getInputMessage(){
                              return inputMessage;
                    }
                    public String getLockWord(){
                              return lockWord;
                    }
                    public String getLockWordUptade(){
                              return lockWordUptade;
                    }
                    public String getAlphabet(){
                              return alphabet; 
                    }
                    public void setInputMessage(String inputMessage){
                              this.inputMessage = inputMessage;
                    }
                    public void setLockWord(String lockWord){
                              this.lockWord = lockWord;
                    }
                    public void setLockWordUptade(String lockWordUptade){
                              this.lockWordUptade = lockWordUptade;
                    }
                    public void setAlphabet(String alphabet){
                              this.alphabet = alphabet;
                    }
                    public Vigenere(){
                    /*Kullanıcıdan stringleri almak ve mesajın uzunlugunu kilit kelimesinin uzunluguyla karsılastıran constructor.  
                       Aynı zamanda girilen metinlerde gömdügüm alfabeden farkli bir karakter varsa hata veren kontrol yapisi. 
                    */  
                    for(;;){
                              Scanner input = new Scanner(System.in);  
                              int inputControl=0,loopControl1=0,loopControl2=0,i,j;
                              
                              //Kullanicidan alinan mesaj.
                              System.out.print("Sifrelemek istediginiz mesaji giriniz : ");
                              String Message = input.nextLine();
                              setInputMessage(Message);

                              //Kullanicidan alinan sifre sozcuk.
                              System.out.print("Sifre kelimeyi giriniz : ");
                              String Lock = input.nextLine();
                              setLockWord(Lock);
                              
                               //Gereksiz bosluklardan kurtulmak icin.
                              String spaceUptade1 = getInputMessage().replace(" ", "");
                              setInputMessage(spaceUptade1);
                              String spaceUptade2 = getLockWord().replace(" ", "");
                              setLockWord(spaceUptade2);
                              
                              //Buyuk girilen harfleri kucultmek icin.
                              String letterUptade1 = getInputMessage().toLowerCase();
                              setInputMessage(letterUptade1);
                              String letterUptade2 = getLockWord().toLowerCase();
                              setLockWord(letterUptade2);
                              
                              
                                        if(getLockWord().length()>getInputMessage().length()){
                                        /*(Burayada mı append islemi yapacaktık emin olamadim EDS'de verilen ornek uzerinden boyle bir kontrol koydum.)    
                                            Sifre kelime daha uzunsa tekrar kullanicidan girdi almamizi saglayan kontrol yapisi.
                                            */
                                                  System.out.println("Sifre kelimesi sifrelemek istediginiz mesajdan uzun olamaz !\nTekrar Deneyiniz :\n "); //Hata Mesaji.
                                        }
                                        else{
                                        /*
                                            Yukarida ki kontrol sarti saglandiktan sonra sifre kelimede veya mesajimizda gomdugum alfabeden farkli bir 
                                            karakter varsa kullanicidan tekrar girdi alan kontrol yapisi.(Bunun icin direkt kullanilan bir method var miydi bulamadim
                                            o yüzden algoritmasini kendim yazdim.)
                                            */    
                                                  for(i=0;i<getLockWord().length();i++){
                                                  //Sifre kelimesini kontrol eden dongu yapisi.    
                                                            for(j=0;j<getAlphabet().length();j++){
                                                                      if(getLockWord().charAt(i)==getAlphabet().charAt(j)){
                                                                                inputControl++;    //Gomulu alfabe ile olan eslestirme sonucunu tutmak icin.
                                                                                loopControl1++;   //Butun kontrol yapilari sorunsuz olduktan sonra sonsuz donguden cıkmak icin(Asagidaki if yapisinda.).
                                                                      }
                                                            }
                                                            if(inputControl==0){
                                                                      System.out.println("Sifre kelimenizde hatali karakter vardir!\nTekrar Deneyiniz :\n"); //Hata Mesaji.
                                                                      break;
                                                            }
                                                  inputControl = 0;          
                                                  }                                                   
                                                  for(i=0;i<getInputMessage().length();i++){
                                                  //Mesaj kelimesini kontrol eden dongu yapisi.    
                                                            for(j=0;j<getAlphabet().length();j++){
                                                                      if(getInputMessage().charAt(i)==getAlphabet().charAt(j)){
                                                                                inputControl++;    //Gomulu alfabe ile olan eslestirme sonucunu tutmak icin.
                                                                                loopControl2++;   //Butun kontrol yapilari sorunsuz olduktan sonra sonsuz donguden cıkmak icin(Asagidaki if yapisinda.).
                                                                      }
                                                            }
                                                            if(inputControl==0){
                                                                      System.out.println("Sifrelemek istediginiz mesajda hatali karakter vardir!\nTekrar Deneyiniz :\n"); //Hata Mesaji
                                                                      break;
                                                            }
                                                  inputControl = 0;          
                                                  } 
                                                  if(loopControl1==getLockWord().length() && loopControl2==getInputMessage().length()){
                                                  //Yukarida ki yorum satirlarinda bahsettigim butun kontrol yapilari sorunsuz oldugunda donguden cikmak icin olan yapi.
                                                            break; 
                                                  }
                                        }
                              }
                    }
                    void Equalizer(){
                              //StringBuilder ile kilit kelimesi ile mesaj arasındaki harf farkını kilit kelimesine ekleyen method.    
                              StringBuilder builder = new StringBuilder();
                              
                              int lengthDiff;
                              lengthDiff = getInputMessage().length() - getLockWord().length(); //Mesaj ile sifre kelime arasindaki string uzunluk farki.
                              builder.append(getLockWord()); //Buildera ilk olarak sifre kelimemizi ekledim.
                              
                                        while(lengthDiff>getLockWord().length()){
                                        //Eger fark sifre kelimeden daha uzunsa yukaridaki islemi birkez daha yapip lengthDiff degiskeninden dustum.    
                                                  builder.append(getLockWord());
                                                  lengthDiff = lengthDiff - getLockWord().length();
                                        }
                                        for(int i=0;i<lengthDiff;i++){
                                        //Uzunluk farkini sifre kelimeden kisa hale getirdikten sonra harfleri kalan harfleri ekledim..    
                                                  builder.append(getLockWord().charAt(i));     
                                        }                                        
                                        
                              //Sifre kelimemizin son halini LockWordUptade'e atadim.          
                              String newLock = builder.toString();
                              setLockWordUptade(newLock);
                              
                              //System.out.println(lockWordUptade); Kilit kelimesinin son hali    
                    }  
                    void Converter(){
                    //Stringlerdeki harfleri gomulu olan alfabedeki sıraya cevirip toplayıp tekrar harfe çeviren method.    
                    int lockIndex;
                    System.out.print("Sifreniz : ");
                              for(int i=0; i<getInputMessage().length(); i++){
                              /*LockWordUptade'in uzunlugu artik mesajla ayni oldugu icin dongu kosuluna ne koydugumuz farketmez.    
                                 Mesajdaki ve sifre kelimede ki harfleri charAt ile cekip gomdugum alfabedeki indexlerini buldum ve 1 ekledim(0'dan baslatmamak icin).
                                  */
                                        lockIndex = (getAlphabet().indexOf(getInputMessage().charAt(i))+1)+(getAlphabet().indexOf(getLockWordUptade().charAt(i))+1);
                                                  if(lockIndex<=26){
                                                            System.out.print(getAlphabet().charAt(lockIndex-1)+" ");
                                                  }
                                                  else{
                                                  //Eger lockIndex gomdugum alfabenın uzunlugundan yani 26'dan(ingiliz alfabesi) fazla cikarsa tekrar basa donmesi icin 26 cikarip islemi yapiyoruz.    
                                                            lockIndex = lockIndex- 26;
                                                            System.out.print(getAlphabet().charAt(lockIndex-1)+" ");
                                                  }
                              }
                    System.out.println(""); //Sonda bir satir alta indirmek icin.
                    }
}
