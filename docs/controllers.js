

angular.module('SvgMapApp', [])
    .controller('MainCtrl', ['$scope', function ($scope) {
        var states = ["JK","GJ","TN","UP","MP","KT"];
        $scope.createDummyData = function () {
            var dataTemp = {};
            angular.forEach(states, function (state, key) {
                dataTemp[state] = {value: Math.random()}
            });
            $scope.dummyData = dataTemp;
        };
        $scope.createDummyData();
    }]);
