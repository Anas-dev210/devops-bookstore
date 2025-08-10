angular.module('bookstoreApp')
  .controller('UserController', function($scope, UserService) {
    $scope.users = [];
    $scope.loading = true;
    $scope.error = null;

    UserService.getAll()
      .then(function(response) {
        $scope.users = response.data;
      })
      .catch(function(err) {
        $scope.error = 'Failed to load users';
      })
      .finally(function() {
        $scope.loading = false;
      });

    $scope.addUser = function(newUser) {
      UserService.create(newUser)
        .then(function(response) {
          $scope.users.push(response.data);
          $scope.newUser = {};
        })
        .catch(function(err) {
          $scope.error = 'Failed to add user';
        });
    };
  });