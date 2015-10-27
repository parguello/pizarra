/**
 * Configure routes of user module.
 */
define(['angular', './controllers', 'common'], function(angular, controllers) {
  'use strict';

  var mod = angular.module('phrase.routes', ['phrase.services', 'pizarra.common']);
  mod.config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/add', {
        templateUrl:'/assets/javascripts/phrase/form.html', 
        controller:controllers.PhraseCtrl
      });
  }]);
  return mod;
});
