'use strict';

angular.module('zooApp').controller('viewFoodCtrl', ['$scope','$http', function($scope, $http){

	$scope.foodList = [];
	$scope.categoryList = [];
	$scope.selectedId = 0;
	$scope.currentFood = {
	    foodId: 0,
	    name: "",
		categoryId: 0,
		vendor: ""
	};
	$scope.currentCategory = "";
	
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
			$scope.currentCategory = "";
		}
		else{
			//We can't reference these by index, so we have to do a search of the array.
			angular.forEach($scope.foodList, function(value){
				if(value.foodId == $scope.selectedId){
				  $scope.currentFood = value;
				    //Getting the enclosed animal out the same way for the same reason.
					angular.forEach($scope.categoryList, function(value){
					    if(value.categoryId == $scope.currentFood.categoryId){
					        $scope.currentCategory = value.category;
						}
					});
				}
			});
		}
	};
	
}]);