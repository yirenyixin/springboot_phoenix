// 公共弹框样式
// 建议左右栏的：Width：460，Height：190
// 建议宽屏对应值：Width：760，Height：500
function pop_box_new(value, Width, Height){
    if($("#popupAll").length > 0){
        $("#popupAll").remove();
    }
    w = ($(window).width() - Width)/2;
    h = ($(window).height() - Height)/2;
    var html="<div class=\"popupAll none\" id='popupAll'><div class=\"pr\"><div id=\"popupWrap\"></div></div></div>";
    $(document.body).append(html);
    $("#popupWrap").html(value);
    $('#popupWrap').css({"top": h+"px","left": w+"px","padding":"0","border":"none","position":"fixed","z-index":"99999","background-color":"#fff","border-radius":"10px"});
    $("#popupWrap").parent().parent().show();
    $('#popupWrap').find("a[class*='pop_close']").click(function(){
        $("#popupAll").hide();
    });
    //拖拽
    function Drag(id) {
        this.div = document.getElementById(id);
        if (this.div) {
            this.div.style.cursor = "move";
            this.div.style.position = "fixed";
        }
        this.disX = 0;
        this.disY = 0;
        var _this = this;
        this.div.onmousedown = function (evt) {
            _this.getDistance(evt);
            document.onmousemove = function (evt) {
                _this.setPosition(evt);
            };
            _this.div.onmouseup = function () {
                _this.clearEvent();
            }
        }
    }
    Drag.prototype.getDistance = function (evt) {
        var oEvent = evt || event;
        this.disX = oEvent.clientX - this.div.offsetLeft;
        this.disY = oEvent.clientY - this.div.offsetTop;
    };
    Drag.prototype.setPosition = function (evt) {
        var oEvent = evt || event;
        var l = oEvent.clientX - this.disX;
        var t = oEvent.clientY - this.disY;
        if (l <= 0) {
            l = 0;
        }
        else if (l >= document.documentElement.clientWidth - this.div.offsetWidth) {
            l = document.documentElement.clientWidth - this.div.offsetWidth;
        }
        if (t <= 0) {
            t = 0;
        }
        else if (t >= document.documentElement.clientHeight - this.div.offsetHeight) {
            t = document.documentElement.clientHeight - this.div.offsetHeight;
        }
        this.div.style.left = l + "px";
        this.div.style.top = t + "px";
    };
    Drag.prototype.clearEvent = function () {
        this.div.onmouseup = null;
        document.onmousemove = null;
    };

    new Drag("popupWrap");

    $("#popupWrap input, #popupWrap textarea, #popupWrap ul, #popupWrap a").mousedown(function(event){
        event.stopPropagation();
        new Drag("popupWrap");
    });
}

function hideModal(el) {
    if($("#popupAll").length > 0){
        $("#popupAll").remove();
    }
    else{
        var modal;
        if (el) {
            modal = $(el).parents('.ui-dialog-content');
        } else {
            modal = $('#ajax-modal');
        }
        modal.dialog("close");
    }
}