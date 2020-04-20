import java.awt.*;

//Интерфейс, задающий новый тип - фигуру.
interface Figure{
    public int count();
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public  void draw(Graphics g);

}