angular.module('SvgMapApp').directive('svgMap', ['$compile', function ($compile) {
    return {
        restrict: 'A',
        templateUrl: 'img/India-map-en',
        link: function (scope, element, attrs) {
            var regions = element[0].querySelectorAll('.state');
            angular.forEach(regions, function (path, key) {
                var regionElement = angular.element(path);
                regionElement.attr("region", "");
                $compile(regionElement)(scope);
            })
        }
    }
}]);

angular.module('SvgMapApp').directive('region', ['$compile', function ($compile) {
    return {
        restrict: 'A',
        scope: true,
        link: function (scope, element, attrs) {
            scope.elementId = element.attr("id");
            scope.regionClick = function () {
                alert(scope.elementId);
            };
            element.attr("ng-click", "regionClick()");
            element.removeAttr("region");
            $compile(element)(scope);
        }
    }
}]);
