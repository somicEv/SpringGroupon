$(function () {
    $.fn.raty.defaults.path = 'http://localhost:8080/images';
    rate();
    //commendSubmit();
});

function rate() {
    $('#rate').raty({
        click: function (score, evt) {
            console.log(score);
            $('input[name="rate"]').val(score);
            console.log($('input[name="rate"]').val());
        }
    })
}

function commendSubmit() {

    var rate = $('input[name="rate"]').val();
    var commend = $('#commend_area').val();
    console.log(rate + commend);
    var data = {
        commend: {
            'rate': rate,
            'commend': commend
        }
    };
    $.ajax({
        type: 'post',
        url: '/commend/add',
        contentType: 'application/json',
        dataType: "json",
        //数据格式是json串，商品信息
        data: {
            'rate': rate,
            'commend': commend
        },
        success: function (data) {//返回json结果
            alert("cesj");
        }
    });
}