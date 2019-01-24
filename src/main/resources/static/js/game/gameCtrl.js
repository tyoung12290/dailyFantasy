angular.module('myApp').controller('gameCtrl', ['$http', 'gameFactory','playerFactory', function($http, gameFactory,playerFactory){
		let vm = this;
		vm.games=gameFactory.games;
		
		vm.getGames = function() {
			gameFactory.getGames().success(function(result){
				vm.games=result;
				console.log(vm.games)
			}).error(function(error){
				console.log(error)
		});
		}
		vm.getVal = function(game){
			if(game=='ALL'){
				playerFactory.search.homeTeam=''
				playerFactory.search.awayTeam=''
			}else{
				playerFactory.search.homeTeam=game.home.team.abbr
				playerFactory.search.awayTeam=game.home.team.abbr
			}
		}

	}]);