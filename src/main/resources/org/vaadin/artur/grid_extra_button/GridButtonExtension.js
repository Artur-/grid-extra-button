org_vaadin_artur_grid_extra_button_GridButtonExtension = function() {
	var connector = this;
	
	var grid = this.getElement(this.getParentId(this.getConnectorId()));
	var sidebar = grid.getElementsByClassName("v-grid-sidebar")[0];
	
	var button = document.createElement("span");
	button.style.fontFamily="FontAwesome";
	button.style.paddingRight="5px";
	button.innerText="";
	
	button.addEventListener("click",function(event) {
		connector.clicked();
	});
	sidebar.appendChild(button);
	
}