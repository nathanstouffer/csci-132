/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.lab.pkg4;

/**
 *
 * @author natha
 */
public class InLab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Start();
    }
    
    public static void Start(){
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
    }
    
    public static void questionOne(){
        Person pOne = new Person("First");
        Person pTwo = new Person("Second");
        int a = 5;
        pOne = pTwo.changeName(pTwo, pOne, a);
        System.out.println(pOne.getName()); //8
        System.out.println(a); //9
        System.out.println( pTwo.getName()); //10
    }
    
    public static void questionTwo(){
        Daffy quack = new Daffy("funny", 6);
        Daffy webbed = new Daffy("silly");
        Daffy beak = quack;
        quack = quack.testQuestion(beak, webbed, new Daffy("tickly", 2));
        System.out.println(quack.getFeature()); // Statement 4
        System.out.println(webbed.getFeature()); // Statement 5
        System.out.println(beak.getFeature()); // Statement 6
        System.out.println(beak.num); // Statement 7
    }
    
    public static void questionThree(){
        Car tow = new Car("Mater");
        Garage radiatorSprings = new Garage(new Car("McQueen"));
        Car lizzie = new Car();


        System.out.println(tow.getName()); //Print statement one
        System.out.println(radiatorSprings.getName()); //print statement two
        System.out.println(lizzie.getName()); //print statement three

        radiatorSprings.setCar(tow.testQuestion(radiatorSprings, new Garage(new Car("Sally")), lizzie));

        System.out.println(tow.getName()); //print statement ten
        System.out.println(radiatorSprings.getName()); //print statement eleven
        System.out.println(lizzie.getName()); //print statement twelve
    }
    
    public static void questionFour(){
        Band frampton = new Band( "Alive", 6000);
        RecordCompany warner = new RecordCompany(new Band("Devo", 1000));
        Band startUp = new Band(30);    
        RecordCompany rca = new RecordCompany(warner.getBand());

        System.out.println(frampton.getAlbum()); //Question 1
        System.out.println(warner.getAlbum()); //Question 2
        System.out.println(startUp.getAlbum()); //Question 3

        rca = frampton.testQuestion(warner, new RecordCompany(new Band(9)), rca.getBand());

        System.out.println(frampton.getAlbum()); //Question 12
        System.out.println(warner.getAlbum()); //Question 13
        System.out.println(startUp.getAlbum()); //Question 14
        System.out.println(warner.getBand().count); //Question 15

    }

}
