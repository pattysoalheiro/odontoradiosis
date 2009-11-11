
package odontoradiosis.view.pontos;

import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;

/**
 *
 * @author Lucas
 */
public class ORSPolygon extends Polygon {

    LinkedList<Point> listaPontos;

    public ORSPolygon() {
        super();
        listaPontos = new LinkedList<Point>();
    }

    public ORSPolygon(int[] xpoints, int[] ypoints, int npoints){
        super(xpoints, ypoints, npoints);
        listaPontos = new LinkedList<Point>();
    }

    @Override
    public void addPoint(int x, int y){
        super.addPoint(x, y);
        listaPontos.add(new Point(x, y));
    }

    public void restart(){
        super.reset();
        for (int i = 0; i < listaPontos.size(); i++) {
            Point point = listaPontos.get(i);
            super.addPoint(point.x, point.y);
        }
    }

    public LinkedList<Point> getListaPontos() {
        return listaPontos;
    }

    public void setListaPontos(LinkedList<Point> listaPontos) {
        this.listaPontos = listaPontos;
    }

    public void addPointIndex(int index, int x, int y){
        super.addPoint(x, y);
        listaPontos.add(index, new Point(x, y));
    }

}
