<html>
	<head>
	    <jsp:include page="/WEB-INF/templates/fragments/header.jsp">
	        <jsp:param name="title" value="LandingPage" />
	    </jsp:include>
	</head>
<body>
	<div class="game_filters" ng-controller="gameCtrl as g" ng-init="g.getGames()">
	<div class="game_container" ng-click="g.getVal('ALL')">
			<div class="game_teams">ALL</div>
		</div>
		<div class="game_container" ng-repeat="game in g.games" ng-click="g.getVal(game)">
			<div class="game_teams">{{game.away.team.abbr}}@{{game.home.team.abbr}}</div>
			<div class="game_time">{{game.time | date:'HH:mm'}}</div>
		</div>
	</div>


</body>

</html>