'use strict';

angular.module('zooApp').controller('viewAnimalCtrl', ['$scope','$http', function($scope, $http){
	$scope.animalList = []; 
	$scope.foodList = [];
	$scope.selectedId = 0;
	$scope.currentAnimal = {
	    animalId: 0,
	    commonName: "",
		foodId: 0,
		infoLink: "",
		scientificName: ""
	};
	$scope.currentFood = "";
	
	//Database call to fill out Animal dropdown
	$http.get("/getAnimals").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.animalList.push(value);
		});
	});

	//Database call to fill out Food array
	$http.get("/getAllFood").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.foodList.push(value);
		});
	});
	
	//Gets the entire Animal object from the stored array from the ID selected from the dropdown.
	$scope.setCurrent = function(){
		if($scope.selectedId == 0){
			//Create a 'safe' object to avoid errors if the user selects a "--Select One--"
			//option or something.
			$scope.currentAnimal = {
			    animalId: 0,
			    commonName: "",
				foodId: 0,
				infoLink: "",
				scientificName: ""
			};
			$scope.currentFood = "";
		}
		else{
			//We can't reference these by index, so we have to do a search of the array.
			angular.forEach($scope.animalList, function(value){
				if(value.animalId == $scope.selectedId){
				    $scope.currentAnimal = value;
			        //Getting the favorite food out the same way for the same reason.
				    angular.forEach($scope.foodList, function(value){
				    	if(value.foodId == $scope.currentAnimal.foodId){
					      $scope.currentFood = value.name;
					    }
				    });
				}
			});
		}
	};
	
}]);