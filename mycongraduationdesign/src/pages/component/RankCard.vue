<template>
    <div class="rank-card">
        <el-card>
            <ul>
                <li v-for="(user) in users" :key="user.rid">{{ user }}</li>
            </ul>

        </el-card>

    </div>
</template>

<script>
export default {
    name: "RankCard",
    props: {
        "ranked": {
            type: Array,
            default: [
                {
                    rid: 1,
                    type: "游戏",
                    name: "窝窝屎"
                },
                {
                    rid: 2,
                    type: "动画",
                    name: "海绵宝宝"
                },
                {
                    rid: 3,
                    type: "软件",
                    name: "Maven"
                },

            ]
        }
    },
    data() {
        return {
            rankedResource:[]


        }
    },
    created: {
        bindData(){
            this.rankedResource = this.ranked;

        }
      

    }

}
</script>

<style>
.rank-card {
    height: 100%;
    width: 100%;
}
</style>