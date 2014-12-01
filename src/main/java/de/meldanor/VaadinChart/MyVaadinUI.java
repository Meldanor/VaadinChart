package de.meldanor.VaadinChart;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import de.meldanor.VaadinChart.charts.Axis;
import de.meldanor.VaadinChart.charts.CircleDataSeries;
import de.meldanor.VaadinChart.charts.DataSeriesType;
import de.meldanor.VaadinChart.charts.DonutChart;
import de.meldanor.VaadinChart.charts.PieChart;
import de.meldanor.VaadinChart.charts.XAxis;
import de.meldanor.VaadinChart.charts.XAxis.CategoryXAxis;
import de.meldanor.VaadinChart.charts.XYChart;
import de.meldanor.VaadinChart.charts.XYDataSeries;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "de.meldanor.VaadinChart.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        setContent(layout);

        Label header = new Label("This is my chart test");
        header.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(header);

        XYChart barChart = new XYChart();

        XYDataSeries lab = new XYDataSeries("Bar", DataSeriesType.BAR);
        for (int i = 1; i <= 10; ++i) {
            lab.addData(i);
        }
        barChart.addDataSeries(lab);

        XYDataSeries lab2 = new XYDataSeries("Step", DataSeriesType.STEP);
        for (int i = 11; i <= 20; ++i) {
            lab2.addData(i);
        }
        barChart.addDataSeries(lab2);

        XYDataSeries lab3 = new XYDataSeries("Line", DataSeriesType.LINE);
        for (int i = 21; i <= 31; ++i) {
            lab3.addData(i);
        }

        barChart.addDataSeries(lab3);
        barChart.setZoom(true);
        layout.addComponent(barChart);

        PieChart pieChart = new PieChart();
        CircleDataSeries halfEmpty = new CircleDataSeries("Empty");
        halfEmpty.addData(Arrays.asList(10, 10, 10, 10, 10));

        CircleDataSeries halfFull = new CircleDataSeries("Full");
        halfFull.addData(Arrays.asList(10, 10, 10, 10, 10));
        pieChart.addDataSeries(Arrays.asList(halfEmpty, halfFull));
        layout.addComponent(pieChart);

        DonutChart donutChart = new DonutChart();
        donutChart.addDataSeries(Arrays.asList(halfEmpty, halfFull));
        layout.addComponent(donutChart);

//        XYChart customAxisChart = new XYChart();
//        XYDataSeries energyCosts = new XYDataSeries("Energy Costs", DataSeriesType.STEP);
//        energyCosts.addData(Arrays.asList(7, 6, 4, 4, 4, 5, 4, 5, 8, 9, 10, 13, 12, 10, 10, 10, 10, 14, 13, 10, 10, 8, 8, 6));
//        Axis costsAxis = new Axis("Cent");
//        costsAxis.setMax(20);
//        costsAxis.addDataSeries(energyCosts);
//        customAxisChart.setLeftYAxis(costsAxis);
//
//        XYDataSeries needs = new XYDataSeries("Needs", DataSeriesType.BAR);
//        needs.addData(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 4, 4, 5, 7, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0));
//        Axis needsAxis = new Axis("Count");
//        needsAxis.setMax(20);
//        customAxisChart.setRightYAxis(needsAxis);
//
//        List<Object> categories = IntStream.range(0, 24).mapToObj(i -> {
//            if (i < 10)
//                return "0" + i;
//            else
//                return Integer.toString(i);
//        }).collect(Collectors.toList());
//        XAxis xAxis = new CategoryXAxis(categories);
//        customAxisChart.setXAxis(xAxis);
//
//        customAxisChart.addDataSeries(Arrays.asList(energyCosts, needs));
//        layout.addComponent(customAxisChart);
    }
}
