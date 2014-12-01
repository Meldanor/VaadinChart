window.de_meldanor_VaadinChart_charts_XYChart = function () {

    var diagramElement = this.getElement();
    var chart = c3.generate({
        bindto: diagramElement,
        data: {
            columns: []
        },
        zoom: {
            enabled: this.getState().zoom
        }
    });

    this.onStateChange = function () {
        console.log(this.getState());
        /*var axis = new Object();
        var axes = new Object();
        if (this.getState().xAxis) {
            var oxAxis = this.getState().xAxis;
            console.log(oxAxis);
            var curAxe = new Object();
            curAxe['min'] = oxAxis.min;
            curAxe['max'] = oxAxis.max;
            curAxe['label'] = oxAxis.label;
            var type = oxAxis.type;
            if (type === 'indexed') {
                // Do nothing
            } else if (type === 'category') {
                curAxe['categories'] = oxAxis.categories;
            } else {
                // Do nothing - at the moment
            }
            axis['x'] = curAxe;
        }
        if (this.getState().leftYAxis) {
            var olyAxis = this.getState().leftYAxis;
            var curYAxis = new Object();
            console.log(olyAxis);
            var axisSeries = olyAxis.dataSeries;
            for (var i = 0; i < axisSeries.length; ++i) {
                var series = axisSeries[i];
                axes[series.label] = 'y';
            }
            curYAxis['min'] = olyAxis.min;
            curYAxis['max'] = olyAxis.max;
            curYAxis['label'] = olyAxis.label;

        }
        if (this.getState().rightYAxis) {
            var oryAxis = this.getState().rightYAxis;
            var curYAxis = new Object();
            console.log(oryAxis);
            var axisSeries = curYAxis.dataSeries;
            for (var i = 0; i < axisSeries.length; ++i) {
                var series = axisSeries[i];
                axes[series.label] = 'y2';
            }
            curYAxis['min'] = oryAxis.min;
            curYAxis['max'] = oryAxis.max;
            curYAxis['label'] = oryAxis.label;
        }*/

        var series = this.getState().series;
        var types = new Object();
        var datas = new Array();
        for (var i = 0; i < series.length; ++i) {
            var serie = series[i];
            types[serie.label] = serie.type;
            var data = serie.data.slice();
            data.unshift(serie.label);
            datas.push(data);
        }
        console.log(chart);
        chart.load({
            columns: datas,
            types: types
        });
    };
};