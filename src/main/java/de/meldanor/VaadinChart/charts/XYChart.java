package de.meldanor.VaadinChart.charts;

import java.util.Collection;

import com.vaadin.annotations.JavaScript;

/**
 * An XYChart displaying the values in simple graph. Each {@link XYChart} can
 * have multiple {@link DataSeries} with different {@link DataSeriesType}. For
 * example, an XYChart can have a data series displayed as a bar chart combined
 * with a data series displayed as a line chart.
 */
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

    /**
     * Zoomable charts can be zoomed via mouse wheel and dragged with mouse
     * click. Default is <code>false</code>
     * 
     * @param enableZoom Enabling zoom
     */
    public void setZoom(boolean enableZoom) {
        getState().setZoom(enableZoom);
    }

    /**
     * @return Is the chart zoom able? Default is <code>false</code>
     * @see #setZoom(boolean)
     */
    public boolean isZoom() {
        return getState(false).getZoom();
    }

    /**
     * Add a single data series to the chart. The label of the data series
     * should be unique!
     * 
     * @param serie The data series added to the chart.
     */
    public void addDataSeries(XYDataSeries serie) {
        getState().getSeries().add(serie);
    }

    /**
     * Add a collection of data series to the chart.
     * 
     * @param series Collection of data series added to the chart
     * @see #addDataSeries(XYDataSeries)
     */
    public void addDataSeries(Collection<XYDataSeries> series) {
        getState().getSeries().addAll(series);
    }

    /**
     * Remove a single data series from the chart. The label is used as an
     * identifier.
     * 
     * @param label The label of the data series to remove
     */
    public void removeDataSeries(String label) {
        getState().getSeries().removeIf(s -> s.getLabel().equals(label));
    }

    /**
     * Set a specific configured {@link XAxis} for the chart. If no XAxis is
     * specified, a default one(indexed) will be used.
     * 
     * @param axis The axis for this chart
     */
    public void setXAxis(XAxis axis) {
        getState().setXAxis(axis);
    }

    /**
     * Set the left (the standard) Y axis for the chart. If no YAxis is
     * specified, a default one will be used.
     * 
     * @param axis The left y axis for this chart.
     */
    public void setLeftYAxis(Axis axis) {
        getState().setLeftYAxis(axis);
    }

    /**
     * Set the right (the standard) Y axis for the chart. If there was no right
     * y axis is specified, only the left one will be displayed
     * 
     * @param axis The right y axis for this chart.
     */
    public void setRightYAxis(Axis axis) {
        getState().setRightYAxis(axis);
    }

}
