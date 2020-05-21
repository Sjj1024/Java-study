<template>
    <div>
        <div class="data-item-row" :key="i" v-for="(item,i) in items">
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.name}}</div>
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.name}}</div>
            <div style="width: 200px;margin: 5px;line-height:50px;float: left;">{{item.name}}</div>
            <div style="width: 200px;margin: 5px;line-height:50px;float: right;">
                <button class="btn btn-danger btn-xs" style="float: right;margin: 2px;">删除</button>
                <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#editRobotDlg" style="float: right;margin: 2px;" @click="onShowRobotEditDialog()">编辑</button>
        </div>
    </div>
    </div>
</template>

<script>

export default {
    name:"agvtable",
    props:{
        items:[]
    },
    data(){
        return {
            title:""
        }
    },
    methods:{
        
    },
    mounted:function(){
        var robot = new Object();
        robot.name = "Aubo";
        this.items.push(robot);
    }
}
</script>


<style>

</style>
