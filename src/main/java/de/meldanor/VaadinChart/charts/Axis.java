package de.meldanor.VaadinChart.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.meldanor.VaadinChart.charts.AxisType.IndexedAxisType;

public class Axis implements Serializable {

    private static final long serialVersionUID = -7781862474914998103L;

    private String label;
    private AxisType type;

    private List<DataSeries> dataSeries;
    private boolean show;

    private Object max;
    private Object min;

    protected Axis() {
        // For Serialization
        this("x", new IndexedAxisType());
    }

    public Axis(final String label, final AxisType type) {
        this.type = type;
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

    /**
     * @deprecated This is just for Vaadin - for nobody else!
     */
    public void setType(AxisType type) {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }

    /**
     * @deprecated This is just for Vaadin - for nobody else!
     */
    public void setDataSeries(List<DataSeries> dataSeries) {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }

    public AxisType getType() {
        return type;
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
