angular.module('myApp').factory('playerFactory', ['$http', function($http){
	this.search={pos:'',
			fuzzy:'',
			homeTeam:'',
			awayTeam:''};
	this.getLineups = function(userId){
			return $http.get("/lineup", {params: {userId:userId}})
		};
		
		return {
			getLineups : this.getLineups,
			search: this.search
		}
	}]);