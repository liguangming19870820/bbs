(function($) {
    appcan.switchBtn($("#SwitchBtn_mg3Fly"),
    function(obj, value) {});

    appcan.select($("#Select_7lrLjM"),
    function(ele, value) {});

    var slider_Slider_21VOUc = appcan.slider({
        selector: $("#Slider_21VOUc"),
        aspectRatio: 0.38 || 6 / 16,
        hasLabel: true,
        index: 0
    });
    slider_Slider_21VOUc.set([{
        "img": "${pageContext.request.contextPath }/res/img/pic/bank01.png",
        "label": "图片1"
    },
    {
        "img": "${pageContext.request.contextPath }/res/img/pic/bank02.png",
        "label": "图片2"
    },
    {
        "img": "${pageContext.request.contextPath }/res/img/pic/bank03.png",
        "label": "图片3"
    },
    {
        "img": "${pageContext.request.contextPath }/res/img/pic/bank04.png",
        "label": "图片4"
    }]);
    slider_Slider_21VOUc.on("clickItem",
    function(index, data) {});

    var listview_MultiListView_Fy4wmb = appcan.listview({
        selector: $("#MultiListView_Fy4wmb"),
        type: "thickLine",
        hasAngle: false || false,
        hasIcon: false || false,
        align: "left" || "left",
        hasRadiobox: false || false,
        hasCheckbox: false || false,
        hasSubTitle: false || false,
        multiLine: 1 || 1,
    });

    listview_MultiListView_Fy4wmb.set([{
        "title": "临时数据",
        "describe": "测试",
        "note": "测试",
        "icon": "css/res/appcan_s.png",
        "icontitle": "appcan",
        "subTitle": "-195.3",
        "subDescribe": "缺货",
        "subNote": "北京",
        "id": "1"
    },
    {
        "title": "临时数据",
        "describe": "测试",
        "note": "测试",
        "icon": "css/res/appcan_s.png",
        "icontitle": "appcan",
        "subTitle": "-195.3",
        "subDescribe": "缺货",
        "subNote": "北京",
        "id": "2"
    }]);
})($);