      google.charts.load('current', {'packages':['geochart']});
      google.charts.setOnLoadCallback(drawRegionsMap);

      function drawRegionsMap() {

        var data = google.visualization.arrayToDataTable([
          ['Country', 'State ID'],
          ["Andaman and Nicobar",1],
  				["Andhra Pradesh",2],
  				["Arunachal Pradesh",3],
  				["Assam",4],
  				["Bihar",5],
  				["Chandigarh",6],
  				["Chhattisgarh",7],
  				["Dadra and Nagar Haveli",8],
  				["Daman and Diu",9],
  				["Delhi",10],
  				["Goa",11],
  				["Gujarat",12],
  				["Haryana",13],
  				["Himachal Pradesh",14],
  				["Jammu and Kashmir",15],
  				["Jharkhand",16],
  				["Karnataka",17],
  				["Kerala",18],
  				["Lakshadweep",19],
  				["Madhya Pradesh",20],
  				["Maharashtra",21],
  				["Manipur",22],
  				["Meghalaya",23],
  				["Mizoram",24],
  				["Nagaland",25],
  				["Orissa",26],
  				["Pondicherry",27],
  				["Punjab",28],
  				["Rajasthan",29],
  				["Sikkim",30],
  				["Tamil Nadu",31],
  				["Tripura",32],
  				["Uttar Pradesh",33],
  				["Uttarakhand",34],
  				["West Bengal",35]
        ]);

        var options = {
        	region: 'IN',
        	displayMode: 'regions',
        	resolution: 'provinces',
          backgroundColor: 'transparent',
          //colorAxis: {colors: ['#00853f', 'black', '#e31b23']},
          regionClick: true
        };
        var chart = new google.visualization.GeoChart(document.getElementById('map'));
        google.visualization.events.addListener(chart, 'regionClick', function(regionObject){
          var regionId = regionObject.region;
          var cScope = angular.element(document.getElementById('uc')).scope();
          cScope.$apply(function(){
            cScope.setStateDetailsWithRegionCode(regionId);
          });
          console.log(arguments[0]);
        });
        chart.draw(data, options);
      }