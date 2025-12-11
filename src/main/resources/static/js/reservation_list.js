/* Add the number of classrooms */
function addNum(rid) {
	var n = parseInt($("#classroomsCount"+rid).val());
	$("#classroomsCount"+rid).val(n + 1);
	calcRow(rid);
}

/* Reduce the number of classrooms */
function reduceNum(rid) {
	var n = parseInt($("#classroomsCount"+rid).val());
	if (n == 0)
		return;
	$("#classroomsCount"+rid).val(n - 1);
	calcRow(rid);
}

/* Select all or not to select all the classrooms in the waiting list*/
function checkall(ckbtn) {
	$(".ckitem").prop("checked", $(ckbtn).prop("checked"));
	//calcTotal();
}

/* The 'Delete' button */
function delCartItem(btn) {	
	$(btn).parents("tr").remove();
	//calcTotal();
}

// Select some items and then delete button
function selDelCart() {
	// Traverse and check all of the buttons
	for (var i = $(".ckitem").length - 1; i >= 0; i--) {
		// If the one is selected
		if ($(".ckitem")[i].checked) {
			// Delect the chosen one from your waiting list
			$($(".ckitem")[i]).parents("tr").remove();
		}
	}
	//calcTotal();
}
$(function() {
	//单选一个也得算价格
	$(".ckitem").click(function() {
			//calcTotal();
		})
		//开始时计算价格
		//calcTotal();
})
//计算单行小计价格的方法
function calcRow(rid) {
	//取单价
	var vprice = parseFloat($("#goodsPrice"+rid).html());
	//取数量
	var vnum = parseFloat($("#classroomsCount"+rid).val());
	//小计金额
	var vtotal = vprice * vnum;
	//赋值
	$("#goodsCast"+rid).html("¥" + vtotal);
}

//计算总价格的方法
/*
function calcTotal() {
	//选中商品的数量
	var vselectCount = 0;
	//选中商品的总价
	var vselectTotal = 0;

	//循环遍历所有tr
	for (var i = 0; i < $(".cart-body tr").length; i++) {
		//计算每个商品的价格小计开始
		//取出1行
		var $tr = $($(".cart-body tr")[i]);
		//取单价
		var vprice = parseFloat($tr.children(":eq(3)").children("span").html());
		//取数量
		var vnum = parseFloat($tr.children(":eq(4)").children(".num-text").val());
		//小计金额
		var vtotal = vprice * vnum;
		//赋值
		$tr.children(":eq(5)").children("span").html("¥" + vtotal);
		//计算每个商品的价格小计结束

		//检查是否选中
		if ($tr.children(":eq(0)").children(".ckitem").prop("checked")) {
			//计数
			vselectCount++;
			//计总价
			vselectTotal += vtotal;
		}
		//将选中的数量和价格赋值
		$("#selectTotal").html(vselectTotal);
		$("#selectCount").html(vselectCount);
	}
}*/