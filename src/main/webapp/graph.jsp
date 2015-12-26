<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SolarMax LoGgeR</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script src="http://code.highcharts.com/stock/highstock.js"></script>
    <script src="http://code.highcharts.com/stock/modules/exporting.js"></script>

    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
</head>

<body>
<div id="header">
    <div id="logo">

    </div>
    <div id="interval">
        <form id="intervalForm">
            <label for="dateSelector">Choose date:</label><input id="dateSelector" name="dateSelector" type="date"/>
        </form>
    </div>
</div>
<div id="container"></div>
<style scoped>
    body {
        height: 100%;
        width: 100%;
        position: absolute;
        margin: auto;
    }

    #header {
        height: 10%;
        width: 100%;
        vertical-align: middle;
    }

    #container {
        height: 90%;
        width: 100%;
    }

    #logo {
        width: 35%;
        float: left;
    }

    #interval {
        width: 65%;
        text-align: right;
        float: right;
    }

    #dateSelector {
        text-align: center;
    }
</style>
<script type="text/javascript">
    var inverterTag = "<%= request.getAttribute("inverterTag") %>";
    var minDate = new Date(<%= request.getAttribute("minDate") %>);
    var maxDate = new Date(<%= request.getAttribute("maxDate") %>);

    function updateInterval(date) {
        var startDate = new Date(date).setHours(0, 0, 0, 0);
        var stopDate = new Date(date).setHours(23, 59, 59, 999);

        var requestBody = {
            tag: inverterTag,
            startInterval: startDate,
            stopInterval: stopDate
        };

        $.ajax({
            url: "api/query/dataPayload",
            type: "POST",
            data: JSON.stringify(requestBody),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (response) {
                console.log(response);
                var dataToRender = response.data.dataPayloads.map(function (a) {
                    return [a.dateTime, a.acPower]
                });
                renderChart(dataToRender);
            }
        });
    }

    $(function () {
        Highcharts.setOptions({
            global: {
                useUTC: true
            }
        });

        var dateSelector = $("#dateSelector");
        dateSelector.datepicker({
            showButtonPanel: true,
            changeMonth: true,
            changeYear: true,
            showWeek: true,
            firstDay: 1,
            showAnim: "slideDown",
            dateFormat: "yy-mm-dd",
            minDate: minDate,
            maxDate: maxDate,
            onSelect: function (d, i) {
                if (d !== i.lastVal) {
                    $(this).change();
                }
            }
        });

        dateSelector.change(function () {
            updateInterval(dateSelector.val());
        });

        updateInterval(1451001600000, 1451087999999);
    });

    function renderChart(data) {
        $("#container").highcharts("StockChart", {
            chart: {
                type: "line"
            },
            rangeSelector: {
                enabled: false
            },
            title: {
                text: "Power"
            },
            xAxis: {
                title: {
                    enabled: true,
                    text: "Hours of the day"
                },
                type: "datetime",
                dateTimeLabelFormats: {
                    hour: '%H:%M',
                    minute: '%H:%M'
                }
            },
            yAxis: {
                allowDecimals: false,
                title: {
                    text: "Power (W)",
                    min: 0,
                    floor: 0,
                    ceiling: 3000
                }
            },
            tooltip: {
                crosshairs: [true, true],
                valueDecimals: 0,
                valueSuffix: " Watt"
            },
            series: [{
                name: "Production",
                type: "area",
                data: data,
                fillColor: {
                    linearGradient: {
                        x1: 0,
                        y1: 0,
                        x2: 0,
                        y2: 1
                    },
                    stops: [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get("rgba")]
                    ]
                }
            }]
        });
    }
</script>
</body>

</html>
