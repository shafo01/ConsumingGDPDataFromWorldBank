/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* useful links
 https://api.jquery.com/jquery.getjson/
 http://api.worldbank.org/v2/countries/c5?page=1&per_page=304&format=json
 */



function updateCountryList() {

    document.getElementById('errorLabel').style.display = 'none';
    const url = 'http://api.worldbank.org/v2/countries/all?page=1&per_page=304&format=json';

    // Populate dropdown with list of countries and codes
    $.getJSON(url, function (data) {

        populatedropdown(data);

    })

            .done(function () {

                populatedropdown(data);
            })
            .fail(function () {
                document.getElementById('errorLabel').style.display = 'block';
            });

// Assign handlers immediately after making the request,




}



function displayGraph() {

    document.getElementById('errorLabel').style.display = 'none';
    var iso2Code = $("#country_list option:selected").val();

    const url = "http://api.worldbank.org/v2/countries/" + iso2Code + "/indicators/NY.GDP.MKTP.CD?format=json";

    $.getJSON(url, function (data) {

        parseGDP(data);

    })
            .done(function (data) {

                parseGDP(data);
            })
            .fail(function () {
                document.getElementById('errorLabel').style.display = 'block';
            });



}


function displayGraph2() {

    document.getElementById('errorLabel').style.display = 'none';
    var iso2Code = $("#country_list option:selected").val();

    const url = "/GDPParsingService/webresources/gdp/" + iso2Code;

    $.getJSON(url, function (data) {

        parseGDP2(data);

    })
            .done(function (data) {

                parseGDP2(data);
            })
            .fail(function () {
                document.getElementById('errorLabel').style.display = 'block';
            });



}
