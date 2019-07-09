<#include "../../base/base.ftl">
<@title>
    <title>vue_wysiwyg</title>
</@title>
<@css>
    <link rel="stylesheet" href="/node_modules/wangeditor/wangEditor.css">
</@css>
<@body>
<div id="div1"></div>
</@body>
<@js>
    <script src="/node_modules/wangeditor/wangEditor.js"></script>
    <script rel="script">
        function init() {
            let E = window.wangEditor;
            let editor = new E('#div1');
            editor.create();
        }
        init();

    </script>

</@js>