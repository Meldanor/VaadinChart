package de.meldanor.VaadinChart.charts;

/**
 * A chart displaying values in a donut form. Difference to a pie chart is, that
 * the area in the middle is not filled
 */
public class DonutChart extends CircleChart {

    private static final String DONUT_CHART = "donut";
    private static final long serialVersionUID = 8278080693154990598L;

    /**
     * New donut chart
     */
    public DonutChart() {
        super(DONUT_CHART);
    }
}
