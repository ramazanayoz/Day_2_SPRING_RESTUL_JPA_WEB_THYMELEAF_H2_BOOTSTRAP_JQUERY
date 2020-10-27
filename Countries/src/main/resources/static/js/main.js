/**
 * 
 */


$(document).ready(function(){
	$('.nBtn, .table .eBtn').on('click', function(myEvent){
		
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text=='Edit'){
			$.get(href, function(countryObj, status){
				$('.myForm #id').val(countryObj.id);
				$('.myForm #name').val(countryObj.name);
				$('.myForm #capital').val(countryObj.capital);	
				$('.myForm #exampleModal').modal();
			});
		}else{
				$('.myForm #id').val('');
				$('.myForm #name').val('');
				$('.myForm #capital').val('');
				$('.myForm #exampleModal').modal();	
		}			
	});
	
	
	$('.table .delBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href'); //href output:: delete/?id=5
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal(); // delete tuşuna basıldığında http://localhost:8080/delete/?id=5 adresine request yapılır
 	});
});