<template>
    <div class="modal fade" :id="id" tabindex="-1" role="dialog"
            aria-labelledby="addRobotDlgTitle" aria-hidden="false" >
        <div class="modal-dialog modal-dialog-centered" role="document" style="width:1050px;">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editRobotDlgTitle">机械臂参数</h5>
                </div>
                <div class="modal-body">
                    <div class="form">
                        <div class="form-group form-inline">
                            <div style="display:inline-block">
                                <vinput id="input_lab_id" size="lg" label="实验室ID" labelwidth="100px" ref="input_lab_id"></vinput>
                            </div>
                            <div style="display:inline-block">
                                <vinput id="input_agent_ip" size="lg" label="Agent IP" labelwidth="100px" ref="input_agent_ip"></vinput>
                            </div>
                        </div>
                        <div>
                            <label>安全位置</label>
                        </div>
                        <div class="form-group form-inline">
                            <div style="display:inline-block">
                                <div style="display:inline-block">
                                    <vinput id="j1" size="lg" label="关节坐标" labelwidth="150px" ref="j1"></vinput>
                                </div>
                                <div style="display:inline-block">
                                    <vinput id="j2" size="lg" label="" labelwidth="150px" ref="j2"></vinput>
                                </div>
                                <div style="display:inline-block">
                                    <vinput id="j3" size="lg" label="" labelwidth="150px" ref="j3"></vinput>
                                </div>
                                <div style="display:inline-block">
                                    <vinput id="j4" size="lg" label="" labelwidth="150px" ref="j4"></vinput>
                                </div>
                                <div style="display:inline-block">
                                    <vinput id="j5" size="lg" label="" labelwidth="150px" ref="j5"></vinput>
                                </div>
                                <div style="display:inline-block">
                                    <vinput id="j6" size="lg" label="" labelwidth="150px" ref="j6"></vinput>
                                </div>
                                <!-- <vinput id="j1" size="lg" label="关节坐标" labelwidth="150px" ref="j1"></vinput>
                                <vinput id="j2" size="lg" label="" labelwidth="150px" ref="j2"></vinput>
                                <vinput id="j3" size="lg" label="" labelwidth="150px" ref="j3"></vinput>
                                <vinput id="j4" size="lg" label="" labelwidth="150px" ref="j4"></vinput>
                                <vinput id="j5" size="lg" label="" labelwidth="150px" ref="j5"></vinput>
                                <vinput id="j6" size="lg" label="" labelwidth="150px" ref="j6"></vinput> -->
                            </div>
                            <button type="button" class="btn-xx btn-primary" @click="getPoints">获取</button>
                        </div>
                        <div style="margin: 5px;">
                            <button type="button" class="btn-xx btn-primary" @click="addRoute">添加路径</button>
                        </div>
                        <!-- <vroutelist :id="'routeA_'+i" v-for="(item,i) in routes" :ref="'routeA_'+i" :name="item.name" :uuid="item.uuid" :routepoints="item.routepoints"
                                    :pkey="item.pkey"></vroutelist> -->
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal" @click="onCompleted">确定</button>
                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
import vinput from "./vinput.vue";

export default {
    name:"editrobotdlg",
    props:{
        id:String
    },
    data(){
        return {
            routes:[]
        }
    },
    components:{
        vinput
    },
    methods:{
        addRoute:function(){
            console.log("添加路由");
        },
        onCompleted:function(){
            console.log("点确定的回调函数");
        },
        getPoints:function(){
            console.log("获取机械臂坐标");
            var j1 = this.$refs.j1.getValue()
        }

    },
    mounted(){
        console.log("agv编辑弹窗");
    }
}

</script>


<style>

</style>
