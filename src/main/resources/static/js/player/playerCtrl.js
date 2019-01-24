angular.module('myApp').controller('playerCtrl', ['$http', 'tagFactory', 'lineupFactory','playerFactory', function($http, tagFactory, lineupFactory,playerFactory){
		let vm = this;
		vm.player={};
		vm.allPlayers=[];
		vm.lineup=lineupFactory.lineup;
		vm.search=playerFactory.search;
		vm.loadPlayers= function(){
			let date = new Date();
			let dateString = new Date(date.getTime() - (date.getTimezoneOffset() * 60000 ))
			                    .toISOString()
			                    .split("T")[0];
			$http.get("/players",{params: {date:dateString}}).then(function(successData){
				vm.allPlayers=successData.data;
				console.log(successData.data)
				for(let playerDetail of vm.allPlayers){
					
					playerDetail.playerDtlId=playerDetail.player.id
					playerDetail.id=playerDetail.id;
					playerDetail.firstName=playerDetail.player.firstName;
					playerDetail.lastName=playerDetail.player.lastName;
					playerDetail.pos=playerDetail.player.pos;
					playerDetail.team=playerDetail.team.abbr;
					delete playerDetail.player;
				}
				}, function(error){
					console.log(error)
				});
		}
		vm.getVal = function(val){
			if(val.currentTarget.value==="All"){
				playerFactory.search.pos = '';
			}
			else{
				playerFactory.search.pos = val.currentTarget.value;
			}
			
		}
		vm.inLineup = function(playerId){
			let bool = false;
			for (let player of vm.lineup.players){
				if((Object.keys(player).length > 2) && player.id === playerId){
					bool = true;
				}

			}
			return bool;
		}
		
		vm.isPosFilled = function(pos){
			let bool = false;
			if(vm.lineup.playerCount[pos] == vm.lineup.maxPlayerCount[pos]){
				bool=true;
			}
			return bool;
		}
		
		vm.addPlayer = function (activePlayer){
			lineupFactory.addPlayer(activePlayer);
			vm.tags = tagFactory.calcTags(vm.lineup.playerCount.total);
		}
		vm.removePlayer = function(activePlayer){
			lineupFactory.removePlayer(activePlayer);
			vm.tags = tagFactory.calcTags(vm.lineup.playerCount.total);
		}
		
		vm.search
	}]);