window.de_meldanor_VaadinChart_charts_CircleChart = function () {

    var diagramElement = this.getElement();
    var chart = c3.generate({
        bindto: diagramElement,
        data: {
            columns: []
        }
    });

    this.onStateChange = function () {

        var series = this.getState().series;
        var datas = new Array();

        for (var i = 0; i < series.length; ++i) {
            var serie = series[i];
            var data = serie.data.slice();
            data.unshift(serie.label);
            datas.push(data);
        }
        chart.load({
            columns: datas,
            type: this.getState().type
        });
    };
};