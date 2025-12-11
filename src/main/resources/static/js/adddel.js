$(function() {
	// Address management prompt when clicking delete
	$(".add-del").click(function() {
			if (confirm("确定删除这个信息吗？")) {
				location.href = "details.html";
			}
		})
		// Effect when click is set as default address
	$(".add-def").click(function() {
		$(".add-def").show();
		$(this).hide();
	})
	$(".add-def:eq(0)").hide();
})