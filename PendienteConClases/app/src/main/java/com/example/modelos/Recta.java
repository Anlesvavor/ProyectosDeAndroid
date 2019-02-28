package com.example.modelos;

import com.example.interfaces.Calculos;

public class Recta implements Calculos {

    private Punto p1;
    private Punto p2;

    public Recta() {
    }

    public Recta(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Recta(double x1, double x2, double y1, double y2) {
        this.p1 = new Punto(x1, y1);
        this.p2 = new Punto(x2, y2);
    }

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }


    @Override
    public double getPendiente() {
        return (getP2().getY() - getP1().getY()) / (getP2().getX() - getP1().getX());
    }

    @Override
    public boolean isInfinito() {
        return getP1().getX() == getP2().getX();
    }

}
