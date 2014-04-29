<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>NTS - Bakalarka</title>

        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <!--        <script src="resources/js/geoLocation.js" type="text/javascript"/>-->

        <script>
            function getLocation()

    alert("som tu");

{

    if (navigator.geolocation)

    {

        navigator.geolocation.getCurrentPosition(showPosition, showError);

    }

    else {

        x.innerHTML = "Geolocation is not supported by this browser.";

    }



}



function showPosition(position)

{

    x.innerHTML = "Vaša aktuálna poloha je:<br>"

    "Zemepisná šírka: " + position.coords.latitude+
            "<br>Zemepisná dĺžka: " + position.coords.longitude;



    lat = position.coords.latitude;

    lon = position.coords.longitude;

    latlon = new google.maps.LatLng(lat, lon);

    mapholder = document.getElementById('mapholder');

    mapholder.style.height = '650px';

    mapholder.style.width = '800px';



    var myOptions = {
        center: latlon, zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        mapTypeControl: false,
        navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL}

    };


    var map = new google.maps.Map(document.getElementById("mapholder"), myOptions);

    var pinImage = new google.maps.MarkerImage(
            "http://www.patres.php5.sk/nts/marker.png");

    var marker = new google.maps.Marker({position: latlon, icon: pinImage, map: map, title: "Tu sa nachadzate!", animation: google.maps.Animation.BOUNCE});



    if (window.XMLHttpRequest)

    {// code for IE7+, Firefox, Chrome, Opera, Safari

        xmlhttp = new XMLHttpRequest();

    }

    else

    {// code for IE6, IE5

        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

    }

    xmlhttp.open("GET", "poi.xml", false);

    xmlhttp.send();

    xmlDoc = xmlhttp.responseXML;





    var xm = xmlDoc.getElementsByTagName("poi");
    var d = 0;

    for (i = 0; i < xm.length; i++)

    {

        lat2 = xm[i].getElementsByTagName("latitude")[0].childNodes[0].nodeValue;

        lon2 = xm[i].getElementsByTagName("longitude")[0].childNodes[0].nodeValue;

        if (getDistance(lat, lon, lat2, lon2) < 50) {

            d++;

            var latlon2 = new google.maps.LatLng(xm[i].getElementsByTagName("latitude")[0].childNodes[0].nodeValue,
                    xm[i].getElementsByTagName("longitude")[0].childNodes[0].nodeValue);



            var marker2 = new google.maps.Marker({position: latlon2, map: map, title: xm[i].getElementsByTagName("poiTitle")[0].childNodes[0].nodeValue + "\n" + getDistance(lat, lon, lat2, lon2) + " km" + "\n" + xm[i].getElementsByTagName("poiDescription")[0].childNodes[0].nodeValue});

        }
        if (d == 20)
            break;

    }

}





function showError(error)

{

    switch (error.code)

    {

        case error.PERMISSION_DENIED:

            x.innerHTML = "User denied the request for Geolocation."

            break;

        case error.POSITION_UNAVAILABLE:

            x.innerHTML = "Location information is unavailable."

            break;

        case error.TIMEOUT:

            x.innerHTML = "The request to get user location timed out."

            break;

        case error.UNKNOWN_ERROR:

            x.innerHTML = "An unknown error occurred."

            break;

    }



}




        </script>

    </head>

    <body>
        <h1>Home page</h1>


        <p>
            <a href="${pageContext.request.contextPath}/stat/add.html">Add new - stat</a><br/>
            <a href="${pageContext.request.contextPath}/stat/list.html">Stat - ZOZNAM</a><br/>
        </p>

        <p>
            <a href="${pageContext.request.contextPath}/skupiny/add.html">Add new - skupinu</a><br/>
            <a href="${pageContext.request.contextPath}/skupiny/list.html">Skupiny - ZOZNAM</a><br/>
        </p>

        <center>
            <p>
                <a href="${pageContext.request.contextPath}/stat/statsjson">JSON- zoznam statov</a><br/>
                <a href="${pageContext.request.contextPath}/pocitadlo.html">pocitadlo vs. odberov</a><br/>

            </p>
        </center>

        
       
        <button type="button" class="button" onclick="getLocation()" >
            Ukáž mi najbližšiu stanicu!
        </button>
                
        <br><br><br><br><br>
        <div class="mapulekca" id="mapholder">xx</div>

    </body>
</html>