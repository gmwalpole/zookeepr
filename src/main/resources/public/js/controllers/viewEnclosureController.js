'use strict';

angular.module('zooApp').controller('viewEnclosureCtrl', ['$scope','$http', function($scope, $http){
	
	$scope.currentEnclosure = {
			enclosureId: 0,
		    animalId: 0,
			animalQuantity: 0,
		    name: "",
		    conditionId: 0,
			feedingTime: "1:00PM"
		};
	
	$scope.currentAnimal = "";
	$scope.currentCondition = "";
		
	$scope.enclosureList = [];
	$scope.conditionList = [];
	$scope.animalList = [];

	//Database call to fill out Enclosures dropdown
	$http.get("/getEnclosures").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.enclosureList.push(value);
		});
	});

	//Database call to fill out Conditions dropdown
	$http.get("/getConditions").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.conditionList.push(value);
		});
	});

	//Database call to fill out Animals dropdown
	$http.get("/getAnimals").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.animalList.push(value);
		});
	});
	
	//Gets the entire Enclosure object from the stored array from the ID selected from the dropdown.
	$scope.setCurrent = function(){
		if($scope.selectedId == 0){
			//Create a 'safe' object to avoid errors if the user selects a "--Select One--"
			//option or something.
			$scope.currentEnclosure = {
					enclosureId: 0,
				    animalId: 0,
					animalQuantity: 0,
				    name: "",
				    conditionId: 0,
					feedingTime: "1:00PM"
				};
			$scope.currentAnimal = "";
			$scope.currentCondition = "";
		}
		else{	
			//We can't reference these by index, so we have to do a search of the array.
			angular.forEach($scope.enclosureList, function(value){
				if(value.enclosureId == $scope.selectedId){
					$scope.currentEnclosure = value;
				    //Getting the enclosed animal out the same way for the same reason.
					angular.forEach($scope.animalList, function(value){
					    if(value.animalId == $scope.currentEnclosure.animalId){
					        $scope.currentAnimal = value.commonName;
						}
					});
				    //...Aaand the condition. Same deal.
					angular.forEach($scope.conditionList, function(value){
					    if(value.conditionId == $scope.currentEnclosure.conditionId){
					        $scope.currentCondition = value.condition;
						}
					});
				}
			});
		}
	};

}]);