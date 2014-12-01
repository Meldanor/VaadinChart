package de.meldanor.VaadinChart.charts;

import java.util.Collection;

import com.vaadin.annotations.JavaScript;

@JavaScript("xychart_connector.min.js")
public class XYChart extends Chart {

    private static final long serialVersionUID = 2281193242769697215L;

    @Override
    protected XYChartState getState() {
        return (XYChartState) super.getState();
    }

    @Override
    protected XYChartState getState(boolean markAsDirty) {
        return (XYChartState) super.getState(markAsDirty);
    }

    public void setZoom(boolean enableZoom) {
        getState().setZoom(enableZoom);
    }

    public boolean isZoom() {
        return getState(false).getZoom();
    }

    public void addDataSeries(XYDataSeries serie) {
        getState().getSeries().add(serie);
    }

    public void addDataSeries(Collection<XYDataSeries> series) {
        getState().getSeries().addAll(series);
    }

    public void removeDataSeries(String label) {
        getState().getSeries().removeIf(s -> s.getLabel().equals(label));
    }

}
