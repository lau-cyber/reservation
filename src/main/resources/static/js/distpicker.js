/** Cooperate with the data in the drop-down menu list to complete the linkage of three drop-down menus */

(function(factory) {
	if (typeof define === 'function' && define.amd) {
		define(['jquery', 'Academies'], factory);
	} else if (typeof exports === 'object') {
		factory(require('jquery'), require('Academies'));
	} else {
		factory(jQuery, Academies);
	}
})(function($, Academies) {
	'use strict';
	if (typeof Academies === 'undefined') {
		throw new Error('The file "distpicker.data.js" must be included first!');
	}
	var NAMESPACE = 'distpicker';
	var EVENT_CHANGE = 'change.' + NAMESPACE;
	var DEPARTMENT = 'department';
	var MAJOR = 'major';
	var GRADE = 'grade';
	function Distpicker(element, options) {
		this.$element = $(element);
		this.options = $.extend({}, Distpicker.DEFAULTS, $.isPlainObject(options) && options);
		this.placeholders = $.extend({}, Distpicker.DEFAULTS);
		this.active = false;
		this.init();
	}
	Distpicker.prototype = {
		constructor: Distpicker,
		init: function() {
			var options = this.options;
			var $select = this.$element.find('select');
			var length = $select.length;
			var data = {};
			$select.each(function() {
				$.extend(data, $(this).data());
			});
			$.each([DEPARTMENT, MAJOR, GRADE], $.proxy(function(i, type) {
				if (data[type]) {
					options[type] = data[type];
					this['$' + type] = $select.filter('[data-' + type + ']');
				} else {
					this['$' + type] = length > i ? $select.eq(i) : null;
				}
			}, this));
			this.bind();
			// Reset all the selects (after event binding)
			this.reset();
			this.active = true;
		},
		bind: function() {
			if (this.$department) {
				this.$department.on(EVENT_CHANGE, (this._changeDepartment = $.proxy(function() {
					this.output(MAJOR);
					this.output(GRADE);
				}, this)));
			}

			if (this.$major) {
				this.$major.on(EVENT_CHANGE, (this._changeMajor = $.proxy(function() {
					this.output(GRADE);
				}, this)));
			}
		},
		unbind: function() {
			if (this.$department) {
				this.$department.off(EVENT_CHANGE, this._changeDepartment);
			}

			if (this.$major) {
				this.$major.off(EVENT_CHANGE, this._changeMajor);
			}
		},
		output: function(type) {
			var options = this.options;
			var placeholders = this.placeholders;
			var $select = this['$' + type];
			var dmg = {};
			var data = [];
			var code;
			var matched;
			var value;
			if (!$select || !$select.length) {
				return;
			}
			value = options[type];
			code = (
				type === DEPARTMENT ? 86 :
				type === MAJOR ? this.$department && this.$department.find(':selected').data('code') :
				type === GRADE ? this.$major && this.$major.find(':selected').data('code') : code
			);
			dmg = $.isNumeric(code) ? Academies[code] : null;
			if ($.isPlainObject(dmg)) {
				$.each(dmg, function(code, details) {
					var selected = details === value;
					if (selected) {
						matched = true;
					}
					data.push({
						code: code,
						details: details,
						selected: selected
					});
				});
			}
			if (!matched) {
				if (data.length && (options.autoSelect || options.autoselect)) {
					data[0].selected = true;
				}
				// Save the unmatched value as a placeholder at the first output
				if (!this.active && value) {
					placeholders[type] = value;
				}
			}
			// Add placeholder option
			if (options.placeholder) {
				data.unshift({
					code: '',
					details: placeholders[type],
					selected: false
				});
			}
			$select.html(this.getList(data));
		},
		getList: function(data) {
			var list = [];
			$.each(data, function(i, n) {
				list.push(
					'<option' +
					' value="' + (n.details && n.code ? n.details : '') + '"' +
					' data-code="' + (n.code || '') + '"' +
					(n.selected ? ' selected' : '') +
					'>' +
					(n.details || '') +
					'</option>'
				);
			});
			return list.join('');
		},
		reset: function(deep) {
			if (!deep) {
				this.output(DEPARTMENT);
				this.output(MAJOR);
				this.output(GRADE);
			} else if (this.$department) {
				this.$department.find(':first').prop('selected', true).trigger(EVENT_CHANGE);
			}
		},
		destroy: function() {
			this.unbind();
			this.$element.removeData(NAMESPACE);
		}
	};
	Distpicker.DEFAULTS = {
		autoSelect: true,
		placeholder: true,
		department: '—— department ——',
		major: '—— major ——',
		grade: '—— grade ——'
	};
	Distpicker.setDefaults = function(options) {
		$.extend(Distpicker.DEFAULTS, options);
	};
	// Save the other distpicker
	Distpicker.other = $.fn.distpicker;
	// Register as jQuery plugin
	$.fn.distpicker = function(option) {
		var args = [].slice.call(arguments, 1);
		return this.each(function() {
			var $this = $(this);
			var data = $this.data(NAMESPACE);
			var options;
			var fn;
			if (!data) {
				if (/destroy/.test(option)) {
					return;
				}
				options = $.extend({}, $this.data(), $.isPlainObject(option) && option);
				$this.data(NAMESPACE, (data = new Distpicker(this, options)));
			}
			if (typeof option === 'string' && $.isFunction(fn = data[option])) {
				fn.apply(data, args);
			}
		});
	};
	$.fn.distpicker.Constructor = Distpicker;
	$.fn.distpicker.setDefaults = Distpicker.setDefaults;
	// No conflict
	$.fn.distpicker.noConflict = function() {
		$.fn.distpicker = Distpicker.other;
		return this;
	};
	$(function() {
		$('[data-toggle="distpicker"]').distpicker();
	});
});