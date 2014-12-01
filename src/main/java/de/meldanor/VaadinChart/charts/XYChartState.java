package de.meldanor.VaadinChart.charts;

import java.util.ArrayList;
import java.util.List;

public class XYChartState extends ChartState {

    private static final long serialVersionUID = -7104324979504083367L;

    private List<Axis> axes;
    private List<XYDataSeries> series;

    private boolean zoom;

    public XYChartState() {
        this.axes = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    public void setAxes(List<Axis> axes) {
        this.axes = axes;
    }

    public List<Axis> getAxes() {
        return axes;
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
}
