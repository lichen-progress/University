<template>
    <div id="sticklayer">


    </div>
  
</template>

<script>
import Login from './Login.vue';
export default {
    name:'StickLayer',
    comments:{
        login:Login
    }

}
</script>    

<style>
    #sticklayer{
        display: block;
        position: fixed;
        border-block: solid;
        top:40px;
        background-color: rgba(50, 50, 50, 0);
        height: 2000px;
        width: 100%;
        z-index: -1;
    }


    .sidebar{
        width: 100px;
        height: 100%;
        min-height: 300px;
        border: 1px solid black;

    }

</style>