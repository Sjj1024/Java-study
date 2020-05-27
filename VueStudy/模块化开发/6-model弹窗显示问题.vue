<template>
    <div>
        <div class="data-item-row">
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.name}}</div>
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.vendor}}</div>
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.model}}</div>
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.ip}}</div>
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.port}}</div>
            <div style="margin: 12px 0px 0px 0px;float: right;">
                <button class="btn-danger btn-xx" style="float: right;margin: 2px;">删除</button>
                <button class="btn-primary btn-xx" style="float: right;margin: 2px;" @click="onShowRobotEditDialog()">编辑</button>
            </div>
        </div>
        <editrobotdlg :id="'editrobotdlg_'+item.name" :ref="'RobotDlg_'+item.name" :item="item"></editrobotdlg>
    </div>
</template>

<script>
import editrobotdlg from "./editrobotdlg.vue"

export default {
    name:"agvtable",
    props:{
        item: Object
    },
    data(){
        return {
            reFresh:true,
            name:"",
            menukey:1
        }
    },
    components:{
        editrobotdlg
    },
    // watch:{
    //     menuTree(){
    //         ++this.menuKey
    //     }
    // },
    methods:{
        onShowRobotEditDialog:function(){
            // model框缓存，使用v-if判断，为false即销毁，为true则重新渲染
            // 每个组件中都有一个编辑窗，但是名字和ref不能使用相同的，否则使用的可能都是同一个
            console.log("显示编辑框");
            console.log(this.item);
            $("#editrobotdlg_"+this.item.name).modal('show');
        }
    }
}
</script>


<style>

</style>
