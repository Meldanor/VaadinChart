package de.meldanor.VaadinChart.charts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        private List<Object> categories;

        protected CategoryXAxis() {
            // For serialization
            this(Collections.emptyList());
        }

        public CategoryXAxis(List<Object> categories) {
            super(AXIS_TYPE_CATEGORY);
            this.categories = new ArrayList<>(categories);
        }

        public List<Object> getCategories() {
            return Collections.unmodifiableList(categories);
        }

        /**
         * @deprecated This is just for Vaadin - for nobody else!
         */
        public void setCategories(List<Object> categories) {
            throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
        }
    }

    public static class TimeseriesXAxis extends XAxis {

        private static final String AXIS_TYPE_TIMESERIES = "timeseries";
        private static final long serialVersionUID = 4251514834428188692L;

        private String timeFormat;

        private List<String> timeseriesStrings;

        protected TimeseriesXAxis() {
            this(Collections.emptyList());
        }

        public TimeseriesXAxis(List<LocalDateTime> timeseries) {
            this(timeseries, "yyyy-MM-dd HH:mm:ss");
        }

        public TimeseriesXAxis(List<LocalDateTime> timeseries, String timeFormat) {
            super(AXIS_TYPE_TIMESERIES);
            this.timeFormat = timeFormat;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
            this.timeseriesStrings = timeseries.stream().map(dt -> dt.format(formatter)).collect(Collectors.toList());
        }

        public String getTimeFormat() {
            return timeFormat;
        }

        /**
         * @deprecated This is just for Vaadin - for nobody else!
         */
        public void setTimeFormat(String timeFormat) {
            throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
        }

        public List<String> getTimeseriesStrings() {
            return Collections.unmodifiableList(timeseriesStrings);
        }

        /**
         * @deprecated This is just for Vaadin - for nobody else!
         */
        public void setTimeseriesStrings(List<String> timeseriesStrings) {
            throw new UnsupportedOperationException("This is just for Vaadin - for nobody else!");
        }
    }
}
