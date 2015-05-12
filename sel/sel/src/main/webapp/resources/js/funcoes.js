/**
 * 
 */

//máscara para cpf
var mascaraCPF = function() {
	$("#cpf").mask("999.999.999-99");
}

//insere cpf no hidden
var atualiza = function() {
	$("#cpf").blur(function() {
		var cpfComMascara = cpf.value;
//		var cpfSemPonto = cpfComMascara.replace(/./g, "");
		var somenteNumeros = cpfComMascara.replace(/[\.-]/g, "");
		
		autentication.value = somenteNumeros;
//		alert(autentication.value);
	});
}
//chamando jQuery
//$(document).ready(function(){});