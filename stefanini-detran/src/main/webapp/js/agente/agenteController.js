App.controller('AgenteCtrl', function($scope, AgenteService, $route, $routeParams, $location){
	$scope.agentes = [];
	$scope.notFound = false;
	AgenteService.list().then(function(data){
		$scope.agentes = data.data;
		if(data.data.length == 0){
			$scope.notFound = true;
		}
	},function(data){
		console.log("data", data);
	});

	$scope.deletar = function(id){
		AgenteService.remove(id).then(function(data){
			console.log(data);
			$route.reload();
		});	
	}
	 
	/*
	$scope.editar = function(agente){
		$scope.agente = agente;
		$location.path('/editar-agente')
	};
	
	$scope.atualizar = function(agente){
		AgenteService.update(agente, agente.id).then(function(data){
			$location.path('/');
		}
	}
	*/
});