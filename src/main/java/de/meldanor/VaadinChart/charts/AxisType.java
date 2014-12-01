package de.meldanor.VaadinChart.charts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AxisType implements Serializable {

    private static final long serialVersionUID = 2422166779275632710L;

    private final String type;

    public AxisType() {
        // For serialization
        this("");
    }

    public AxisType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static class IndexedAxisType extends AxisType {

        private static final String AXIS_TYPE_INDEXED = "indexed";
        private static final long serialVersionUID = -2807420780336975402L;

        public IndexedAxisType() {
            super(AXIS_TYPE_INDEXED);
        }
    }

    public static class CategoryAxisType extends AxisType {

        private static final String AXIS_TYPE_CATEGORY = "category";
        private static final long serialVersionUID = -7023052491595342968L;

        private final List<Object> categories;

        protected CategoryAxisType() {
            // For serialization
            this(Collections.emptyList());
        }

        public CategoryAxisType(List<Object> categories) {
            super(AXIS_TYPE_CATEGORY);
            this.categories = new ArrayList<>(categories);
        }

        public List<Object> getCategories() {
            return Collections.unmodifiableList(categories);
        }
    }

    public static class TimeseriesAxisType extends AxisType {

        private static final String AXIS_TYPE_TIMESERIES = "timeseries";
        private static final long serialVersionUID = 4251514834428188692L;

        private final String format;

        private final List<String> timeseriesStrings;

        protected TimeseriesAxisType() {
            this(Collections.emptyList());
        }

        public TimeseriesAxisType(List<LocalDateTime> timeseries) {
            this(timeseries, "yyyy-MM-dd HH:mm:ss");
        }

        public TimeseriesAxisType(List<LocalDateTime> timeseries, String format) {
            super(AXIS_TYPE_TIMESERIES);
            this.format = format;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            this.timeseriesStrings = timeseries.stream().map(dt -> dt.format(formatter)).collect(Collectors.toList());
        }

        public String getFormat() {
            return format;
        }

        public List<String> getTimeseriesStrings() {
            return Collections.unmodifiableList(timeseriesStrings);
        }

    }
}
