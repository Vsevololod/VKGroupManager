'use strict';

google.charts.load('current', {
  'packages': ['corechart', 'line', 'controls']
});

$(document).ready(() => {
		let topBtn = $("#go_top_btn");
    $(".choice-form").submit(event => {
        let start = Math.round(new Date($("input#start").val()).getTime() / 1000);
        let end = Math.round(new Date($("input#end").val()).getTime() / 1000);
        let errorLabel = $(".error");
        if (isNaN(start) || isNaN(end) || end < start) {
            errorLabel.fadeTo("fast", 1.0);
            return false;
        }
        if (errorLabel.css("opacity") != 0) {
            errorLabel.fadeOut("fast");
        }        
        getDataByPeriod(start, end).then(drawChart);
        topBtn.fadeTo("slow", 1.0);
        event.preventDefault();
        return false;
    });

    topBtn.click(() => {
    	$("#choice_wrapper").animatescroll();
    	topBtn.fadeOut("fast");
    });
});

function getDataByPeriod(start, end) {
    let url = new URL(document.location + "online"),
        params = {
            start: start,
            end: end
        };
    Object.keys(params).forEach(
        key => url.searchParams.append(key, params[key]));
    const options = {
        method: "GET",
        headers: new Headers(),
        mode: "cors",
        cache: "default"
    };
    return fetch(url, options)
        .then(resp => resp.json())
        .then(json => {
            return json.map(Object.values).map(arr => arr.reverse())
        })
        .catch(err => console.log(err));
}

function drawChart(dataTable) {
    let dt = new google.visualization.DataTable();
    dt.addColumn('datetime', 'Time');
    dt.addColumn('number', 'People');
    const dashboard = new google.visualization.Dashboard(
        document.getElementById('dashboard_div')
    );

    const lineChart = new google.visualization.ChartWrapper({
        'chartType': 'ColumnChart',
        'containerId': 'chart_div',
        'options': {
            'hAxis': {
                'title': 'Time'
            },
            'vAxis': {
                'title': 'People'
            },
            'title': 'Visitors',
            'backgroundColor': '#C5EDD2',
            'width': 1000,
            'height': 500
        }
    });
    const chartRangeFilter = new google.visualization.ControlWrapper({
        'controlType': 'ChartRangeFilter',
        'containerId': 'filter_div',
        'options': {
            'filterColumnLabel': 'Time',
            'ui': {
                'chartOptions': {
                    'height': 70,
                    'width': 1000,
                    'chartArea': {
                        'width': '70%'
                    }
                }
            }
        }
    });
    dashboard.bind(chartRangeFilter, lineChart);    

    dataTable.forEach(arr => arr[0] = new Date(arr[0] * 1000));
    dt.addRows(dataTable);
    dashboard.draw(dt);
    google.visualization.events.addListener(dashboard, 'ready', () => $("#dashboard_div").animatescroll());
}
