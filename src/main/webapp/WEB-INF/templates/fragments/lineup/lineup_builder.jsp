<html>
<head>
</head>
<body>
	<div class="col-md-4" ng-controller="lineupCtrl as l">
		<jsp:include page="/WEB-INF/templates/fragments/lineup/lineup_tags.jsp">
			<jsp:param name="title" value="lineupSalary" />
		</jsp:include>
		<div class="lineup_salary">
			<div class="lineup_salary_label">Total Salary</div>
			<div class="lineup_salary_rem">$ {{l.lineup.remSalary}}</div>
		</div>
		<div class="lineup_points">
			<div class="lineup_points_label">Projected Points</div>
			<div class="lineup_points_counter">{{l.lineup.points}}</div>
		</div>
		<ul class="lineup__body">
			<li
				ng-repeat="player in l.lineup.players track by $index"
				class="lineup__slot"
				ng-class="{'lineup__slot--has-player':player.id}">
				<div class="lineup__empty-state">
					<span class="lineup__player-position">{{player.pos}}</span>
					<span class="lineup__player-empty-text">Add Player</span>
				</div>
				<div class="lineup__player-container">
					<div class="lineup__player">
						<div class="lineup_player_info">
							<span class="lineup_player_name">{{player.pos}} {{player.firstName}} {{player.lastName}}</span>
							<span class="lineup_player_salary">{{player.salary}}</span>
							<span class="lineup_player_points">{{player.projectedScore}}</span>
							<span class="player-action">
								<button class = "player-remove-button"
								ng-click= "l.removePlayer(player, false)">
								<span class="fas fa-minus-circle fas-lg"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
			</li>
		</ul>
		<button  ng-show="l.lineup.id" ng-disabled="l.lineup.playerCount.total!=9" ng-click="l.updateLineup(l.lineup)">update</button>
		<button  ng-show="!l.lineup.id" ng-disabled="l.lineup.playerCount.total!=9" ng-click="l.saveLineup(${userId})">Save</button>
		<button  ng-click="l.clearLineup(l.lineup)">New</button>
	</div>
</body>
</html>