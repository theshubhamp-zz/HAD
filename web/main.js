var hadApp = angular.module('hadApp',['ngMaterial', 'ngMessages']);
var unifiedController = hadApp.controller("unifiedController",function($scope, $http) {
	$scope.stateName = "Select a State from the map";
	$scope.stateId = -1;
	//$http.get("").success();
	$scope.setStateDetailsWithRegionCode = function(regionCode){
		switch(regionCode.split('-')[1])
		{
			case 'AN':
				$scope.stateName = "Andaman and Nicobar";
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
				$scope.stateName = "Gujrat";
				break;
			case 'HR':
				$scope.stateName = "Haryana";
				break;
			case 'HP':
				$scope.stateName = "Himachal Pradesh";
				break;
			case 'JK':
				$scope.stateName = "Jammu & Kashmir";
				break;
			case 'JH':
				$scope.stateName = "Jharkhand";
				break;
			case 'KA':
				$scope.stateName = "Karnataka";
				break;
			case 'KL':
				$scope.stateName = "Kerla";
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
	}
});