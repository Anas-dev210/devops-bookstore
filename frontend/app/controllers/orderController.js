angular.module('bookstoreApp')
  .controller('OrderController', function($scope, OrderService) {
    $scope.orders = [];
    $scope.loading = true;
    $scope.error = null;

    OrderService.getAll()
      .then(function(response) {
        $scope.orders = response.data;
      })
      .catch(function(err) {
        $scope.error = 'Failed to load orders';
      })
      .finally(function() {
        $scope.loading = false;
      });

    $scope.placeOrder = function(order) {
      OrderService.create(order)
        .then(function(response) {
          $scope.orders.push(response.data);
          $scope.newOrder = {};
        })
        .catch(function(err) {
          $scope.error = 'Failed to place order';
        });
    };
  });