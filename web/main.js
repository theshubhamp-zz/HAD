var hadApp = angular.module('hadApp',['ngMaterial', 'ngMessages','angular-dimple']);
var unifiedController = hadApp.controller("unifiedController",function($scope, $http,$mdDialog) {
	$scope.stateName = "Select a State from the map";
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
            $scope.popDataStateGraph = resp.data;
            $scope.popDataState =  resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/pci')
        .then(function(resp){
            $scope.pciDataStateGraph = resp.data;
            $scope.pciDataState =  resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/gdp')
        .then(function(resp){
            $scope.gdpDataStateGraph = resp.data;
            $scope.gdpDataState = resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/literacy')
        .then(function(resp){
            $scope.literacyDataStateGraph = resp.data;
            $scope.literacyDataState = resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/ger')
        .then(function(resp){
            $scope.gerDataStateGraph = resp.data;
            $scope.gerDataState = resp.data;
        },function(resp) {
            console.log(resp);
        });
    $http.get('api/hh')
        .then(function(resp){
            $scope.hhDataStateGraph = resp.data;
            $scope.hhDataState = resp.data;
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
        //pop-districtwise
        $http.get('api/population?stateid='+$scope.stateId)
            .then(function(resp){
                $scope.popDataDistrict = $scope.popDataDistrictGraph = resp.data;
                //console.log($scope.popDataDistrict);
            },function(resp) {
                console.log(resp);
            });
        //
        if($scope.stateId>0)
        {
            var idx = $scope.stateId;
            $scope.stateSummary = [
                $scope.popDataState[idx-1].name,
                "Population is "+$scope.popDataState[idx-1].populationYear2011,
                "GDP is "+$scope.gdpDataState[idx-1].gdpYear2010_11,
                "Per Capita Income is "+$scope.pciDataState[idx-1].percapitaYear2009_10,
                "Gross Enrollment for All Males is "+$scope.gerDataState[idx-1].allMale,
                "Literacy Rate is "+$scope.literacyDataState[idx-1].literacyRate2011,
                "Households with Size of 4 are "+$scope.hhDataState[idx-1].HHSIZE_4 ];
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

function DialogController($scope, $mdDialog,data,xf,yf) {
    $scope.graphData = data;
    $scope.x = xf;
    $scope.y = yf;
    $scope.hide = function() {
        $mdDialog.hide();
    }
    $scope.cancel = function() {
        $mdDialog.cancel();
    }
}