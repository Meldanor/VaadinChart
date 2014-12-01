package de.meldanor.VaadinChart.charts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class XAxis extends Axis {

    private static final long serialVersionUID = 5637923497217237145L;
    private static final String AXIS_TYPE_INDEXED = "indexed";

    private String type;

    public XAxis() {
        // For serialization
        this(AXIS_TYPE_INDEXED);
    }

    protected XAxis(final String type) {
        this.type = type;
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

    public static class CategoryXAxis extends XAxis {

        private static final String AXIS_TYPE_CATEGORY = "category";
        private static final long serialVersionUID = -7023052491595342968L;

        protected CategoryXAxis() {
            // For serialization
            this(Collections.emptyList());
        }

        public CategoryXAxis(List<Object> categories) {
            super(AXIS_TYPE_CATEGORY);
            DataSeries tmp = new XYDataSeries("", DataSeriesType.BAR);
            tmp.addData(categories);
            super.addDataSeries(tmp);
        }
    }

    public static class TimeseriesXAxis extends XAxis {

        private static final String AXIS_TYPE_TIMESERIES = "timeseries";
        private static final long serialVersionUID = 4251514834428188692L;

        protected TimeseriesXAxis() {
            this(Collections.emptyList());
        }

        public TimeseriesXAxis(List<LocalDateTime> timeseries) {
            this(timeseries, "yyyy-MM-dd HH:mm:ss");
        }

        public TimeseriesXAxis(List<LocalDateTime> timeseries, String timeFormat) {
            super(AXIS_TYPE_TIMESERIES);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
            DataSeries tmp = new XYDataSeries(timeFormat, DataSeriesType.BAR);

            timeseries.stream().map(dt -> dt.format(formatter)).forEach(s -> tmp.addData(tmp));
        }
    }
}
