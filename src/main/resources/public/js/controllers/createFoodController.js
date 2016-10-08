'use strict';

angular.module('zooApp').controller('createFoodCtrl', ['$scope','$http', function($scope, $http){
	
	$scope.categoryId = 0;
	$scope.vendor = "";
	$scope.foodName = "";
	
	$scope.resultMsg = "";

	$scope.categoryList = [];
	
	$http.get("/getCategories").then(function(dataObj){
		angular.forEach(dataObj.data, function(value){
			$scope.categoryList.push(value);
		});
	});
	
	//Form validation
	$scope.validateForm = function(){
		var errorOutput = "";
		//Build the error string as needed.
		if($scope.categoryId == 0){
			errorOutput = errorOutput + "A category must be selected.<br>";
		}
		if($scope.foodName.length == 0){
			errorOutput = errorOutput + "A name is required.<br>";
		}
		if($scope.vendor.length == 0){
			errorOutput = errorOutput + "A vendor is required.<br>";
		}
		//If nothing is invalid, run the add function, otherwise display the error message.
		if(errorOutput.length == 0){
			$scope.addFood();
		}
		else{
			$scope.resultMsg = errorOutput;
		}
	};
	
	$scope.addFood = function()
	{
		$scope.food = JSON.stringify({"name":$scope.foodName,
				         "categoryId":$scope.categoryId,
				         "vendor":$scope.vendor});
		$http.post("/addFood",$scope.food).
        success(function(){
        	$scope.resultMsg = "Food successfully added.";
        }).
        error(function(){
        	$scope.resultMsg = "Error adding food.";
        });
	};
}]);