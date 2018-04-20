
package pkg14253039uzaykayaödev2;
import java.util.Scanner;

public class Dikdörtgen {
           private double length;
           private double weight;
           private double x;
           private double y;
           public double getLength(){
                    return length;
           }
           public double getWeight(){
                    return weight;
           }
           public double getX(){
                    return x;
           }    
           public double getY(){
                    return y;
           }         
           public void setLength(double length){
                    this.length = length;
           }
           public void setWeight(double weight){
                    this.weight = weight;
           }
           public void setX(double x){
                    this.x= x;
           }     
           public void setY(double y){
                    this.y= y;
           }   
                    public Dikdörtgen(){
                    //Constructor default olarak secilirse kullanicidan girdi aldim.    
                              Scanner input = new Scanner(System.in);
                              
                              System.out.print("Dikdortgenin uzunlugunu kenarini giriniz : ");
                              double uzunluk = input.nextDouble();
                              setLength(uzunluk);
                              
                              System.out.print("Dikdortgenin genisligini kenarini giriniz : ");
                              double en = input.nextDouble();
                              setWeight(en); 
                              
                              System.out.print("Dikdortgenin sol alt kösesinin apsinini giriniz : ");
                              double apsis = input.nextDouble();
                              setX(apsis);   
                              
                              System.out.print("Dikdortgenin sol alt kösesinin ordinatini giriniz : ");
                              double ordinat = input.nextDouble();
                              setY(ordinat);                              
                    }
                    public Dikdörtgen(double length,double weight,double x,double y){
                    //Degerleri parametre olarak atadigimiz constructor.    
                              this.length = length;
                              this.weight = weight;
                              this.x = x;
                              this.y = y;
                    }
                              void MoveRectangle(int switchX,int switchY){
                              /*Dikdortgeni hareket ettirdigimiz x'in ve y'nin degisim miktarlarini parametre olarak alan method.
                                 Sadece x ve y ekseninde kaydirma yaptirmak istedigimiz icin parametrelerden biri 0 olarak girilmeli(?).
                                  */    
                                        Scanner Move = new Scanner(System.in);
                                        
                                        //Kaydirmayi ne yonde yapmak istedigimizi soran switch-case yapisi.
                                        System.out.print("1 - Yukari\n2 - Asagi\n3 - Sol\n4 - Sag\nDikdörtgeni ne tarafa dogru hareket ettirmek istediginizi seciniz : ");
                                        int secim = Move.nextInt();
                                                  switch(secim){
                                                      case 1:         
                                                            setY(getY()+switchY);
                                                            //X = 0 olacagi icin sadece Y üstünde pozitif islem yaptım.
                                                            break;
                                                      case 2:
                                                            switchY = switchY*(-1);
                                                            setY(getY()+switchY);
                                                            //X = 0 olacagi icin sadece Y üstünde NEGATIF islem yaptım.
                                                            break;
                                                      case 3:
                                                            switchX = switchX*(-1);
                                                            setX(getX()+switchX);
                                                            //Y = 0 olacagi icin sadece X üstünde NEGATIF islem yaptım.
                                                            break;
                                                      case 4:
                                                            setX(getX()+switchX);
                                                            //Y = 0 olacagi icin sadece X üstünde pozitif islem yaptım.
                                                            break; 
                                                      default:
                                                            System.out.println("Hatali secim ! ");
                                                            break;
                                                  }
                                                 
                                        System.out.println("Kaydirdiktan sonraki kordinatlar :\nX : "+getX()+"\nY : "+getY());
                              }
                              double PerimeterRectangle(){
                                        double Perimeter;
                                        Perimeter = (getLength()+getWeight())*2; //Kenarlar toplaminin 2 kati ile cevreyi hesapladim.
                                        return Perimeter;
                              }
                              double AreaRectangle(){
                                        double Area;
                                        Area = getLength()*getWeight(); //Kenarlar carpimi ile alani hesapladim.
                                        return Area;
                              }
}
