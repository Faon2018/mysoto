<#include "../../base/base.ftl">
<@title>
    <title>首页</title>
</@title>
<@css>
    <link rel="stylesheet" href="/node_modules/wangeditor/wangEditor.css">
    <style>
        .edit{
            width: 700px;
            margin: 0 auto;
        }
        .form-test{
            margin-left: 15px
        }
    </style>
</@css>
<@body>
    <div id="app">
        <div class="input-group edit">
            <span class="input-group-addon">标题</span>
            <input type="text" class="form-control" placeholder="请输入标题">
            <span class="input-group-addon">0/100</span>
        </div>
        <div id="div1" class="edit"></div>
        <div class="edit">
            <form class="form-horizontal form-test">
                <div class="form-group">
                    <label class="control-label">标签：</label>
                    <a href="#"><span class="glyphicon glyphicon-plus">添加标签</span></a>
                </div>
                <div class="form-group">
                    <label class="control-label">分类：</label>
                    <a href="#"><span class="glyphicon glyphicon-plus">添加新分类</span></a>
                    <div>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary btn-lg btn-block">提交</button>
                </div>
            </form>
        </div>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <p>添加成功！</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button>
                </div>
            </div>
        </div>
    </div>
</@body>
<@js>
    <script src="/node_modules/wangeditor/wangEditor.js"></script>

    <script rel="script">
            var app=new Vue({
                el:'#app',
                data:{
                    editor:null
                },
                methods:{
                    submit(){
                        let  data=JSON.stringify(this.editor.txt.getJSON());
                        axios.post('/article/add',{data:data}).then(function (res) {
                            $('#myModal').modal();
                        }).catch(function (error) {

                        });
                    }

                }

            });

            app.editor=new (window.wangEditor)('#div1');
            app.editor.customConfig.uploadImgShowBase64 = true;
            app.editor.create();
        // let editor;
        // function init() {
        //     let E = window.wangEditor;
        //     editor = new E('#div1');
        //     editor.customConfig.uploadImgShowBase64 = true;
        //     editor.create();
        // }
        // init();
        // $('#submit').on('click',function () {
        //     console.log(JSON.stringify(editor.txt.getJSON()));
        // });



    </script>

</@js>