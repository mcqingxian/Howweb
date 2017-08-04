/*! jQuery.kinMaxShow v1.1 2013-08-27 | mr.kin@foxmail.com */
(function($) {
	$.fn.kinMaxShow = function(user_options) {
		var default_options = {
			intervalTime: 5,
			switchTime: 500,
			hoverPause: true,
			easing: 'linear',
			imageAlign: 'center center',
			button: {
				switchEvent: 'mouseover',
				showIndex: false,
				normal: {}
			},
			callback: function(index, action) {}
		};
		options = jQuery.extend(true, {},
		default_options, user_options);
		var k = {};
		k.selector = $(this).selector;
		if ($(this).length > 1) {
			$.error('kinMaxShow error[More than one selected object]');
			return false;
		}
		k.self = this;
		k.index = 0;
		k.lindex = 0;
		k.size = $(k.self).children('div').size();
		k.prename = k.selector.replace(/\W/ig, '') + '_';
		k.data = {};
		k.fn = {};
		k.onload = function() {
			$(k.self).children('div').addClass(k.prename + 'image_item').hide();
			k.init();
		};
		k.init = function() {
			k.setLayout();
			k.setAnimate();
		};
		k.setLayout = function() {
			$(k.self).children('div').wrapAll('<div class="' + k.prename + 'image_box"></div>');
			$('.' + k.prename + 'image_item', k.self).each(function() {
				var a = $(this).children('a');
				if (a.length) {
					var image = a.children('img').attr('src');
					a.children('img').remove();
					a.addClass(k.prename + 'coverlink');
				} else {
					var image = $(this).children('img').attr('src');
					$(this).children('img').remove();
				}
				$(this).css({
					background: 'url(' + image + ') no-repeat ' + options.imageAlign,
					'z-index': 1
				});
			});
			$('.' + k.prename + 'image_item', k.self).eq(0).css('z-index', '2');
			if (options.button.normal.display != 'none') {
				var button_list = '';
				for (i = 1; i <= k.size; i++) {
					if (options.button.showIndex) {
						button_list += '<li>' + i + '</li>';
					} else {
						button_list += '<li> </li>';
					}
				}
				$(k.self).append('<ul class="' + k.prename + 'button">' + button_list + '</ul>');
				$('.' + k.prename + 'button li', k.self).eq(0).addClass(k.prename + 'focus');
			}
			
			$('.' + k.prename + 'image_item:gt(0)', k.self).css('z-index', 1).css({
				opacity: 0
			});
			$('.' + k.prename + 'image_item', k.self).show();			
		};
		
		k.setAnimate = function() {
			options.callback.call($('.' + k.prename + 'image_item:eq(' + k.index + ')', k.self), k.index, 'fadeIn');
			var overDelayTimer;
			$('.' + k.prename + 'button', k.self).delegate('li', options.button.switchEvent,
			function() {
				_this = this;
				function setChange() {
					k.index = $(_this).index();
					k.setOpacity();
				}
				if (options.button.switchEvent == 'mouseover') {
					overDelayTimer = setTimeout(setChange, 200);
				} else {
					setChange();
				}
			}) 
			if (options.button.switchEvent == 'mouseover') {
				$('.' + k.prename + 'button', k.self).delegate('li','mouseout',function() {
					clearTimeout(overDelayTimer);
				})
			}
			k.index = 1;
			k.lindex = 0;
			k.data.moveTimer = setInterval(k.setOpacity, options.intervalTime * 1000 + options.switchTime);
			if (options.hoverPause) {
				$(k.self).hover(function() {
					clearInterval(k.data.moveTimer);
				},
				function() {
					k.data.moveTimer = setInterval(k.setOpacity, options.intervalTime * 1000 + options.switchTime);
				})
			}
		};
		k.setOpacity = function() {
			options.callback.call($('.' + k.prename + 'image_item:eq(' + (k.lindex) + ')', k.self), k.lindex, 'fadeOut');
			if (options.button.normal.display != 'none') {
				$('ul.' + k.prename + 'button li', k.self).removeClass(k.prename + 'focus');
				$('ul.' + k.prename + 'button li', k.self).eq(k.index).addClass(k.prename + 'focus');
			}
			$('.' + k.prename + 'image_item:animated', k.self).stop(true, false);
			$('.' + k.prename + 'image_item', k.self).css('z-index', 1);
			$('.' + k.prename + 'image_item', k.self).eq(k.index).css({
				opacity: 0,
				'z-index': 2
			});
			$('.' + k.prename + 'image_item', k.self).eq(k.index).animate({
				opacity: 1
			},
			options.switchTime, options.easing,
			function() {
				$('.' + k.prename + 'image_box .' + k.prename + 'image_item:not(:eq(' + k.index + '))', k.self).css({
					opacity: 0
				});
				options.callback.call($('.' + k.prename + 'image_item:eq(' + k.index + ')', k.self), k.index, 'fadeIn');
				k.lindex = k.index;
				if (k.index == k.size - 1) {
					k.index = 0;
				} else {
					k.index++;
				}
			});
		};
		k.run = function() {
			k.onload();
		};
		k.fn.objToCss = function(obj, excArr, excFlag) {
			excFlag = excFlag ? true: false;
			var isIE = navigator.userAgent.indexOf("MSIE") != -1;
			var style = '';
			if (excFlag) {
				for (var key in obj) {
					if ($.inArray(key, excArr) != -1) {
						pKey = key.replace(/([A-Z])/, KtoLowerCase);
						if (pKey == 'opacity' && isIE) {
							style += "filter:alpha(opacity=" + (obj[key] * 100) + ");";
						} else {
							style += pKey + ":" + obj[key] + ";";
						}
					}
				};
			} else {
				for (var key in obj) {
					if ($.isArray(excArr)) {
						if ($.inArray(key, excArr) == -1) {
							pKey = key.replace(/([A-Z])/, KtoLowerCase);
							if (pKey == 'opacity' && isIE) {
								style += "filter:alpha(opacity=" + (obj[key] * 100) + ");";
							} else {
								style += pKey + ":" + obj[key] + ";";
							}
						}
					} else {
						pKey = key.replace(/([A-Z])/, KtoLowerCase);
						if (pKey == 'opacity' && isIE) {
							style += "filter:alpha(opacity=" + (obj[key] * 100) + ");";
						} else {
							style += pKey + ":" + obj[key] + ";";
						}
					}
				};
			}
			function KtoLowerCase(word) {
				var str = '';
				str = '-' + word.toLowerCase();
				return str;
			};
			return style;
		};
		k.run();
	}
})(jQuery)