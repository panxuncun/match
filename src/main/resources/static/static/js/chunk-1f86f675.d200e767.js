(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1f86f675"],{"333d":function(t,e,n){"use strict";var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"pagination-container",class:{hidden:t.hidden}},[n("el-pagination",t._b({attrs:{background:t.background,"current-page":t.currentPage,"page-size":t.pageSize,layout:t.layout,"page-sizes":t.pageSizes,total:t.total},on:{"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e},"update:pageSize":function(e){t.pageSize=e},"update:page-size":function(e){t.pageSize=e},"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}},"el-pagination",t.$attrs,!1))],1)},a=[];n("c5f6");Math.easeInOutQuad=function(t,e,n,r){return t/=r/2,t<1?n/2*t*t+e:(t--,-n/2*(t*(t-2)-1)+e)};var i=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function o(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function u(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function l(t,e,n){var r=u(),a=t-r,l=20,s=0;e="undefined"===typeof e?500:e;var c=function t(){s+=l;var u=Math.easeInOutQuad(s,r,a,e);o(u),s<e?i(t):n&&"function"===typeof n&&n()};c()}var s={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[8,15,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(t){this.$emit("update:page",t)}},pageSize:{get:function(){return this.limit},set:function(t){this.$emit("update:limit",t)}}},methods:{handleSizeChange:function(t){this.$emit("pagination",{page:this.currentPage,limit:t}),this.autoScroll&&l(0,800)},handleCurrentChange:function(t){this.$emit("pagination",{page:t,limit:this.pageSize}),this.autoScroll&&l(0,800)}}},c=s,d=(n("f959"),n("2877")),f=Object(d["a"])(c,r,a,!1,null,"f7df7540",null);e["a"]=f.exports},4406:function(t,e,n){"use strict";var r=n("49df"),a=n.n(r);a.a},"49df":function(t,e,n){},"50fc":function(t,e,n){"use strict";n.d(e,"z",(function(){return a})),n.d(e,"b",(function(){return i})),n.d(e,"L",(function(){return o})),n.d(e,"N",(function(){return u})),n.d(e,"n",(function(){return l})),n.d(e,"w",(function(){return s})),n.d(e,"s",(function(){return c})),n.d(e,"c",(function(){return d})),n.d(e,"B",(function(){return f})),n.d(e,"r",(function(){return m})),n.d(e,"g",(function(){return p})),n.d(e,"C",(function(){return h})),n.d(e,"D",(function(){return g})),n.d(e,"H",(function(){return b})),n.d(e,"j",(function(){return v})),n.d(e,"y",(function(){return y})),n.d(e,"d",(function(){return w})),n.d(e,"x",(function(){return _})),n.d(e,"i",(function(){return O})),n.d(e,"K",(function(){return j})),n.d(e,"m",(function(){return k})),n.d(e,"t",(function(){return x})),n.d(e,"v",(function(){return S})),n.d(e,"h",(function(){return C})),n.d(e,"E",(function(){return $})),n.d(e,"k",(function(){return z})),n.d(e,"f",(function(){return Q})),n.d(e,"q",(function(){return L})),n.d(e,"M",(function(){return I})),n.d(e,"p",(function(){return P})),n.d(e,"o",(function(){return T})),n.d(e,"u",(function(){return E})),n.d(e,"F",(function(){return K})),n.d(e,"G",(function(){return A})),n.d(e,"J",(function(){return B})),n.d(e,"I",(function(){return N})),n.d(e,"A",(function(){return V})),n.d(e,"l",(function(){return F})),n.d(e,"a",(function(){return q})),n.d(e,"e",(function(){return D}));var r=n("b775");function a(t){return console.log("api.js获取全部角色 params->",t),Object(r["a"])({url:"/role/list",method:"get",params:t})}function i(t){return Object(r["a"])({url:"/role/add",method:"post",data:t})}function o(t){return Object(r["a"])({url:"/role/update",method:"post",data:t})}function u(t){return Object(r["a"])({url:"role/updateStatus",method:"post",data:t})}function l(t){return Object(r["a"])({url:"/role/delete/"+t,method:"post"})}function s(){return Object(r["a"])({url:"/resource/cate/list",method:"get"})}function c(){return Object(r["a"])({url:"/resource/list",method:"get"})}function d(t){return Object(r["a"])({url:"/role/allocResource",method:"post",data:t})}function f(t){return Object(r["a"])({url:"/resource/listByRole/"+t,method:"get"})}function m(t){return Object(r["a"])({url:"/admin/list",method:"get",params:t})}function p(t){return Object(r["a"])({url:"/admin/add",method:"post",data:t})}function h(t){return Object(r["a"])({url:"/admin/update",method:"post",data:t})}function g(t){return Object(r["a"])({url:"/admin/updateStatus",method:"post",data:t})}function b(t){return Object(r["a"])({url:"/admin/updatePassword",method:"post",data:t})}function v(t){return Object(r["a"])({url:"/admin/delete/"+t,method:"post"})}function y(t){return Object(r["a"])({url:"/role/listByAdmin/"+t,method:"get"})}function w(t){return Object(r["a"])({url:"/admin/allocRole",method:"post",data:t})}function _(t){return Object(r["a"])({url:"/resource/listWithPage",method:"get",params:t})}function O(t){return Object(r["a"])({url:"/resource/add",method:"post",data:t})}function j(t){return Object(r["a"])({url:"/resource/update",method:"post",data:t})}function k(t){return Object(r["a"])({url:"/resource/delete/"+t,method:"post"})}function x(){return Object(r["a"])({url:"/contest/cate/list",method:"get"})}function S(){return Object(r["a"])({url:"/contest/cate/parentList",method:"get"})}function C(t){return Object(r["a"])({url:"/contest/cate/add",method:"post",data:t})}function $(t){return Object(r["a"])({url:"/contest/cate/update",method:"post",data:t})}function z(t){return Object(r["a"])({url:"/contest/cate/delete/"+t,method:"post"})}function Q(t){return Object(r["a"])({url:"/contest/check",method:"post",data:t})}function L(){return Object(r["a"])({url:"/",method:"get"})}function I(){return Object(r["a"])({url:"/",method:"get"})}function P(){return Object(r["a"])({url:"/",method:"get"})}function T(){return Object(r["a"])({url:"/contest/cate/listWithChildren",method:"get"})}function E(t){return Object(r["a"])({url:"/contest/list",method:"get",params:t})}function K(){return Object(r["a"])({url:"/",method:"get"})}function A(){return Object(r["a"])({url:"/",method:"get"})}function B(){return Object(r["a"])({url:"/",method:"get"})}function N(){return Object(r["a"])({url:"/",method:"get"})}function V(){return Object(r["a"])({url:"/recommend/listForAdmin",method:"get"})}function F(t){return Object(r["a"])({url:"/recommend/delete/"+t,method:"post"})}function q(t){return Object(r["a"])({url:"/recommend/add",method:"post",data:t})}function D(t){return Object(r["a"])({url:"/contest/batchCheck",method:"post",data:t})}},9289:function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("el-card",{staticClass:"filter-container role-card-search",attrs:{shadow:"never"}},[n("div",[n("i",{staticClass:"el-icon-search"}),t._v(" "),n("span",[t._v("筛选搜索")])]),t._v(" "),n("div",{staticStyle:{"margin-top":"15px"}},[n("el-form",{attrs:{inline:!0,model:t.listQuery,size:"small","label-width":"140px"}},[n("el-form-item",{attrs:{label:"资源名称："}},[n("el-input",{staticClass:"input-width",attrs:{placeholder:"资源名称",clearable:""},model:{value:t.listQuery.nameKeyword,callback:function(e){t.$set(t.listQuery,"nameKeyword",e)},expression:"listQuery.nameKeyword"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"资源路径："}},[n("el-input",{staticClass:"input-width",attrs:{placeholder:"资源路径",clearable:""},model:{value:t.listQuery.urlKeyword,callback:function(e){t.$set(t.listQuery,"urlKeyword",e)},expression:"listQuery.urlKeyword"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"资源模块："}},[n("el-select",{staticClass:"input-width",attrs:{placeholder:"全部",clearable:""},model:{value:t.listQuery.parentId,callback:function(e){t.$set(t.listQuery,"parentId",e)},expression:"listQuery.parentId"}},t._l(t.categoryOptions,(function(t){return n("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1),t._v(" "),n("el-form-item",[n("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.handleSearchList()}}},[t._v("搜索")])],1)],1)],1)]),t._v(" "),n("el-card",{staticClass:"operate-container role-list-title",attrs:{shadow:"never"}},[n("i",{staticClass:"el-icon-tickets"}),t._v(" "),n("span",[t._v("资源列表")]),t._v(" "),n("el-button",{staticClass:"btn-add",staticStyle:{"margin-left":"20px"},attrs:{size:"mini"},on:{click:function(e){return t.handleAdd()}}},[t._v("添加资源")]),t._v(" "),n("el-button",{staticClass:"btn-add",attrs:{size:"mini"},on:{click:function(e){return t.handleShowCategory()}}},[t._v("管理资源模块")])],1),t._v(" "),n("div",{staticClass:"table-container"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],ref:"resourceTable",staticStyle:{width:"100%"},attrs:{data:t.list,border:""}},[n("el-table-column",{attrs:{label:"编号",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.id))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"资源名称",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.name))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"资源路径",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.url))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"权限标识",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.permission))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"描述",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.description))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"添加时间",width:"160",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.createTime))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",width:"140",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(n){return t.handleUpdate(e.$index,e.row)}}},[t._v("编辑")]),t._v(" "),n("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(n){return t.handleDelete(e.$index,e.row)}}},[t._v("删除")])]}}])})],1)],1),t._v(" "),n("div",{staticClass:"pagination-container"},[n("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total>0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getList}})],1),t._v(" "),n("el-dialog",{attrs:{title:t.isEdit?"编辑资源":"添加资源",visible:t.dialogVisible,width:"40%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[n("el-form",{ref:"resourceForm",attrs:{model:t.resource,"label-width":"150px",size:"small"}},[n("el-form-item",{attrs:{label:"资源名称："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{maxlength:"30","show-word-limit":""},model:{value:t.resource.name,callback:function(e){t.$set(t.resource,"name",e)},expression:"resource.name"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"资源路径："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{maxlength:"50","show-word-limit":""},model:{value:t.resource.url,callback:function(e){t.$set(t.resource,"url",e)},expression:"resource.url"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"权限标识："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{maxlength:"50","show-word-limit":""},model:{value:t.resource.permission,callback:function(e){t.$set(t.resource,"permission",e)},expression:"resource.permission"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"所属模块："}},[n("el-select",{staticStyle:{width:"250px"},attrs:{maxlength:"30","show-word-limit":"",placeholder:"全部",clearable:""},model:{value:t.resource.parentId,callback:function(e){t.$set(t.resource,"parentId",e)},expression:"resource.parentId"}},t._l(t.categoryOptions,(function(t){return n("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1),t._v(" "),n("el-form-item",{attrs:{label:"描述："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{maxlength:"100","show-word-limit":"",type:"textarea",rows:5},model:{value:t.resource.description,callback:function(e){t.$set(t.resource,"description",e)},expression:"resource.description"}})],1)],1),t._v(" "),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{size:"small"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),n("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(e){return t.sureDiag()}}},[t._v("确 定")])],1)],1)],1)},a=[],i=(n("7f7f"),n("50fc")),o=n("333d"),u={id:null,name:null,url:null,parentId:null,description:""},l={name:"resourceList",data:function(){return{list:null,total:0,listLoading:!0,listQuery:{page:1,limit:8,keyword:null,nameKeyword:null,urlKeyword:null,parentId:null},dialogVisible:!1,resource:Object.assign({},u),isEdit:!1,categoryOptions:[],defaultParentId:null}},created:function(){this.getList(),this.getCateList()},filters:{},components:{Pagination:o["a"]},methods:{handleSearchList:function(){console.log("搜索"),this.listQuery.page=1,this.getList()},handleAdd:function(){this.dialogVisible=!0,this.isEdit=!1,this.resource=Object.assign({},u),this.resource.parentId=this.defaultParentId},handleDelete:function(t,e){var n=this;this.$confirm("是否要删除资源"+e.name+"?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){Object(i["m"])(e.id).then((function(t){n.$message({type:"success",message:"删除成功!"}),n.getList()}))}))},handleUpdate:function(t,e){this.dialogVisible=!0,this.isEdit=!0,this.resource=Object.assign({},e)},sureDiag:function(){var t=this;null==this.resource.name||this.resource.name.length<1?this.$message({message:"资源名称不能留空",type:"fail"}):null==this.resource.url||this.resource.url.length<1?this.$message({message:"资源路径不能留空",type:"fail"}):null==this.resource.permission||this.resource.permission.length<1?this.$message({message:"权限标识不能留空",type:"fail"}):null==this.resource.parentId||this.resource.parentId.length<1?this.$message({message:"请选择所属模块",type:"fail"}):this.isEdit?Object(i["K"])(this.resource).then((function(e){t.$message({message:"修改成功！",type:"success"}),t.dialogVisible=!1,t.getList()})):Object(i["i"])(this.resource).then((function(e){t.$message({message:"添加成功！",type:"success"}),t.dialogVisible=!1,t.getList()}))},handleShowCategory:function(){this.$router.push({path:"/admin/rbac/resourceCategory"})},getList:function(){var t=this;this.listLoading=!0,console.log("请求参数->",this.listQuery),Object(i["x"])(this.listQuery).then((function(e){console.log("返回数据->",e.data),t.listLoading=!1,t.list=e.data.list,t.total=e.data.total}))},getCateList:function(){var t=this;Object(i["w"])().then((function(e){console.log("资源分类->",e.data);for(var n=e.data,r=0;r<n.length;r++){var a=n[r];t.categoryOptions.push({label:a.name,value:a.id})}t.defaultParentId=n[0].id}))}}},s=l,c=(n("4406"),n("2877")),d=Object(c["a"])(s,r,a,!1,null,"29c657b0",null);e["default"]=d.exports},c1a9:function(t,e,n){},f959:function(t,e,n){"use strict";var r=n("c1a9"),a=n.n(r);a.a}}]);