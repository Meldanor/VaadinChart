package de.meldanor.VaadinChart.charts;

public enum DataSeriesType {

    LINE("line"), SPLINE("spline"), STEP("step"), AREA("area"), AREA_SPLINE("area-spline"), AREA_STEP("area-step"), BAR("bar"), SCATTER("scatter");

    private final String c3String;

    private DataSeriesType(final String c3String) {
        this.c3String = c3String;
    }

    public String getC3String() {
        return c3String;
    }
}
