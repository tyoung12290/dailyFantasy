angular.module('myApp').factory('gameFactory', ['$http','playerFactory', function($http,playerFactory){
	this.games={};	
	this.getGames = function(){
		let date = new Date();
		let dateString = new Date(date.getTime() - (date.getTimezoneOffset() * 60000 ))
		                    .toISOString()
		                    .split("T")[0];
			return $http.get("/game", {params: {date:dateString}})
		};
		
		return {
			getGames : this.getGames
		}
	}]);