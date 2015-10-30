/* *************************************************************************** */
/* Título: navegacion.js	                     							   */
/* Desripción: Javascript para controlar el menú principal de navegación	   */
/* *************************************************************************** */


var velocidad = 400


$(document).ready(function () {	
	
	//Desactivacion de la css accesible para poder realizar efectos dinamicos
	
	desactivarCss("accesible.css")	
	
	
	//Cambio de pestañas Activas en los menus
	$(".navMenuPrincipal li").click(function(){

		$(".navMenuPrincipal li.active").removeClass("active")
		
		$(this).addClass("active")
		
	})
	
	$(".navMenuSecundario li").click(function(){
		
		$(".navMenuSecundario li.active").removeClass("active")
		
		$(this).addClass("active")
		
	})		
	
	//primero cerramos todos los deplegables
	$('.level2').css("display", "none");
	
	
	//Añadimos los eventos a los elementos
	$('.botonDespliegueClick').hover(function (e) {
			
			mostrarOcultar($(this), e.type)					
	});	
	
	$('.botonDespliegueHover').hover(function (e) {	
			
			mostrarOcultar($(this), e)					
	});	
		
	
})

function mostrarOcultar(elemento, evento){	
	
	if(evento.type == "mouseenter"){
		$(".level2").slideUp(velocidad)
		elemento.find('.level2').stop(true).slideDown(velocidad)	
	}else{
		if(evento.type == "mouseleave"){			
			elemento.find('.level2').stop(true).slideUp(velocidad)
		}
	}
	
}


function desactivarCss(direccion){	
	
	links = $("head link")
	
	
	links.each(function(){
	
		var posicionUltimaBarra = $(this).attr("href").lastIndexOf("/"); 
		var rutaRelativa = $(this).attr("href").substring( posicionUltimaBarra + "/".length , $(this).attr("href").length ); 
	
		if(direccion == rutaRelativa){
		
			$(this).remove()
			
		}
	
	})
}
	
	