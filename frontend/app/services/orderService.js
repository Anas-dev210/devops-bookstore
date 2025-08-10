angular.module('bookstoreApp')
  .service('OrderService', function($http) {
    const baseUrl = 'http://localhost:8083/orders';

    this.getAll = function() {
      return $http.get(baseUrl);
    };

    this.create = function(order) {
      return $http.post(baseUrl, order);
    };
  });