(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4b341648"],{"15b0":function(t,e,n){},"333d":function(t,e,n){"use strict";var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"pagination-container",class:{hidden:t.hidden}},[n("el-pagination",t._b({attrs:{background:t.background,"current-page":t.currentPage,"page-size":t.pageSize,layout:t.layout,"page-sizes":t.pageSizes,total:t.total},on:{"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e},"update:pageSize":function(e){t.pageSize=e},"update:page-size":function(e){t.pageSize=e},"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}},"el-pagination",t.$attrs,!1))],1)},a=[];n("c5f6");Math.easeInOutQuad=function(t,e,n,i){return t/=i/2,t<1?n/2*t*t+e:(t--,-n/2*(t*(t-2)-1)+e)};var o=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function r(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function l(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function s(t,e,n){var i=l(),a=t-i,s=20,u=0;e="undefined"===typeof e?500:e;var c=function t(){u+=s;var l=Math.easeInOutQuad(u,i,a,e);r(l),u<e?o(t):n&&"function"===typeof n&&n()};c()}var u={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[8,15,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(t){this.$emit("update:page",t)}},pageSize:{get:function(){return this.limit},set:function(t){this.$emit("update:limit",t)}}},methods:{handleSizeChange:function(t){this.$emit("pagination",{page:this.currentPage,limit:t}),this.autoScroll&&s(0,800)},handleCurrentChange:function(t){this.$emit("pagination",{page:t,limit:this.pageSize}),this.autoScroll&&s(0,800)}}},c=u,d=(n("f959"),n("2877")),m=Object(d["a"])(c,i,a,!1,null,"f7df7540",null);e["a"]=m.exports},"50fc":function(t,e,n){"use strict";n.d(e,"z",(function(){return a})),n.d(e,"b",(function(){return o})),n.d(e,"L",(function(){return r})),n.d(e,"N",(function(){return l})),n.d(e,"n",(function(){return s})),n.d(e,"w",(function(){return u})),n.d(e,"s",(function(){return c})),n.d(e,"c",(function(){return d})),n.d(e,"B",(function(){return m})),n.d(e,"r",(function(){return f})),n.d(e,"g",(function(){return p})),n.d(e,"C",(function(){return h})),n.d(e,"D",(function(){return g})),n.d(e,"H",(function(){return b})),n.d(e,"j",(function(){return v})),n.d(e,"y",(function(){return w})),n.d(e,"d",(function(){return y})),n.d(e,"x",(function(){return O})),n.d(e,"i",(function(){return j})),n.d(e,"K",(function(){return _})),n.d(e,"m",(function(){return k})),n.d(e,"t",(function(){return S})),n.d(e,"v",(function(){return x})),n.d(e,"h",(function(){return L})),n.d(e,"E",(function(){return z})),n.d(e,"k",(function(){return $})),n.d(e,"f",(function(){return A})),n.d(e,"q",(function(){return C})),n.d(e,"M",(function(){return R})),n.d(e,"p",(function(){return N})),n.d(e,"o",(function(){return E})),n.d(e,"u",(function(){return I})),n.d(e,"F",(function(){return T})),n.d(e,"G",(function(){return D})),n.d(e,"J",(function(){return V})),n.d(e,"I",(function(){return P})),n.d(e,"A",(function(){return Q})),n.d(e,"l",(function(){return B})),n.d(e,"a",(function(){return F})),n.d(e,"e",(function(){return q}));var i=n("b775");function a(t){return console.log("api.js获取全部角色 params->",t),Object(i["a"])({url:"/role/list",method:"get",params:t})}function o(t){return Object(i["a"])({url:"/role/add",method:"post",data:t})}function r(t){return Object(i["a"])({url:"/role/update",method:"post",data:t})}function l(t){return Object(i["a"])({url:"role/updateStatus",method:"post",data:t})}function s(t){return Object(i["a"])({url:"/role/delete/"+t,method:"post"})}function u(){return Object(i["a"])({url:"/resource/cate/list",method:"get"})}function c(){return Object(i["a"])({url:"/resource/list",method:"get"})}function d(t){return Object(i["a"])({url:"/role/allocResource",method:"post",data:t})}function m(t){return Object(i["a"])({url:"/resource/listByRole/"+t,method:"get"})}function f(t){return Object(i["a"])({url:"/admin/list",method:"get",params:t})}function p(t){return Object(i["a"])({url:"/admin/add",method:"post",data:t})}function h(t){return Object(i["a"])({url:"/admin/update",method:"post",data:t})}function g(t){return Object(i["a"])({url:"/admin/updateStatus",method:"post",data:t})}function b(t){return Object(i["a"])({url:"/admin/updatePassword",method:"post",data:t})}function v(t){return Object(i["a"])({url:"/admin/delete/"+t,method:"post"})}function w(t){return Object(i["a"])({url:"/role/listByAdmin/"+t,method:"get"})}function y(t){return Object(i["a"])({url:"/admin/allocRole",method:"post",data:t})}function O(t){return Object(i["a"])({url:"/resource/listWithPage",method:"get",params:t})}function j(t){return Object(i["a"])({url:"/resource/add",method:"post",data:t})}function _(t){return Object(i["a"])({url:"/resource/update",method:"post",data:t})}function k(t){return Object(i["a"])({url:"/resource/delete/"+t,method:"post"})}function S(){return Object(i["a"])({url:"/contest/cate/list",method:"get"})}function x(){return Object(i["a"])({url:"/contest/cate/parentList",method:"get"})}function L(t){return Object(i["a"])({url:"/contest/cate/add",method:"post",data:t})}function z(t){return Object(i["a"])({url:"/contest/cate/update",method:"post",data:t})}function $(t){return Object(i["a"])({url:"/contest/cate/delete/"+t,method:"post"})}function A(t){return Object(i["a"])({url:"/contest/check",method:"post",data:t})}function C(){return Object(i["a"])({url:"/",method:"get"})}function R(){return Object(i["a"])({url:"/",method:"get"})}function N(){return Object(i["a"])({url:"/",method:"get"})}function E(){return Object(i["a"])({url:"/contest/cate/listWithChildren",method:"get"})}function I(t){return Object(i["a"])({url:"/contest/list",method:"get",params:t})}function T(){return Object(i["a"])({url:"/",method:"get"})}function D(){return Object(i["a"])({url:"/",method:"get"})}function V(){return Object(i["a"])({url:"/",method:"get"})}function P(){return Object(i["a"])({url:"/",method:"get"})}function Q(){return Object(i["a"])({url:"/recommend/listForAdmin",method:"get"})}function B(t){return Object(i["a"])({url:"/recommend/delete/"+t,method:"post"})}function F(t){return Object(i["a"])({url:"/recommend/add",method:"post",data:t})}function q(t){return Object(i["a"])({url:"/contest/batchCheck",method:"post",data:t})}},a485:function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("el-card",{staticClass:"filter-container role-card-search",attrs:{shadow:"never"}},[n("div",[n("i",{staticClass:"el-icon-search"}),t._v(" "),n("span",[t._v("筛选搜索")])]),t._v(" "),n("div",{staticStyle:{"margin-top":"15px"}},[n("el-form",{attrs:{inline:!0,size:"small","label-width":"140px"}},[n("el-form-item",[n("el-input",{staticClass:"input-width",attrs:{placeholder:"请输入昵称或账号",clearable:""},model:{value:t.listQuery.keyword,callback:function(e){t.$set(t.listQuery,"keyword",e)},expression:"listQuery.keyword"}})],1),t._v(" "),n("el-form-item",[n("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",size:"small"},on:{click:function(e){return t.handleSearchList()}}},[t._v("搜索")])],1)],1)],1)]),t._v(" "),n("el-card",{staticClass:"operate-container role-list-title",attrs:{shadow:"never"}},[n("i",{staticClass:"el-icon-tickets"}),t._v(" "),n("span",[t._v("用户列表")]),t._v(" "),n("el-button",{staticClass:"btn-add",staticStyle:{"margin-left":"20px"},attrs:{size:"mini"},on:{click:function(e){return t.handleAdd()}}},[t._v("添加用户")])],1),t._v(" "),n("div",{staticClass:"table-container"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],ref:"adminTable",staticStyle:{width:"100%"},attrs:{data:t.list,border:""}},[n("el-table-column",{attrs:{label:"编号",width:"100",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.id))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"昵称",width:"130",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.nickName))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"帐号",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.username))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"添加时间",width:"160",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(e.row.createTime))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"是否启用",width:"140",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-switch",{attrs:{"active-value":1,"inactive-value":0},on:{change:function(n){return t.updateAdminStatus(e.$index,e.row)}},model:{value:e.row.status,callback:function(n){t.$set(e.row,"status",n)},expression:"scope.row.status"}})]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",width:"230",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(n){return t.handleSelectRole(e.$index,e.row)}}},[t._v("分配角色")]),t._v(" "),n("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(n){return t.handleUpdate(e.$index,e.row)}}},[t._v("编辑")]),t._v(" "),n("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(n){return t.updatePassword(e.$index,e.row)}}},[t._v("重置密码")]),t._v(" "),n("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(n){return t.handleDelete(e.$index,e.row)}}},[t._v("删除")])]}}])})],1)],1),t._v(" "),n("div",{staticClass:"pagination-container"},[n("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total>0"}],attrs:{total:t.total,page:t.listQuery.page,limit:t.listQuery.limit},on:{"update:page":function(e){return t.$set(t.listQuery,"page",e)},"update:limit":function(e){return t.$set(t.listQuery,"limit",e)},pagination:t.getList}})],1),t._v(" "),n("el-dialog",{attrs:{title:t.isEdit?"编辑用户":"添加用户",visible:t.dialogVisible,width:"40%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[n("el-form",{ref:"adminForm",attrs:{model:t.admin,"label-width":"150px",size:"small"}},[t.isEdit?t._e():n("el-form-item",{attrs:{label:"帐号："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{maxlength:"30","show-word-limit":""},model:{value:t.admin.username,callback:function(e){t.$set(t.admin,"username",e)},expression:"admin.username"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"昵称："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{maxlength:"20","show-word-limit":""},model:{value:t.admin.nickName,callback:function(e){t.$set(t.admin,"nickName",e)},expression:"admin.nickName"}})],1),t._v(" "),t.isEdit?t._e():n("el-form-item",{attrs:{label:"密码："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{maxlength:"35","show-word-limit":"",type:"password"},model:{value:t.admin.password,callback:function(e){t.$set(t.admin,"password",e)},expression:"admin.password"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"备注："}},[n("el-input",{staticStyle:{width:"250px"},attrs:{type:"textarea",maxlength:"100","show-word-limit":"",rows:5},model:{value:t.admin.note,callback:function(e){t.$set(t.admin,"note",e)},expression:"admin.note"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"是否启用："}},[n("el-radio-group",{model:{value:t.admin.status,callback:function(e){t.$set(t.admin,"status",e)},expression:"admin.status"}},[n("el-radio",{attrs:{label:1}},[t._v("是")]),t._v(" "),n("el-radio",{attrs:{label:0}},[t._v("否")])],1)],1)],1),t._v(" "),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{size:"small"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),n("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(e){return t.sureDiag()}}},[t._v("确 定")])],1)],1),t._v(" "),n("el-dialog",{attrs:{title:"分配角色",visible:t.allocDialogVisible,width:"30%"},on:{"update:visible":function(e){t.allocDialogVisible=e}}},[n("el-select",{staticStyle:{width:"80%"},attrs:{filterable:"",multiple:"",placeholder:"请选择",size:"small"},model:{value:t.allocRoleIds,callback:function(e){t.allocRoleIds=e},expression:"allocRoleIds"}},t._l(t.ALLROLELIST,(function(t){return n("el-option",{key:t.id,attrs:{label:t.name,value:t.id}})})),1),t._v(" "),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{size:"small"},on:{click:function(e){t.allocDialogVisible=!1}}},[t._v("取 消")]),t._v(" "),n("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(e){return t.handleAllocDialogConfirm()}}},[t._v("确 定")])],1)],1)],1)},a=[],o=(n("5df3"),n("1c4c"),n("bd86")),r=n("50fc"),l=n("333d"),s={pageNum:1,pageSize:10,keyword:null},u={id:null,username:null,password:null,nickName:null,note:null,status:1},c={name:"adminList",data:function(){var t;return t={list:null,total:0,listLoading:!0,listQuery:{page:1,limit:8,keyword:null}},Object(o["a"])(t,"listLoading",!1),Object(o["a"])(t,"dialogVisible",!1),Object(o["a"])(t,"admin",Object.assign({},u)),Object(o["a"])(t,"isEdit",!1),Object(o["a"])(t,"allocDialogVisible",!1),Object(o["a"])(t,"allocRoleIds",[]),Object(o["a"])(t,"ALLROLELIST",[]),Object(o["a"])(t,"allocAdminId",null),t},created:function(){this.getList(),this.getAllRoleList()},filters:{},components:{Pagination:l["a"]},methods:{handleResetSearch:function(){this.listQuery=Object.assign({},s)},handleSearchList:function(){this.listQuery.pageNum=1,this.getList()},handleAdd:function(){this.dialogVisible=!0,this.isEdit=!1,this.admin=Object.assign({},u)},updateAdminStatus:function(t,e){var n=this,i={id:e.id,status:e.status};console.log("up data->",i),Object(r["D"])(i).then((function(t){n.$message({type:"success",message:"操作成功"})}))},updatePassword:function(t,e){var n=this;this.$prompt("请输入新密码","提示",{confirmButtonText:"确定",cancelButtonText:"取消",inputPattern:/^(\w){5,30}$/,inputErrorMessage:"密码由5-30个字母、数字、下划线组成"}).then((function(t){var i=t.value,a={id:e.id,password:i};Object(r["H"])(a).then((function(t){n.$message({type:"success",message:e.nickName+"的密码已经重置为"+i}),n.getList()}))}))},handleDelete:function(t,e){var n=this;this.$confirm("是否要删除"+e.nickName+"?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){Object(r["j"])(e.id).then((function(t){n.$message({type:"success",message:"删除成功!"}),n.getList()}))}))},handleUpdate:function(t,e){this.dialogVisible=!0,this.isEdit=!0,this.admin=Object.assign({},e)},sureDiag:function(){var t=this;if(this.isEdit)Object(r["C"])(this.admin).then((function(e){t.$message({message:"修改成功！",type:"success"}),t.dialogVisible=!1,t.getList()}));else{console.log("crate data->",this.admin);var e=/^(\w){5,30}$/;if(!e.test(this.admin.password))return void this.$message({message:"密码由5-30个字母、数字、下划线组成",type:"fail"});Object(r["g"])(this.admin).then((function(e){t.$message({message:"添加成功！",type:"success"}),t.dialogVisible=!1,t.getList()}))}},handleAllocDialogConfirm:function(){var t=this,e={id:this.allocAdminId,ids:Array.from(this.allocRoleIds)};Object(r["d"])(e).then((function(e){t.$message({message:"分配成功！",type:"success"}),t.allocDialogVisible=!1}))},handleSelectRole:function(t,e){this.allocAdminId=e.id,this.allocDialogVisible=!0,this.getRoleListByAdmin(e.id)},getList:function(){var t=this;this.listLoading=!0,Object(r["r"])(this.listQuery).then((function(e){t.listLoading=!1,t.list=e.data.list,t.total=e.data.total}))},getAllRoleList:function(){var t=this;Object(r["z"])().then((function(e){console.log("得到全部角色->",e.data),t.ALLROLELIST=e.data.list}))},getRoleListByAdmin:function(t){var e=this;Object(r["y"])(t).then((function(t){var n=t.data;if(e.allocRoleIds=[],null!=n&&n.length>0)for(var i=0;i<n.length;i++)e.allocRoleIds.push(n[i].id)}))}}},d=c,m=(n("fc94"),n("2877")),f=Object(m["a"])(d,i,a,!1,null,"0dc871d7",null);e["default"]=f.exports},c1a9:function(t,e,n){},f959:function(t,e,n){"use strict";var i=n("c1a9"),a=n.n(i);a.a},fc94:function(t,e,n){"use strict";var i=n("15b0"),a=n.n(i);a.a}}]);