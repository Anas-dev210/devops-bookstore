angular.module('bookstoreApp')
  .run(function($rootScope, $location) {
    $rootScope.isActive = function(viewLocation) {
      return viewLocation === $location.path();
    };
  });