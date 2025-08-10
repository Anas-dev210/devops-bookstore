angular.module('bookstoreApp')
  .service('BookService', function($http) {
    const baseUrl = 'http://localhost:8082/books';

    this.getAll = function() {
      return $http.get(baseUrl);
    };

    this.create = function(book) {
      return $http.post(baseUrl, book);
    };
  });