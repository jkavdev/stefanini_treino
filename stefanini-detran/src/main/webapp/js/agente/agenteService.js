App.factory('AgenteService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'tipo');
		},
		
		create: function(item){
			return $http.post(API+'tipo', item);
		},
		
		update: function(item, id){
			return $http.put(API+'tipo/'+id, item);	
		},
		
		delete: function(id){
			return $http.remove(API+'tipo/'+id);
		}
	}
})