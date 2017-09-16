var Submit = {
    AjaxSubmit: function (url, params) {

        $.ajax({
            type: "post",
            url: url,
            data: {"params":params},
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
    },
    AjaxSubmit_new: function (url, params) {

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
    }

}
