'use strict';

angular.module('zooApp').controller('createAnimalCtrl', ['$scope','$http', function($scope, $http){
	
	$scope.animalName = "";
	$scope.latinName = "";
	$scope.favoriteFood = 0;
	$scope.infoLink = "";
	
	$scope.resultMsg = "";
	
	$scope.foodList = [];
	$http.get("/getAllFood").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.foodList.push(value);
		});
	});

	//Form validation
	$scope.validateForm = function(){
		var errorOutput = "";
		//Build the error string as needed.
		if($scope.favoriteFood == 0){
			errorOutput = errorOutput + "A favorite food must be selected.<br>";
		}
		if($scope.animalName.length == 0){
			errorOutput = errorOutput + "A common name is required.<br>";
		}
		if($scope.latinName.length == 0){
			errorOutput = errorOutput + "A scientific name is required.<br>";
		}
		//If nothing is invalid, run the add function, otherwise display the error message.
		if(errorOutput.length == 0){
			$scope.addAnimal();
		}
		else{
			$scope.resultMsg = errorOutput;
		}
	};

	$scope.addAnimal = function()
	{
		$scope.animal = JSON.stringify({"commonName":$scope.animalName,
				         "scientificName":$scope.latinName,
				         "foodId":$scope.favoriteFood,
				         "infoLink":$scope.infoLink});
		$http.post("/addAnimal",$scope.animal).
        success(function(){
        	$scope.resultMsg = "Animal successfully added.";
        }).
        error(function(){
        	$scope.resultMsg = "Error adding animal.";
        });
	};
}]);