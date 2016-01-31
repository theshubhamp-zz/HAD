var cidx =0;
$(document).ready(function(){
    $("#popchart").show();
    $("#gdpchart").hide();
    $("#litchart").hide();
});
$('#toggle').click(function(){
    cidx++;
    $('#chart').html('');
    cidx = cidx%3;
    if(cidx==0)
    {
        $('#chart').html('<h2>Population Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1200, 600);
        d3.json("http://"+location.hostname+"/api/population", function (data) {
            var myChart = new dimple.chart(svg, data);
            //myChart.setBounds(60, 60, 1200, 700);
            var x = myChart.addCategoryAxis("x", "name");
            var y = myChart.addMeasureAxis("y", "populationYear2011");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("Population in 2011");
        });
    }
    else if(cidx==1)
    {
        $('#chart').html('<h2>GDP Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1200, 600);
        d3.json("http://"+location.hostname+"/api/gdp", function (data) {
            var myChart = new dimple.chart(svg, data);
            //myChart.setBounds(60, 60, 1200, 700);
            var x = myChart.addCategoryAxis("x", "name");
            var y = myChart.addMeasureAxis("y", "gdpYear2010_11");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("GDP in 2010-11");
        });
    }
    else{
        $('#chart').html('<h2>Literacy Rate Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1200, 600);
        d3.json("http://"+location.hostname+"/api/literacy", function (data) {
            var myChart = new dimple.chart(svg, data);
            //myChart.setBounds(60, 60, 1200, 700);
            var x = myChart.addCategoryAxis("x", "name");
            var y = myChart.addMeasureAxis("y", "literacyRate2011");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("Literacy in 2011");
        });
    }
});