import java.awt.*;

//Класс "Многоугольник", реализующий интерфейс фигуры.
class Polygon extends Deq implements Figure {
    private double s, p;
    private int counter = 0;
    private boolean b = true;
    public Polygon(R2Point a, R2Point b, R2Point c) {

        pushFront(b);

        if (b.light(a, c)) {
            pushFront(a);
            pushBack(c);
        } else {
            pushFront(c);
            pushBack(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));

    }

    public double perimeter() {
        return p;
    }

    public double area() {
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public int count() {
        if (b) {
            b = false;
            R2Point p_1 = popBack();
            R2Point p_2 = popBack();
            R2Point p_3 = popBack();
            if ((p_1.getX() >= 0 && p_2.getX() >= 0) && (p_1.getX() <= 3 && p_2.getX() <= 3) && (p_1.getY() >= 0 && p_2.getY() >= 0) && (p_1.getY() <= 3 && p_2.getY() <= 3)) {
                counter++;
            }
            if ((p_1.getX() >= 0 && p_3.getX() >= 0) && (p_1.getX() <= 3 && p_3.getX() <= 3) && (p_1.getY() >= 0 && p_3.getY() >= 0) && (p_1.getY() <= 3 && p_3.getY() <= 3)) {
                counter++;
            }
            if ((p_3.getX() >= 0 && p_2.getX() >= 0) && (p_3.getX() <= 3 && p_2.getX() <= 3) && (p_3.getY() >= 0 && p_2.getY() >= 0) && (p_3.getY() <= 3 && p_2.getY() <= 3)) {
                counter++;
            }
            pushFront(p_1);
            pushFront(p_2);
            pushFront(p_3);
        }
        return counter;
    }
    public Figure add(R2Point t) {
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for (i = length(); i > 0 && !t.light(back(), front()); i--)
            pushBack(popFront());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i > 0) {
            R2Point x;
            grow(back(), front(), t);

            //Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront()) {
                System.out.println(x.getX()+" "+x.getY()+" "+front().getX()+" "+front().getY());
                if ((x.getX() >= 0 && front().getX() >= 0) && (x.getX() <= 3 && front().getX() <= 3) && (x.getY() >= 0 && front().getY() >= 0) && (x.getY() <= 3 && front().getY() <= 3)) {
                    counter--;
                }
                if ((x.getX() >= 0 && back().getX() >= 0) && (x.getX() <= 3 && back().getX() <= 3) && (x.getY() >= 0 && back().getY() >= 0) && (x.getY() <= 3 && back().getY() <= 3)) {
                    counter--;
                 }
                grow(x, front(), t);
            }
            pushFront(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack()) {
                System.out.println(x.getX()+" "+x.getY()+" "+back().getX()+" "+back().getY()+"из конца");
                if ((x.getX() >= 0 && back().getX() >= 0) && (x.getX() <= 3 && back().getX() <= 3) && (x.getY() >= 0 && back().getY() >= 0) && (x.getY() <= 3 && back().getY() <= 3)) {
                    counter--;
                }
                if ((x.getX() >= 0 && front().getX() >= 0) && (x.getX() <= 3 && front().getX() <= 3) && (x.getY() >= 0 && front().getY() >= 0) && (x.getY() <= 3 && front().getY() <= 3)) {
                    counter--;
                }
                grow(back(), x, t);
            }
            pushBack(x);

            //Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());

            if (t.getX()>=0 && t.getX()<=3 && t.getY()>=0 && t.getY()<=3){
                if (front().getX()>=0 && front().getX()<=3 && front().getY()>=0 && front().getY()<=3) counter++;
                if (back().getX()>=0 && back().getX()<=3 && back().getY()>=0 && back().getY()<=3) counter++;
            }
            pushFront(t);
        }

        return this;
    }

    public void draw(Graphics g) {
        int[] x = new int[length()];
        int[] y = new int[length()];
        for (int i = length() - 1; i >= 0; i--) {
            x[i] = 507 + front().getX() * front().getK();
            y[i] = 580 - front().getY() * front().getK();

            pushBack(popFront());
        }
        g.fillPolygon(x, y, length());

    }
}
