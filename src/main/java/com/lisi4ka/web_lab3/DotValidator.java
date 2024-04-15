package com.lisi4ka.web_lab3;

public class DotValidator {

        public static String[] result(Float X, Float Y, Float R, Float random) {
            int gr;
            int re;
            int bl;
            String text;
            if (((X <= 0 && X > -R/2) && (Y >= 0 && Y < R)) || ((X >= 0 && Y >= 0) && ((X + Y) < R)) || ((X >= 0 && Y <= 0) && ((Math.pow(X, 2) + Math.pow(Y, 2) < Math.pow(R/2, 2))))) {
                if (random < 0.5) {
                    gr = 60;
                    re = 60;
                    bl = 60;
                    text = "Не пробил!";
                    return new String[] {String.valueOf(re), String.valueOf(gr), String.valueOf(bl), text};
                } else {
                    gr = 255;
                    re = 0;
                    bl = 0;
                    text = "Есть пробитие!";
                    return new String[] {String.valueOf(re), String.valueOf(gr), String.valueOf(bl), text};
                }
            } else {
                if (((X <= 0 && Y >= 0) && (X == -R/2 || Y == R) || ((X >= 0) && (Y >= 0)) && (X + Y == R)) || ((X >= 0 && Y <= 0) && ((Math.pow(X, 2) + Math.pow(Y, 2) == Math.pow(R/2, 2))))) {
                    gr = 150;
                    re = 150;
                    bl = 150;
                    text = "Рикошет!";
                    return new String[] {String.valueOf(re), String.valueOf(gr), String.valueOf(bl), text};
                } else {
                    gr = 0;
                    re = 255;
                    bl = 0;
                    text = "Не попал!";
                    return new String[] {String.valueOf(re), String.valueOf(gr), String.valueOf(bl), text};
                }
            }
        }

}
