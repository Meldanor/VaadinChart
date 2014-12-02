package de.meldanor.VaadinChart.charts;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import com.vaadin.annotations.JavaScript;

/**
 * A radial based chart like pie or donut chart. Have no axis and is not
 * zoomable. Only interesting, when there is more than one {@link DataSeries}.
 * Will calculate the ratio between the sum of the dataseries and display it.
 */
@JavaScript("circlechart_connector.min.js")
public abstract class CircleChart extends Chart {

    private static final long serialVersionUID = 6506866186112698558L;

    /**
     * Constructor for serialization
     */
    protected CircleChart() {
        // For serialization
        this("pie");
    }

    /**
     * Create a circle chart with a specific type. The type can be a pie (full
     * circle) or a donut (empty center)
     * 
     * @param type The type.
     */
    public CircleChart(final String type) {
        getState(false).setType(type);
    }

    /**
     * @return The type of the circle chart.
     */
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

    /**
     * Add a single {@link DataSeries} to the chart. The chart will display the
     * accumulated values of the {@link DataSeries} and their ratio
     * 
     * @param series The series to add
     */
    public void addDataSeries(@NotNull CircleDataSeries series) {
        getState().getSeries().add(series);
    }

    /**
     * Add all {@link DataSeries} of the collections to the chart.
     * 
     * @param series Collection of series to add
     * @see #addDataSeries(CircleDataSeries)
     */
    public void addDataSeries(Collection<CircleDataSeries> series) {
        getState().getSeries().addAll(series);
    }

    /**
     * Remove a single series from the chart and update the chart.
     * 
     * @param label The identifier of the series.
     */
    public void removeDataSeries(String label) {
        getState().getSeries().removeIf(s -> s.getLabel().equals(label));
    }
}
