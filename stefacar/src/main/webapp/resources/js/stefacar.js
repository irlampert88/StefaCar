$(document).ready(function(){
	carrega("table", "/stefacar/pages/default/default.xhtml");
});	

function carregaUrl(urlTable, urlForm){
	$("#table").load(urlTable);
	$("#form").load(urlForm);
}

function redireciona(url){
	$(location).attr('href', url);
}
	
function mostraFormEscondeTable(div, url){
        $("#table").hide("drop");
        carrega(div, url);
        $("#form").show("drop");
}

function mostraTablaEscondeForm(div, url){
		$("#form").hide("drop");
		carrega(div, url);
        $("#table").show("drop");
}

function carrega(div, url){
	$("#" + div).load(url);
}