// Configure routes and other settings
angular.module('bookstoreApp')
  .config(function($routeProvider) {
    $routeProvider
      .when('/users', {
        templateUrl: 'app/views/user.html',
        controller: 'UserController'
      })
      .when('/books', {
        templateUrl: 'app/views/books.html',
        controller: 'BookController'
      })
      .when('/order', {
        templateUrl: 'app/views/order.html',
        controller: 'OrderController'
      })
      .otherwise({
        redirectTo: '/users'
      });
  });