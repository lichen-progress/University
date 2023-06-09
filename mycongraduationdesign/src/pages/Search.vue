<template>
  <div class="search">
    <div><SearchBar2></SearchBar2></div>

    <div></div>
    <div>
      
      <div
        class="cards-container"
        v-for="(UAndR, index) in UAndRList"
        v-bind:key="index"
      >
        <div class="flex-container">
        
          <UserProfile :profile="UAndR.user"></UserProfile>
          <ResourceCard :resource="UAndR.resource"></ResourceCard>
        </div>
      </div>
    </div>

    <div>
      <input type="file" @change="fileChange(e)" />
      <el-button type="success" @click="upload(e)">提交</el-button>
    </div>
  </div>
</template>

<script>
import ResourceCard from "./component/ResourceCard.vue";
import UserProfile from "./component/UserProfile.vue";
import SearchBar2 from "./component/SearchBar2.vue";

export default {
  name: "Search",
  data() {
    return {
      file: {},

      UAndRList: null,

      userProfile: [],

      resources: [
        { rid: 1, name: "窝窝屎", hoder: 1 },
        { rid: 2, name: "RiderJoker", hoder: 1 },
      ],
    };
  },
  methods: {
    fileChange(e) {

    },
    upload(e) {
      this.$axios
        .post("/file/upload/avatar", {})
        .then((res) => {
          console.log(res.data);
          this.users = res.data;
        })
        .catch((e) => {});
    },

    loadResource() {
      let list = [];

      this.$axios
        .get("/resource/resourceAndUser")
        .then((res) => {
          console.log(res);
          let _resources = res.data.data.resources;
          let _userProfile = res.data.data.users;

          for (let i = 0; i < _resources.length; i++) {
            console.log(i);

            list[i] = {
              user: _userProfile[i],
              resource: _resources[i],
            };
          }

          console.log("UAndRList");
          console.log(list);
          console.log("UAndRList2");
          console.log(this.UAndRList);
          this.UAndRList = list;
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  components: {
    ResourceCard,
    UserProfile,
    SearchBar2,
  },
  created() {
    // this.UAndRList = sessionStorage.getItem("UAndR");
  },
  mounted() {
    this.loadResource();
  },
};
</script>

<style>
.cards-container {
  margin: 20px auto;
  width: 800px;
  min-height: 270px;
  height: fit-content;
  /* display: flex;
  flex-direction: row; */
}
.flex-container {
  display: flex;
  flex-direction: row;
}
</style>
