package de.meldanor.VaadinChart.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class DataSeries implements Serializable {

    private static final long serialVersionUID = 3582630108843581078L;
    private final String label;
    private List<Object> data;

    protected DataSeries() {
        // For serialization
        this("");
    }

    public DataSeries(final String label) {
        this.label = label;
        this.data = new ArrayList<>();
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
    public void setData(List<Object> data) {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }

    public String getLabel() {
        return label;
    }

    public void addData(Object element) {
        this.data.add(element);
    }

    public void addData(Collection<Object> elements) {
        this.data.addAll(elements);
    }

    public List<Object> getData() {
        return Collections.unmodifiableList(data);
    }

}
