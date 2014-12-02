package de.meldanor.VaadinChart.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * An axis for a {@link XYChart} with a max and min value and a label. Every
 * axis can have multiple {@link DataSeries}.
 * 
 * @see XAxis
 */
public class Axis implements Serializable {

    private static final long serialVersionUID = -7781862474914998103L;

    private String label;

    private List<DataSeries> dataSeries;
    private boolean show;

    private Object max;
    private Object min;

    protected Axis() {
        // For Serialization
        this("");
    }

    public Axis(final String label) {
        this.label = label;

        this.show = true;
        this.dataSeries = new ArrayList<>();
        this.max = null;
        this.min = null;
    }

    public String getLabel() {
        return label;
    }

    /**
     * @deprecated This is just for Vaadin - for nobody else!
     */
    public void setLabel(String label) {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }

    public List<DataSeries> getDataSeries() {
        return dataSeries;
    }

    /**
     * @deprecated This is just for Vaadin - for nobody else!
     */
    public void setDataSeries(List<DataSeries> dataSeries) {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }

    public void addDataSeries(DataSeries dataSeries) {
        this.dataSeries.add(dataSeries);
    }

    public void addDataSeries(Collection<DataSeries> dataSeries) {
        this.dataSeries.addAll(dataSeries);
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }

    public void setMax(Object max) {
        this.max = max;
    }

    public Object getMax() {
        return max;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    public Object getMin() {
        return min;
    }
}
