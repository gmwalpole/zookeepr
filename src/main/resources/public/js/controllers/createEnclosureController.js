'use strict';

angular.module('zooApp').controller('createEnclosureCtrl', ['$scope','$http', function($scope, $http){
	
	$scope.animalId = 0;
	$scope.conditionId = 0;
	$scope.animalNumber = 0;
	$scope.enclosureName = "";
	$scope.feedingHour = "1";
	$scope.feedingMinute = "00";
	$scope.feedingDayHalf = "AM";
	$scope.feedingTime = "";
	
	$scope.resultMsg = "";
	
	//In lieu of number fields (which won't display correctly for '0#' minutes)
	//I am instead just looping through hardcoded arrays. A loop to fill out the minutes
	//array takes roughly as much space, so as hackish as this looks...
	$scope.allowedHours = ["1","2","3","4","5","6","7","8","9","10","11","12"];
	$scope.allowedMinutes = ["00","01","02","03","04","05","06","07","08","09",
	                         "10","11","12","13","14","15","16","17","18","19",
	                         "20","21","22","23","24","25","26","27","28","29",
	                         "30","31","32","33","34","35","36","37","38","39",
	                         "40","41","42","43","44","45","46","47","48","49",
	                         "50","51","52","53","54","55","56","57","58","59"];	
	
	$scope.conditionList = [];
	$scope.animalList = [];

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

	//Form validation
	$scope.validateForm = function(){
		var errorOutput = "";
		//Build the error string as needed.
		if($scope.animalId == 0){
			errorOutput = errorOutput + "An animal must be selected.<br>";
		}
		console.log($scope.animalNumber);
		if($scope.animalNumber < 0 || $scope.animalNumber == undefined){
			errorOutput = errorOutput + "Animal quantity less than 0 is not possible.<br>";
		}
		if($scope.conditionId == 0){
			errorOutput = errorOutput + "A condition must be selected.<br>";
		}
		if($scope.enclosureName.length == 0){
			errorOutput = errorOutput + "A name is required.<br>";
		}
		//If nothing is invalid, run the add function, otherwise display the error message.
		if(errorOutput.length == 0){
			$scope.addEnclosure();
		}
		else{
			$scope.resultMsg = errorOutput;
		}
	};
	
	//Database call to add the Enclosure
	$scope.addEnclosure = function(){
		//Have to recombine the subsections of feedingTime and add it to the object.
		$scope.feedingTime = $scope.feedingHour + ":" + $scope.feedingMinute + $scope.feedingDayHalf;
		$scope.space = JSON.stringify({"animalId":$scope.animalId,
				         "conditionId":$scope.conditionId,
				         "animalQuantity":$scope.animalNumber,
				         "feedingTime":$scope.feedingTime,
				         "name":$scope.enclosureName});
		$http.post("/addEnclosure",$scope.space).
        success(function(){
        	$scope.resultMsg = "Enclosure successfully added.";
        }).
        error(function(){
        	$scope.resultMsg = "Error adding enclosure.";
        });
	};
}]);