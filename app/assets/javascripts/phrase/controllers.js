/**
 * User controllers.
 */
define([], function() {
  'use strict';

  var PhraseCtrl = function($scope, $location, phraseService) {
    $scope.dictionary = {};

    $scope.submit = function(dictionary) {
       phraseService.submitPhrase(dictionary).then(function(/*phrase*/) {
         $location.path('/');
       });
    };
  };
  PhraseCtrl.$inject = ['$scope', '$location', 'phraseService'];

  return {
    PhraseCtrl: PhraseCtrl
  };

});
