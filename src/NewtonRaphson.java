/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reyhan
 */
public class NewtonRaphson {
    
    private double xr;
    private double xr1;
    private double fxr;
    private double ftxr;
    private double xr1xr;
    private String iterasi;

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getXr1() {
        return xr1;
    }

    public void setXr1(double xr1) {
        this.xr1 = xr1;
    }

    public double getFxr() {
        return fxr;
    }

    public void setFxr(double fxr) {
        this.fxr = fxr;
    }

    public double getFtxr() {
        return ftxr;
    }

    public void setFtxr(double ftxr) {
        this.ftxr = ftxr;
    }
    
    public double getXr1xr() {
        return xr1xr;
    }

    public void setXr1xr(double xr1xr) {
        this.xr1xr = xr1xr;
    }

    public String getIterasi() {
        return iterasi;
    }

    public void setIterasi(String iterasi) {
        this.iterasi = iterasi;
    }

}
