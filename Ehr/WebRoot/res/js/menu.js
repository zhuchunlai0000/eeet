$(function(){
	$("#res").click(function(){
		$("#mainUI").prop("src","resourceview.action");
	})
	$("#role").click(function(){
		$("#mainUI").prop("src","roleview.action");
	})
	$("#users").click(function(){
		$("#mainUI").prop("src","usersview.action");
	})
});