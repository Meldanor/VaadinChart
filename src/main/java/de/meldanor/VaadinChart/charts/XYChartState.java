package de.meldanor.VaadinChart.charts;

import java.util.ArrayList;
import java.util.List;

public class XYChartState extends ChartState {

    private static final long serialVersionUID = -7104324979504083367L;

    private List<XYDataSeries> series;
    private XAxis xAxis;
    private Axis leftYAxis;
    private Axis rightYAxis;

    private boolean zoom;

    public XYChartState() {
        this.series = new ArrayList<>();
    }

    public void setSeries(List<XYDataSeries> series) {
        this.series = series;
    }

    public List<XYDataSeries> getSeries() {
        return series;
    }

    public boolean getZoom() {
        return this.zoom;
    }

    public void setZoom(boolean zoom) {
        this.zoom = zoom;
    }

    public XAxis getXAxis() {
        return xAxis;
    }

    public void setXAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public Axis getLeftYAxis() {
        return leftYAxis;
    }

    public void setLeftYAxis(Axis leftYAxis) {
        this.leftYAxis = leftYAxis;
    }

    public Axis getRightYAxis() {
        return rightYAxis;
    }

    public void setRightYAxis(Axis rightYAxis) {
        this.rightYAxis = rightYAxis;
    }

}
