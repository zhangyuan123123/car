var Dom = {
    emailEditor: 'tr.email-unvalidate'
};

var Reg = {
    email: /^\w+(.\w+)*@\w+(.\w+)*$/
};

function refreshPage() {
    /// <summary>
    /// 强制刷新当前页
    /// </summary>
    /// <returns type=""></returns>
    location.reload(true);
}

$(function () {
    //驾驶证正页百度未识别次数
    var verificationTime = 1;

    //驾驶证认证编辑
    $('#BtnOptlicense').click(function () {
        $(".licensetype").hide();
        $(".jz-provefront").show().siblings().hide();
        if (userVerify==="True") { 
            $("#PerfectLicense").hide(); 
            alert("请优先完善证件信息！");
        } else {     
            $("#PerfectLicense").show();
        }
    });

    //驾驶证认证修改
    $('#BtnModifylicense').click(function () {
        $(".licensetype").show();
        $(".jz-provesuccess").show().siblings().hide();
        $("#PerfectLicense").show();
    });


    //上传图片
    $('.perfect-box').on('click', '#J_homepage', function () {
        $("#jzHomePage").click();
    });
    $('.perfect-box').on('click', '#J_vicepage', function () {
        $("#jzVicePage").click();
    });
    //驾驶证主页
    $('.perfect-box').on('change', '#jzHomePage', function () {
        var file = $(this).val();
        if (!/.(jpg|gif)$/.test(file)) {
            alert("图片类型必须是.jpg,gif中的一种");
            return false;
        } else {
            if ($(this)[0].files[0].size >= 500 * 1024) {
                alert("请上传小于500k的图片");
                return false;
            }
        }

        $("#uploadForm_f").ajaxSubmit({
            dataType: 'json',
            success: function (data) {
                verificationTime += 1;
                $("#number").val(verificationTime);
                if (!data.Success) {
                    alert(data.Message);
                    return false;
                }
                $('#frontImage').attr('src', data.Message);
                $('.jzzp-seefront').attr('href', data.Message);
                $('#frontImage').show();
            }
        });
    });

    $(document).on("click",
        "#J_provenext",
        function () {
            $(this).hide();
            requestAjax(Url.AuthImage, "", "html", function (data) {
                if (data === "") {
                    $("#J_provenext").show();
                    alert('请上传您的驾驶证图片！');
                    return false;
                }
                $("#provefront").hide();
                $("#auth").html(data).show();
                $("#J_provenext").show();
                bindDatetimepicker("#jz_starDate");
                bindDatetimepicker("#jz_endDate");
            });
        });

    //驾驶证副页
    $('.perfect-box').on('change', '#jzVicePage', function () {
        var file = $(this).val();
        if (!/.(jpg|gif)$/.test(file)) {
            alert("图片类型必须是.jpg,gif中的一种");
            return false;
        } else {
            if ($(this)[0].files[0].size >= 500 * 1024) {
                alert("请上传小于500k的图片");
                return false;
            }
        }


        $("#uploadForm_b").ajaxSubmit({
            dataType: 'json',
            success: function (data) {
                if (!data.Success) {
                    return alert(data.Message);
                }
                $('#backImage').attr('src', data.Message);
                $('.jzzp-seeback').attr('href', data.Message);
                $('#backImage').show();
            }
        });

    });

    //保存驾驶证信息
    $(document).on("click","#drivingLicenseBtn",
        function () {
            var drivingLicenseNo = $('#DrivingLicenseNo').val();
            var drivingType = $('#DrivingType').val();
            var receiveDate = $('#jz_starDate').val();
            var expireDate = $('#jz_endDate').val();
          
            var frontImageUrl = $('.jzzp-seefront').attr('href');
            var backImageUrl = $('.jzzp-seeback').attr('href');

            if (frontImageUrl.length <= 0 || backImageUrl.length <= 0) {
                alert("驾驶证信息丢失，请重新上传");
                return false;
            }

            if (drivingLicenseNo.length <= 0 || drivingType.length <= 0 || receiveDate.length <= 0 || expireDate.length <= 0 ) {
                alert("请确保驾驶证信息必填项已经完善");
                return false;
            }
            var param = {
                DrivingLicenseNo: drivingLicenseNo,
                DrivingType: drivingType,
                ReceiveDate: receiveDate,
                ExpireDate: expireDate,
                FrontImagePath: frontImageUrl,
                BackImagePath: backImageUrl
            }
            requestAjax(Url.DrivingLicense,
                param,"json",
                function (data) {
                    if (data.Success) {
                        alert(data.Message);
                        $(".jz-proveback").hide();
                        $(".perfect-box").hide();
                        window.location = window.Url.MyInfo;
                        return false;
                    } else {
                        alert(data.Message);
                        return false;
                    }
                });
        });


    function bindDatetimepicker(dom) {
        return $(dom).datetimepicker({
            language: 'zh-CN',
            autoclose: true,
            format: 'yyyy-mm-dd',
            startView: 'decade',
            minView: 'month'
        });
    }

    var curDate = new Date;
    var myYear = curDate.getFullYear();//获取当前年
    var myMonth = curDate.getMonth() + 1;//获取当前月
    var myDate = curDate.getDate();//获取当前日
    var curDateTime = myYear + '-' + myMonth + '-' + myDate;

    $(document).on('click',
        '#jz_starDate',
        function() {
            $(this).blur();
            $("#jz_starDate").datetimepicker("setEndDate", curDateTime);
            bindDatetimepicker("#jz_starDate").on('changeDate',
                function() {
                    var starTime = $("#jz_starDate").val();
                    var starDate = new Date(starTime.replace("-", "/").replace("-", "/"));
                    if (curDate < starDate) {
                        $("#jz_endDate").datetimepicker("setStartDate", starTime);
                    }
                });
        });

    $(document).on('click',
        '#jz_endDate',
        function () {
            $(this).blur();
            $("#jz_endDate").datetimepicker("setStartDate", curDateTime);
            bindDatetimepicker("#jz_endDate").on('changeDate',
                function() {
                    var endTime = $("#jz_endDate").val();
                    var endDate = new Date(endTime.replace("-", "/").replace("-", "/"));
                    if (curDate > endDate) {
                        $("#jz_starDate").datetimepicker("setEndDate", endTime);
                    }
                });
        });

    $('.card-year-sel span').mousedown(function () {
        $('.sel-year').val($(this).text());
        var year = $('.sel-year').val();
        var month = $('.sel-month').val();
        var d = new Date(year, month, 0).getDate();
        var str = '';
        for (var i = 1; i <= d; i++) {
            str += '<span>' + i + '</span>';
        }
        $('.card-day-sel').html(str);
        $('.card-year-sel').hide();
        $('.sel-day').val(1);
    });

    $('.card-month-sel span').mousedown(function () {
        $('.sel-month').val($(this).text());
        var year = $('.sel-year').val();
        var month = $('.sel-month').val();
        var d = new Date(year, month, 0).getDate();
        var str = '';
        for (var i = 1; i <= d; i++) {
            str += '<span>' + i + '</span>';
        }
        $('.card-day-sel').html(str);
        $('.sel-day').val(1);
        $('.card-month-sel').hide();
    });

    $('#J_Birthday').on('mousedown', '.card-day-sel span', function () {
        $('.sel-day').val($(this).text());
        $('.card-day-sel').hide();
    });

    //驾驶证类型
    $(document).on('click', '#DrivingType', function (event) {
        event = event || window.event;
        event.stopPropagation();
        var drivTop = ($(this).position().top + 36) + 'px';
        var drivLeft = $(this).position().left + 'px';
        $(".jz-cartype").css({
            "top": drivTop,
            "left": drivLeft
        }).show();
    });
    $(document).on("click", function () {
        $(".jz-cartype").hide();
    });

    $(document).on('click', '.jz-cartype ul li', function () {
        var selCarType = $(this).text();
        $(".jz-cartype").hide();
        $("#DrivingType").val(selCarType);
    });

    $('#btnSubmit').click(function () {
        var year = $('.sel-year').val();
        var month = $('.sel-month').val();
        var day = $('.sel-day').val();
        var trueName = $("#Name").val().trim();
        var idCardType = $("#idCardType").val().trim();
        var idCardNo = $("#idCardNo").val().trim();

        var regName = !(/^[a-zA-Z·.．\u3400-\u9FFF]+$/.test(trueName));
        var regCard = !(/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/.test(idCardNo));
        if (trueName.length === 0) {
            alert("请输入您的真实姓名");
            $("#Name").focus();
            return false;
        } else if (trueName.length < 2) {
            alert("姓名限英文、汉字，2-20个字符");
            $("#Name").focus();
            return false;
        } else if (trueName.length > 0 && regName) {
            alert("姓名限英文、汉字，2-20个字符");
            $("#Name").focus();
            return false;
        }
        if (idCardType === "1010106") {
            alert("请选择证件类型");
            return false;
        } else if (idCardType === "1010101" && idCardNo.length > 0 && regCard) {
            alert("输入的证件号码格式有误");
            $("#idCardNo").focus();
            return false;
        }
        if (idCardNo.length === 0) {
            alert("证件号码不能为空");
            $("#idCardNo").focus();
            return false;
        }

        var param = {
            TrueName: trueName,
            idCardType: idCardType,
            idCardNo: idCardNo,
            birthday: year + "/" + month + "/" + day
        };
        reqAjax(window.Url.UpdateIdCardInfo, param, function (data) {
            if (!data.Success) {
                alert(data.Message);
                return false;
            }
            window.location = window.Url.MyInfo;
        });
    });

    $(document).on('click',
        '#J_econtactBtn',
        function () {
            var contactName = $('#ContactName').val();
            var contactMobilePhoneNo = $('#ContactMobilePhoneNo').val().trim();

            var reg = !(/^\d{7,15}$/.test(contactMobilePhoneNo));
            var regcontactName = !(/^[a-zA-Z·.．\u3400-\u9FFF]+$/.test(contactName));

            if (contactName.length === 0 || contactName.trim().length === 0) {
                alert('请输入紧急联系人姓名');
                $('#ContactName').focus();
                return false;
            } else if (contactName.length < 2) {
                alert("联系人姓名限英文、汉字，2-20个字符");
                $('#ContactName').focus();
                return false;
            } else if (contactName.length > 0 && regcontactName) {
                alert("联系人姓名限英文、汉字，2-20个字符");
                $('#ContactName').focus();
                return false;
            }
            if (contactMobilePhoneNo.length === 0) {
                alert('请输入紧急联系人手机');
                $('#ContactMobilePhoneNo').focus();
                return false;
            } else if (contactMobilePhoneNo.length < 7 || contactMobilePhoneNo.length > 15) {
                alert("请输入7到15位手机号码");
                $('#ContactMobilePhoneNo').focus();
                return false;
            } else if (contactMobilePhoneNo.length > 0 && reg) {
                alert("手机号码格式错误");
                $('#ContactMobilePhoneNo').focus();
                return false;
            }

            var p = {
                Id: $("#h_Id").val(),
                Name: contactName.trim(),
                MobilePhoneNo: contactMobilePhoneNo,
                Address: $('#ContactAddress').val().trim()
            };
            reqAjax(window.Url.SubmitEmergencyContact, p, function (data) {
                if (!data.Success) {
                    alert(data.Message);
                    return false;
                }
                window.location = window.Url.MyInfo;
            });
        });
    $('.save-btn').click(function () {

        var contactName = $('#ContactName').val();
        var contactMobilePhoneNo = $('#ContactMobilePhoneNo').val().trim();
        var imageUrl = $('#ImageUrl').val();
        var reg = !(/^\d{7,15}$/.test(contactMobilePhoneNo));
        var regcontactName = !(/^[a-zA-Z·.．\u3400-\u9FFF]+$/.test(contactName));

        if (contactName.length === 0 || contactName.trim().length === 0) {
            alert('请输入紧急联系人姓名');
            $('#ContactName').focus();
            return false;
        } else if (contactName.length < 2) {
            alert("联系人姓名限英文、汉字，2-20个字符");
            $('#ContactName').focus();
            return false;
        } else if (contactName.length > 0 && regcontactName) {
            alert("联系人姓名限英文、汉字，2-20个字符");
            $('#ContactName').focus();
            return false;
        }
        if (contactMobilePhoneNo.length === 0) {
            alert('请输入紧急联系人手机');
            $('#ContactMobilePhoneNo').focus();
            return false;
        } else if (contactMobilePhoneNo.length < 7 || contactMobilePhoneNo.length > 15) {
            alert("请输入7到15位手机号码");
            $('#ContactMobilePhoneNo').focus();
            return false;
        } else if (contactMobilePhoneNo.length > 0 && reg) {
            alert("手机号码格式错误");
            $('#ContactMobilePhoneNo').focus();
            return false;
        }
        var year = $('#RegTime').val();
        var month = $('#month').val();
        var day = $('#day').val();
        var p = {

            Id: $("h_Id").val(),
            Name: contactName.trim(),
            MobilePhoneNo: contactMobilePhoneNo,
            Address: $('#ContactAddress').val().trim()
        };
        reqAjax(window.Url.SubmitEmergencyContact, p, function (data) {
            if (!data.Success) {
                alert(data.Message);
                return false;
            }
            window.location = window.Url.MyInfo;
        });
    });


    $('.jz-proveoperate').on('click','#modify_D_Btn',
        function() {
            $('.jz-provesuccess').hide();            
            $(".licensetype").hide();
            $(".jz-provefront").show().siblings().hide();
        });
    $('.jz-proveoperate').on('click','#delete_D_Btn',
        function () {
            requestAjax(Url.DeleteDrivingLicense,"","json",
                function(data) {
                    if (data.Success) {
                        alert("删除成功");
                        $('.jz-provesuccess').hide();
                        window.location = window.Url.MyInfo;
                    } else {
                        alert(data.Message);
                    }
                });
        });


    //紧急联系人
    $("#BtnOptContact").click(function () {
        reqAjaxHtml(window.Url.EmergencyContact,
            null,
            function (data) {
                $('#divEmergencyContact').html(data);
                $("#PerfectContact").show();
            });
    });

    $(".perfect-close").on('click', function () {
        $(".perfect-box").hide();
    });

 
});
function reqAjax(url, param, callback) {
    $.ajax({
        type: "post",
        url: url,
        data: param,
        dataType: "json",
        cache: false,
        async:false,
        success: function (data) {
            callback(data);
        }
    });
}
function requestAjax(url, param, dataType, callback) {
    $.ajax({
        type: "post",
        url: url,
        data: param,
        dataType: dataType,
        cache: false,
        async: false,
        success: function (data) {
            callback(data);
        }
    });
}
function reqAjaxHtml(url, param, callback) {
    $.ajax({
        type: "post",
        url: url,
        data: param,
        dataType: "html",
        cache: false,
        success: function (data) {
            callback(data);
        }
    });
}

function CheckImage(file) {
    if (!/.(jpg|gif)$/.test(file)) {
        alert("图片类型必须是.jpg,gif中的一种");
        return false;
    } else {
        if ($(this)[0].files[0].size >= 500 * 1024) {
            alert("请上传小于500k的图片");
            return false;
        }
    }
    return true;
}