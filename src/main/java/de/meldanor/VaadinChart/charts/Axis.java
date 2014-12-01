package de.meldanor.VaadinChart.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class Axis implements Serializable {

    private static final long serialVersionUID = -7781862474914998103L;

    private String label;

    private List<DataSeries> dataSeries;
    private boolean show;

    private Object max;
    private Object min;

    @SuppressWarnings("unused")
    private String[] formatStrings;

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

    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\{1\\}");

    public void setFormat(String format) {
        // format.split(regex)
        this.formatStrings = SPLIT_PATTERN.split(format);
    }

    /**
     * @deprecated This is just for Vaadin - for nobody else!
     */
    public void setFormatStrings(String[] formatStrings) {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }

    /**
     * @deprecated This is just for Vaadin - for nobody else!
     */
    public String[] getFormatStrings() {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }

}
