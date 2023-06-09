<template>
  <div>
    <h1>Resource</h1>
    <div class="flex-container2">
      <div class="user-config">
        <el-card><UserProfile></UserProfile></el-card>
      </div>
    </div>
    <div class="cards-container">
      <el-card class="htmlshow">
        <div slot="header">
          <span>
            <h2>{{ resourceInfo.title }}</h2>
          </span>
        </div>
        <div id="html-text"></div>
      </el-card>
    </div>
    <!-- <div class="cards-container">
      评论
      <el-card></el-card>
    </div> -->
  </div>
</template>

<script>
import UserProfile from "./component/UserProfile.vue";

export default {
  name: "Resource",
  props: ["resource"],
  components: {
    UserProfile,
  },
  data() {
    return {
      _rid: 1,
      resourceInfo: {
        
        title: "默认标题",
        date: "0-0-0",

        htmlText: "null",
      },
    };
  },
  methods: {
    getResource() {
      let path = "/resource/" + this._rid;
      this.$axios
        .get(path)
        .then((res) => {
          console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
          console.log(res);
          this.resourceInfo = res.data.data.resource;
          console.log(this.resourceInfo);
          this.insertHtml();
        })
        .catch((e) => {
          console.log(e);
        });
    },

    insertHtml(){
      console.log("async"+this.resourceInfo.html);
      document.getElementById("html-text").innerHTML = this.resourceInfo.html;
    }
  },
  created() {
    this._rid = this.$route.query.resID;

  },
  mounted() {
    if(this.resource!=null){
      this.resourceInfo = this.resource;
      this.insertHtml();
    }else{
      this.getResource();
    }
    
 

  },
};
</script>

<style>
.cards-container {
  margin: 20px auto;
  width: 800px;
  height: fit-content;
}
.flex-container2 {
  display: flex;
  position: absolute;
  left: 50px;
}

.htmlshow {
  width: 100%;
  height: fit-content;
}
#html-text {
  min-height: 300px;
  height: fit-content;
  text-align: left;
}
</style>