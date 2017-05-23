'use strict'

// Load the Visualization API and the corechart package.
google.charts.load('current', {
    'packages': ['corechart', 'line', 'controls']
});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {
	let dt = new google.visualization.DataTable();
    dt.addColumn('datetime', 'Time');
    dt.addColumn('number', 'People');	
	const dashboard = new google.visualization.Dashboard(
            document.getElementById('dashboard_div'));

	const lineChart = new google.visualization.ChartWrapper({
          'chartType': 'LineChart',
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


	getDataByPeriod(0, Math.round(Date.now()/1000))
		.then(val => {
			val.forEach(arr => arr[0] = new Date(arr[0]*1000));
			dt.addRows(val); 
			return dt; 
		})
		.then(dt => dashboard.draw(dt))
		.catch(err => console.log(err));
}

function getDataByPeriod(start, end) {
	let url = new URL("http://localhost:8080/online"),
					  params = {start:start, end:end}
					  Object.keys(params).forEach(
					  	key => url.searchParams.append(key, params[key]));
	const options = { method: "GET", 
					headers: new Headers(), 
					mode: "cors", 
					cache: "default" };
	return fetch(url, options)
				.then(resp => resp.json())
				.then(json => {
					return json.map(Object.values).map(arr => arr.reverse())
				})
				.catch(err => console.log(err));
}