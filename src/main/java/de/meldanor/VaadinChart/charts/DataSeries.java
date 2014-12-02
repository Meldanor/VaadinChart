package de.meldanor.VaadinChart.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A named list of objects. The objects are the data for the charts and can
 * contain any possible value. Because of Vaadins lack of serialize typed
 * classes the list contains object instead of the specific data type (like
 * Integer or Double). <br>
 * The label of a data series is the identifier in a specific chart and should
 * be unique! <br>
 * Adding a value to a data series does not propagate through the chart, you
 * have to update the chart manually!
 */
public abstract class DataSeries implements Serializable {

    private static final long serialVersionUID = 3582630108843581078L;
    private final String label;
    private List<Object> data;

    /**
     * Constructor for serialization
     */
    protected DataSeries() {
        // For serialization
        this("");
    }

    /**
     * Construct an empty list with a specific label
     * 
     * @param label The identifier of the data series.
     */
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

    /**
     * Add a single element to the data series.
     * 
     * @param element The new element
     */
    public void addData(Object element) {
        this.data.add(element);
    }

    /**
     * Add all elements of the collection to the data series.
     * 
     * @param elements The elements to add
     */
    public void addData(Collection<Object> elements) {
        this.data.addAll(elements);
    }

    /**
     * @return An unmodifiable view of the elements of this data series.
     */
    public List<Object> getData() {
        return Collections.unmodifiableList(data);
    }

}
