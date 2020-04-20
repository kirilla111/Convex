import java.io.File;
import java.io.FileWriter;

//Тест для выпуклой оболочки.
class ConvexTest{
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();


        while(true){
            MyFrame f = new MyFrame(convex);

            convex.add(new R2Point());
            System.out.println("Количество ребер внутри квадрата 3x3: " +convex.count());
            System.out.println("S = " + convex.area()+ ", P = " + convex.perimeter());
            f.hide();
        }
    }
}
