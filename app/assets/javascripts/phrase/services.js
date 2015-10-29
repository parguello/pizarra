/**
 * User service, exposes user model to the rest of the app.
 */
define(['angular', 'common'], function (angular) {
  'use strict';

  var mod = angular.module('phrase.services', ['pizarra.common', 'ngCookies']);

  mod.factory('phraseService', ['$http', '$q', 'playRoutes', '$cookies', '$log', function ($http, $q, playRoutes, $cookies, $log) {
    $log.info('PhaseService');
    var resdata;
    
    return {
      submitPhrase: function (dictionary) {
        return playRoutes.controllers.Phrase.submit().post(dictionary).then(function (response) {
           $log.info("phrase added");
           resdata = response.data;
           $log.info("resdata:" + resdata);
        });
      }
    };


  }]);

  /**
   * If the current route does not resolve, go back to the start page.
   */
  var handleRouteError = function ($rootScope, $location) {
    $rootScope.$on('$routeChangeError', function (/*e, next, current*/) {
      $location.path('/');
    });
  };
  handleRouteError.$inject = ['$rootScope', '$location'];
  mod.run(handleRouteError);
  return mod;
});
