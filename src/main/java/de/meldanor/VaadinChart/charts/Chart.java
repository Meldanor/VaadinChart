package de.meldanor.VaadinChart.charts;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "c3.min.js", "d3.min.js" })
@StyleSheet("c3.min.css")
public abstract class Chart extends AbstractJavaScriptComponent {

    private static final long serialVersionUID = 3262210265525327920L;

}
