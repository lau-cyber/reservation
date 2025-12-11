$(function() {
	/** Product list, add shadow when the mouse moves in, and remove the shadow when the mouse moves out */
	$(".goods-panel").hover(function() {
		$(this).css("box-shadow", "0px 0px 8px #888888");
	}, function() {
		$(this).css("box-shadow", "");
	})
	// When adding to favorites, the solid hollow of ♥ toggles
	$(".add-fav").toggle(function() {
		$(this).html("<span class='fa fa-heart'></span>取消收藏");
	}, function() {
		$(this).html("<span class='fa fa-heart-o'></span>加入收藏");
	})
})