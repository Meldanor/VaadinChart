window.de_meldanor_VaadinChart_charts_XYChart = function () {

    function createYAxis(axesObject, axisObject, axis, axisName) {
        axisObject[axisName] = {
            min: axis.min,
            max: axis.max,
            label: axis.label,
            show: axis.show
        };

        var dataSeries = axis.dataSeries;
        for (var i = 0; i < dataSeries.length; ++i) {
            axesObject[dataSeries[i].label] = axisName;
        }
    }

    function createXAxis(axisObject, xAxis) {
        axisObject['x'] = {
            min: xAxis.min,
            max: xAxis.max,
            label: xAxis.label,
            show: xAxis.show,
            type: xAxis.type
        };
        console.log(xAxis);
        switch (xAxis.type) {
        case 'indexed':
            // Do nothing
            break;
        case 'category':
            axisObject['x'].categories = xAxis.dataSeries[0].data;
            break;
        case 'timeseries':
            // TODO: implement handling timeseries
            break;
        default:
            break;
        }
    }

    var axis = {};
    var axes = {};
    if (this.getState().xAxis) {
        createXAxis(axis, this.getState().xAxis);
    }
    if (this.getState().leftYAxis) {
        createYAxis(axes, axis, this.getState().leftYAxis, 'y');
    }
    if (this.getState().rightYAxis) {
        createYAxis(axes, axis, this.getState().rightYAxis, 'y2');
    }

    var diagramElement = this.getElement();
    var chart = c3.generate({
        bindto: diagramElement,
        data: {
            columns: []
        },
        zoom: {
            enabled: this.getState().zoom
        },
        axis: axis
    });


    this.onStateChange = function () {
        var series = this.getState().series;
        var types = {};
        var datas = [];
        for (var i = 0; i < series.length; ++i) {
            var serie = series[i];
            types[serie.label] = serie.type;
            var data = serie.data.slice();
            data.unshift(serie.label);
            datas.push(data);
        }
        chart.load({
            columns: datas,
            types: types,
            axes: axes
        });
    };
};