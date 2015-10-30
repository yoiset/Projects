/* *************************************************************************** */
/* Título: tabs.js			                     							   */
/* Desripción: Javascript para controlar componentes de pestañas			   */
/* *************************************************************************** */

$(document).ready(function () {		
	
	// Inicializamos los ids necesarios. 
	if ($('.mod-pestanas').length > 0) {
		
		$('.mod-pestanas').each(function (index) {	
			
			$(this).attr('id', 'mod-pestanas_' + index);
			$(this).find('.item_tab').each(function (index2) {
				$(this).attr('id', 'item_tab_' + index + '_' + index2);
			});
			if ($(this).attr('class').indexOf('t2') != -1) {
				$(this).find('.tab_t2').each(function (index2) {
					$(this).attr('id', 'tab_t2_' + index + '_' + index2);
				});
			} else {
				$(this).find('.tab').each(function (index2) {
					$(this).attr('id', 'tab_' + index + '_' + index2);
				});	
			}
		});
		
		// Mostramos las tabs seleccionadas
		$('.item_tab').each(function () {
			if ($(this).attr('class').indexOf('seleccionado') != -1) {				 
				var selected_id = $(this).attr('id').replace('item_tab', '');
				$('#tab' + selected_id).css('display', 'block');
			}
		});
	}
	
	// Control click para mostrar / ocultar pestañas.
	if ($('.item_tab').length > 0) {
		//hacemos click en una pestaña
		$('.item_tab').click(function () {
			
			var selected_id = $(this).parents('.mod-pestanas').first().find('.item_tab.seleccionado').first().attr('id').replace('item_tab', '');
			
			if ($(this).parents('.mod-pestanas').first().attr('class').indexOf('t2') != -1) {
				$(this).parents('.mod-pestanas').first().find('.item_tab.seleccionado').removeClass('seleccionado');
				$('#tab_t2' + selected_id).css('display', 'none');
				var clicked_id = $(this).attr('id').replace('item_tab', '');
				$(this).addClass('seleccionado');			
				$('#tab_t2' + clicked_id).css('display', 'block');	
			} else {
				$(this).parents('.mod-pestanas').first().find('.item_tab.seleccionado').first().removeClass('seleccionado');
				$('#tab' + selected_id).css('display', 'none');
				var clicked_id = $(this).attr('id').replace('item_tab', '');
				$(this).addClass('seleccionado');			
				$('#tab' + clicked_id).css('display', 'block');		
			}
		});
	}	

});