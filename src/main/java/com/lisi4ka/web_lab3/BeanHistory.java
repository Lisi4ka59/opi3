package com.lisi4ka.web_lab3;

import java.io.Serializable;

public class BeanHistory implements Serializable {
    private float X;
    private float Y;
    private int re;
    private int g;
    private int b;

    BeanHistory(float X, float Y, int re, int g, int b) {
        this.X = X;
        this.Y = Y;
        this.re = re;
        this.g = g;
        this.b = b;
    }

    public void setRe(int re) {
        this.re = re;
    }
    public int getRe() {
        return re;
    }

    public float getX() {
        return X;
    }

    public void setX(float x) {
        X = x;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public float getY() {
        return Y;
    }

    public void setY(float y) {
        Y = y;
    }
}
