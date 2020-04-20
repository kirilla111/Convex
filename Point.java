import java.awt.*;

//Класс "Одноугольник", реализующий интерфейс фигуры.
class Point implements Figure{
    private R2Point p;
    public Point(R2Point p){
        this.p = p;
    }

    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public Figure add(R2Point q){
        if(!R2Point.equal(p, q))
            return new Segment(p, q);
        else
            return this;
    }
    public void draw(Graphics g){
        g.fillOval(p.getX()*p.getK()+507,580-p.getY()*p.getK(),3,3);
        g.setColor(Color.black);
    }
    public int count() {
       return 0;
    }
}
