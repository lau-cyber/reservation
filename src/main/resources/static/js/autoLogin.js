$(function() {
	// When the user clicks the login button
	$("#loginBtn").click(function() {
			// If the user does not check the automatic login
			if (!$("#auto").prop("checked")) {
				// Clear the content of the cookie
				$.cookie("isAutoLogin", "false", {
					expire: -1
				});
				$.cookie("username", "", {
					expires: -1
				});
				$.cookie("password", "", {
					expires: -1
				});
			} else {
				// If the user checked automatic login
				// Get username and password
				var vusername = $("#username").val();
				var vpassword = $("#password").val();
				// store cookies
				// expires: 7 means store a cookie with a 7-day expiration
				$.cookie("isAutoLogin", "true", {
					expires: 7
				});
				$.cookie("username", vusername, {
					expires: 7
				});
				$.cookie("password", vpassword, {
					expires: 7
				});
			}
		})
		// Code that runs when the page loads
		// Determine whether there is automatic login content
	if ($.cookie("isAutoLogin") == "true") {
		// If it is an automatic login, automatically fill in the information from the cookie into the username and password boxes
		$("#auto").prop("checked", true);
		$("#username").val($.cookie("username"));
		$("#password").val($.cookie("password"));
	}

});