$(function () {
	var femaleChb = $('#femaleCheckbox');
	var maleChb = $('#maleCheckbox');
	var sexChb = $('.sex');
	
	femaleChb.prop('checked', !maleChb.is(':checked'));
	
	sexChb.on('click', function () {
		var id = $(this).attr('id');
		var idM = maleChb.attr('id');

		if (id == idM) {
			femaleChb.prop('checked', !$(this).is(':checked'));
		} else {
			maleChb.prop('checked', !$(this).is(':checked'));
		}
	});

});
