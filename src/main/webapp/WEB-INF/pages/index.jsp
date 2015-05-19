<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SolarMax LoGgeR</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="http://code.highcharts.com/stock/highstock.js"></script>
    <script src="http://code.highcharts.com/stock/modules/exporting.js"></script>
</head>

<body>
<div id="container"></div>
<style scoped>
    body {
        height: 100%;
        width: 100%;
        position: absolute;
        margin-left: auto;
        margin-right: auto;
        margin-top: auto;
        margin-bottom: auto;
    }

    #container {
        height: 100%;
        width: 100%;
    }
</style>
<script type="text/javascript">
    $(function () {
        Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });

        $.getJSON("api/history/today", function (response) {
            renderChart(response.data);
        });

        function renderChart(data) {
            $("#container").highcharts("StockChart", {
                chart: {
                    type: "line"
                },
                rangeSelector: {
                    enabled: true
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
                        hour: '%H:%m',
                        minute: '%H:%m'
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
    });
</script>
</body>

</html>
