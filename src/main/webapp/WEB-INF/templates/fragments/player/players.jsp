<html>
<head>
</head>
<body>
<div class="col-md-8" >
	<jsp:include page="/WEB-INF/templates/fragments/player/player_filters.jsp">
		<jsp:param name="title" value="Lineup" />
	</jsp:include>
	<jsp:include page="/WEB-INF/templates/fragments/game/game_filters.jsp">
		<jsp:param name="title" value="Games" />
	</jsp:include>
	<table class="table table-color table-bordered table-hover">
		<thead>
	    <tr>
	      <th>Pos</th>
	      <th>Player</th>
	      <th>team</th>
	      <th>projected</th>
	      <th>salary</th>
	      <th>Add/Rem</th>
	    </tr>
	  </thead>
		<tr
			ng-repeat="player in p.allPlayers | filter:{pos:p.search.pos} | filter:{team:p.search.awayTeam} | filter:p.search.fuzzy"
			ng-click>
			<td class="col-md-1">{{player.pos}}</td>
			<td class="col-md-4">{{player.firstName}} {{player.lastName}}</td>
			<td class="col-md-1">{{player.team}}</td>
			<td class="col-md-1">{{player.projectedScore}}</td>
			<td class="col-md-1" ng-class="{neg_salary:p.lineup.remSalary<0}">&#36{{player.salary}}</td>
			<td class = "player-add col-md-1">
				<button class = "player-add-button"
						ng-if="!p.inLineup(player.id)"
						ng-class= "{'player-add-button-pos-filled' : p.isPosFilled(player.pos)}"
						ng-click= "p.addPlayer(player)">
					<span class="fas fa-plus-circle fas-sm"></span>
				</button>
				<button class = "player-remove-button"
						ng-if="p.inLineup(player.id)"
						ng-click= "p.removePlayer(player, true)">
					<span class="fas fa-minus-circle fas-lg"></span>
				</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
