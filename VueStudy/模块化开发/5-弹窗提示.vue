<template>
    <div style="border: 1px solid skyblue; padding: 5px;border-radius: 5px">
        <div class="form form-inline">
            <label style="margin:0px 5px 0px 10px">路径名称</label>
            <input type="text" class="form-control form-control-xs" style="width: 150px;height: 25px; font-size:14px" placeholder="name" v-model="name">
            <button type="button" class="btn-xx btn-success" style="float: right;margin: 2px;" @click="moveRouteRevert(pkey)">反序执行</button>
            <button type="button" class="btn-xx btn-success" style="float: right;margin: 2px;" @click="moveRouteSequence(pkey)">正序执行</button>
            <button type="button" class="btn-xx btn-danger" style="float: right;margin: 2px;" @click="removeRoute(pkey)">删除</button>
        </div>

        <div class="form form-inline" style="margin: 2px;padding: 2px;">
            <div :key="i" v-for="(item,i) in routepoints" style="margin: 2px;padding: 2px; display:inline-block;border-bottom: 1px solid #d5d5d5">
                <div class="form-group">
                    <label style="margin:0px 5px 0px 0px">关节坐标</label>
                    <input class="form-control form-control-xs" type="text" style="width: 90px;height: 25px; margin:2px;font-size: 14px;" placeholder="J1" v-model="item.x">
                    <input class="form-control form-control-xs" type="text" style="width: 90px;height: 25px; margin:2px;font-size: 14px;" placeholder="J2" v-model="item.y">
                    <input class="form-control form-control-xs" type="text" style="width: 90px;height: 25px; margin:2px;font-size: 14px;" placeholder="J3" v-model="item.z">
                    <input class="form-control form-control-xs" type="text" style="width: 90px;height: 25px; margin:2px;font-size: 14px;" placeholder="J4" v-model="item.rx">
                    <input class="form-control form-control-xs" type="text" style="width: 90px;height: 25px; margin:2px;font-size: 14px;" placeholder="J5" v-model="item.ry">
                    <input class="form-control form-control-xs" type="text" style="width: 90px;height: 25px; margin:2px;font-size: 14px;" placeholder="J6" v-model="item.rz">
                </div>
                 <div>
                    <button type="button" class="btn-xx btn-primary" @click="fetchRoutePoint(item.pkey)">获取</button>
                    <button type="button" class="btn-xx btn-primary" @click="moveRoutePoint(item.pkey)">移动</button>
                    <button type="button" class="btn-xx btn-primary" @click="updateRoutePoint(item.pkey)">修改</button>
                    <button type="button" class="btn-xx btn-primary" @click="addRoutePoint()">添加</button>
                    <button type="button" class="btn-xx btn-danger" @click="removeRoutePoint(item.pkey)">删除</button>
                </div>
            </div>
        </div>
    </div>
</template>



<script>
export default {
    name: "vroutelist",
    props: {
        id:String,
        name:String,
        uuid:String,
        pkey:String,
        routepoints:Array
    },
    data(){
        return {

        }
    },
    created(){
        if(this.routepoints.length==0){
            var item = new Object();
            item.x = "";
            item.y = "";
            item.z = "";
            item.rx = "";
            item.ry = "";
            item.rz = "";
            item.uuid = "";
            item.routeUuid = this.uuid;
            this.routepoints.push(item);
        }
    },
    mounted:function(){
        console.log(this.routepoints);
    },
    methods:{
        addRoutePoint:function(){
            console.log("增加一行route");
            var item = new Object();
            item.x = "";
            item.y = "";
            item.z = "";
            item.rx = "";
            item.ry = "";
            item.rz = "";
            item.uuid = "";
            item.routeUuid = this.uuid;
            this.routepoints.push(item);
        }
    }
}
</script>

<style>


</style>
