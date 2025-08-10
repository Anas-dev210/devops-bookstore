angular.module('bookstoreApp')
  .service('UserService', function($http) {
    const baseUrl = 'http://localhost:8081/users'; // adjust as needed

    this.getAll = function() {
      return $http.get(baseUrl);
    };

    this.create = function(user) {
      return $http.post(baseUrl, user);
    };
  });