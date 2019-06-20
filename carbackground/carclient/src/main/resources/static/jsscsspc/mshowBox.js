function myshowBox(titles, urls, objWidth, objHeight, types, classname) {
    var _title = titles;
    var _url = urls;
    var _width = objWidth;
    var _height = objHeight;
    var _type = types;      //ture为iframe,false为div
    var _class = classname;

    /*浏览器高度宽度监测*/
    var findDimensions = function() {
        var winWidth = 0;
        var winHeight = 0;
        if (window.innerWidth) {
            winWidth = window.innerWidth;
        } else if ((document.body) && (document.body.clientWidth)) {
            winWidth = document.body.clientWidth;
        }
        if (window.innerHeight) {
            winHeight = window.innerHeight;
        } else if ((document.body) && (document.body.clientHeight)) {
            winHeight = document.body.clientHeight;
        }
        if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) {
            winHeight = document.documentElement.clientHeight;
            winWidth = document.documentElement.clientWidth;
        }
        return winWidth + "-" + winHeight;
    };

    var addHTML;
    if (_type == "true") {
        addHTML = "<iframe class='iframe-myshowbox' id='myshowbox' src='" + _url + "' frameborder='0' scrolling='no' width='" + _width + "' height='" + _height + "'></iframe>";

        //IE6 BUG fix
        var ieset = navigator.userAgent;
        if (ieset.indexOf("MSIE 6.0") > -1) {
            setTimeout('window.parent[\'myshowbox\'].location.reload();', 0);
        }
    }
    else {
        addHTML = "<div class='div-myshowbox' style='width:" + _width + "px; height:" + _height + "px;'></div>";
    }

    $("body").append("<div id='mshowbox' class='myshowbox'><div class='myshowbox-container " + _class + "'><a class='btn-close' href='javascript:;'></a><h3 class='title'>" + _title + "</h3>" + addHTML + "</div></div><div id='bgScreen'></div>");

    //判断是否有标题
    if (_title == "") {
        $(".myshowbox .title").hide();
    }
    else {
        $(".myshowbox .title").css("width", _width - 20 + "px");
    }

    $(".myshowbox-container").css("width", _width);
    $(".myshowbox").css("margin", (-$(".myshowbox").height() / 2 - 5) + "px 0 0 " + -$(".myshowbox").width() / 2 + "px");
    $("#bgScreen, #bgIFrame").css("height", '100%');

    //关闭释放
    $(".myshowbox-container .btn-close, #bgScreen").click('click', function() {
        $(".myshowbox, #bgScreen, #bgIFrame").hide().remove();        
    });
}