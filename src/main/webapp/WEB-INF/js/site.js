var Submit = {
    AjaxSubmit: function(url, params) {

        $.ajax({
            type: "post",
            url: url,
            data: {"params":params},
            dataType: "json",
            async: true,
            success: function(result, textStatus) {
                if (1 == result) {
                    alert("操作成功");
                } else if(2 == result){
                    alert("已经存在，请不要重复添加");
                }else {
                    alert("操作失败--服务器内部错误");
                }
                //return result;
            },
            error: function() {
                alert("操作失败--error");
            }
        });
    }

}