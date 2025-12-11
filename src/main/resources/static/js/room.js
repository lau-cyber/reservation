$(function() {
	// Add 1 to the number of count
	$("#numUp").click(function() {
		var n = parseInt($("#num").val());
		$("#num").val(n + 1);
	})
	// Number of count - 1
	$("#numDown").click(function() {
		var n = parseInt($("#num").val());
		if (n == 1) {
			return;
		}
		$("#num").val(n - 1);
	})
	// Click the reservation list to jump to the page
	$(".go-list").click(function() {
		location.href = "reservation_list.html";
	});
	$(".img-big:eq(0)").show();
})