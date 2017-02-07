// jQuery Social Dropdown Menu
// (c) Skyrocket Labs
// http://www.skyrocketlabs.com
// skyrocketlabs@gmail.com
// Created: 02.08.2010
// Last updated: 02.18.2010

//This script has been slightly modified but is essentially David Walsh's jQuery Sliders tutorial
// Download the original script or see a demo at http://davidwalsh.name/jquery-sliders/

$(document).ready(function() {
	$('#MySocialMenu h3').each(function() {
		var tis = $(this), state = false, answer = tis.next('div').hide().css('height','auto').slideUp();
		tis.click(function() {
			state = !state;
			answer.slideToggle(state);
			tis.toggleClass('active',state);
		});
	});
});