import java.awt.*;


//Класс "Двуугольник", реализующий интерфейс фигуры.
class Segment implements Figure {
    private R2Point p, q;

    public Segment(R2Point p, R2Point q) {
        this.p = p;
        this.q = q;
    }

    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }

    public double area() {
        return 0.0;
    }

    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);

        if (q.inside(p, r))
            q = r;

        if (p.inside(r, q))
            p = r;

        return this;
    }

    public void draw(Graphics g) {

        g.fillOval(507 + p.getX() * p.getK(), 580 - p.getY() * p.getK(), 3, 3);
        g.setColor(Color.black);
        g.fillOval(507 + q.getX() * q.getK(), 580 - q.getY() * q.getK(), 3, 3);
        g.drawLine(507 + p.getX() * p.getK(), 580 - p.getY() * p.getK(), 507 + q.getX() * q.getK(), 580 - q.getY() * q.getK());

    }

    public int count() {
        return 0;
    }
}

