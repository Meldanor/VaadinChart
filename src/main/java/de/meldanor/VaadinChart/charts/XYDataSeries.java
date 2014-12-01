package de.meldanor.VaadinChart.charts;

public class XYDataSeries extends DataSeries {

    private static final long serialVersionUID = 2295028135617028321L;

    private String type;

    protected XYDataSeries() {
        // For serialization
        this("", DataSeriesType.LINE);
    }

    public XYDataSeries(final String label, final DataSeriesType type) {
        super(label);
        this.type = type.getC3String();

    }

    public String getType() {
        return type;
    }

    /**
     * @deprecated This is just for Vaadin - for nobody else!
     */
    public void setType(String type) {
        throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
    }
}
