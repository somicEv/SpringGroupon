var Submit = {
    AjaxSubmit: function (url, params1,params2) {
        var test = {
            "param":params2,
            "skuId":params1
        };

        $.ajax({
            type: "post",
            url: url,
            data: JSON.stringify(test),
            dataType: "json",
            contentType: "application/json",
            async: true,
            success: function (result, textStatus) {
                console.log(result.queryCode + "," + result.resultMessage);
                if ("200" === result.queryCode) {
                    alert(result.resultMessage);
                } else if ("500" === result.queryCode) {
                    alert(result.resultMessage);
                } else {
                    alert(result.resultMessage);
                }
                location.reload();
            },
            error: function () {
                alert("操作失败--error");
            }
        });
    }
   /* AjaxSubmit_new: function (url, params) {

        $.ajax({
            type: "post",
            url: url,
            data: params,
            dataType: "json",
            async: true,
            success: function (result, textStatus) {
                console.log(result.queryCode + "," + result.resultMessage);
                if ("200" === result.queryCode) {
                    alert(result.resultMessage);
                } else if ("500" === result.queryCode) {
                    alert(result.resultMessage);
                } else {
                    alert(result.resultMessage);
                }
            },
            error: function () {
                alert("操作失败--error");
            }
        });
    }*/

}
