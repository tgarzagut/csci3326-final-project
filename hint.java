import finalPackage.*;
public class hint 
{
    public static void main(String[] args) throws Exception {
        test app = new test();  
         
        int random = (int)(Math.random()*3)+1;
        if(random == 1){
            System.out.println(app.selectMovie());
        }
        else if(random == 2){
            System.out.println(app.selectAnimals());
        }
        else{
            System.out.println(app.selectAnimals());
        }  
    }
}
