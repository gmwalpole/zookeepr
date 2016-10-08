'use strict';

angular.module('zooApp').controller('updateFoodCtrl', ['$scope','$http', function($scope, $http){

	$scope.foodList = [];
	$scope.categoryList = [];
	$scope.selectedId = 0;
	$scope.currentFood = {
	    foodId: 0,
	    name: "",
		categoryId: 0,
		vendor: ""
	};
	
	$scope.resultMsg = "";

	//Database call to fill out Category dropdown
	$http.get("/getCategories").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.categoryList.push(value);
		});
	});
	
	//Database call to fill out Food dropdown
	$http.get("/getAllFood").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.foodList.push(value);
		});
	});
	
	//Gets the entire Food object from the stored array from the ID selected from the dropdown.
	$scope.setCurrent = function(){
		if($scope.selectedId == 0){
			//Create a 'safe' object to avoid errors if the user selects a "--Select One--"
			//option or something.
			$scope.currentFood = {
			    foodId: 0,
			    name: "",
			    categoryId: 0,
			    vendor: ""
			};
		}
		else{
			//We can't reference these by index, so we have to do a search of the array.
			angular.forEach($scope.foodList, function(value){
				if(value.foodId == $scope.selectedId){
				  $scope.currentFood = value;
				}
			});
		}
	};
	
	//Form validation
	$scope.validateForm = function(){
		var errorOutput = "";
		//Build the error string as needed.
		if($scope.selectedId == 0){
			errorOutput = errorOutput + "A food to update must be selected.<br>";
		}
		if($scope.currentFood.categoryId == 0){
			errorOutput = errorOutput + "A category must be selected.<br>";
		}
		if($scope.currentFood.name.length == 0){
			errorOutput = errorOutput + "A name is required.<br>";
		}
		if($scope.currentFood.vendor.length == 0){
			errorOutput = errorOutput + "A vendor is required.<br>";
		}
		//If nothing is invalid, run the add function, otherwise display the error message.
		if(errorOutput.length == 0){
			$scope.updateFood();
		}
		else{
			$scope.resultMsg = errorOutput;
		}
	};
	
	//Function for update call.
	$scope.updateFood = function(){
		$http.put("/updateFood",$scope.currentFood).
		success(function(){
        	$scope.resultMsg = "Food successfully updated.";
        }).
        error(function(){
        	$scope.resultMsg = "Error updating food.";
        });
	};
	
}]);