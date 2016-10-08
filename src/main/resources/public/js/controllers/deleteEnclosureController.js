'use strict';

angular.module('zooApp').controller('deleteEnclosureCtrl', ['$scope','$http', function($scope, $http){

	$scope.deleteId = 0;
	$scope.selectedId = 0;
	$scope.enclosureList = []; 
	
	$scope.resultMsg = "";
	
	//Database call to fill out Enclosure dropdown
	$http.get("/getEnclosures").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.enclosureList.push(value);
		});
	});
	
	$scope.deleteEnclosure = function()
	{
		$http.delete("/deleteEnclosure/"+$scope.selectedId).
        success(function(){
        	$scope.resultMsg = "Enclosure successfully deleted.";
        	$scope.deleteId = 0;
			angular.forEach($scope.enclosureList, function(value, index){
				if(value.enclosureId == $scope.selectedId){
					$scope.deleteId = index;
				}
			});
			$scope.enclosureList.splice($scope.deleteId,1);
        }).
        error(function(error){
        	$scope.resultMsg = "Error deleting enclosure.";
        });
	};
}]);
