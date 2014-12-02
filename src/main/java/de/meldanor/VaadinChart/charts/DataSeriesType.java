package de.meldanor.VaadinChart.charts;

/**
 * The display type of a {@link DataSeries} in a {@link XYChart}. An
 * {@link XYChart} can have multiple data series of different types.
 */
public enum DataSeriesType {

    /** Display the data as a single line */
    LINE("line"),
    /** Display the data as a single line, but use splines to connect two data */
    SPLINE("spline"),
    /**
     * Does not interpolate changes in data between two points. Useful for
     * discrete data
     */
    STEP("step"),
    /** Same as LINE, but fills the area under the graph */
    AREA("area"),
    /** Same as SPLINE, but fills the area under the graph */
    AREA_SPLINE("area-spline"),
    /** Same as STEP, but fills the area under the graph */
    AREA_STEP("area-step"),
    /** Display the values as a filled vertical bar */
    BAR("bar"),
    /** DIsplay only the X/Y coordinates without a connecting line between them */
    SCATTER("scatter");

    private final String c3String;

    private DataSeriesType(final String c3String) {
        this.c3String = c3String;
    }

    /**
     * @return The C3 type as a string
     */
    public String getC3String() {
        return c3String;
    }
}
