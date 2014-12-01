package de.meldanor.VaadinChart.charts;

import java.util.Collection;

import com.vaadin.annotations.JavaScript;

@JavaScript("circlechart_connector.min.js")
public abstract class CircleChart extends Chart {

    private static final long serialVersionUID = 6506866186112698558L;

    protected CircleChart() {
        // For serialization
        this("pie");
    }

    public CircleChart(final String type) {
        getState(false).setType(type);
    }

    public String getType() {
        return getState(false).getType();
    }

    @Override
    protected CircleChartState getState() {
        return (CircleChartState) super.getState();
    }

    @Override
    protected CircleChartState getState(boolean markAsDirty) {
        return (CircleChartState) super.getState(markAsDirty);
    }

    public void addDataSeries(CircleDataSeries series) {
        getState().getSeries().add(series);
    }

    public void addDataSeries(Collection<CircleDataSeries> series) {
        getState().getSeries().addAll(series);
//        CircleChartState state = getState(false);
//        series.forEach(s -> state.getSeries().put(s.getLabel(), s));
//        markAsDirty();
    }
}
