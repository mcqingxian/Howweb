$(function () {
	$(".container").css("height",$(window).height()-50);
    $("#btn").click(function () {
        window.location.href = "topage_m-counsel.action";
    });
    $(".detailTwo").click(function () {
        window.location.href = "topage_m-findPartnerDetail.action";
    });
    $(".detailOne").click(function () {
        window.location.href = "topage_m-companyProfile.action";
    });
   
   /* $(".first").click(function () {
        window.location.href = "#";
    });
    $(".second").click(function () {
        window.location.href = "#";
    });*/
    $(".telBox").click(function () {
        $(".mask").show();
        $(".container-mask").show();
    });
    $(".mask").click(function () {
        $(".mask").hide();
        $(".container-mask").hide();
    })
});