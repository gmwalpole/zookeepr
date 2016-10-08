'use strict';

angular.module('zooApp').controller('updateAnimalCtrl', ['$scope','$http', function($scope, $http){
	
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
	
	$scope.resultMsg = "";

	//Database call to fill out Animal dropdown
	$http.get("/getAnimals").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.animalList.push(value);
		});
	});

	//Database call to fill out Food dropdown
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
		}
		else{
			//We can't reference these by index, so we have to do a search of the array.
			angular.forEach($scope.animalList, function(value){
				if(value.animalId == $scope.selectedId){
				  $scope.currentAnimal = value;
				}
			});
		}
	};

	//Form validation
	$scope.validateForm = function(){
		var errorOutput = "";
		//Build the error string as needed.
		if($scope.selectedId == 0){
			errorOutput = errorOutput + "An animal to update must be selected.<br>";
		}
		if($scope.currentAnimal.foodId == 0){
			errorOutput = errorOutput + "A favorite food must be selected.<br>";
		}
		if($scope.currentAnimal.commonName.length == 0){
			errorOutput = errorOutput + "A common name is required.<br>";
		}
		if($scope.currentAnimal.scientificName.length == 0){
			errorOutput = errorOutput + "A scientific name is required.<br>";
		}
		//If nothing is invalid, run the add function, otherwise display the error message.
		if(errorOutput.length == 0){
			$scope.updateAnimal();
		}
		else{
			$scope.resultMsg = errorOutput;
		}
	};
	
	//Function for update call.
	$scope.updateAnimal = function(){
		$http.put("/updateAnimal",$scope.currentAnimal).
		success(function(){
        	$scope.resultMsg = "Animal successfully updated.";
        }).
        error(function(){
        	$scope.resultMsg = "Error updating animal.";
        });
	};
	
}]);