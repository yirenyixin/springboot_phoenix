// 路径配置
require.config({
    paths: {
        echarts: 'http://echarts.baidu.com/build/dist'
    }
});

// 使用
require(
    [
        'echarts',
        'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
    ],
    function (ec) {
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('chart_col_1'));

        var datas = [];
        var titles = [];
        for(var i in chart_info.chart1){
            var info = chart_info.chart1[i];
            datas.push({value: info.count,  name: info.xdh_mc_xb });
            titles.push(info.xdh_mc_xb);
        }

        option = {
            title : {
                text: '人员入境性别占比',
                subtext: '纯属虚构',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },

            series : [
                {
                    name: '性别占比',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data: datas,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };



        // 为echarts对象加载数据
        myChart.setOption(option);



        var datas1 = [];
        var titles = [];
        for(var i =0; i < chart_info.chart2.length; ++i ){
            var info = chart_info.chart2[i];
            datas1.push({value: info.count,  name: info.xdh_rybs, selected: i==0 });
            titles.push(info.xdh_rybs);
        }

        var datas2 = [];
        for(var i =0; i < chart_info.chart3.length; ++i ){
            var info = chart_info.chart3[i];
            datas2.push({value: info.count,  name: info.xdh_mc_gj});
            titles.push(info.xdh_mc_gj);
        }

        option = {

            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:titles,
            },
            series: [
                {
                    name:'访问来源',
                    type:'pie',
                    selectedMode: 'single',
                    radius: [0, '30%'],

                    label: {
                        normal: {
                            position: 'inner'
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:datas1
                },
                {
                    name:'访问来源',
                    type:'pie',
                    radius: ['40%', '55%'],
                    label: {
                        normal: {
                            formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            // shadowBlur:3,
                            // shadowOffsetX: 2,
                            // shadowOffsetY: 2,
                            // shadowColor: '#999',
                            // padding: [0, 7],
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },

                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:datas2,
                }
            ]
        };


        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('chart_col_2'));
        myChart.setOption(option);
    }


);

