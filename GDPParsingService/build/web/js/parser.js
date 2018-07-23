/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function populatedropdown(data) {

    let dropdown = $('#country_list');
    dropdown.empty();

    dropdown.append('<option selected="true" disabled>Choose Country </option>');

    $.each(data[1], function (key, entry) {
        if (entry.region.iso2code != "NA") {

            dropdown.append($('<option></option>').attr('value', entry.iso2Code).text(entry.name));
        }
    });

    dropdown.prop('selectedIndex', 0);

}



function parseGDP(data) {

    var country = $("#country_list option:selected").text();

    var datasetgoogle = [];

    $.each(data[1], function (key, entry) {
        if (entry.value != null) {

            datasetgoogle.push([entry.date, entry.value]);

        }
    });

    datasetgoogle.reverse();
    datasetgoogle.unshift(['Date', 'GDP']);


    if (datasetgoogle.length < 2)
    {
        errorDisplayingGraph(country);
    } else {
        drawGoogleBar(country, datasetgoogle[1][0], datasetgoogle[datasetgoogle.length - 1][0], datasetgoogle);
    }


}


function parseGDP2(data) {

    var country = $("#country_list option:selected").text();

    var startYear = data["startYear"];
    var endYear = data["endYear"];
    //var lowestGDP = data["lowestGDP"];
    //var highestGDP = data["highestGDP"]

    var datasetgoogle = [];

    $.each(data["dataset"], function (key, entry) {
        if (entry.value != null) {

            datasetgoogle.push([entry.date.toString(), entry.value]);

        }
    });

    datasetgoogle.reverse();
    datasetgoogle.unshift(['Date', 'GDP']);


    if (datasetgoogle.length < 2)
    {
        errorDisplayingGraph(country);
    } else {
        drawGoogleBar(country, startYear, endYear, datasetgoogle);
    }


}