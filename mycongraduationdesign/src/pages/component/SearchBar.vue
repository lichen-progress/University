<template>
    <div class="searchbar" >
        <el-row :gutter="10">
            <el-col :span="20"><el-input v-model="searchText"></el-input></el-col>
            <el-col :span="4"><el-button class="el-icon-search"></el-button></el-col>
        </el-row>
        
    </div>
  
</template>

<script>
import axios from "axios"
export default {
    name:"SearchBar",
    props:{
        "where":{
            type:String,
            default:"resource"
        }
    },
    data(){
        return{
            
            
            searchText:"",

        }
    },
    methods:{
        sendReq(){
            this.$axios.get("/file/search")
            .then((res)=>{
                console.log(res);
            })
            .catch((e)=>{

            });
            

        }
    },
    created(){},
    mounted(){}

}
</script>

<style>
.searchbar{
    width: fit-content;
    height: 100%;
    background-color: rgba(red, green, blue, 0);
}


</style>