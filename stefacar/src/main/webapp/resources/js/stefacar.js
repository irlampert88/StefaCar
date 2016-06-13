$(document).ready(function(){
    $("#table").load("/stefacar/pages/default/default.xhtml");
});	

function carrega(urlTable, urlForm){
	$('#table').load(urlTable);
	$('#form').load(urlForm);
}

function carregaModal(urlModal){
	$('#modal').load(urlModal);
}

function redireciona(url){
	$(location).attr('href', url);
}
	
function mostraFormEscondeTable(){
        $("#table").hide();
        $("#form").show();
}

function mostraTablaEscondeForm(urlTable){
        $("#form").hide();
        $('#table').load(urlTable);
        $("#table").show();
}

function recarrega(url){
	$(location).attr('href', url);
}