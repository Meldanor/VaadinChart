package de.meldanor.VaadinChart.charts;

import java.util.ArrayList;
import java.util.List;

/**
 * The state class for {@link CircleChart}s. Contains a list of
 * {@link CircleDataSeries} and the specific type (pie or donut).
 */
public class CircleChartState extends ChartState {

    private static final long serialVersionUID = -2789654164088335116L;

    private String type;
    private List<CircleDataSeries> series;

    public CircleChartState() {
        this.series = new ArrayList<>();
    }

    public List<CircleDataSeries> getSeries() {
        return series;
    }

    public void setSeries(List<CircleDataSeries> series) {
        this.series = series;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
