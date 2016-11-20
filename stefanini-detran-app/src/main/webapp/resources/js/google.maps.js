var currentMarker = null;

function handlePointClick(event) {
	if (currentMarker === null) {
		document.getElementById('lat').value = event.latLng.lat();
		document.getElementById('lng').value = event.latLng.lng();

		currentMarker = new google.maps.Marker({
			position : new google.maps.LatLng(event.latLng.lat(), event.latLng
					.lng())
		});

		PF('map').addOverlay(currentMarker);

		PF('cadastroLocalDialog').show();
	}
}

function markerAddComplete() {
	var title = document.getElementById('descricao');
	var velocidade = document.getElementById('velocidade');
	currentMarker.setTitle(title.value);
	
	velocidade.value = null;
	title.value = "";

	currentMarker = null;
	PF('cadastroLocalDialog').hide();
}

function cancel() {
	PF('cadastroLocalDialog').hide();
	currentMarker.setMap(null);
	currentMarker = null;

	return false;
}