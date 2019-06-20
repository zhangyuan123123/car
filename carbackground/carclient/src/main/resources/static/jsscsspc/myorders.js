function showEmptyOrders($panel) {
    /// <summary>
    /// 无订单展示
    /// </summary>
    /// <param name="$panel"></param>
    $panel.children().hide();
    $(".order-list-null").show();
}

function showOrders($panel) {
    /// <summary>
    /// 有订单展示
    /// </summary>
    /// <param name="$table"></param>
    $panel.show();
    $(".order-list-null").hide();
}
function autoShowOrderPanel($panel) {
    /// <summary>
    /// 自动展示订单面板
    /// </summary>
    /// <param name="$panel"></param>
    if ($panel.find('tr').length <= 1) {
        showEmptyOrders($panel);
        return;
    }
    showOrders($panel);
}
function showLoading($loading) {
    $loading.show();
    $(".order-list-null").hide();
}
$(function () {

    //下拉列表
    $(".orderdown-menu li a").click(function () {
        var selText = $(this).text();
        var $NavLabel = $("#dLabel");
        $NavLabel.html(selText + '<span class="caret"></span>');//下拉文字修改
        //$(this).parents('.btn-group').find('.dropdown-toggle').html(selText + '<span class="caret"></span>');
        var targetClass = $(this).data("targetClass");
        var $targetDiv = $('.' + targetClass);
        $targetDiv.show().siblings(".order-list").hide();//显示对应订单面板并隐藏其它订单面板
        $targetDiv.find(".ui-tab-hd li.ck a").trigger('click');//间接触发'refersh'事件
       
    });


    $('.orderTab').click(function () {
        /// <summary>
        /// 触发'refresh'事件
        /// </summary>
        var targetClass = $(this).data('tableClass');
        $("." + targetClass).trigger('refresh');
    });

    //切换订单列表并刷新
    $('div.ui-table-list').on('refresh', function () {
        /// <summary>
        /// 'refresh'事件
        /// </summary>
        var $panel = $(this);
        if (!$panel.is(':empty')) {
            autoShowOrderPanel($panel);
            return false;
        }
        var $loading = $panel.parents('.ui-tab-bd').siblings('.ui-loading');
        showLoading($loading);
        var status = $panel.data('status');
        var queryPara = {
            Status: status
        };

        var queryUrl = $panel.parents(".ui-tab-bd").data("action");
        $panel.load(queryUrl, queryPara, function (responseTxt, statusTxt, xhr) {
            //global.js控制切换显示
            if (statusTxt === "error") {
                //alert(decodeURI(xhr.statusText));
                return alert("加载失败，请重试");
            }

            $loading.hide();
            autoShowOrderPanel($panel);
            if (responseTxt.indexOf('Success') > 0) {

                var obj = JSON.parse(responseTxt);
                if (!obj.Success) {
                    $('#OrderList').html(obj.Message);
                }
            }
        });
    });

    //点击订单分页
    $('.ui-table-list').on('click', '.pages a', function () {
        var pageIndex = $(this).data('pageIndex');
        var $table = $(this).parents('div.ui-table-list');
        var status = $table.data('status');
        var queryPara= {
            Status: status,
            PageIndex:pageIndex
        }
        var queryUrl = $table.parents(".ui-tab-bd").data("action");
        $table.load(queryUrl, $.param(queryPara), function (responseTxt, statusTxt, xhr) {
            //global.js控制切换显示
            if (statusTxt == "error") {
                //alert(decodeURI(xhr.statusText));
                return alert("加载失败，请重试");
            }
            $table.show();
        });
    });


    $('.ui-table-list.all').trigger("refresh");
});