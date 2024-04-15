package com.lisi4ka.web_lab3;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Named("beanCoordinates")
@SessionScoped
public class BeanCoordinates implements Serializable {
    private String inputX;
    private String inputY;
    private String inputR = "1";
    private String history = "";
    private String result = "";
    private String time = "";
    private String scriptTime = "";
    private String reGraph = "true";
    private ArrayList<BeanHistory> dotHistory = new ArrayList<>();

    public ArrayList<BeanHistory> getDotHistory() {
        return dotHistory;
    }

    public void setDotHistory(ArrayList<BeanHistory> dotHistory) {
        this.dotHistory = dotHistory;
    }
    public void setSuperDotHistory(BeanHistory dotHistory) {
        this.dotHistory.add(dotHistory);
    }

    public String getReGraph() {
        return reGraph;
    }

    public void setReGraph(String reGraph) {
        this.reGraph = reGraph;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScriptTime() {
        return scriptTime;
    }

    public void setScriptTime(String scriptTime) {
        this.scriptTime = scriptTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getInputR() {
        return inputR;
    }

    public void setInputR(String inputR) {
        this.inputR = inputR;
        this.reGraph = "true";
    }
    public void setSuperInputR(String inputR) {
        this.inputR = inputR;
        this.inputY = "0";
        this.inputX = "1000";


    }
    public void setR(String inputR) {
        long time = System.nanoTime();
        this.reGraph = "true";
        setInputR(inputR);
        if (inputX != null && inputY != null) {
            float X = Float.parseFloat(inputX);
            float Y = Float.parseFloat(inputY);
            float R = Float.parseFloat(inputR);

            String[] result = DotValidator.result(X, Y, R, 0.5F);
            String text = result[3];

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<tr><td>").append(X).append("</td>").append("<td>").append(Y).append("</td>").append("<td>").append(inputR).append("</td><td>");
            String timeNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTimeInMillis());
            stringBuilder.append(timeNow).append("</td><td>");
            stringBuilder.append(System.nanoTime() - time).append("</td><td>");
            stringBuilder.append(text).append("</td></tr>");
            stringBuilder.append(history);
            history = stringBuilder.toString();
            setResult("<tr style=\" text-align: center\"><td>" + X + "</td><td>" + Y + "</td><td>" + inputR + "</td><td>" + text + "</td></tr>");
        }
    }



    public String getInputY() {
        return inputY;
    }

    public void setInputY(String inputY) {
        this.inputY = inputY;
    }

    public String getInputX() {
        return inputX;
    }

    public void setInputX(String inputX) {
        this.inputX = inputX;
    }
}