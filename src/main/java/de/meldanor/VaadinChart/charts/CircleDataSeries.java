package de.meldanor.VaadinChart.charts;

/**
 * A wrapper class for {@link DataSeries} to provide type safety
 */
public class CircleDataSeries extends DataSeries {

    private static final long serialVersionUID = -7635294668573676478L;

    protected CircleDataSeries() {
        // For serialization
    }

    public CircleDataSeries(final String label) {
        super(label);
    }
}
