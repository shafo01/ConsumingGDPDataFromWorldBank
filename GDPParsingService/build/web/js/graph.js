/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function drawGoogleBar(country, startDate, endDate, dataset) {

    document.getElementById('graph').style.display = 'block';

    var data = new google.visualization.arrayToDataTable(dataset);

    var options = {
        width: 800,
        legend: {position: 'none'},
        chart: {
            title: 'GDP for ' + country + ' from ' + startDate + ' to ' + endDate,
            subtitle: 'in US $'},
        axes: {
            x: {
                0: {side: 'bottom', label: 'Years'} // Top x-axis.
            }
        },
        bar: {groupWidth: "90%"}
    };

    var chart = new google.charts.Bar(document.getElementById('graph'));
    chart.draw(data, google.charts.Bar.convertOptions(options));
}


function errorDisplayingGraph(country) {
    document.getElementById("graph").innerHTML = "<h2 style='color:red'> There was an error when trying to display data for " + country + "</h2>";
}