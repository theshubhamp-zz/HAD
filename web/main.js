var hadApp = angular.module('hadApp',['ngMaterial', 'ngMessages','angular-dimple']);
var unifiedController = hadApp.controller("unifiedController",function($scope, $http,$mdDialog) {
	$scope.stateName = "Select a State from the map";
	$scope.stateTabName = 'Districtwise Charts';
	$scope.stateId = -1;
    $scope.stateSummary="";
    var states;
    $http.get('api/states')
        .then(function(resp){
            $scope.stateData = resp.data;
            states = resp.data;
        },function(resp) {
            console.log(resp);
        });
	$http.get('api/population')
        .then(function(resp){
            $scope.popDataState =  resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/pci')
        .then(function(resp){
            $scope.pciDataState =  resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/gdp')
        .then(function(resp){
            $scope.gdpDataState = resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/literacy')
        .then(function(resp){
            $scope.literacyDataState = resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/ger')
        .then(function(resp){
            $scope.gerDataState = resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/hh')
        .then(function(resp){
            $scope.hhDataState = resp.data;
        },function(resp) {
            console.log(resp);
        });
	$http.get('api/pcilitanalysis')
		.then(function(resp){
			$scope.pcilitAnalysisData = resp.data;
		},function(resp) {
			console.log(resp);
		});
	$http.get('api/poplitanalysis')
		.then(function(resp){
			$scope.poplitAnalysisData = resp.data;
		},function(resp) {
			console.log(resp);
		});
	$http.get('api/gdppcianalysis')
		.then(function(resp){
			$scope.gdppciAnalysisData = resp.data;
		},function(resp) {
			console.log(resp);
		});
	$scope.setStateDetailsWithRegionCode = function(regionCode){
		switch(regionCode.split('-')[1])
		{
			case 'AN':
				$scope.stateName = "Andaman and Nicobar Islands";
				break;
			case 'AP':
				$scope.stateName = "Andhra Pradesh";
				break;
			case 'AR':
				$scope.stateName = "Arunachal Pradesh";
				break;
			case 'AS':
				$scope.stateName = "Assam";
				break;
			case 'BR':
				$scope.stateName = "Bihar";
				break;
			case 'CT':
				$scope.stateName = "Chhattisgarh";
				break;
			case 'DL':
				$scope.stateName = "Delhi";
				break;
			case 'GA':
				$scope.stateName = "Goa";
				break;
			case 'GJ':
				$scope.stateName = "Gujarat";
				break;
			case 'HR':
				$scope.stateName = "Haryana";
				break;
			case 'HP':
				$scope.stateName = "Himachal Pradesh";
				break;
			case 'JK':
				$scope.stateName = "Jammu and Kashmir";
				break;
			case 'JH':
				$scope.stateName = "Jharkhand";
				break;
			case 'KA':
				$scope.stateName = "Karnataka";
				break;
			case 'KL':
				$scope.stateName = "Kerala";
				break;
			case 'MP':
				$scope.stateName = "Madhya Pradesh";
				break;
			case 'MH':
				$scope.stateName = "Maharashtra";
				break;
			case 'MN':
				$scope.stateName = "Manipur";
				break;
			case 'ML':
				$scope.stateName = "Meghalaya";
				break;
			case 'MZ':
				$scope.stateName = "Mizoram";
				break;
			case 'NL':
				$scope.stateName = "Nagaland";
				break;
			case 'OR':
				$scope.stateName = "Orissa";
				break;
			case 'PB':
				$scope.stateName = "Punjab";
				break;
			case 'RJ':
				$scope.stateName = "Rajasthan";
				break;
			case 'SK':
				$scope.stateName = "Sikkim";
				break;
			case 'TN':
				$scope.stateName = "Tamil Nadu";
				break;
			case 'UP':
				$scope.stateName = "Uttar Pradesh";
				break;
			case 'WB':
				$scope.stateName = "West Bengal";
				break;
		}
        states.forEach(function(item,index,array) {
            if($scope.stateName === item.name)
            {
                $scope.stateId = item.stateid;
            }
        });
		$scope.stateTabName = $scope.stateName + " Districtwise Charts";
        $http.get('api/population?stateid='+$scope.stateId)
            .then(function(resp){
                $scope.popDataDistrict = resp.data;
            },function(resp) {
                console.log(resp);
            });
		$http.get('api/gdp?stateid='+$scope.stateId)
			.then(function(resp){
				$scope.gdpDataDistrict = resp.data;
			},function(resp) {
				console.log(resp);
			});
        if($scope.stateId>0)
        {
            $scope.stateSummary = [];
			$scope.popDataState.forEach(function(item,index,array) {
				if($scope.stateName === item.name)
				{$scope.stateSummary.push("Population is "+item.populationYear2011);}});
			$scope.gdpDataState.forEach(function(item,index,array) {
				if($scope.stateName === item.name)
				{$scope.stateSummary.push("GDP is "+item.gdpYear2010_11);}});
			$scope.pciDataState.forEach(function(item,index,array) {
				if($scope.stateName === item.name)
				{$scope.stateSummary.push("Per Capita Income is "+item.percapitaYear2010_11);}});
			$scope.gerDataState.forEach(function(item,index,array) {
				if($scope.stateName === item.name)
				{$scope.stateSummary.push("Gross Enrollment Ratio for Males is "+item.allMale+"%");}});
			$scope.literacyDataState.forEach(function(item,index,array) {
				if($scope.stateName === item.name)
				{$scope.stateSummary.push("Literacy Rate is "+item.literacyRate2011+"%");}});
			$scope.hhDataState.forEach(function(item,index,array) {
				if($scope.stateName === item.name)
				{$scope.stateSummary.push("Households with size > 4 are "+item.HHSIZE_4);}});
        }
	}
    //Dialog
    $scope.showDialog = function(ev,graphData,x,y) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: 'chart.tmpl.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true,
            fullscreen: false,
            locals: {
                data : graphData,
                xf : x,
                yf : y
            }
        });
    }
});