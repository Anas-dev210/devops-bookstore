angular.module('bookstoreApp')
  .controller('BookController', function($scope, BookService) {
    $scope.books = [];
    $scope.loading = true;
    $scope.error = null;

    BookService.getAll()
      .then(function(response) {
        $scope.books = response.data;
      })
      .catch(function(err) {
        $scope.error = 'Failed to load books';
      })
      .finally(function() {
        $scope.loading = false;
      });

    $scope.addBook = function(newBook) {
      BookService.create(newBook)
        .then(function(response) {
          $scope.books.push(response.data);
          $scope.newBook = {};
        })
        .catch(function(err) {
          $scope.error = 'Failed to add book';
        });
    };
  });