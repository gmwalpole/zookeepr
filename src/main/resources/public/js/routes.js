'use strict';

angular.module('zooApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

  $urlRouterProvider.otherwise('/');

  $stateProvider.state('createAnimal', {
    url: '/createAnimal',
    templateUrl: 'templates/createAnimal.tpl.html',
    controller: 'createAnimalCtrl'
  });

  $stateProvider.state('updateAnimal', {
    url: '/updateAnimal',
    templateUrl: 'templates/updateAnimal.tpl.html',
    controller: 'updateAnimalCtrl'
  });
  
  $stateProvider.state('viewAnimal', {
	    url: '/viewAnimal',
	    templateUrl: 'templates/viewAnimal.tpl.html',
	    controller: 'viewAnimalCtrl'
	  });
  
  $stateProvider.state('createEnclosure', {
	    url: '/createEnclosure',
	    templateUrl: 'templates/createEnclosure.tpl.html',
	    controller: 'createEnclosureCtrl'
	  });

  $stateProvider.state('updateEnclosure', {
    url: '/updateEnclosure',
    templateUrl: 'templates/updateEnclosure.tpl.html',
    controller: 'updateEnclosureCtrl'
  });

  $stateProvider.state('deleteEnclosure', {
    url: '/deleteEnclosure',
    templateUrl: 'templates/deleteEnclosure.tpl.html',
    controller: 'deleteEnclosureCtrl'
  });
  
  $stateProvider.state('viewEnclosure', {
	    url: '/viewEnclosure',
	    templateUrl: 'templates/viewEnclosure.tpl.html',
	    controller: 'viewEnclosureCtrl'
	  });
  
  $stateProvider.state('createFood', {
    url: '/createFood',
    templateUrl: 'templates/createFood.tpl.html',
    controller: 'createFoodCtrl'
  });

  $stateProvider.state('updateFood', {
	url: '/updateFood',
	templateUrl: 'templates/updateFood.tpl.html',
	controller: 'updateFoodCtrl'
  });

  $stateProvider.state('viewFood', {
	    url: '/viewFood',
	    templateUrl: 'templates/viewFood.tpl.html',
	    controller: 'viewFoodCtrl'
	  });
  
}]);