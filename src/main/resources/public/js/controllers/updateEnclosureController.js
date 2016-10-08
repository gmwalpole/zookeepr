'use strict';

angular.module('zooApp').controller('updateEnclosureCtrl', ['$scope','$http','$filter', function($scope, $http, $filter){
	
	$scope.currentEnclosure = {
			enclosureId: 0,
		    animalId: 0,
			animalQuantity: 0,
		    name: "",
		    conditionId: 0,
			feedingTime: "1:00PM"
		};
	
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
		}
		else{	
			//We can't reference these by index, so we have to do a search of the array.
			angular.forEach($scope.enclosureList, function(value){
				if(value.enclosureId == $scope.selectedId){
				  $scope.currentEnclosure = value;
				}
			});
		}
		//Parse the feedingTime into pieces for the dropdowns to model
		$scope.feedingHour = $filter('limitTo')($scope.currentEnclosure.feedingTime, -2, -5);
		$scope.feedingMinute = $filter('limitTo')($scope.currentEnclosure.feedingTime, -2, -2);
		$scope.feedingDayHalf = $filter('limitTo')($scope.currentEnclosure.feedingTime, -2, -0);
	};

	//Form validation
	$scope.validateForm = function(){
		var errorOutput = "";
		//Build the error string as needed.
		if($scope.selectedId == 0){
			errorOutput = errorOutput + "An enclosure to update must be selected.<br>";
		}
		if($scope.currentEnclosure.animalId == 0){
			errorOutput = errorOutput + "An animal must be selected.<br>";
		}
		if($scope.currentEnclosure.animalQuantity < 0 || $scope.currentEnclosure.animalQuantity == undefined){
			errorOutput = errorOutput + "Animal quantity less than 0 is not possible.<br>";
		}
		if($scope.currentEnclosure.conditionId == 0){
			errorOutput = errorOutput + "A condition must be selected.<br>";
		}
		if($scope.currentEnclosure.name.length == 0){
			errorOutput = errorOutput + "A name is required.<br>";
		}
		//If nothing is invalid, run the add function, otherwise display the error message.
		if(errorOutput.length == 0){
			$scope.updateEnclosure();
		}
		else{
			$scope.resultMsg = errorOutput;
		}
	};
	
	//Function for update call.
	$scope.updateEnclosure = function(){
		//Have to recombine the subsections of feedingTime and re-add it to the object.
		$scope.currentEnclosure.feedingTime = $scope.feedingHour + ":" + $scope.feedingMinute + $scope.feedingDayHalf;
		$http.put("/updateEnclosure",$scope.currentEnclosure).
		success(function(){
        	$scope.resultMsg = "Enclosure successfully updated.";
        }).
        error(function(){
        	$scope.resultMsg = "Error updating enclosure.";
        });
	};
	
}]);