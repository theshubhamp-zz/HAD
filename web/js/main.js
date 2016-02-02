var cidx =0;
$(document).ready(function(){
    $("#chart").show();
});
$('#toggle').click(function(){
    cidx++;
    $('#chart').html('');
    cidx = cidx%4;
    if(cidx==0)
    {
        $('#chart').html('<h2>Population Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1360, 600);
        d3.json("http://"+location.hostname+"/api/population", function (data) {
            var myChart = new dimple.chart(svg, data);
            myChart.setBounds(60, 60, 1300, 400);
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
        var svg = dimple.newSvg("#chart", 1360, 600);
        d3.json("http://"+location.hostname+"/api/gdp", function (data) {
            var myChart = new dimple.chart(svg, data);
            myChart.setBounds(60, 60, 1300, 400);
            var x = myChart.addCategoryAxis("x", "name");
            var y = myChart.addMeasureAxis("y", "gdpYear2010_11");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("GDP in 2010-11");
        });
    }
    else if(cidx==2){
        $('#chart').html('<h2>Literacy Rate Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1360, 600);
        d3.json("http://"+location.hostname+"/api/literacy", function (data) {
            var myChart = new dimple.chart(svg, data);
            myChart.setBounds(60, 60, 1300, 400);
            var x = myChart.addCategoryAxis("x", "name");
            var y = myChart.addMeasureAxis("y", "literacyRate2011");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("Literacy in 2011");
        });
    }
	else if(cidx==3){
        $('#chart').html('<h2>Household Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1360, 600);
        d3.json("http://"+location.hostname+"/api/hh", function (data) {
            var myChart = new dimple.chart(svg, data);
            myChart.setBounds(60, 60, 1300, 400);
            var x = myChart.addCategoryAxis("x", "name");
            var y = myChart.addMeasureAxis("y", "houseoldYear2011");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("Household in 2011");
        });
    }
	else if(cidx==3){
        $('#chart').html('<h2>Gross Enrollment Ratio Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1360, 600);
        d3.json("http://"+location.hostname+"/api/gre", function (data) {
            var myChart = new dimple.chart(svg, data);
            myChart.setBounds(60, 60, 1300, 400);
            var x = myChart.addCategoryAxis("x", "name");
            var y = myChart.addMeasureAxis("y", "grossenrollRatio2011");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("Gross Enroll Ratio in 2011");
        });
    }
    else{
        $('#chart').html('<h2>Per Capita Income Statewise for year 2011</h2>>');
        var svg = dimple.newSvg("#chart", 1360, 600);
        d3.json("http://"+location.hostname+"/api/pci", function (data) {
            var myChart = new dimple.chart(svg, data);
            myChart.setBounds(60, 60, 1300, 400);
            var x = myChart.addCategoryAxis("x", "stateName");
            var y = myChart.addMeasureAxis("y", "percapitaYear2010_11");
            myChart.addSeries(null, dimple.plot.bar);
            myChart.draw();
            x.titleShape.text("States");
            y.titleShape.text("PCI in 2011");
        });
    }
});