/*booking header 联系方式*/
$(function () {
	$(".contact-us").hover(function () {
			$(this).addClass("on");
			$(".contact-popup").show();
		}, function () {
			$(this).removeClass("on");
			$(".contact-popup").hide();
		});
		$(".contact-popup").hover(function () {
			$(this).show().siblings(".contact-us").addClass("on");
		}, function () {
			$(this).hide().siblings(".contact-us").removeClass("on");
	});
});


/*=================================
*Author <aikowang>
*Create Date <2014-06-19>
*Description <头部模板调用脚本>
=================================*/


$(function () {
    var contactWidth = $(".contact-phone").outerWidth() - 2;
    $(".cover-contact").css({
        "width": contactWidth
    });

    /**头部**/
    $(".site-map-drop").hover(function () {
        $(this).parents().find(".site-mapinfo").show()
    }, function () {
        $(this).parents().find(".site-mapinfo").hide()
    })
    $(".site-mapinfo").hover(function () {
        $(this).show().parents().find(".site-map-drop").addClass("linkon")
    }, function () {
        $(this).hide().parents().find(".site-map-drop").removeClass("linkon")
    })

    $(".contact-phone").hover(function () {
        $(this).parents().find(".contact-info").show()
    }, function () {
        $(this).parents().find(".contact-info").hide()
    })
    $(".contact-info").hover(function () {
        $(this).show().parents().find(".contact-phone").addClass("linkon")
    }, function () {
        $(this).hide().parents().find(".contact-phone").removeClass("linkon")
    })

    $(".wx-title").hover(function () {
        $(this).parents().find(".wx-info").show()
    }, function () {
        $(this).parents().find(".wx-info").hide()
    })

    /**导航栏**/
    $(".nav-wrap li a").hover(function () {
        $(this).parent().addClass("menu-index-on");
    }).mouseleave(function () {
        $(this).parent().removeClass("menu-index-on").parents().find(".menu-index").addClass("menu-index-on");
    })
})






