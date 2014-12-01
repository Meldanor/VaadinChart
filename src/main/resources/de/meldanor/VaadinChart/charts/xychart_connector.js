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

        var eleAxis = this.getState().axes;
        if (eleAxis.length > 0) {
            // TODO: Implement Axis
        }

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
        chart.load({
            columns: datas,
            types: types
        });
    };
};