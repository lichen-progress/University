<template>
  <div class="card-container">
    <el-card class="card">
      <div slot="header" class="clearfix">
        <span class="title-text" @click="pushTo()">{{
          _resource.rid + _resource.title
        }}</span>
      </div>
      <div>{{ _resource.resource }}</div>
      <div class="card-info">
        <i class="el-icon-view">{{ _resource.visits }}</i>
        <i class="el-icon-user">{{ _resource.comment }}</i>
        <i class="el-icon-star-off">{{ _resource.collect }}</i>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "ResourceCard",
  data() {
    return {
      _resource: {},
    };
  },
  methods: {
    pushTo() {
      let router = this.$router;

      console.log(router);

      router.push({
        path: "/resource",
        query: {
          resID: this._resource.rid,
        },
      });
    },
    load() {
      if (this.resource != null) {
        this._resource = this.resource;
      }
    },
  },
  props: {
    resource: {
      type: Object,
      default: {
        rid: 1,
        type: "游戏",
        name: "窝窝屎",
      },
    },
  },
  created() {
    if (this.resource != null) {
      this._resource = this.resource;
    }
    setInterval(load(),100);
    this._resource = this.resource;
  },
  mounted() {
    // if (this.resource != null) {
    //   this._resource = this.resource;
    // }
    console.log("Rcard");
    console.log(this._resource);
  },
};
</script>



<style>
.card-container {
  margin: 10px 10px;
  height: 250px;
  min-width: 600px;
  max-width: 1000px;
  width: 100%;
  background-color: #c2c7fc;
}
.card {
  text-align: left;
  position: relative;
  height: 100%;
}
.clearfix {
  text-align: left;
}
.clearfix:after {
  display: table;
  content: "";
  clear: both;
  height: 100%;
}

.title-text {
  font-size: 20px;
}
.card-info {
  position: absolute;
  bottom: 10px;
}
</style>